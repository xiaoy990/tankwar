package client;

import java.awt.*;

public class Bullet {

    private int x,y;
    private int speed = 10;
    private Dir dir;

    private boolean living;

    private final int OFFSET = 15;

    Bullet(Tank curTank){
        this.x = curTank.getX();
        this.y = curTank.getY();
        this.dir = curTank.getDir();
        this.living = true;
    }

    void paint(Graphics g){
        switch (dir){
            case DOWN:
                g.drawImage(ResourceManager.BulletDown,x+OFFSET,y+OFFSET,null);
                dir = Dir.DOWN;
                break;
            case UP:
                g.drawImage(ResourceManager.BulletUp,x+OFFSET,y,null);
                dir = Dir.UP;
                break;
            case LEFT:
                g.drawImage(ResourceManager.BulletLeft,x,y+OFFSET,null);
                dir = Dir.LEFT;
                break;
            case RIGHT:
                g.drawImage(ResourceManager.BulletRight,x+OFFSET,y+OFFSET,null);
                dir = Dir.RIGHT;
                break;
        }
        move();
    }

    private void move() {
        if (x<0||x>TankFrame.FWIDTH||y<0||y>TankFrame.FHEIGHT){living = false;}
        switch (dir){
            case DOWN:
                y += speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case LEFT:
                x -= speed;
                break;
            case UP:
                y -= speed;
                break;
        }
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }
}
