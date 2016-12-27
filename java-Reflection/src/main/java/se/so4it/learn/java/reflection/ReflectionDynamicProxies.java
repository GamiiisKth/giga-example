package se.so4it.learn.java.reflection;

import se.so4it.learn.java.reflection.proxies.AddingTwoNumbers;
import se.so4it.learn.java.reflection.proxies.DealWithProxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author Ali Yusha {@literal <mailto:Ali.yusha@konsult.folksam.se/>}
 *         <p>
 *         Using Java Reflection you create dynamic implementations of interfaces at runtime.
 *         java.lang.reflect.Proxy
 *         <p>
 *         Dynamic proxies can be used for many different purposes, e.g. database connection and transaction management,
 *         dynamic mock objects for unit testing, and other AOP-like method intercepting purposes.
 */
public class ReflectionDynamicProxies {

    public static void main(String[] args) {
        InvocationHandler addingTwoNumbers = new AddingTwoNumbers();
        DealWithProxies proxy = (DealWithProxies) Proxy.newProxyInstance(DealWithProxies.class.getClassLoader(),
                new Class[]{DealWithProxies.class},
                addingTwoNumbers);

    }


}
