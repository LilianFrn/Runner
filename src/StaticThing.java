import javax.swing.text.html.ImageView;

public class StaticThing {
    private Integer lon;
    private Integer lar;
    private ImageView imageView;

    public StaticThing(Integer lon, Integer lar, ImageView imageView) {
        this.lon = lon;
        this.lar = lar;
        this.imageView = imageView;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
