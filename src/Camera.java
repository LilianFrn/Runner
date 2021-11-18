public class Camera {

    private Integer cx;
    private Integer cy;

    public Integer getCx() {
        return cx;
    }
    public Integer getCy() {
        return cy;
    }

    public Camera(Integer cx, Integer cy) {
        this.cx = cx;
        this.cy = cy;
    }

    void update(long time){

    }

    @Override
    public String toString() {
        return cx+","+cy;
    }
}
