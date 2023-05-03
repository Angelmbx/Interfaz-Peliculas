import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VentanaAPP extends JFrame  implements ActionListener {

    JButton reiniciar, salir, infantil, comedia, exitos;
    JPanel filaSuperior, filaCentral, filaInferior, panelCronometro;
    Cronometro c1,c2,c3;
    PanelImagenes p1,p2,p3;


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

       // String ruta1 = "Resources/frozen.jpg";
        p1 = new PanelImagenes();
        filaCentral.add(p1);

        //String ruta2 = "Resources/ParksAndRec.jpg";
        p2 = new PanelImagenes();
        filaCentral.add(p2);

        //String ruta3 = "Resources/GoT.jpg";
        p3 = new PanelImagenes();
        filaCentral.add(p3);

        this.add(filaCentral);
        //hasta aqui fila central

        panelCronometro=new JPanel();
        panelCronometro.setLayout(new GridLayout(1,3));
        c1 = new Cronometro();
        panelCronometro.add(c1);
        c1.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        c1.setVisible(false);

        c2 = new Cronometro();
        panelCronometro.add(c2);
        c2.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        c2.setVisible(false);

        c3 = new Cronometro();
        panelCronometro.add(c3);
        c3.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        c3.setVisible(false);

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

            String ruta1 = "Resources/frozen.jpg";
            try {
                p1.primeraImagen(ruta1);
                c1.setVisible(true);
                c1.Start();
                c2.End(); c2.setVisible(false);
                c3.End(); c3.setVisible(false);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }


            String ruta2 = "Resources/ParksAndRec.jpg";
            try {
                boolean b = true;
                p2.siguienteImagen(b, ruta2);
                c2.setVisible(true);
                c2.Start();
                c1.End(); c1.setVisible(false);
                c3.End(); c3.setVisible(false);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }

        if(e.getSource()==comedia){
            c2.setVisible(true);
            c2.Start();
            c1.End(); c1.setVisible(false);
            c3.End(); c3.setVisible(false);
        }
        if(e.getSource()==exitos){
            c3.setVisible(true);
            c3.Start();
            c1.End(); c1.setVisible(false);
            c2.End(); c2.setVisible(false);
        }

        if(e.getSource()==reiniciar){
            c1.Reset();
            c2.Reset();
            c3.Reset();
        }

        if(e.getSource()==salir){
            dispose();
        }

    }
}
