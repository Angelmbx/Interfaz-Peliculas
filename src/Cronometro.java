import javax.swing.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class Cronometro extends JLabel implements Serializable {

    private Timer timer;
    private TimerTask task;
    private int segundos = 10;
    private String texto;
    private boolean funcionando;
    public Cronometro(){
    this.setText("10");
    this.funcionando=false;
    }



    public void Start(){
        timer = new Timer();
        task = new TimerTask() {

            @Override
            public void run() {
                    if (segundos > 0) {
                        segundos--;
                        texto = Integer.toString(segundos);
                        setText(texto);
                    } else {
                        task.cancel();
                    }

                }
        };
        timer.schedule(task,0, 1000);
    }


    public void End(){
        task.cancel();
    }

    public void Reset (){
    task.cancel();
    setText("10");
    segundos=10;

    }
}
