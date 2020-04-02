package tutorial_anno.access_private;

public class PrivateObject {
    private String privateString = null;
    public int number;

    public PrivateObject(String privateString, int publicNumber) {
        this.privateString = privateString;
        number = publicNumber;

    }
}
