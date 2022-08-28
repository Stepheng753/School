package Interface;

public interface StackSpecs <E> {

    public boolean isEmpty ();
    public void emptyStack ();
    public void push (E pushObj);
    public E pop ();
    public E peek ();
}
