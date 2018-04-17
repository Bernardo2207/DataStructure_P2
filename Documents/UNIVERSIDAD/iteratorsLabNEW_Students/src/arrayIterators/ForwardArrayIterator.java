package arrayIterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardArrayIterator<E> implements Iterator<E> {

	private E[] arr;
	private int current;// the array to iterate over
	// other internal fields...
	
	public ForwardArrayIterator(E[] arr) { 
		this.arr = arr; 
		current=0;
		// initialize other internal fields as needed
	}
	
	public boolean hasNext() {
		// rewrite...
		if(current!=arr.length)
		return true;   
		else 
			return false;
	}

	public E next() throws NoSuchElementException {
		if (!hasNext())
			throw new 
				NoSuchElementException("No more elements to iterate over."); 
		// rewrite
		E etr= arr[current];
		
		current++;

		return etr;
	}

	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException(
				"Remove peration not implemented.");
		// do not implement
	}
}
