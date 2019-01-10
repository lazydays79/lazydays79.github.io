import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedImage in = ImageIO.read(Main.class.getResourceAsStream("barcode.png"));
            BufferedImage out = new BufferedImage(in.getWidth(), 1, BufferedImage.TYPE_INT_ARGB);

            //Color white = Color.WHITE;
            //Color black = Color.BLACK;
            Color white = new Color(0x000000);
            Color black = new Color(0x010101);


            /*for (int y = 0; y < 21; y++) {
                for (int x = 0; x < 21; x++) {
                    int rgb = in.getRGB(x * 10, y * 10);
                    int r = rgb & 0xFF;
                    out.setRGB(x, y, r == 0 ? black.getRGB() : white.getRGB());
                }
            }*/

            for (int x = 0; x < out.getWidth(); x++) {
                int rgb = in.getRGB(x, 0);
                int r = rgb & 0xFF;
                out.setRGB(x, 0, r == 0 ? black.getRGB() : white.getRGB());
            }

            File fout = new File("out.gif");
            ImageIO.write(out, "gif", fout);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}