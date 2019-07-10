package client;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Tank {

    private int x,y;
    private int speed;
    private int width,height;

    private Dir dir ;
    private boolean dL, dU, dR, dD;

    private boolean moving;

    private TankFrame tankFrame;

    Tank(int x,int y,int speed,int width,TankFrame tankFrame){
        this(tankFrame);
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
    }

    Tank(TankFrame tankFrame){
        x = 100;
        y = 400;
        speed = 5;
        width = 50;
        height = 50;
        dir = Dir.UP;
        this.tankFrame = tankFrame;
    }

    void paint(Graphics g){
        switch (dir){
            case LEFT:
                g.drawImage(ResourceManager.TankLeft,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceManager.TankUp,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.TankRight,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.TankDown,x,y,null);
                break;
        }
        move();
    }

    void keyPressed(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                dL = true;
                break;
            case KeyEvent.VK_UP:
                dU = true;
                break;
            case KeyEvent.VK_RIGHT:
                dR = true;
                break;
            case KeyEvent.VK_DOWN:
                dD = true;
                break;
        }
        changeDir();
    }

    void keyReleased(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                dL = false;
                break;
            case KeyEvent.VK_UP:
                dU = false;
                break;
            case KeyEvent.VK_RIGHT:
                dR = false;
                break;
            case KeyEvent.VK_DOWN:
                dD = false;
                break;
            case KeyEvent.VK_SPACE:
                fire();
                break;
        }
        changeDir();
    }

    void changeDir(){
        if(!dL && !dU && !dR && !dD){
            moving = false;
            return;
        }

        if (dL)dir = Dir.LEFT;
        if (dD)dir = Dir.DOWN;
        if (dU)dir = Dir.UP;
        if (dR)dir = Dir.RIGHT;
        moving = true;
    }

    void move(){

        if (!moving)return;

        switch (dir){
            case LEFT:
                x-=speed;break;
            case UP:
                y-=speed;break;
            case RIGHT:
                x+=speed;break;
            case DOWN:
                y+=speed;break;

        }
    }

    void fire(){
        Bullet bullet = new Bullet(this);
        this.tankFrame.addBullet(bullet);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Dir getDir() {
        return dir;
    }
}
