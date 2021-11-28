import javafx.scene.image.Image;

public class Hero extends AnimatedThing {

    int Y;
    int X;
    double vy = 0;
    double ay = 0;

    public Hero(Integer x, Integer y, Image image, Integer index, Integer tFrame, Integer indexMax, Integer winSizel, Integer winSizeh , Integer offX, Integer offY) {
        super(x, y, image, index, tFrame, indexMax, winSizel, winSizeh, offX, offY);
        this.X = x;
        this.Y = y;
    }

    void update(long time){
        if(Y==250) {
            setOffY(0);
            setIndex((getIndex() + 1) % getIndexMax());
        }
        if(Y<250) {
            setOffY(160);
            if (vy<0) {setIndex(0);}
            if (vy>=0) {setIndex(1);}
            ay += 2;
        }
        vy = vy+ay;
        Y = (int)vy+Y;
        if (Y>=250) {ay=0; vy=0; Y=250;}
        getImageView().setY(Y);
    }

    void jump() {
        ay -= 8;
        vy = -4;
        System.out.println("Jump");
    }
}
