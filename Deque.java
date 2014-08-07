import java.util.Iterator;

/**
* @author Mamie
* Implementation of double-ended queue using doubly linked list
* @see http://coursera.cs.princeton.edu/algs4/assignments/queues.html
*/

public class Deque<Item> implements Iterable<Item> {
    private int N;              // size
    private Node first;
    private Node last;

/**
* inner class to define Node
*/
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    // initialize an empty deque
    public Deque() {
        first = null;
        last = null;
        N = 0;
    }

/**
* @return the size of deque
*/
    public int size() {
        return N;
    }

/**
* @return true if the deque is empty else false
*/
    public boolean isEmpty() {
        return N == 0;
    }

/**
* add elements to the front of the deque
*/
    public void addFirst(Item item) {
        if (item == null)
            throw new NullPointerException("cannot add null item.");
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.prev = null;
        if (isEmpty()) {
            first.next = null;
            last = first;
        }
        /*else if (N == 1) {
            last.prev = first;
            first.next = last;
        }*/
        else {
            oldfirst.prev = first;
            first.next = oldfirst;
        }
        N++;
    }


/**
* add elements to the end of the deque
*/
    public void addLast(Item item) {
        if (item == null)
            throw new NullPointerException("cannot add null item.");
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            last.prev = null;
            first = last;
        }
        /*else if (N == 1) {
            last.prev = first;
            first.next = last;
        }*/
        else {
            oldlast.next = last;
            last.prev = oldlast;
        }
        N++;
    }

/**
* remove elements from the front of the deque
*/
    public Item removeFirst() {
        if (isEmpty())
        throw new java.util.NoSuchElementException("empty deque.");
        Item item = first.item;
        if (N == 1) {
            first = null;
            last = null;
        }
        else {
            first = first.next;
            first.prev = null;
        }
        N--;
        return item;
    }

/**
* @return elements from the end of the deque
*/
    public Item removeLast() {
        if (isEmpty())
            throw new java.util.NoSuchElementException("empty deque.");
        Item item = last.item;
        if (N == 1) {
            last = null;
            first = null;
        }
        else {
            last = last.prev;
            last.next = null;
        }
        N--;
        return item;
    }

/**
* @return an iterator of the queue
*/
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

/**
* ListIterator class
*/
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public void remove() {
            throw new UnsupportedOperationException("remove() is not supported.");
        }
        public Item next() {
            if (!hasNext())
                throw new java.util.NoSuchElementException("no more element to return.");
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

/**
* modular testing
*/
    public static void main(String[] args) {
        Deque<String> d = new Deque<String>();
        d.addFirst(args[0]);
        d.addLast(args[1]);
        d.addFirst(args[2]);
        for (String s : d) {
            StdOut.println(s);

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-") && !item.equals("+"))
                d.addFirst(item);
            else if (item.equals("-") && !d.isEmpty())
                StdOut.print(d.removeFirst() + " ");
            else if (item.equals("+") && !d.isEmpty())
                StdOut.print(d.removeLast() + " ");
        }
        StdOut.println("(" + d.size() + " left on deque.)");
    }

    }
}





