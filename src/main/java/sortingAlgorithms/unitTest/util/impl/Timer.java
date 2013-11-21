package sortingAlgorithms.unitTest.util.impl;

import sortingAlgorithms.unitTest.util.AppTimer;

/**
 * Get the time before and after the operation you want to measure,
 * and calculate the time difference
 */
public class Timer implements AppTimer{

    private long startTime = 0;
    private long endTime   = 0;

    /**
     * Start timer
     */
    @Override
    public void start(){
        this.startTime = System.currentTimeMillis();
    }

    /**
     * Stop timer
     */
    @Override
    public void stop() {
        this.endTime   = System.currentTimeMillis();
    }

    /**
     * Return start time
     */
    @Override
    public long getStartTime() {
        return this.startTime;
    }

    /**
     * Return end time
     */
    @Override
    public long getStopTime() {
        return this.endTime;
    }

    /**
     * Return total time
     */
    @Override
    public long getTotalTime() {
        return this.endTime - this.startTime;
    }
}
