package client;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceManager {
    public static BufferedImage TankUp,TankLeft,TankRight,TankDown,
                                BulletUp,BulletLeft,BulletRight,BulletDown;

    static {
        try {
            TankUp = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("img/tankmodel/GoodTank1_up.png"));
            TankDown = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("img/tankmodel/GoodTank1_down.png"));
            TankLeft = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("img/tankmodel/GoodTank1_left.png"));
            TankRight = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("img/tankmodel/GoodTank1_right.png"));

            BulletUp = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("img/bulletmodel/bulletU.png"));
            BulletLeft = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("img/bulletmodel/bulletL.png"));
            BulletRight = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("img/bulletmodel/bulletR.png"));
            BulletDown = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("img/bulletmodel/bulletD.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
