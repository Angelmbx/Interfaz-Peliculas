import Componentes.Cronometro;
import Eventos.EventoTiempoaCero;
import Eventos.TiempoaCeroListener;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.util.ArrayList;

public class Historia extends ImageView implements TiempoaCeroListener {


    private ArrayList<String> images = new ArrayList<>();
    private int index = 0;
    private boolean finished = false;
    private Cronometro crono;

    public Historia() {
        crono = new Cronometro();
        crono.addListener(this);
    }


    public void addImage(String url){
        images.add(url);
    }


    public void nextImage(){
        if (!finished) {
            String url = images.get(++index);
            this.setImage(new Image(url));

            if (index == images.size() - 1) {
                finished = true;
            } else {
                crono.End();
                start();
            }
        }

    }


    public void start(){
        if (images.size() > 0) {
            this.setImage(new Image(images.get(index)));
            this.setVisible(true);
        }
        finished = false;
        crono.start();
    }


    public void stop(){
        try {
            timer.stop();
        } catch (Exception ignore){}

        index = 0;
        finished = false;
        this.setVisible(false);
    }


    @Override
    public void timerEnded(ETimerEnded timerEnded) {
        nextImage();
    }

    @Override
    public void tiempoACero(EventoTiempoaCero tiempoaCero) {

    }
}