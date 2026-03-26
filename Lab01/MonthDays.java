import java.util.Scanner;

public class MonthDays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] monthList = {{"January", "Jan.", "Jan", "1"}, {"February", "Feb.", "Feb", "2"}, {"March", "Mar.", "Mar", "3"}, {"April", "Apr.", "Apr", "4"}, {"May", "5"}, {"June", "Jun", "6"}, {"July", "Jul", "7"}, {"August", "Aug.", "Aug", "8"}, {"September", "Sept.", "Sep", "9"}, {"October", "Oct.", "Oct", "10"}, {"November", "Nov.", "Nov", "11"}, {"December", "Dec.", "Dec", "12"}};
        int[] dayList = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String monthIn;
        int month, monthDay, year;

        outer:
        while (true) {
            System.out.print("Month: ");
            monthIn = input.nextLine();
            for (int i = 0; i < monthList.length; i++) {
                for (String monthStr : monthList[i]) {
                    if (monthIn.equals(monthStr)) {
                        month = i;
                        break outer;
                    }
                }
            }
            System.out.println("Invalid month.");
        }

        while (true) {
            System.out.print("Year: ");
            if (input.hasNextInt()) {
                year = input.nextInt();
                if (year >= 0) break;
            } else input.next();
            System.out.println("Invalid year.");
        }

        if (month == 1 && year % 4 == 0) {
            if (year % 100 == 0 && year % 400 != 0) monthDay = 28;
            else monthDay = 29;
        } else monthDay = dayList[month];

        System.out.println(monthDay);
        System.exit(0);
    }
}
