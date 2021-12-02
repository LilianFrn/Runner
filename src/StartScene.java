import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class StartScene extends Scene{

    private Camera cam;
    private StaticThing bg;
    private Image background;
    private Text runner;
    private Text pak;

    public StartScene(Camera cam, Pane pane, Integer sx, Integer sy, boolean bool, Image background) {
        super(pane, sx, sy, bool);
        this.cam = cam;
        this.runner = new Text();
        this.pak = new Text();
        runner.setText("Lone Wolf");
        runner.setX(200);
        runner.setY(100);
        runner = textStyle(runner, 80);
        pak.setText("Press Any Key");
        pak.setX(260);
        pak.setY(150);
        pak = textStyle(pak, 40);
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

    public Text getRunner() {
        return runner;
    }

    public Text getPak() {
        return pak;
    }
}
