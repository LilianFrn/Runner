import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class EndScene extends Scene{

    private Camera cam;
    private StaticThing bg;
    private Image background;
    private Text fin;
    private Text tryAgain;

    public EndScene(Camera cam, Pane pane, Integer sx, Integer sy, boolean bool, Image background) {
        super(pane, sx, sy, bool);
        this.cam = cam;
        this.fin = new Text();
        this.tryAgain = new Text();
        fin.setX(200);
        fin.setY(100);
        fin = textStyle(fin, 80);
        tryAgain.setX(260);
        tryAgain.setY(150);
        tryAgain = textStyle(tryAgain, 40);
        bg = new StaticThing(0,0,background);
        bg.getImageView().setViewport(new Rectangle2D(0,0,800,400));
    }

    public Text textStyle(Text text, int t){
        text.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR, t));
        text.setFill(Color.WHITE);
        text.setStroke(Color.BLACK);
        text.setStrokeWidth(2);
        return text;
    }

    public StaticThing getBg() {
        return bg;
    }

    public Text getFin() {
        return fin;
    }

    public Text getTryAgain() {
        return tryAgain;
    }
}
