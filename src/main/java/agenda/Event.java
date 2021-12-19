package agenda;

import java.time.*;
import java.util.ArrayList;
import java.util.Set;

public class Event {

    private final String myTitle;
    private final LocalDateTime myStart;
    private final Duration myDuration;

    public Event(String title, LocalDateTime start, Duration duration) {
        this.myTitle = title;
        this.myStart = start;
        this.myDuration = duration;
    }

    /**
     * Tests if an event occurs on a given day
     *
     * @param aDay the day to test
     * @return true if the event occurs on that day, false otherwise
     */
    public boolean isInDay(LocalDate aDay) {
        boolean ret = true;
        LocalDateTime myEnd = myStart.plus(myDuration);
        if (aDay.isBefore(myStart.toLocalDate()) || aDay.isAfter(myEnd.toLocalDate())) {
            ret = false;
        }
        return ret;
    }

    /**
     * @return the myTitle
     */
    public String getTitle() {
        return myTitle;
    }

    /**
     * @return the myStart
     */
    public LocalDateTime getStart() {
        return myStart;
    }

    /**
     * @return the myDuration
     */
    public Duration getDuration() {
        return myDuration;
    }

    @Override
    public String toString() {
        return "Event{" + "myTitle=" + myTitle + '}';
    }

}
