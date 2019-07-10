package client;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {

    public static final Integer FWIDTH = 800,FHEIGHT = 600;

    private Tank player = new Tank(this);
    private List<Bullet> bullets = new ArrayList<>();

    //使用双缓冲消除闪烁
    Image offScreenImage = null;

    TankFrame(){
        this.setBackground(Color.BLACK);
        this.setLocation(100,400);
        this.setSize(800,600);
        this.setTitle("Tank War");
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                player.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player.keyReleased(e);
            }
        });
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {

        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹总数："+bullets.size(),10,50);
        g.setColor(c);

        player.paint(g);

        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            bullet.paint(g);
            if (!bullet.isLiving()){
                bullets.remove(bullet);
            }
        }

    }

    public void addBullet(Bullet bullet){
        this.bullets.add(bullet);
    }

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(FWIDTH, FHEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, FWIDTH, FHEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }
}
