import java.util.ArrayList;

public class Tester2 {
 public static void main(String[] args) {
	 
	 ArrayList<Integer>list= new ArrayList<>();
	 list.add(2);
	 list.add(4);
	 list.add(11);
	 list.add(9);
	 list.add(8);
	 System.out.println(list.toString());
	 
	 ArrayQueue<Integer> q= new ArrayQueue<>();
	 q.sort(list);
	 System.out.println(list);
	 
	 
 }
}
