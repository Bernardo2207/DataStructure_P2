import java.util.ArrayList;

public class ArrayQueue<E> implements Queue<E> {
	private final static int INITCAP = 4; 
	private E[] elements; 
	private int first, size; 
	public ArrayQueue() { 
		elements = (E[]) new Object[INITCAP]; 
		first = 0; 
		size = 0; 
	}
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() {
		if (isEmpty()) return null; 
		return elements[first]; 
	}

	public E dequeue() {
		if (isEmpty()) return null;
		E etr = elements[first]; 
		elements[first]=null;
		first=(first+1)%elements.length;
		size--;
		 
		//if (elements.length >= 2*INITCAP && size < elements.length/4)
			//changeCapacity(elements.length/2); 
		return etr; 
	}

	public void enqueue(E e) {
		if (size == elements.length) {   // check capacity, double it if needed
			changeCapacity(2*size); }
		elements[(first+size)%elements.length]=e;
		size++;
		

		//... finish the implementation of this method ... 
	}

	private void changeCapacity(int newCapacity) { 
		// PRE: newCapacity >= size

		//... finish the implementation of this method ...
		
		E[] t= (E[]) new Object[newCapacity];
		for(int i=0;i<size;i++) {
			t[i]=elements[(first+i)%size];
		}
		elements=t;
		first=0;
	}
	
	
	
	public void sort(ArrayList<E> ar){   // sorts the elements in q in non-decreasing order
		   if (ar.size() > 1) {     // if size is <= 1, then nothing needs to be done
		      //Queue<E> q,q1, q2; 
		      
		   //   q = new ArrayQueue<>();
		      
//		      for(E x:ar) {
//		    	  q.enqueue(x);
//		      }
		      // Initialize q1 and q2 to empty instances of  ArrayQueue as implemented in previous lab.
		      
		//      q1 = new ArrayQueue<>(); 
		  //    q2 = new ArrayQueue<>(); 
		      
		      ArrayList<E> ar1= new ArrayList<>();
		      ArrayList<E> ar2= new ArrayList<>();
		      

		      // split the elements of q in two halves (or close to), first half into q1 and second half into q2
		      int n = ar.size(); 
		      for (int i=0; i<n/2; i++) {
		    	 // E tem=q.dequeue();
		    	 E tem= ar.remove(0);
		         // q1.enqueue(tem);
		          ar1.add(tem);}
		      while (!ar.isEmpty()) {
		    	 // E tem=q.dequeue();
		    	 E tem= ar.remove(0);
		    //      q2.enqueue(tem); 
		          ar2.add(tem);
		          }

		      sort(ar1);    // recursively sort q1
		      sort(ar2);    // recursively sort q2

		      // What is left to do now is the merging operation. Given that q1 and q2 are each sorted, 
		      // efficiently combine is elements back into q so that they are placed in order from first to last. 
		      // This process efficiently exploits the property that both, q1 and q2, are sorted.
		      while (!ar1.isEmpty() && !ar2.isEmpty())
		          if (((Comparable<E>) ar1.get(0)).compareTo(ar2.get(0))<= 0) {
		        //	  E z=q1.dequeue();
		        	E z=  ar1.remove(0);
		            // q.enqueue(z); 
		             ar.add(z);}
		          else {
		        	//  E w=q2.dequeue();
		        	 E w= ar2.remove(0);
		          //   q.enqueue(w);
		             ar.add(w);}
		      // At this moment, one of the two queues, either q1 or q2, is empty.
		      ArrayList<E> r = (!ar1.isEmpty() ? ar1 : ar2);  // find which, q1 or q2, is not empty yet
		      while (!r.isEmpty()) {
		    	  E y =r.remove(0);
		       //   q.enqueue(y); 
		          ar.add(y);}
		     } 
		}

}
