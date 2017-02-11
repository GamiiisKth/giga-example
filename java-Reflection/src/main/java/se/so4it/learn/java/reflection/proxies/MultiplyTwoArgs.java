package se.so4it.learn.java.reflection.proxies;

/**
 * @author Ali Yusha {@literal <mailto:Ali.yusha@konsult.folksam.se/>}
 */
public class MultiplyTwoArgs implements DealWithProxies {

    @Override
    public int twoArgs(int a, int b) {
        return a*b;
    }
}
