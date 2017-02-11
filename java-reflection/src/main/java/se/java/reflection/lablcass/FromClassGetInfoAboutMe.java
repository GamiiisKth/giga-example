package se.java.reflection.lablcass;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class FromClassGetInfoAboutMe {


    private String imAPrivateString;
    public String imAPublicString;


    public FromClassGetInfoAboutMe(String imAPrivateString) {
        this.imAPrivateString = imAPrivateString;
    }
    public FromClassGetInfoAboutMe(String imAPrivateString, String imAPublicString) {
        this.imAPrivateString = imAPrivateString;
        this.imAPublicString = imAPublicString;

    }

    public String getImAPrivateString() {
        return imAPrivateString;
    }

    private void setImAPrivateString(String imAPrivateString) {
        this.imAPrivateString = imAPrivateString;
    }

    public String getImAPublicString() {
        return imAPublicString;
    }

    public void setImAPublicString(String imAPublicString) {
        this.imAPublicString = imAPublicString;
    }
}
