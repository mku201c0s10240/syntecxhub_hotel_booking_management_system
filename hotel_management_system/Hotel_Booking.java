package hotel_management_system;
import java.util.*;

public class Hotel_Booking {
	
	static class Room{
		
		int RoomNo;
		boolean isBooked;
		String BookedBy;
		
		Room(int roomno){
			this.RoomNo=roomno;
			this.isBooked=false;
			this.BookedBy="";
		}
		
		static Room getroom(Room[] rooms, int roomno) {
			for(Room room:rooms) {
				if(room.RoomNo==roomno) {
					return room;
				}
				
			}
			return null;
		}
		
	public static void printheader(String text) {
		System.out.println("================================================");
		System.out.println(text);
		System.out.println("================================================");
	}

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		Room[] rooms=new Room[10];
		for(int i=0; i<rooms.length; i++) {
			rooms[i]=new Room(101 + i);
		}
		while(true) {
			System.out.println();
			printheader("         ...Hotel Booking Management...");
			System.out.println();
			System.out.println("1. Available Rooms");
			System.out.println("2. Booking Room");
			System.out.println("3. Cancel Booking");
			System.out.println("4. Exist");
			System.out.println("Enter Your Choice..");
			 String choice=sc.nextLine();
			 
			 switch(choice) {
			 case "1":
				 Viewavailablerooms(rooms);
				 break;
			 case "2":
				 bookingroom(sc,rooms);
				 break;
			 case "3":
				 cancelbooking(sc,rooms);
				 break;
			 case "4":
				 System.out.println("Existing..Thank You..!");
				 return;
			 default:
				 System.out.println("Invalid Input.. Try Again");
				 
			 }
			
		}
	
	}
	 static void Viewavailablerooms(Room[] rooms) {
		 
		 printheader("            ***Available Rooms***");
		 boolean found=false;
		 
		 for(Room room:rooms) {
			 if(!room.isBooked) {
				 System.out.println("Room No : "+room.RoomNo);
				 found=true;
			 }
		 }
		 if(!found) {
			 System.out.println("No Rooms Available..!");
		 }
		 
	 }
	 
	 static void bookingroom(Scanner sc, Room[] rooms) {
		 System.out.println("Enter the Room Number..");
		 int RoomNo=sc.nextInt();
		 sc.nextLine();
		 
		 Room room=getroom(rooms, RoomNo);
		 
		 if(room==null) {
			 System.out.println("Invalid Room Number");
			 return;
		 }
		 if(room.isBooked) {
			 System.out.println("Room is Already Booked");
			 return;
		 }
		 System.out.println("Enter Your Name");
		 String name=sc.nextLine();
		 room.isBooked=true;
		 room.BookedBy=name;
		 System.out.println("Room "+RoomNo+" Booking Successfully...Booked By "+name+"..!");
	 }
	 
	 static void cancelbooking(Scanner sc, Room[] rooms) {
		 System.out.println("Enter Room Number..");
		 int Roomno=sc.nextInt();
		 Room room=getroom(rooms,Roomno);
		 if(room==null) {
			 System.out.println("Invalid Room Number..!");
			 return;
		 }
		 if(!room.isBooked) {
			 System.out.println("Room is Not Booked Yet..!");
			 return;
		 }
		 
		 System.out.println("Room "+Roomno+" Cancelling Successfully..(Booked by "+room.BookedBy+")");
		 room.isBooked=false;
		 room.BookedBy="";
	 }
	
	
	
	}

}
