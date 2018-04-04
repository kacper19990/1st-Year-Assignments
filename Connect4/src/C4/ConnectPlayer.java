package C4;

public abstract class ConnectPlayer {
    abstract String assignSign();

    protected String getSign() {
        return assignSign();
    }
}
