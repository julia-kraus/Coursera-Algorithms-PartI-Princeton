import java.util.Iterator;

/*
A randomized queue is similar to a stack or queue, except that the item removed is chosen uniformly at random among
items in the data structure. This sounds like an array implementation. Each iterator must return the items in uniformly
random order. The order of two or more iterators to the same randomized queue must be mutually independent, each
iterator must maintain its random order.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public RandomizedQueue() {

    }

    public boolean isEmpty() {
        return true;
    }

    public int size() {
        return 0;
    }

    public void enqueue(Item item) {
        if (item == null) throw new java.lang.IllegalArgumentException();
    }

    public Item dequeue() {

    }

    public Item sample() {

    }

    // unit testing(required)
    public static void main(String[] args) {

    }
}
