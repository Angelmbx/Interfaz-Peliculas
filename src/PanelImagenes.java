import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class PanelImagenes extends JPanel implements Serializable {

    private String ruta;
    private int duracion;

    public PanelImagenes(){

    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    BufferedImage image;

    public PanelImagenes(String ruta) throws IOException {
        this.ruta = ruta;
        this.duracion = 5;
        image = ImageIO.read(new File(ruta));
        JLabel label = new JLabel(new ImageIcon(image));
        this.add(label);
    }
}
