import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int N = 0;
    private Item[] a;
    
    // construct an empty RandomizedQueue
    public RandomizedQueue() {
        a = (Item[]) new Object[2];
    }
    
    // Is the queue empty
    public boolean isEmpty() {
        return N == 0;
    }
    
    // How many elements doees the queue have
    public int size() {
        return N;
    }
    
    // add items into the resizable array
    public void enqueue(Item item) {
        if (item == null)
            throw new java.lang.NullPointerException("cannot add null item.");
        if (N == a.length)
            resize(2 * a.length);
        a[N++] = item;
    }
    
    // resize the array and copying the original array into the new array
    private void resize(int max) {
        assert max >= N;
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) 
            temp [i] = a[i];
        a = temp;
    }
    
    // return a random element from the queue and delete it
    public Item dequeue() {
        if (isEmpty()) 
            throw new java.util.NoSuchElementException("the queue is empty.");
        int index = StdRandom.uniform(N);
        Item item = a[index];
        // move the last item to fill in the place of removed item
        a[index] = a[N-1];
        a[N-1] = null;
        N--;
        // shrink the array if necessary
        if (N > 0 && N == a.length/4) 
            resize(a.length/2);
        return item;
    }
    
    // return a random element from the queue without deleting it
    public Item sample() {
        if (isEmpty())
            throw new java.util.NoSuchElementException("the queue is empty.");
        return a[StdRandom.uniform(N)];
    }
    
    // return a random iterator
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }
    
    // class ArrayIterator
    private class ArrayIterator implements Iterator<Item> {
        private int i;
        private Item[] copy;
        
        public ArrayIterator() {
            copy = (Item[]) new Object[N];
            i = N;
            
        for (int k = 0; k < N; k++) 
            copy[k] = a[k];
        StdRandom.shuffle(copy);
        }
        
        public void remove() {
            throw new UnsupportedOperationException("remove() is not supported.");
        }
        
        public boolean hasNext() {
            return i > 0;
        }
        
        public Item next() {
            if (!hasNext())
                throw new java.util.NoSuchElementException("empty queue.");
            return copy[--i];
        }
    }
}
              
        
      
       
        
    