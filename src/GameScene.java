import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

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
    private long last;
    private ArrayList<Foe> list;
    private int nfoe;
    private int wolf;
    private Text fin;
    private Text tryAgain;

    public GameScene(Camera cam, Pane pane, Integer sx, Integer sy, boolean bool, Image background, Image fullhearts, Image spriteSheet, Image wolfSheet) {
        super(pane,sx,sy,bool);
        this.cam = cam;
        this.background = background;
        this.fullhearts = fullhearts;
        this.spriteSheet = spriteSheet;
        this.wolfSheet = wolfSheet;

        numberOfLives = 3;
        nfoe = ThreadLocalRandom.current().nextInt(20, 30);
        wolf = 0;
        list = generateList(nfoe);

        fin = new Text();
        fin.setX(200);
        fin.setY(100);
        fin = textStyle(fin, 80);
        tryAgain = new Text();
        tryAgain.setX(300);
        tryAgain.setY(150);
        tryAgain = textStyle(tryAgain, 40);

        left = new StaticThing(0,0,background);
        left.getImageView().setViewport(new Rectangle2D(0,0,800,400));
        right = new StaticThing(800,0,background);
        right.getImageView().setViewport(new Rectangle2D(0,0,800,400));
        hero = new Hero(80,250, spriteSheet,0,3800000,6,60,100,84, 0);
        stfullhearts = new StaticThing(20,20,fullhearts);
        stfullhearts.getImageView().setViewport(new Rectangle2D(0,0,(35*numberOfLives)+1,32));

        this.setOnMouseClicked((event)->{
            if (hero.getImageView().getY()>=250) {hero.jump();}
        });
    }

    public Text textStyle(Text text, int t){
        text.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR, t));
        text.setFill(Color.WHITE);
        text.setStroke(Color.BLACK);
        text.setStrokeWidth(2);
        return text;
    }

    void update(long time){
        hero.getImageView().setViewport(new Rectangle2D((hero.getOffX()*hero.getIndex())+7, 0+hero.getOffY(),75,100));
        for (int i=0; i < nfoe; i++){
            list.get(i).getImageView().setViewport(new Rectangle2D((list.get(i).getOffX()*list.get(i).getIndex())+23, 43+list.get(i).getOffY(),131,78));
            list.get(i).getImageView().setX(list.get(i).getX()-(cam.getCx())*2);
            if (collision(hero, list.get(i)) && hero.isInvincible()==false) {
                System.out.println("Crash");
                numberOfLives-=1;
                hero.setTInv(100000000000000L);
                if (numberOfLives==0){
                    stfullhearts.getImageView().setViewport(new Rectangle2D(0,0,1,1));
                    Atimer.stop();
                    fin.setText("Game Over");
                    tryAgain.setText("Try again :)");
                }
                else {
                    stfullhearts.getImageView().setViewport(new Rectangle2D(0,0,35*numberOfLives,32));
                }
            }
        }
        if (wolf<nfoe){
            if (list.get(wolf).getImageView().getX()<0){
                wolf++;
            }
        }
        if (wolf==nfoe){
            Atimer.stop();
            fin.setText("You won !");
            tryAgain.setX(230);
            tryAgain.setText("Congratulations");
        }
        left.getImageView().setX(0-cam.getCx()%800);
        right.getImageView().setX(800-cam.getCx()%800);
        cam.setXhero(cam.getXhero()+5);
    }

    AnimationTimer Atimer = new AnimationTimer(){
        public void handle(long time){
            if (time - last >= hero.gettFrame()) {
                hero.update(time);
                for (int i=0; i < nfoe; i++) {
                    list.get(i).update(time);
                }
                cam.update(time);
                update(time);
                last = time;
            }
        }
    };

    public boolean collision(AnimatedThing a1, AnimatedThing a2){
        Rectangle2D rec1 = a1.getHitbox();
        Rectangle2D rec2 = a2.getHitbox();
        Rectangle2D rec3 = new Rectangle2D(rec2.getMinX(),rec2.getMinY(),rec2.getWidth()-60,rec2.getHeight());
        return rec1.intersects(rec3);
    }

    public ArrayList<Foe> generateList(int n){
        ArrayList<Foe> list = new ArrayList<Foe>();
        int rn = 0;
        int c = 0;
        for(int i=0; i<=n; i++){
            rn = ThreadLocalRandom.current().nextInt(300, 799 + 1);
            list.add(new Foe(1000+c+rn,268, wolfSheet,0,38000000,4,131,78,165, 0));
            c+=rn+300;
        }
        return list;
    }

    public AnimationTimer getAtimer() { return Atimer;}
    public Camera getCam() { return cam; }
    public StaticThing getLeft() { return left; }
    public StaticThing getRight() { return right; }
    public StaticThing getStfullhearts() { return stfullhearts; }
    public Hero getHero() { return hero; }
    public ArrayList<Foe> getList() { return list; }
    public int getNfoe() { return nfoe; }
    public int getWolf() {return wolf;}
    public int getNumberOfLives() { return numberOfLives; }
    public Text getFin() {
        return fin;
    }

    public Text getTryAgain() {
        return tryAgain;
    }
}