import java.util.Iterator;
import java.util.NoSuchElementException;
/*
A double-ended queue or deque is a generalization of a stack and a queue that supports adding and removing items from
either the front or the back of the data structure. The deque implementation must support each deque operation
(including construction) in constant worst-case time. A deque containing `n` items must use at most `48n + 192` bytes of
memory. Additionally, your iterator implementation must support each operation in constant worst-case time. This sounds
like the linked-list implementation. Use doubly linked list
 */

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        public boolean hasNext() {
            return current != null;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) throw new NullPointerException();
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if (isEmpty()) last = first;
        oldFirst.prev = first;
        size++;
    }

    public void addLast(Item item) {
        if (item == null) throw new NullPointerException();
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.prev = oldLast;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        size++;


    }

    public Item removeFirst() {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        Item item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) last = first;
        else first.prev = null;
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        Item item = last.item;
        last = last.prev;
        size--;
        if (isEmpty()) first = last;
        else last.next = null;
        return item;
    }


    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque deque = new Deque<String>();
    }
}
