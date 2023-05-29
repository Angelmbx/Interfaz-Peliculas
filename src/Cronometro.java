import javax.swing.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class Cronometro extends JLabel implements Serializable {

    private Timer timer;
    private TimerTask task;
    private int segundos = 30;
    private String texto;

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public TimerTask getTask() {
        return task;
    }

    public void setTask(TimerTask task) {
        this.task = task;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Cronometro(){
    this.setSegundos(0);
    }


    public void Start(){
        this.setVisible(true);

        timer = new Timer();
        task = new TimerTask() {

            @Override
            public void run() {
                //do {
                    segundos++;
                    texto = Integer.toString(segundos);
                    setText(texto);
                //} while (texto != "-1");
            }
        };
        timer.schedule(task,0, 1000);
    }

    public void End(){
        task.cancel();
        this.setVisible(false);
    }

    public void Reset (){
    //task.cancel();
    setSegundos(0);
    //this.setVisible(false);
    }
}
