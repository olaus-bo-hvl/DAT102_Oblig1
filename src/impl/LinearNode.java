package impl;

public class LinearNode<Film> {

    private Film data;
    private LinearNode<Film> neste;
    private int antall;

    public LinearNode(Film data) {
        this.data = data;
        this.neste = null;
    }

    public Film getData() {
        return data;
    }

    public void setData(Film data) {
        this.data = data;
    }
}
