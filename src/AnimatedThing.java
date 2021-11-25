import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AnimatedThing {

    private Integer X;
    private Integer Y;
    private Image image;
    private ImageView imageView;
    private int index;
    private Integer tFrame;
    private Integer indexMax;
    private Integer winSizel;
    private Integer winSizeh;
    private Integer offFrame;

    public void setX(Integer x) {
        X = x;
    }

    public Integer getIndexMax() {
        return indexMax;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Integer getY() {
        return Y;
    }

    public Integer getX() {
        return X;
    }

    public AnimatedThing(Integer x, Integer y, Image image, Integer index, Integer tFrame, Integer indexMax, Integer winSizel, Integer winSizeh, Integer offFrame) {
        X = x;
        Y = y;
        this.image = image;
        this.index = index;
        this.tFrame = tFrame;
        this.indexMax = indexMax;
        this.winSizeh = winSizeh;
        this.winSizel = winSizel;
        this.offFrame = offFrame;
        imageView = new ImageView(image);
        imageView.setX(X);
        imageView.setY(Y);
    }



    void jump(){
        imageView.setY(0);
    }

    public int getIndex() {
        return index;
    }

    public Integer gettFrame() {
        return tFrame;
    }

    public Integer getOffFrame() {
        return offFrame;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
