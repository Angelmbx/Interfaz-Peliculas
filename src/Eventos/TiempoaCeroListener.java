package Eventos;

import java.io.IOException;
import java.util.EventListener;

public interface TiempoaCeroListener  extends EventListener {

    public void tiempoACero(EventoTiempoaCero tiempoaCero) throws IOException;

}
