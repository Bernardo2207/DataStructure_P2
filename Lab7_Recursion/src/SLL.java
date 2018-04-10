import java.util.ArrayList;

public class SLL<E> {
	private static class Node<E> {
		private E element; 
		private Node<E> next;
		public Node(E element, Node<E> next) {
			super();
			this.element = element;
			this.next = next;
		}
		public Node(E element) { this(element, null); } 
		public Node() { this(null, null); }
		public E getElement() { return element; }
		public void setElement(E element) { this.element = element; }
		public Node<E> getNext() { return next; }
		public void setNext(Node<E> next) { this.next = next; }	
	}

	private Node<E> first = null; 
	private int size = 0; 	
	public void addFirst(E e) { 
		first = new Node<>(e, first); 
		size++; 
	}
	
              // returns string formed by elements in this list, separated by spaces
	public String toString() { 
		String s = ""; 
		Node<E> current = first; 
		while (current != null) { 
			s += " " + current.getElement(); 
			current = current.getNext(); 
		}
		return s; 
	}	
	


public void reverse() { 
   if (size > 1) 
      first = recReverse(first,first); 
} 

private Node<E> recReverse(Node<E> b, Node<E> c) { 
	
	
    if  (c==null) return b;
    Node<E> a=c.getNext(); 
    c.setNext(b);
    return recReverse(c, a);
}
private Pair<E> recReverse(Node<E> first) { 
	// returns a pair (fr, lr), where fr is the first node
		//in that resulting reversed linked list 
		//and lr is the last node in that reversed linked list.
		
    if  (first==null) return null;
    //rF=First of the reverse list.
    Pair<E> rF =recReverse(first.getNext());
   // addLast(rF,first);
    Pair<E> p=new Pair<>();
    
  //  p.first(rF);
   
    
    
    return p;
}

public ArrayList<E> lessThan(E e) { 
   ArrayList<E> result = new ArrayList<>();     // and empty ArrayList object
   if (size > 0) 
      recLessThan(first, e, result);   // passing only reference to result
   return result; 
}

private void recLessThan(Node<E> fr, E e, ArrayList<E> result) { 
	   if (fr != null) { 
	      if (((Comparable<E>) fr.getElement()).compareTo(e) < 0)
	         result.add(fr.getElement()); 
	      recLessThan(fr.getNext(), e, result);  // passing reference to result
	   }
	} 


public ArrayList<Pair<E>> consecutiveIncreasingPairs() { 
   ArrayList<Pair<E>> result = new ArrayList<>();     // and empty ArrayList object
   if (size > 0) 
      recCIP(first, result); 
   return result; 
}

public ArrayList<Pair<E>> recCIP(Node<E> first,ArrayList<Pair<E>> result){
//The execution of recCIP(first, result) can be described as follows: 
//adds to the list result all the consecutive pairs of consecutive increasing
//elements in the linked list whose first node is referenced by first. 
//Notice that if first is null, or if first.getNext() is null, then no such pair exists in the 
//list whose first node is first.
	
	// If a pair exists, check if the next possible pair satisfies the condition. 
	//If it does, add a new pair to result. No matter what happens, the rest of the pairs, 
	//if any, will be found by applying recCIP to the remaining of the list; that is, the 
	//list whose first node is the node after first, and so on... You should determine that 
	//the base case is for this recursion. 
		
	
if(first==null) {return null;}
	if((((Comparable<E>) first.getElement()).compareTo(first.getNext().getElement()) < 0)) {
		result.add(new Pair(first.getElement(),first.getNext().getElement()));}
	
	 recCIP(first.getNext(), result);
	 return result;




		}
}
