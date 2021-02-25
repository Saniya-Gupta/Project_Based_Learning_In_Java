package exp;

import java.util.Locale;

public class Employee {
	int id, basic, hra, it, da;
	char desigCode;
	String name, date, dep, designation;

	
	Employee(int id, String name, String date, char desigCode, String dep, int basic, int hra, int it) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.desigCode = desigCode;
		this.dep = dep;
		this.basic = basic;
		this.hra = hra;
		this.it = it;
	}
	
	Employee(char desigCode, String designation, int da) {
		this.desigCode = desigCode;
		this.designation = designation;
		this.da =da;
	}
	
	public static void main(String[] args) {
		Employee[] arrayOfEmployees = new Employee[7];
		arrayOfEmployees[0] = new Employee(1001, "Ashish", "1/4/2009", 'e', "R&D", 20000, 8000, 3000);
		arrayOfEmployees[1] = new Employee(1002, "Sushma", "23/08/2012", 'c', "PM", 30000, 12000, 9000);
		arrayOfEmployees[2] = new Employee(1003, "Rahul", "12/11/2008", 'k', "Acct", 10000, 8000, 1000);
		arrayOfEmployees[3] = new Employee(1004, "Chahat", "29/01/2013", 'r', "Front Desk", 6000, 8000, 2000);
		arrayOfEmployees[4] = new Employee(1005, "Ranjan", "16/07/2005", 'm', "Engg", 50000, 20000, 20000);
		arrayOfEmployees[5] = new Employee(1006, "Suman", "1/1/2000", 'e', "Manufacturing", 9000, 8000, 44000);
		arrayOfEmployees[6] = new Employee(1007, "Tanmay", "12/06/2006", 'c', "PM", 29000, 12000, 10000);
		Employee[] arrayOfDesignation = new Employee[5];
		arrayOfDesignation[0] = new Employee('e', "Engineer", 20000);
		arrayOfDesignation[1] = new Employee('c', "Consultant", 32000);
		arrayOfDesignation[2] = new Employee('k', "Clerk", 12000);
		arrayOfDesignation[3] = new Employee('r', "Receptionist", 15000);
		arrayOfDesignation[4] = new Employee('m', "Manager", 40000);
		if(args.length != 0) {
			try {
				int id = Integer.parseInt(args[0]);
				if(id> 1000 && id < 1008) {
					// formatting: (-) to left justify, S to upper case string, 20 to specify width, %n for line break, %, Local Us for inserting comma
					// s -> String, d -> Integer, f -> Float, t -> Date
					System.out.printf("%-20S %-20S %-20S %-20S %-20S %n","Emp No.","Emp Name", "Department", "Designation", "Salary");
					System.out.printf("%-20d %-20s %-20s ",arrayOfEmployees[id - 1001].id, arrayOfEmployees[id - 1001].name, arrayOfEmployees[id - 1001].dep);
					switch(arrayOfEmployees[id - 1001].desigCode) {
						case 'e': {
							System.out.printf(Locale.US, "%-20s %,-20d %n", arrayOfDesignation[0].designation, (arrayOfEmployees[id - 1001].basic
								+arrayOfEmployees[id - 1001].hra
								+arrayOfEmployees[id - 1001].da
								-arrayOfDesignation[0].it));
							break;
						}
						case 'c': {
							System.out.printf(Locale.US, "%-20s %,-20d %n", arrayOfDesignation[1].designation, (arrayOfEmployees[id - 1001].basic
									+arrayOfEmployees[id - 1001].hra
									+arrayOfEmployees[id - 1001].da
									-arrayOfDesignation[1].it));
								break;
						}
						case 'k': {
							System.out.printf(Locale.US, "%-20s %,-20d %n", arrayOfDesignation[2].designation, (arrayOfEmployees[id - 1001].basic
									+arrayOfEmployees[id - 1001].hra
									+arrayOfEmployees[id - 1001].da
									-arrayOfDesignation[2].it));
								break;
						}
						case 'm': {
							System.out.printf(Locale.US, "%-20s %,-20d %n", arrayOfDesignation[3].designation, (arrayOfEmployees[id - 1001].basic
									+arrayOfEmployees[id - 1001].hra
									+arrayOfEmployees[id - 1001].da
									-arrayOfDesignation[3].it));
							break;
						}
						case 'r': {
							System.out.printf(Locale.US, "%-20s %,-20d %n", arrayOfDesignation[4].designation, (arrayOfEmployees[id - 1001].basic
									+arrayOfEmployees[id - 1001].hra
									+arrayOfEmployees[id - 1001].da
									-arrayOfDesignation[4].it));
								break;
						}
					}
				} else {
					System.out.println("There is no employee with empid: "+id);
				}
			} catch(NumberFormatException e) {
				e.printStackTrace();
			}
		}
	}
}
