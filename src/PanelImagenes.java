import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class PanelImagenes extends JPanel implements Serializable {

    private String ruta;
    BufferedImage image;

    public PanelImagenes(String ruta) throws IOException {
        this.ruta = ruta;
        image = ImageIO.read(new File(ruta));
        JLabel label = new JLabel(new ImageIcon(image));
        this.add(label);
    }
}
