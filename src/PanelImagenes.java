import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class PanelImagenes extends JPanel implements Serializable {

    private String ruta;
    BufferedImage image;

    public PanelImagenes() { }

    public void primeraImagen (String ruta) throws IOException {
        this.ruta = ruta;
        image = ImageIO.read(new File(ruta));
        JLabel label = new JLabel(new ImageIcon(image));
        this.add(label);
    }

    public void siguienteImagen (boolean nextImagen, String ruta) throws IOException {
        if (nextImagen= true) {
            this.ruta = ruta;
            image = ImageIO.read(new File(ruta));
            JLabel label = new JLabel(new ImageIcon(image));
            this.add(label);

        }


    }


}
