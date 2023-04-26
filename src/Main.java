import periodCalculator.PeriodCalculator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static final PeriodCalculator periodCalculator = new PeriodCalculator();
    public static void main(String[] args) {
        mainMenu();
    }
    private static void mainMenu() {
        System.out.println("Welcome to your flo assist");
        System.out.println(" => Enter your length of your period days: ");
        int periodDays = input.nextInt();

        String lastMenstrualPeriod = getDate();

        System.out.println("Enter your cycle length: ");
        int cycleLength = input.nextInt();

        String nextPeriodDate = periodCalculator.calculateNextPeriodDate(cycleLength, lastMenstrualPeriod);
        String safeDays = periodCalculator.calculateSafeDays(lastMenstrualPeriod);
        String ovulationDate = periodCalculator.calculateNextOvulation(cycleLength,lastMenstrualPeriod);
        String dates = periodCalculator.calculateAllDatesForTwelveMonths(lastMenstrualPeriod,cycleLength);
        System.out.printf("""
                %s
                %s
                %s
                %s
                """, nextPeriodDate, safeDays, ovulationDate, dates);
    }

    private static String getDate() {
        System.out.println(" => Enter the date of the first Day Of Your Last Menstrual Period (LMP) in this format (YYYY-MM-DD):");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String lastMenstrualPeriod = input.next();
        try {
            LocalDate.parse(lastMenstrualPeriod.trim(), dateTimeFormatter);
        } catch (RuntimeException e) {
            System.out.println("The date format is invalid. Please enter a date in the format yyyy-MM-dd.");
            getDate();
        }
        return lastMenstrualPeriod;
    }
}

