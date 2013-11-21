package sortingAlgorithms.unitTest.util;

import org.junit.Test;
import sortingAlgorithms.unitTest.util.impl.Timer;

import static org.junit.Assert.assertNotNull;

/**
 * Testing AppTimer implementation
 */
public class TestTimer {

    private static AppTimer appTimer = new Timer();

    /**
     *  testing all Timer functionality
     */
    @Test
    public void test_timer() {

        appTimer.start();
        assertNotNull("Fail - appTimer must contain start time", appTimer.getStartTime());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String sArray[] = new String[1000000];

        for (int i = 0; i < 1000000; i++) {
            sArray[i] = "Array " + i;
        }

        appTimer.stop();
        assertNotNull("Fail - appTimer must contain start time", appTimer.getStopTime());

        assertNotNull("Fail - appTimer must contain start time", appTimer.getTotalTime());
    }
}
