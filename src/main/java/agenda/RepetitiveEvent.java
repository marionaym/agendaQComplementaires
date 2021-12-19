package agenda;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive Event
 */
public class RepetitiveEvent extends Event {

    /**
     * Constructs a repetitive event
     *
     * @param title the title of this event
     * @param start the start of this event
     * @param duration myDuration in seconds
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     */
    protected ChronoUnit frequency;
    private List<LocalDate> lesExceptions = new ArrayList<>();

    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
        super(title, start, duration);
        this.frequency = frequency;
    }

    /**
     * Adds an exception to the occurrence of this repetitive event
     *
     * @param date the event will not occur at this date
     */
    public void addException(LocalDate date) {
        lesExceptions.add(date);
    }

    /**
     *
     * @return the type of repetition
     */
    public ChronoUnit getFrequency() {
        return frequency;
    }


    public boolean isInDay(LocalDate aDay) {

        boolean ret = false;

        if (!lesExceptions.contains(aDay)) {

            if (frequency == ChronoUnit.DAYS && (this.getStart().toLocalDate().equals(aDay) || this.getStart().toLocalDate().isBefore(aDay))) {
                ret = true;
            }

            if (frequency == ChronoUnit.WEEKS) {
                for (int i = 0; i < 53; i++) {
                    if (this.getStart().toLocalDate().plus(i, ChronoUnit.WEEKS).equals(aDay)) {
                        ret = true;
                    }
                }
            }

            if (frequency == ChronoUnit.MONTHS) {
                for (int i = 0; i < 12; i++) {
                    if (this.getStart().toLocalDate().plus(i, ChronoUnit.MONTHS).equals(aDay)) {
                        ret = true;
                    }
                }
            }
        }
        return ret;
    }

}
