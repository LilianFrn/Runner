import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class GameScene extends Scene {

    private Camera cam;
    private StaticThing left;
    private StaticThing right;
    private Image background;
    private Image fullhearts;
    private StaticThing stfullhearts;
    private int numberOfLives;

    public GameScene(Camera cam, Pane pane, Integer sx, Integer sy, boolean bool, Image background, Image fullhearts) {
        super(pane,sx,sy,bool);
        this.cam = cam;
        this.background = background;
        this.fullhearts = fullhearts;
        numberOfLives = 3;
        left = new StaticThing(0,0,background);
        left.getImageView().setViewport(new Rectangle2D(0,0,800,400));
        right = new StaticThing(800,0,background);
        right.getImageView().setViewport(new Rectangle2D(0,0,800,400));
        stfullhearts = new StaticThing(20,20,fullhearts);
        stfullhearts.getImageView().setViewport(new Rectangle2D(0,0,35*numberOfLives,32));
    }

    public Camera getCam() { return cam; }
    public StaticThing getLeft() { return left; }
    public StaticThing getRight() { return right; }
    public StaticThing getStfullhearts() { return stfullhearts; }
}