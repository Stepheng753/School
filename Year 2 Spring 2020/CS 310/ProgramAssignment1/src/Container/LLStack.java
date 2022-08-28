package Container;
import Interface.StackSpecs;

public class LLStack <E> implements StackSpecs <E> {

    private Node <E> top;
    private int stackSize;

    public LLStack () {
        this.top = null;
        this.stackSize = 0;
    }

    @Override
    public boolean isEmpty() {
        if (top == null) {
            return true;
        }
        return false;
    }

    @Override
    public void emptyStack() {
        int currentSize = stackSize;
        for (int i = 0; i < currentSize; i++) {
            pop();
        }
    }

    @Override
    public void push(E pushObj) {
        try {
            if (pushObj == null) {
                throw new Exception("Cannot Push Null Values into Stack");
            }

            Node <E> pushNode = new Node <> (pushObj, top);     // Creates pushNode with pushObj as its data, and nextNode = top
            top = pushNode;                             // Sets the top to the pushNode, as its the new top of Stack
            stackSize++;                                // Increments stackSize by 1 as size has increased

        } catch (Exception nullPush) {
            System.out.println(nullPush.getMessage());
        }
    }

    @Override
    public E pop() {
        try {
            if (isEmpty()) {
                throw new Exception("Cannot Pop Because Stack is Empty");
            }

            E popData = top.getData();                  // Holds the Top Value to return later
            top = top.getNextNode();                    // Sets the top to its nextNode
            stackSize--;                                // Decrements stackSize by 1 as size has decreased
            return popData;

        } catch (Exception emptyStack) {
            System.out.println(emptyStack.getMessage());
            return null;
        }
    }

    @Override
    public E peek() {
        return top.getData();
    }

    public int getStackSize () {
        return stackSize;
    }

    @Override
    public String toString () {
        int j = 0;
        int currentSize = stackSize;
        LLStack <E> stackHolder = new LLStack<>();

        String stackDisplay = "[ ";
        while (!isEmpty()) {
            if (j++ != 0) {
                stackDisplay = stackDisplay.concat("  ");
            }
            E popVal = pop();
            stackHolder.push(popVal);
            stackDisplay = stackDisplay.concat(String.valueOf(popVal));
            if (j != currentSize) {
                stackDisplay = stackDisplay.concat("\n");
            }
        }
        while (!stackHolder.isEmpty()) {
            push(stackHolder.pop());
        }
        stackDisplay = stackDisplay.concat(" ]");
        return stackDisplay;
    }
}
