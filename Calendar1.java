/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar1 {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	
	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	public static void main(String args[]) {
		// Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999, inclusive.
	    // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday, prints "Sunday".
	    // The following variable, used for debugging purposes, counts how many days were advanced so far.
		String current_date = dayOfMonth + "/" + month + "/" + year;
		int first_sundays = 0;
	    //// Write the necessary initialization code, and replace the condition
	    //// of the while loop with the necessary condition 
	 	while (!current_date.equals("1/1/2000")) {
	 		//// Write the body of the while 	
			System.out.print("\n" + current_date);
			if (dayOfWeek == 1) {
				System.out.print(" Sunday");
				if (dayOfMonth == 1) {
					first_sundays++;
				}
			}
	 		advance();
			current_date = dayOfMonth + "/" + month + "/" + year;
        }
	 	System.out.println("\nDuring the 20th century, " + first_sundays + " Sundays fell on the first day of the month");
	 }
	
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance() {
		if (dayOfMonth == nDaysInMonth(month, year)) {
			dayOfMonth = 1;
			month ++;
		}
		else {
			dayOfMonth++;
		}
		if (dayOfWeek == 7) {
			dayOfWeek = 1;
		}
		else {
			dayOfWeek++;
		}

		if (month == 13) {
			month = 1;
			year++;
		}
	 } 
		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
		boolean is_leap_year = ((year % 400) == 0);
		is_leap_year = is_leap_year || ((year % 4) == 0) && ((year % 100) != 0);
		return is_leap_year;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
		switch (month) {
			case 4:
				return 30;
			case 6:
				return 30;
			case 9:
				return 30;
			case 11:
				return 30;
			case 2:
				if (isLeapYear(year)) {
					return 29;
				} 
				else {
					return 28;
				} 
			default:
				return 31;
		}
	}
}
