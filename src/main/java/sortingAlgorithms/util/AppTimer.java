package sortingAlgorithms.util;

/**
 * Get the time before and after the operation you want to measure,
 * and calculate the time difference
 */
public interface AppTimer {

    /**
     * Start timer
     */
    public void start();

    /**
     * Stop timer
     */
    public void stop();

    /**
     * Return start time
     */
    public long getStartTime();

    /**
     * Return stop time
     */
    public long getStopTime();

    /**
     * Return total time
     */
    public long getTotalTime();
}
