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
    public Cronometro(){
    this.setText("30");
    }


    public void Start(){
        timer = new Timer();
        task = new TimerTask() {

            @Override
            public void run() {
                //do {
                    segundos--;
                    texto = Integer.toString(segundos);
                    setText(texto);
                //} while (texto != "-1");
            }
        };
        timer.schedule(task,0, 1000);
    }

    public void End(){
        task.cancel();
    }

    public void Reset (){
    task.cancel();
    setText("30");
    task.run();
    }
}
