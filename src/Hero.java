import javafx.scene.image.Image;

public class Hero extends AnimatedThing {

    int Y;
    int X;
    double vy = 0;
    double ay = 0;
    long tInv = 0;
    int c = 1;
    int cinv = 1;

    public Hero(Integer x, Integer y, Image image, Integer index, Integer tFrame, Integer indexMax, Integer winSizel, Integer winSizeh , Integer offX, Integer offY) {
        super(x, y, image, index, tFrame, indexMax, winSizel, winSizeh, offX, offY);
        this.X = x;
        this.Y = y;
    }

    void update(long time){
        if(Y==250 && c==1) {
            setOffY(0);
            setIndex((getIndex() + 1) % getIndexMax());
        }
        if(Y<250 && Y>220) {
            setOffY(160);
            if (vy<0) {setIndex(0);}
            if (vy>=0) {setIndex(1);}
            ay += 0.2;
        }
        if(Y<225) {
            setOffY(160);
            if (vy<0) {setIndex(0);}
            if (vy>=0) {setIndex(1);}
            ay += 0.15;
        }
        vy = vy+ay;
        Y = (int)vy+Y;
        if (Y>=250) {ay=0; vy=0; Y=250;}
        getImageView().setY(Y);
        if(tInv>0){
            cinv = (cinv+1)%50;
            if (cinv == 1){
                tInv-=time;
            }
        }
        c=(c+1)%10;
    }

    void jump() {
        ay -= 1.7;
        vy = -6;
        System.out.println("Jump");
    }

    boolean isInvincible() {
        return (tInv>0);
    }

    public void setTInv(long tInv) {
        this.tInv = tInv;
    }
}
