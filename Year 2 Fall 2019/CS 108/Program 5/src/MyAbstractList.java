/**
 * Program: 5
 * Description : My version of an ArrayList
 * Class: CS 108-2
 *
 * @author Stephen Giang
 * @date 11/25/2019
 **/

public abstract class MyAbstractList<E> implements MyList<E> {

	protected int size;
	
	public MyAbstractList() {
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public int size() {
		return this.size;
	}

}