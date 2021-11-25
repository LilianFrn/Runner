import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Hello world");
        Group root = new Group();
        Pane pane = new Pane(root);
        Camera cam = new Camera(0,0);
        Image background = new Image("./images/desert.png");
        Image fullhearts = new Image("./images/fullhearts.png");
        Image spriteSheet = new Image("./images/heros.png");
        GameScene theScene = new GameScene(cam, pane, 800, 400,true, background, fullhearts, spriteSheet);
        root.getChildren().addAll(theScene.getLeft().getImageView(),theScene.getRight().getImageView(),theScene.getStfullhearts().getImageView(),theScene.getHero().getImageView());
        primaryStage.setScene(theScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}