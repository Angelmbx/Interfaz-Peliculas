import Componentes.Cronometro;

import java.util.ArrayList;

public class Historia {


    private ArrayList<String> images = new ArrayList<>();
    private int index = 0;
    private boolean finished = false;
    private Cronometro timer;
//
//    public Relato() {
//        this.setPreserveRatio(true);
//        this.setFitWidth(200d);
//        timer = new CustomTimer(5);
//
//        timer.addListener(this);
//    }


    public void addImage(String url) {
        images.add(url);
    }

//
//    public void nextImage(){
//        if (!finished) {
//            String url = images.get(++index);
//            this.setImage(new Image(url));
//
//            if (index == images.size() - 1) {
//                finished = true;
//            } else {
//                timer.stop();
//                start();
//            }
//        }
//
//    }


//    public void start(){
//        if (images.size() > 0) {
//            this.setImage(new Image(images.get(index)));
//            this.setVisible(true);
//        }
//        finished = false;
//        timer.start();
//    }

//
//    public void stop(){
//        try {
//            timer.stop();
//        } catch (Exception ignore){}
//
//        index = 0;
//        finished = false;
//        this.setVisible(false);
//    }

//
//    @Override
//    public void timerEnded(ETimerEnded timerEnded) {
//        nextImage();
//    }
//}

}