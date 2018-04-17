package linkedLists;

import interfaces.LinkedList;
import interfaces.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DLDHDTListIterableL2F<E> extends DLDHDTList<E> 
									  implements Iterable<E> 
{
	public Iterator<E> iterator() {
		return new LLIteratorL2F<E>(this);
	}

	private static class LLIteratorL2F<E> 
	implements Iterator<E> 
	{ 
		private LinkedList<E> theList;   // the list to iterate over
		// ... other internal fields ...
		private Node<E> current; 
		private boolean hasMoreElements; 

		public LLIteratorL2F(LinkedList<E> list) {
			theList = list; 
			if (theList.length() == 0) { 
				current = null; 
				hasMoreElements = false; 
			}
			else { 
				
				current = theList.getLastNode(); 
				hasMoreElements = true; 
			}
			// ... initialize other internal fields ...
		}

		public boolean hasNext() {
			// Write the new code and substitute next statement ....
			return hasMoreElements; 
		}

		public E next() throws NoSuchElementException {
			if(current==null)
				throw new NoSuchElementException("There is no such Element");
//			
			
			E etr=current.getElement();
			if(current!=theList.getFirstNode())
			current=theList.getNodeBefore(current);
				
			else
				hasMoreElements=false;
			
			
			// Write the new code and substitute next statement ...
			return etr;
		}

		public void remove() throws UnsupportedOperationException 
		{
			throw new UnsupportedOperationException("Remove is not implemented.");

		}
	}

}
