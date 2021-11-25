import javafx.scene.image.Image;

public class Hero extends AnimatedThing {

    int Y = getY();

    public Hero(Integer x, Integer y, Image image, Integer index, Integer tFrame, Integer indexMax, Integer winSizel, Integer winSizeh , Integer offFrame) {
        super(x, y, image, index, tFrame, indexMax, winSizel, winSizeh, offFrame);
    }

    void update(long time){
        setIndex((getIndex()+1)%getIndexMax());
        if (Y<=230) {Y=Y+20; getImageView().setY(Y);}
        if (Y>230) {Y=250; getImageView().setY(Y);}
    }
}
