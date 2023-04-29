import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VentanaAPP extends JFrame  implements ActionListener {

    JButton reiniciar, salir, infantil, romantica, terror;
    JPanel filaSuperior, filaCentral, filaInferior;


    public VentanaAPP() throws IOException {
        this.setLayout(new GridLayout(3,1));
        infantil = new JButton("Infantil"); romantica=new JButton("Romantica"); terror= new JButton("Terror");
        filaSuperior=new JPanel();
        filaSuperior.add(infantil);
        filaSuperior.add(romantica);
        filaSuperior.add(terror);
        this.add(filaSuperior);
        //hasta aquí fila superior

        filaCentral=new JPanel();
        filaCentral.setLayout(new GridLayout(1,3));

        String ruta1 = "Resources/IMG_1115.JPG";
        PanelImagenes p1 = new PanelImagenes(ruta1);
        filaCentral.add(p1);

        String ruta2 = "Resources/IMG_2420.jpeg";
        PanelImagenes p2 = new PanelImagenes(ruta2);
        filaCentral.add(p2);

        String ruta3 = "Resources/IMG_2423.jpeg";
        PanelImagenes p3 = new PanelImagenes(ruta3);
        filaCentral.add(p3);

        this.add(filaCentral);
        //hasta aqui fila central

        filaInferior=new JPanel();

        reiniciar=new JButton("Reiniciar");
        salir=new JButton("Salir");

        filaInferior.add(reiniciar);
        filaInferior.add(salir);
        this.add(filaInferior);
        //hasta aqui fila inferior

        this.setSize(650,470);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
