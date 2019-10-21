package Week2.StopWatch;

import java.time.LocalTime;

public class StopWatch {
    private LocalTime startTime;
    private LocalTime stopTime;

    public StopWatch() {
        startTime = java.time.LocalTime.now();
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getStopTime() {
        return stopTime;
    }

    public LocalTime start() {
        startTime = java.time.LocalTime.now();
        return startTime;
    }

    public LocalTime stop() {
        stopTime = java.time.LocalTime.now();
        return stopTime;
    }

    public double getElapsedTime() {
        return stopTime.getNano() - startTime.getNano();
    }

}
