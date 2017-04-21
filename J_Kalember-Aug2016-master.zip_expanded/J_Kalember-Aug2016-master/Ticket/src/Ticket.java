
public class Ticket {
	private int ticketNumber;
	private double ticketPrice;
	
	public void setTicketNumber(int number){
		this.ticketNumber = number;
	}
	public double getTicketPrice(){
		return this.ticketPrice;
	}
	public String toString(){
		return("Number: " + this.ticketNumber + ", Price : " + this.ticketPrice);
	}
	
	public class WalkupTicket extends Ticket{
		this.ticketPrice = 50.0;
	}
	
	public class AdvanceTicket extends Ticket{
		private int numDaysTillEvent;
		public void setNumDays(int numDays){
			this.numDaysTillEvent = numDays;
		}
		
		if(numDaysTillEvent>=10){
			this.ticketPrice = 30.0;
		}
		
		if(numDaysTillEvent<10){
			this.ticketPrice = 40.0;
		}
		
	}
	
	public class StudentAdvanceTicket extends AdvanceTicket{
		this.ticketPrice = 
	}
}

