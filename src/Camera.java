public class Camera {

    private Integer cx;
    private Integer cy;
    double ax = 0;
    double vx = 0;
    double km = 0.1;
    double fm = 1;
    double xhero = 0;

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

    public void setXhero(double xhero) {
        this.xhero = xhero;
    }

    public double getXhero() {
        return xhero;
    }

    void update(long time){
        ax = km*(xhero-cx)+fm*vx;
        vx = ax;
        cx = (int)(vx);
    }

    public void setCx(Integer cx) {
        this.cx = cx;
    }

    @Override
    public String toString() {
        return cx+","+cy;
    }
}
