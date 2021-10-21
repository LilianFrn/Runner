import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class GameScene extends Scene {
    private Camera cam;

    public GameScene(Camera cam, Pane pane, Integer sx, Integer sy, boolean bool) {
        super(pane,sx,sy,bool);
        this.cam = cam;
    }

    public Camera getCam() {
        return cam;
    }
}
