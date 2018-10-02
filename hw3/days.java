package birthday;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Scanner;
import java.time.Period;

public class days {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter month:");
		int month = in.nextInt();
		System.out.println("Enter day:");
		int dayOfMonth = in.nextInt();
		System.out.println("Enter year:");
		int year = in.nextInt();
		in.close();
		
		ZonedDateTime today = ZonedDateTime.now();
		LocalDate localDateToday = today.toLocalDate();
		LocalDate bdate = LocalDate.of(year, month, dayOfMonth);
		
		Period period = Period.between(bdate, localDateToday);
		
		System.out.println("---Number of days that have elapsed since you were born---");
		System.out.print(period.getDays() + "days, ");
		System.out.println(period.getMonths() + "months, ");
		System.out.println(period.getYears() + "years, ");
	}

}
