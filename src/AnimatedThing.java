import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AnimatedThing {

    private Integer X;
    private Integer Y;
    private Image image;
    private ImageView imageView;
    private Integer state;
    private Integer nbFrames;
    private Integer hFrame;
    private Integer wFrame;
    private Integer xFrame;
    private Integer yFrame;

    public AnimatedThing(Integer X, Integer Y, Image image, Integer xFrame, Integer yFrame, Integer hFrame, Integer wFrame) {
        this.X = X;
        this.Y = Y;
        this.xFrame = xFrame;
        this.yFrame = yFrame;
        this.hFrame = hFrame;
        this.wFrame = wFrame;
        this.image = image;
        imageView = new ImageView(image);
        imageView.setX(X);
        imageView.setY(Y);
        imageView.setViewport(new Rectangle2D(xFrame,yFrame,hFrame,wFrame));
    }

    public ImageView getImageView() {
        return imageView;
    }
}
