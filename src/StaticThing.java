import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StaticThing {

    private Integer X;
    private Integer Y;
    private Image image;
    private ImageView imageView;

    public StaticThing(Integer X, Integer Y, Image image) {
        this.X = X;
        this.Y = Y;
        this.image = image;
        imageView = new ImageView(image);
        imageView.setX(X);
        imageView.setY(Y);
    }

    public ImageView getImageView() {
        return imageView;
    }
}
