import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.animation.AnimationTimer;

public class GameScene extends Scene {

    private Camera cam;
    private StaticThing left;
    private StaticThing right;
    private Image background;
    private Image fullhearts;
    private Image spriteSheet;
    private StaticThing stfullhearts;
    private int numberOfLives;
    private static Hero hero;
    private long last;

    public GameScene(Camera cam, Pane pane, Integer sx, Integer sy, boolean bool, Image background, Image fullhearts, Image spriteSheet) {
        super(pane,sx,sy,bool);
        this.cam = cam;
        this.background = background;
        this.fullhearts = fullhearts;
        this.spriteSheet = spriteSheet;
        numberOfLives = 3;
        timer.start();
        left = new StaticThing(0,0,background);
        left.getImageView().setViewport(new Rectangle2D(0,0,800,400));
        right = new StaticThing(800,0,background);
        right.getImageView().setViewport(new Rectangle2D(0,0,800,400));
        hero = new Hero(80,0, spriteSheet,1,38000000,6,60,100,84);
        stfullhearts = new StaticThing(20,20,fullhearts);
        stfullhearts.getImageView().setViewport(new Rectangle2D(0,0,35*numberOfLives,32));

    }

    AnimationTimer timer = new AnimationTimer(){
        public void handle(long time){
            if (time - last >= hero.gettFrame()) {
                hero.update(time);
                cam.update(time);
                GameScene.update(time);
                last = time;
            }
        }
    };

    static void update(long time){
        hero.getImageView().setViewport(new Rectangle2D((hero.getOffFrame()*hero.getIndex())+7, 0,75,100));
    }

    public Camera getCam() { return cam; }
    public StaticThing getLeft() { return left; }
    public StaticThing getRight() { return right; }
    public StaticThing getStfullhearts() { return stfullhearts; }
    public Hero getHero() { return hero; }
}