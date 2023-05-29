import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static javax.swing.SwingConstants.WEST;

public class VentanaAPP extends JFrame  implements ActionListener {

    JButton reiniciar, salir, infantil, comedia, exitos;
    JPanel filaSuperior, filaCentral, filaInferior, panelCronometro;
    Cronometro crono1, crono2, crono3;


    public VentanaAPP() throws IOException {
        this.setLayout(new BorderLayout());
        infantil = new JButton("Infantil"); comedia=new JButton("Comedia"); exitos= new JButton("Exitos");
        filaSuperior=new JPanel();
        filaSuperior.add(infantil); infantil.addActionListener(this);
        filaSuperior.add(comedia);  comedia.addActionListener(this);
        filaSuperior.add(exitos);   exitos.addActionListener(this);
        this.add(filaSuperior,BorderLayout.NORTH);
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

        this.add(filaCentral, BorderLayout.CENTER);
        //hasta aqui fila central

        /*
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
         */
        //hasta aqui panel cronometro


        filaInferior=new JPanel();
        filaInferior.setLayout(new GridLayout(1,3));

        reiniciar = new JButton("Reiniciar");
        crono1 = new Cronometro();
        crono2 = new Cronometro();
        crono3 = new Cronometro();
        salir=new JButton("Salir");


        filaInferior.add(reiniciar); reiniciar.addActionListener(this);

        panelCronometro = new JPanel();
        panelCronometro.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
        panelCronometro.add(crono1, c);
        c.anchor = GridBagConstraints.CENTER;
        panelCronometro.add(crono2,c);
        c.anchor = GridBagConstraints.CENTER;
        panelCronometro.add(crono3,c);
        filaInferior.add(panelCronometro);
        filaInferior.add(salir);     salir.addActionListener(this);
        this.add(filaInferior, BorderLayout.SOUTH);
        //hasta aqui fila inferior


        this.setSize(720,400);
        this.setTitle("Catálogo");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==infantil){
            crono1.Reset();
            crono1.Start();
            crono2.End(); crono2.Reset();
            crono3.End(); crono3.Reset();

        }

        if(e.getSource()==comedia){
            crono2.Reset();
            crono2.Start();
         /*
            c2.setVisible(true);
            c2.Start();
            c1.End(); c1.Reset();
            c3.End(); c3.Reset();
          */
        }
        if(e.getSource()==exitos){
            crono3.Reset();
            crono3.Start();
            /*
            c3.setVisible(true);
            c3.Start();
            c1.End(); c1.Reset();
            c2.End(); c2.Reset();
             */
        }

        if(e.getSource()==reiniciar){
            crono1.Reset();
            crono2.Reset();
            crono3.Reset();

        }

        if(e.getSource()==salir){
            System.exit(0);
        }

    }
}
