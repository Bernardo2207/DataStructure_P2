package policies;
import java.util.LinkedList;

import Main.Clerks;
import Main.Customer;

//Single Line Multiple Servers
public class SLMS implements Policie{
int posts,nCustomers;
double time=0;
private double averageTime=0;
private LinkedList<Customer> customers;
private LinkedList<Customer> waitingList;
private Clerks[]clerks;


public SLMS(LinkedList<Customer> customers,int posts) {
	//pre:Customers list must be ordered.
	this.nCustomers=customers.size();
	this.customers=copy(customers);
	this.posts=posts;
	this.clerks=new Clerks[posts];
	this.waitingList=new LinkedList<>();
	createClerks();
	
}

public void Simulate() {
	while(!Finished()) {		
	for(Customer c: customers) {
		if(c.getArrivalTime()==time) {
			waitingList.add(c);
		}
	}
		addToPostDisponible();
		Serve();
		time++;
	}	
}


public void addToPostDisponible() {
	
	for(int i=0;i<clerks.length;i++) {
		if(clerks[i].getCustomers()==0 && !waitingList.isEmpty()){
			clerks[i].addCustomer(waitingList.removeFirst());
		}
	}
	
}
public void Serve() {
	for(Clerks c: clerks) {
	if(c.getCustomers()!=0) {
		if(c.getCustomers()!=0) {
			c.getFirst().setServiceTime(c.getFirst().getServiceTime()-1);
			//System.out.println(time);
			c.getFirst().setDepartureTime(c.getFirst().getDepartureTime()+1);
		}
		if(c.getFirst().getServiceTime()==0) {
			System.out.println(time);
			Customer tr=c.removeCustomer();
			tr.setDepartureTime((int)(time+1)-tr.getArrivalTime()-tr.getDepartureTime());
			System.out.println("DepartureTime="+tr.getDepartureTime());
			averageTime=averageTime+tr.getDepartureTime();
			customers.remove(tr);
		}
		
		
		
		
	}
	}
}
private LinkedList<Customer> copy(LinkedList<Customer>c) {
	
	LinkedList<Customer> copy= new LinkedList<>();
	for(Customer x: c) {
		copy.add(new Customer(x.getArrivalTime(),x.getServiceTime()));
	}
	return copy;
}

public double showAverageTime() {
	return averageTime/nCustomers;
}
public int numberOfCustomer() {
	return nCustomers;
}
public void createClerks() {
	for(int i=0;i<posts;i++) {
		clerks[i]=new Clerks(i);
	}
}
public String getPolicy() {
	return "SLMS";
}
public int postNumbers() {
	return posts;
}
public double getTime() {
	return time;
}
public boolean Finished() {
	return customers.isEmpty();
}
}
