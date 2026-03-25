package GiorgiaFormicola;

import GiorgiaFormicola.dao.EventsDAO;
import GiorgiaFormicola.entities.Event;
import GiorgiaFormicola.enums.EventType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("events_management_pu");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EventsDAO eventsDAO = new EventsDAO(entityManager);

        Event event1 = new Event("Coldplay Concert", 2026, 6, 15, "Amazing concert", EventType.PUBLIC, 70634);
        Event event2 = new Event("Louis C.K. Show", 2025, 3, 1, "Hilarious stand-up comedy", EventType.PUBLIC, 1500);
        Event event3 = new Event("Architecture Conference", 2027, 1, 12, "Conference on the latest trends in architecture field", EventType.PRIVATE, 300);

        System.out.println("Hello World!");
    }
}
