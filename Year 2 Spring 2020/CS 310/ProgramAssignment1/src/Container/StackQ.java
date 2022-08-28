package Container;
import Interface.QueueSpecs;

public class StackQ <E> implements QueueSpecs <E> {

    private LLStack <E> enqueueStack;
    private LLStack <E> dequeueStack;

    public StackQ () {
        enqueueStack = new LLStack<E>();
        dequeueStack = new LLStack<E>();
    }

    @Override
    public boolean isEmpty() {
        return dequeueStack.isEmpty();
    }

    @Override
    public void emptyQueue() {
        dequeueStack.emptyStack();
    }

    @Override
    public void enqueue(E enqueueObj) {
        try {
            if (enqueueObj == null) {
                throw new Exception("Cannot Enqueue Null Values into StackQ");
            }

            while (!dequeueStack.isEmpty()) {
                E dqPopVal = dequeueStack.pop();
                enqueueStack.push(dqPopVal);
            }
            enqueueStack.push(enqueueObj);
            while (!enqueueStack.isEmpty()) {
                E eqPopVal = enqueueStack.pop();
                dequeueStack.push(eqPopVal);
            }

        } catch (Exception nullEnqueue) {
            System.out.println(nullEnqueue.getMessage());
        }
    }

    @Override
    public E dequeue() {
        try {
            if (isEmpty()) {
                throw new Exception("Cannot Dequeue Because StackQ is Empty");
            }

            E returnVal = dequeueStack.pop();

            return returnVal;

        } catch (Exception emptyStackQ) {
            System.out.println(emptyStackQ.getMessage());
            return null;
        }
    }

    @Override
    public E peek() {
        try {
            if (isEmpty()) {
                throw new Exception("Cannot Peek Because StackQ is Empty");
            }

            E returnVal = dequeueStack.peek();

            return returnVal;

        } catch (Exception emptyStackQ) {
            System.out.println(emptyStackQ.getMessage());
            return null;
        }
    }

    public int getStackQSize () {
        return dequeueStack.getStackSize();
    }

    public String toString () {
        return dequeueStack.toString();
    }

    public LLStack<E> getEnqueueStack() {
        return enqueueStack;
    }

    public LLStack<E> getDequeueStack() {
        return dequeueStack;
    }
}
