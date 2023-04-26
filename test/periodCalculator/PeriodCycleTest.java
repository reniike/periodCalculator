package periodCalculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PeriodCycleTest {
    private PeriodCalculator periodCalculator;

    @Test void calculateNextPeriodTest(){
        periodCalculator = new PeriodCalculator();
        String result = periodCalculator.calculateNextPeriodDate(27,"2023-01-10");
        assertEquals("Your next period date is TUESDAY 2023-02-06" , result);
    }

    @Test void calculateOvulationTest(){
        periodCalculator = new PeriodCalculator();
        String result = periodCalculator.calculateNextOvulation(27,"2023-01-10");
        assertEquals("Your next ovulation date is MONDAY 2023-01-23", result);
    }

    @Test void calculateSafeDaysTest(){
        periodCalculator = new PeriodCalculator();
        String result = periodCalculator.calculateSafeDays("2023-01-10");
        assertEquals("Your safe period is from TUESDAY 2023-01-10 to THURSDAY 2023-01-19", result);
    }


}