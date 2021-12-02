import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.animation.AnimationTimer;

public class main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Lone Wolf");

        Group root = new Group();
        Group root2 = new Group();
        Group root3 = new Group();
        Pane pane = new Pane(root);
        Pane pane2 = new Pane(root2);
        Pane pane3 = new Pane(root3);
        Camera cam = new Camera(0,0);

        Image background = new Image("./images/desert.png");
        Image fullhearts = new Image("./images/fullhearts.png");
        Image spriteSheet = new Image("./images/heros.png");
        Image wolfSheet = new Image("./images/wolf.png");

        StartScene start = new StartScene(cam, pane2, 800, 400, true, background);
        EndScene end = new EndScene(cam, pane3, 800,400,true,background);
        GameScene theScene = new GameScene(cam, pane, 800, 400,true, background, fullhearts, spriteSheet, wolfSheet);

        root.getChildren().addAll(theScene.getLeft().getImageView(),theScene.getRight().getImageView(),theScene.getStfullhearts().getImageView(),theScene.getHero().getImageView(),theScene.getFin(), theScene.getTryAgain());
        for(int i=0; i<=theScene.getNfoe(); i++) {
            root.getChildren().add(theScene.getList().get(i).getImageView());
        }
        root2.getChildren().addAll(start.getBg().getImageView(),start.getRunner(),start.getPak());
        root3.getChildren().addAll(end.getBg().getImageView(),end.getFin(),end.getTryAgain());
        primaryStage.setScene(start);
        primaryStage.show();
        start.setOnMouseClicked((event) -> {
            theScene.getAtimer().start();
            primaryStage.setScene(theScene);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}