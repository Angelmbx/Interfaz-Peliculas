import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

public class RelojContador implements Serializable {

    private Timer timer;
    private TimerTask task;

    public void Start(){
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {

            }
        };
        timer.schedule(task,0, 1000);
    }

    public void End(){
        timer.cancel();
    }

    public void Reset (){

    }
}
