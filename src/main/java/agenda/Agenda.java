package agenda;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {

    /**
     * Adds an event to this agenda private
     *
     * @param e the event to add
     */
    private Set<Event> myEvents = new HashSet<>();

    public void addEvent(Event e) {
        myEvents.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public Set<Event> eventsInDay(LocalDate day) {
        Set<Event> EventDay = new HashSet<>();
        for (Event e : myEvents) {
            if (e.isInDay(day)) {
                EventDay.add(e);
            }

        }
        return EventDay;
    }

    /**
     * Trouver les événements de l'agenda en fonction de leur titre
     *
     * @param title le titre à rechercher
     * @return les événements qui ont le même titre
     */
    public List<Event> findByTitle(String title) {
        List<Event> ret = new ArrayList<>();
        for (Event e : myEvents) {
            if (e.getTitle().equals(title)) {
                ret.add(e);
            }

        }
        return ret;
    }

    /**
     * Déterminer s’il y a de la place dans l'agenda pour un événement
     *
     * @param e L'événement à tester (on se limitera aux événements simples)
     * @return vrai s’il y a de la place dans l'agenda pour cet événement
     */
    public boolean isFreeFor(Event e) {
        boolean ret = true;
        for (Event ev : myEvents) {
            for (int i = 0; i < e.getDuration().plus(1, ChronoUnit.DAYS).toDays(); i++) {
                if (e.isInDay(ev.getStart().plus(i, ChronoUnit.DAYS).toLocalDate())) {
                    ret = false;
                }
            }
        }
        return ret;
    }

}
