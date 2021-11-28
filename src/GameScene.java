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
    private Image wolfSheet;
    private StaticThing stfullhearts;
    private int numberOfLives;
    private Hero hero;
    private Foe wolf;
    private long last;

    public GameScene(Camera cam, Pane pane, Integer sx, Integer sy, boolean bool, Image background, Image fullhearts, Image spriteSheet, Image wolfSheet) {
        super(pane,sx,sy,bool);
        this.cam = cam;
        this.background = background;
        this.fullhearts = fullhearts;
        this.spriteSheet = spriteSheet;
        this.wolfSheet = wolfSheet;
        numberOfLives = 3;
        timer.start();
        left = new StaticThing(0,0,background);
        left.getImageView().setViewport(new Rectangle2D(0,0,800,400));
        right = new StaticThing(800,0,background);
        right.getImageView().setViewport(new Rectangle2D(0,0,800,400));
        hero = new Hero(80,250, spriteSheet,0,38000000,6,60,100,84, 0);
        wolf = new Foe(1000,268, wolfSheet,0,38000000,4,131,78,165, 0);
        stfullhearts = new StaticThing(20,20,fullhearts);
        stfullhearts.getImageView().setViewport(new Rectangle2D(0,0,35*numberOfLives,32));
        this.setOnMouseClicked((event)->{
            if (hero.getImageView().getY()>=250) {hero.jump();}
        });
    }

    void update(long time){
        hero.getImageView().setViewport(new Rectangle2D((hero.getOffX()*hero.getIndex())+7, 0+hero.getOffY(),75,100));
        wolf.getImageView().setViewport(new Rectangle2D((wolf.getOffX()*wolf.getIndex())+23, 43+wolf.getOffY(),131,78));
        wolf.getImageView().setX(wolf.getX()-(cam.getCx())*3);
        left.getImageView().setX(0-cam.getCx()%800);
        right.getImageView().setX(800-cam.getCx()%800);
        cam.setXhero(cam.getXhero()+10);
        if (collision(hero, wolf)) {
            System.out.println("Crash");
            timer.stop();
        }
    }

    AnimationTimer timer = new AnimationTimer(){
        public void handle(long time){
            if (time - last >= hero.gettFrame()) {
                hero.update(time);
                wolf.update(time);
                cam.update(time);
                update(time);
                last = time;
            }
        }
    };

    public boolean collision(AnimatedThing a1, AnimatedThing a2){
        Rectangle2D rec1 = a1.getHitbox();
        Rectangle2D rec2 = a2.getHitbox();
        return rec1.intersects(rec2);
    }

    public Camera getCam() { return cam; }
    public StaticThing getLeft() { return left; }
    public StaticThing getRight() { return right; }
    public StaticThing getStfullhearts() { return stfullhearts; }
    public Foe getWolf() { return wolf; }
    public Hero getHero() { return hero; }
}