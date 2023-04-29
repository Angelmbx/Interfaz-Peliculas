import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        VentanaAPP ventanaAPP = new VentanaAPP();

        String ruta = "Resources/IMG_1115.JPG";
        PanelImagenes p = new PanelImagenes(ruta);

        ventanaAPP.add(p);


    }

}
