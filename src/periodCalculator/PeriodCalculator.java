package periodCalculator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PeriodCalculator {
    public String calculateNextPeriodDate(int cycleLength, String lastMenstrualPeriod) {
        LocalDate lastMenstrualPeriodDate = LocalDate.parse(lastMenstrualPeriod);
        LocalDate nextPeriodDate = lastMenstrualPeriodDate.plusDays(cycleLength);
        String dayOfTheWeek = String.valueOf(lastMenstrualPeriodDate.getDayOfWeek());
        return "Your next period date is " + dayOfTheWeek + " " + nextPeriodDate;
    }

    public String calculateNextOvulation(int cycleLength, String lastMenstrualPeriod) {
        LocalDate lastMenstrualPeriodDate = LocalDate.parse(lastMenstrualPeriod);
        LocalDate nextPeriodDate = lastMenstrualPeriodDate.plusDays(cycleLength);
        int amountToSubtract = 14;
        LocalDate nextOvulationDate = nextPeriodDate.minusDays(amountToSubtract);
        String dayOfTheWeek = String.valueOf(nextOvulationDate.getDayOfWeek());
        return "Your next ovulation date is " + dayOfTheWeek + " " + nextOvulationDate;
    }


    public String calculateSafeDays(String lastMenstrualPeriod) {
        LocalDate lastMenstrualPeriodDate = LocalDate.parse(lastMenstrualPeriod);
        LocalDate nextSafeDay = lastMenstrualPeriodDate.plusDays(9);
        String daysOfTheWeek = String.valueOf(nextSafeDay.getDayOfWeek());
        String lastMenstrualPeriodDay = String.valueOf(lastMenstrualPeriodDate.getDayOfWeek());
        return "Your safe period is from " + lastMenstrualPeriodDay + " " + lastMenstrualPeriod + " to " + daysOfTheWeek + " " + nextSafeDay;
    }

    public String calculateAllDatesForTwelveMonths(String lastMenstrualPeriod, int cycleLength) {
        LocalDate lastMenstrualPeriodDate = LocalDate.parse(lastMenstrualPeriod);
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            LocalDate output = lastMenstrualPeriodDate.plusDays((long) cycleLength * i);
            result.add(String.valueOf(output));
        }
        return String.format("Your period dates fot the next 12 months are: %s", result);
    }
}

