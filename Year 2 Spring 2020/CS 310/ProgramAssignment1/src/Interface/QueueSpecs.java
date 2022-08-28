package Interface;

public interface QueueSpecs <E>{

    public boolean isEmpty ();
    public void emptyQueue ();
    public void enqueue (E enqueueObj);
    public E dequeue ();
    public E peek ();
}
