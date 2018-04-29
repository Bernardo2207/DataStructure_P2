package Main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

import policies.MLMS;
import policies.SLMS;

public class MainReader {

	public static void main(String[] args) {
		//Instace of Deque
		LinkedList<LinkedList<Customer>>alpha= theData();
		LinkedList<Customer>x= new LinkedList<>();
//		Customer a= new Customer(0,5);
//		Customer b= new Customer(1,5);
//		Customer c= new Customer(2,10);
//		Customer cd= new Customer(3,5);
//		Customer a1=new Customer(5,5);
//		x.add(a);
//		x.add(b);
//		x.add(c);
//		x.add(cd);
//		x.add(a1);
		x.add(new Customer(0,1));
		x.add(new Customer(0,1));
		x.add(new Customer(0,2));
//		x.add(new Customer(1,3));
//		x.add(new Customer(1,4));
//		x.add(new Customer(2,1));
//		x.add(new Customer(2,1));
//		x.add(new Customer(2,1));
//		x.add(new Customer(2,1));
//		x.add(new Customer(3,4));
//		x.add(new Customer(3,3));
//		x.add(new Customer(3,2));
//		x.add(new Customer(3,1));
		
		MLMS q= new MLMS(x,5);
		
		q.Simulate();
		System.out.println(q.getPolicy()+" "+q.postNumbers()+" :"+q.getTime()+"  "+q.showAverageTime());
//		MLMS  q1= new MLMS(alpha.get(2),3);
//		
//		q1.Simulate();
//		System.out.println(q1.getPolicy()+" "+q1.postNumbers()+" :"+q1.getTime()+"  "+q1.showAverageTime());
//	   q= new MLMS(alpha.get(2),5);
//		
//		q.Simulate();
//		System.out.println(q.getPolicy()+" "+q.postNumbers()+" :"+q.getTime()+"  "+q.showAverageTime());
	}
		
// customer, clerk, event, arrival event, service-starts event, service-completed event, 
//transfer event, monitor, line of service, collection of events, collection
		//of customers, collection of lines
		
	
	
	
	
		public static LinkedList<LinkedList<Customer>> theData(){
		LinkedList<LinkedList<Customer>>alpha= new LinkedList<>();
		//TEST
		
			String parentDirectory; 		
			parentDirectory = "inputFiles"; 
			Scanner parameters;
			ArrayList<String>todo=new ArrayList<>();
			try {
				parameters = new Scanner(new File(parentDirectory, "dataFiles.txt"));
				while(parameters.hasNext()) {
					String s= parameters.nextLine(); 
					todo.add(s);
					}
			} catch (FileNotFoundException e) {
				System.out.println("No file");
				e.printStackTrace();
			} 
			
			
			for(String s:todo) {
				LinkedList<Customer>cl= new LinkedList<>();
				
				Scanner parameters2;
				try {
					
					parameters2 = new Scanner(new File(parentDirectory, s));
					//Informacion dentro de los documentos.
					while(parameters2.hasNext()) {
						
						String data= parameters2.nextLine(); 
						System.out.println(data);
						
						StringTokenizer st= new StringTokenizer(data," ");
						cl.add(new Customer(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
						
						}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("data is Missing");
					e.printStackTrace();
				} 
				
				alpha.add(cl);
				
			}
			return alpha;
		}
				

//				}
//				double ave=0;
//				for(int i=0;i<terminatedJobs.size();i++) {
//					ave=ave+(terminatedJobs.get(i).getDepartureTime()-terminatedJobs.get(i).getArrivalTime());
//				}
//				System.out.printf("Average Time: %.2f",(ave/(terminatedJobs.size())));
//			
//				

		}

