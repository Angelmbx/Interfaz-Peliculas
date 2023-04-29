import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VentanaAPP extends JFrame  implements ActionListener {

    JButton reiniciar, salir, infantil, comedia, exitos;
    JPanel filaSuperior, filaCentral, filaInferior, panelCronometro;
    Cronometro c1,c2,c3;


    public VentanaAPP() throws IOException {
        this.setLayout(new GridLayout(4,1));
        infantil = new JButton("Infantil"); comedia=new JButton("Comedia"); exitos= new JButton("Exitos");
        filaSuperior=new JPanel();
        filaSuperior.add(infantil); infantil.addActionListener(this);
        filaSuperior.add(comedia);  comedia.addActionListener(this);
        filaSuperior.add(exitos);   exitos.addActionListener(this);
        this.add(filaSuperior);
        //hasta aquí fila superior

        filaCentral=new JPanel();
        filaCentral.setLayout(new GridLayout(1,3));

        String ruta1 = "Resources/frozen.jpg";
        PanelImagenes p1 = new PanelImagenes(ruta1);
        filaCentral.add(p1);

        String ruta2 = "Resources/ParksAndRec.jpg";
        PanelImagenes p2 = new PanelImagenes(ruta2);
        filaCentral.add(p2);

        String ruta3 = "Resources/GoT.jpg";
        PanelImagenes p3 = new PanelImagenes(ruta3);
        filaCentral.add(p3);

        this.add(filaCentral);
        //hasta aqui fila central

        panelCronometro=new JPanel();
        c1 = new Cronometro();
        panelCronometro.add(c1);
        c1.setVisible(false);
        this.add(panelCronometro);
        //hasta aqui panel cronometro

        filaInferior=new JPanel();

        reiniciar=new JButton("Reiniciar");
        salir=new JButton("Salir");

        filaInferior.add(reiniciar); reiniciar.addActionListener(this);
        filaInferior.add(salir);     salir.addActionListener(this);
        this.add(filaInferior);
        //hasta aqui fila inferior


        this.setSize(720,800);
        this.setTitle("Catálogo");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==infantil){
            c1.setVisible(true);
            c1.Start();
        }


        if(e.getSource()==salir){
            dispose();
        }

    }
}
