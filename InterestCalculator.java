package exp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterestCalculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		while(true) {
			System.out.println("\nSelect the option:\r\n"
					+ "1. Interest Calculator –SB\r\n"
					+ "2. Interest Calculator –FD\r\n"
					+ "3. Interest Calculator –RD\r\n"
					+ "4. Exit\r\n");
			int choice = sc.nextInt();
			if(choice == 4) {
				break;
			}
			switch(choice) {
				case 2 : {
					FDAccount obj = new FDAccount();
					System.out.print("Enter Amount: ");
					obj.amount = sc.nextDouble();
					if(obj.amount < 0.0) {
						throw new InputMismatchException("Invalid amount! Please enter correct value.");
					}
					System.out.println("Enter No. of Days: ");
					obj.noOfDays = sc.nextInt();
					if(obj.noOfDays < 0) {
						throw new InputMismatchException("Invalid no. of days! Please enter correct value.");
					}
					System.out.println("Enter Age of Account Holder: ");
					obj.age = sc.nextInt();
					if(obj.age < 0) {
						throw new InputMismatchException("Invalid age! Please enter correct value.");
					}
					System.out.println("Interest gained is: "+obj.calculateInterest());
					break;
				}
				case 1 : {
					System.out.println("Enter type of account: ");
					sc.nextLine();
					String accountType = sc.nextLine();
					if(accountType.compareToIgnoreCase("Normal") == 0 || accountType.compareToIgnoreCase("NRI") == 0) {
						SBAccount obj = new SBAccount(accountType);						
						System.out.print("Enter Amount: ");
						obj.amount = sc.nextDouble();
						if(obj.amount < 0.0) {
							throw new InputMismatchException("Invalid amount! Please enter correct value.");
						}
						System.out.println("Interest gained is: "+obj.calculateInterest());
					} else {
						throw new InputMismatchException("Invalid account type! Please enter correct value.");						
					}
					break;
				}
				case 3 : {
					RDAccount obj = new RDAccount();
					System.out.print("Enter Amount: ");
					obj.amount = sc.nextDouble();
					if(obj.amount < 0.0) {
						throw new InputMismatchException("Invalid amount! Please enter correct value.");
					}
					System.out.println("Enter No. of Months: ");
					obj.noOfMon = sc.nextInt();
					if(obj.noOfMon < 0) {
						throw new InputMismatchException("Invalid no. of months! Please enter correct value.");
					}
					System.out.println("Interest gained is: "+obj.calculateInterest());
					break;
				}
				default : {
					System.out.println("Invalid choice!");
				}
			}
		}
		sc.close();
	}
}

abstract class Account {
	double interestRate, amount;
	abstract double calculateInterest();
}

class FDInterestTable {
	
	boolean isAmountAbove1Crore = false, isSeniorCitizen = false;
	int noOfDays;
	
	FDInterestTable(double amount, int age, int noOfDays) {
		if(amount > 10000000) {
			isAmountAbove1Crore = true;
		}
		if(age >= 60) {
			isSeniorCitizen = true;
		}
		this.noOfDays = noOfDays;
	}
	
	double getInterest() {
		if(isSeniorCitizen) {
			if(noOfDays < 7) {
				return 0.0;
			} else if(noOfDays < 15) {
				return 5.0;
			} else if(noOfDays < 30) {
				return 5.25;
			} else if(noOfDays < 46) {
				return 6.0;
			} else if(noOfDays < 61) {
				return 7.5;
			} else if(noOfDays < 185) {
				return 8.0;
			} else {
				return 8.5;
			}
		} else {
			if(noOfDays < 7) {
				return 0.0;
			} else if(noOfDays < 15) {
				return 4.5;
			} else if(noOfDays < 30) {
				return 4.75;
			} else if(noOfDays < 46) {
				return 5.5;
			} else if(noOfDays < 61) {
				return 7.0;
			} else if(noOfDays < 185) {
				return 7.5;
			} else {
				return 8.0;
			}
		}
	}
	
}

class SBInterestTable {

	double getInterest(String typeOfAccount) {
		if(typeOfAccount.compareToIgnoreCase("Normal") == 0) {
			return 4.0;
		} else {
			return 6.0;
		}
	}
	
}

class FDAccount extends Account {
	
	int age, noOfDays;
	double calculateInterest() {
		FDInterestTable obj = new FDInterestTable(amount, age, noOfDays);
		double interest = obj.getInterest();
		interest = (amount * interest) / 100;
		return interest;
	}
	
}

class SBAccount extends Account {
	String typeOfAccount;
	SBAccount(String typeOfAccount) {
		this.typeOfAccount = typeOfAccount;
	}
	double calculateInterest() {
		SBInterestTable obj = new SBInterestTable();
		double interest = obj.getInterest(typeOfAccount);
		interest = (amount * interest) / 100;
		return interest;
	}	
}

class RDInterestTable {
	
	boolean isSeniorCitizen = false;
	int noOfMon;
	
	RDInterestTable(int age, int noOfMon) {
		if(age >= 60) {
			isSeniorCitizen = true;
		}
		this.noOfMon = noOfMon;
	}
	
	double getInterest() {
		if(isSeniorCitizen) {
			if(noOfMon < 6) {
				return 0.0;
			} else if(noOfMon < 9) {
				return 8.0;
			} else if(noOfMon < 12) {
				return 8.25;
			} else if(noOfMon < 15) {
				return 8.50;
			} else if(noOfMon < 18) {
				return 8.75;
			} else if(noOfMon < 21) {
				return 9.0;
			} else {
				return 9.25;
			}
		} else {
			if(noOfMon < 6) {
				return 0.0;
			} else if(noOfMon < 9) {
				return 7.5;
			} else if(noOfMon < 12) {
				return 7.75;
			} else if(noOfMon < 15) {
				return 8.0;
			} else if(noOfMon < 18) {
				return 8.25;
			} else if(noOfMon < 21) {
				return 8.5;
			} else {
				return 8.75;
			}
		}
	}
	
}

class RDAccount extends Account {
	
	int age, noOfMon;
	double calculateInterest() {
		RDInterestTable obj = new RDInterestTable(age, noOfMon);
		double interest = obj.getInterest();
		interest = (amount * interest) / 100;
		return interest;
	}
	
}
