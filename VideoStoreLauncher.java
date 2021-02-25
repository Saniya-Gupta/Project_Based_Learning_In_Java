package exp;

import java.util.ArrayList;
import java.util.Scanner;

class Video {
	String title;
	double avgUserRating;
	boolean isCheckedOut;
	
	Video() {
		isCheckedOut = false;
	}
	
	Video(String title) {
		this.title = title;
		isCheckedOut = false;
	}
	
	void beingCheckedOut() {
		if(isCheckedOut == false) {
		isCheckedOut = true;
		System.out.println(title + " checked out successfully."); 
		} else {
			System.out.println("The video is already rented.");
		}
	}
	
	void beingReturned() {
		if(isCheckedOut == true) {
			isCheckedOut = false;
			System.out.println(title + " returned successfully.");
		} else {
			System.out.println("The video is already in store.");
		}
	}
	
	void receivingRating(double userRating) {
		if(avgUserRating == 0.0) {
			avgUserRating = userRating;
		} else {
			avgUserRating = (userRating + avgUserRating) / 2;
		}
		System.out.println("Rating updated."); 
	}
}

class VideoStore extends Video {
	ArrayList<Video> videos;
	
	public VideoStore() {
		videos = new ArrayList<Video>();
	}
	
	public VideoStore(String title) {
		super(title);
	}
	
	void addVideo(String title) {
		videos.add(new Video(title));
		System.out.println("Movie added successfully."); 
	}
	
	void checkOut(String title) {
		int flag = 0;
		for(Video obj: videos) {
			if(obj.title.compareTo(title) == 0) {
				obj.beingCheckedOut();
				flag = 1;
			}
		}
		if(flag == 0) {
			System.out.println("No such movie in inventory");
		}
	}
	
	void returnVideo(String title) {
		int flag = 0;
		for(Video obj: videos) {
			if(obj.title.compareTo(title) == 0) {
				obj.beingReturned();
				flag = 1;
			}
		}
		if(flag == 0) {
			System.out.println("No such movie in inventory");
		}
	}
	
	void receiveRating(String title, double rating) {
		int flag = 0;		
		for(Video obj: videos) {
			if(obj.title.compareTo(title) == 0) {
				obj.receivingRating(rating);
				flag = 1;
			}
		}				
		if(flag == 0) {
			System.out.println("No such movie in inventory");
		}
	}
	
	void listInventory() {
		System.out.printf("%-20S %-10S %-10S\n", "Movie Title", "Rating", "IsInStore");
		for(Video obj: videos) {
			System.out.printf("%-20s %-10.2f %-10s\n", obj.title, obj.avgUserRating, !obj.isCheckedOut);
		}
	}
}

public class VideoStoreLauncher {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		VideoStore obj = new VideoStore();
		int i = 0;
		while(i++ != 20) {
		System.out.println("\n\nMovie Inventory System\n1. Add movie\n2. Check out Movie\n3. Rate Movie\n4. Return Movie\n5. List Inventory\nEnter choice: ");
		int choice = sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1: {
			System.out.println("Enter movie name: ");
			obj.addVideo(sc.nextLine());			
			break;
		}
		case 2: {
			System.out.println("Enter movie name: ");
			obj.checkOut(sc.nextLine());
			break;
		}
		case 3: {
			System.out.println("Enter movie name: ");
			String title = sc.nextLine();
			System.out.println("Enter rating: ");
			double rating = sc.nextDouble();
			obj.receiveRating(title, rating);
			break;
		}
		case 4: {
			System.out.println("Enter movie name: ");
			obj.returnVideo(sc.nextLine());			
			break;
		}
		case 5: {
			obj.listInventory();
			break;
		}
		default: {
			System.out.println("Invalid choice");
		}
		}
		}
		sc.close();
	}		
}
