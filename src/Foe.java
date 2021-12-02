import javafx.scene.image.Image;

public class Foe extends AnimatedThing {

    int Y;
    int X;
    int c=1;

    public Foe(Integer x, Integer y, Image image, Integer index, Integer tFrame, Integer indexMax, Integer winSizel, Integer winSizeh , Integer offX, Integer offY) {
        super(x, y, image, index, tFrame, indexMax, winSizel, winSizeh, offX, offY);
        this.X = x;
        this.Y = y;
    }

    void update(long time){
        if(c==1) {
            setIndex((getIndex() + 1) % getIndexMax());
        }
        c=(c+1)%10;
    }

}
