package se.so4it.learn.java.reflection.proxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Ali Yusha {@literal <mailto:Ali.yusha@konsult.folksam.se/>}
 */
public class AddingTwoNumbers  implements InvocationHandler{

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        final int[] i = {0};
        DealWithProxies dealWithProxies = new DealWithProxies() {
            @Override
            public int twoArgs(int a, int b) {
                System.out.println(a +":"+b);
              return i[0] =a +b;
            }
        };
        System.out.println(i[0]);
        return i[0];
    }
}
