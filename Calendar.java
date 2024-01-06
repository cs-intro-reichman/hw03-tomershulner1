/** 
 * Prints the calendar of a specific year
 */
public class Calendar {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	
	public static void main(String args[]) {
		int given_year = Integer.parseInt(args[0]);
		String current_date = dayOfMonth + "/" + month + "/" + year;

	 	while (year != given_year + 1) {	
			if (year == given_year) {
				System.out.print("\n" + current_date);
				if (dayOfWeek == 1) {
					System.out.print(" Sunday");
			}
			}
	 		advance();
			current_date = dayOfMonth + "/" + month + "/" + year;
        }
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
