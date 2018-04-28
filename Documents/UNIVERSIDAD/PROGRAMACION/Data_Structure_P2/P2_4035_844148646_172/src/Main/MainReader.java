package Main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

import policies.SLMS;

public class MainReader {

	public static void main(String[] args) {
		//Instace of Deque
		LinkedList<Customer>x= new LinkedList<>();
		Customer a= new Customer(0,5);
		Customer b= new Customer(1,5);
		Customer c= new Customer(2,10);
		Customer cd= new Customer(3,5);
		Customer a1=new Customer(5,5);
		x.add(a);
		x.add(b);
		x.add(c);
		x.add(cd);
		x.add(a1);
		SLMS q= new SLMS(x,1);
		
		q.Simulate();
		System.out.println(q.showAvergaeTime());
		
// customer, clerk, event, arrival event, service-starts event, service-completed event, 
//transfer event, monitor, line of service, collection of events, collection
		//of customers, collection of lines
		
		
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
					//StringTokenizer st= new StringTokenizer(s,", ");
					}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("No file");
				e.printStackTrace();
			} 
			
			
			for(String s:todo) {
				Scanner parameters2;
				try {
					parameters2 = new Scanner(new File(parentDirectory, s));
					//Informacion dentro de los documentos.
					while(parameters2.hasNext()) {
						String data= parameters2.nextLine(); 
						System.out.println(data);
						StringTokenizer st= new StringTokenizer(data," ");
						System.out.println(st.nextToken());
						System.out.println(st.nextToken());
						
						}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("data is Missing");
					e.printStackTrace();
				} 
				
				
				
			}
				
				
//				while(st.hasMoreTokens()) {
//					x=Integer.parseInt(st.nextToken());
//					y=Integer.parseInt(st.nextToken());
//					System.out.println(x+" "+y);
//					Job j= new Job(id,x,y);
//					inputQueue.enqueue(j);
//					id++;
//					
//				}
//				}
//				
//				parameters.close();
//				ArrayQueue<Job> processingQueue= new ArrayQueue<>();
//				ArrayList<Job> terminatedJobs= new ArrayList<>();
//				int time=0;
//				
//				while(!inputQueue.isEmpty() || !processingQueue.isEmpty()) {
//					if(!processingQueue.isEmpty()) {
//						processingQueue.first().isServed(1);
//						if(processingQueue.first().getRemainingTime()==0) {
//							processingQueue.first().setDepartureTime(time);
//							terminatedJobs.add(processingQueue.dequeue());
//						}
//						else {
//							processingQueue.enqueue(processingQueue.dequeue());
//						}
//					}
//					
//						if(!inputQueue.isEmpty() && inputQueue.first().getArrivalTime()==time) {
//							processingQueue.enqueue(inputQueue.dequeue());}
//						
//					time++;
//					
//				}
//				double ave=0;
//				for(int i=0;i<terminatedJobs.size();i++) {
//					ave=ave+(terminatedJobs.get(i).getDepartureTime()-terminatedJobs.get(i).getArrivalTime());
//				}
//				System.out.printf("Average Time: %.2f",(ave/(terminatedJobs.size())));
//			
//				
		
		}
}
