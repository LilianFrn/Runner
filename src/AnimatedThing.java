import javafx.geometry.Rectangle2D;
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
    private Integer offX;
    private Integer offY;

    public AnimatedThing(Integer x, Integer y, Image image, Integer index, Integer tFrame, Integer indexMax, Integer winSizel, Integer winSizeh, Integer offX, Integer offY) {
        X = x;
        Y = y;
        this.image = image;
        this.index = index;
        this.tFrame = tFrame;
        this.indexMax = indexMax;
        this.winSizeh = winSizeh;
        this.winSizel = winSizel;
        this.offX = offX;
        this.offY = offY;
        imageView = new ImageView(image);
        imageView.setX(X);
        imageView.setY(Y);
    }

    public Rectangle2D getHitbox() {
        Rectangle2D rec = new Rectangle2D(getImageView().getX(),getImageView().getY(),getWinSizel(),getWinSizeh());
        return rec;
    }

    public int getIndex() {
        return index;
    }

    public Integer gettFrame() {
        return tFrame;
    }

    public Integer getOffY() {
        return offY;
    }

    public void setOffY(Integer offY) {
        this.offY = offY;
    }

    public Integer getOffX() {
        return offX;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setX(Integer x) {
        X = x;
    }

    public Integer getIndexMax() {
        return indexMax;
    }

    public void setIndexMax(Integer indexMax) {
        this.indexMax = indexMax;
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

    public Integer getWinSizel() {
        return winSizel;
    }

    public Integer getWinSizeh() {
        return winSizeh;
    }
}
