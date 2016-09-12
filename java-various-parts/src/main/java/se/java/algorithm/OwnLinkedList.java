package se.java.algorithm;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 *         <p>
 *         algorithm book page 142 Linked List
 *         +++
 *         old | first
 *         +++
 */
public class OwnLinkedList<T>  implements Iterable<T>{

    private Node first; // top of stack
    private int numberOfTs;



    private class Node {

        T T;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return numberOfTs;
    }

    public void push(T T) {
        Node oldfirst = first;
        first = new Node();
        first.T = T;
        first.next = oldfirst;
        numberOfTs++;
    }

    public T pop() {
        T T = first.T;
        first = first.next;
        numberOfTs--;
        return T;

    }
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }


}
