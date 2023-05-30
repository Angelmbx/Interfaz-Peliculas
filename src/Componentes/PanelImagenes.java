package Componentes;

import Eventos.EventoTiempoaCero;
import Eventos.TiempoaCeroListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class PanelImagenes extends JPanel implements TiempoaCeroListener, Serializable {

    private String ruta;
    BufferedImage image;

    private ArrayList<String> images = new ArrayList<>();


    public void primeraImagen (String ruta) throws IOException {
        this.ruta = ruta;
        image = ImageIO.read(new File(ruta));
        JLabel label = new JLabel(new ImageIcon(image));
        this.add(label);
    }

    public void siguienteImagen (String ruta) throws IOException {
            this.ruta = ruta;
            image = ImageIO.read(new File(ruta));
            JLabel label = new JLabel(new ImageIcon(image));
            this.add(label);
    }


    @Override
    public void tiempoACero(EventoTiempoaCero tiempoaCero) throws IOException {
        siguienteImagen("sa");
    }
}
