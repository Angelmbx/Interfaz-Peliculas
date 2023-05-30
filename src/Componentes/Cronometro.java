package Componentes;

import Eventos.EventoTiempoaCero;
import Eventos.TiempoaCeroListener;

import javax.swing.*;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Cronometro extends JLabel implements Serializable {


    private int segundos;
    private int duracion;
    private boolean funcionando;
    private Timer timer;
    private TimerTask task;

    private List<TiempoaCeroListener> listeners = new ArrayList<>();


    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
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
                segundos--;
                setText(Integer.toString(segundos));
                if (segundos == 0) {
                    EventoTiempoaCero tiempoaCero = new EventoTiempoaCero(this);
                    task.cancel();
                    try {
                        notifyListeners();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        timer.schedule(task,0, 1000);
    }


    public void End(){
        task.cancel();
        timer.purge();
    }

    public void Reset (){
    setSegundos(6);
    this.Start();
    }

    public void addListener(TiempoaCeroListener tiempoaCeroListener){ listeners.add(tiempoaCeroListener);}

    public void notifyListeners() throws IOException {
        for (TiempoaCeroListener listener: listeners){
            listener.tiempoACero(new EventoTiempoaCero(this));
        }
    }


}
