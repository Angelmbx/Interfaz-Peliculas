import javax.swing.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class Cronometro extends JLabel implements Serializable {

    private Timer timer;
    private TimerTask task;
    private int segundos;
    private int duracion;
    private boolean funcionando;
    private String texto;

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

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public boolean isFuncionando() {
        return funcionando;
    }

    public void setFuncionando(boolean funcionando) {
        this.funcionando = funcionando;
    }


    public Cronometro(){
    this.segundos = 6;
    this.setText(Integer.toString(segundos));
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
    setSegundos(6);
    }
}
