Randomized queue and deque
=====

Summary
---------
Use resizable array and linked list to implement two elementary data structure respectively: randomized queue and deque.

Randomized queue
--------------------
Implementation of a queue that allows for uniformly random removal of items in the data structure based on resizable array. API is as follows:

    public class RandomizedQueue<Item> implements Iterable<Item> {
    public RandomizedQueue()                 // construct an empty randomized queue
    public boolean isEmpty()                 // is the queue empty?
    public int size()                        // return the number of items on the queue
    public void enqueue(Item item)           // add the item
    public Item dequeue()                    // delete and return a random item
    public Item sample()                     // return (but do not delete) a random item
    public Iterator<Item> iterator()         // return an independent iterator over items in random order
    public static void main(String[] args)   // unit testing}
    }

Deque
------------------------
A double-ended stack data structure implemented by double linked list, which allows for insertion and deletion of items at both end. API is as follows:

    public class Deque<Item> implements Iterable<Item> {
    public Deque()                           // construct an empty deque
    public boolean isEmpty()                 // is the deque empty?
    public int size()                        // return the number of items on the deque
    public void addFirst(Item item)          // insert the item at the front
    public void addLast(Item item)           // insert the item at the end
    public Item removeFirst()                // delete and return the item at the front
    public Item removeLast()                 // delete and return the item at the end
    public Iterator<Item> iterator()         // return an iterator over items in order from front to end
    public static void main(String[] args)   // unit testing
    }

Assignment details can be found at:
> http://coursera.cs.princeton.edu/algs4/assignments/queues.html
