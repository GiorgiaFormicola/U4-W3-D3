package GiorgiaFormicola;

import GiorgiaFormicola.dao.EventsDAO;
import GiorgiaFormicola.dao.LocationsDAO;
import GiorgiaFormicola.dao.ParticipationsDAO;
import GiorgiaFormicola.dao.PeopleDAO;
import GiorgiaFormicola.entities.Event;
import GiorgiaFormicola.entities.Location;
import GiorgiaFormicola.entities.Participation;
import GiorgiaFormicola.entities.Person;
import GiorgiaFormicola.enums.EventType;
import GiorgiaFormicola.enums.GenderType;
import GiorgiaFormicola.enums.StateType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("events_management_pu");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        /*EventsDAO eventsDAO = new EventsDAO(entityManager);

        Event event1 = new Event("Coldplay Concert", 2026, 6, 15, "Amazing concert", EventType.PUBLIC, 70634);
        Event event2 = new Event("Louis C.K. Show", 2025, 3, 1, "Hilarious stand-up comedy", EventType.PUBLIC, 1500);
        Event event3 = new Event("Architecture Conference", 2027, 1, 12, "Conference on the latest trends in architecture field", EventType.PRIVATE, 300);*/

        //CREATES DAO FOR EARCH CLASS
        LocationsDAO locationsDAO = new LocationsDAO(entityManager);
        EventsDAO eventsDAO = new EventsDAO(entityManager);
        PeopleDAO peopleDAO = new PeopleDAO(entityManager);
        ParticipationsDAO participationsDAO = new ParticipationsDAO(entityManager);

        //CREATE A PERSON AND ADDS IT TO THE DB
        Person person1 = new Person("Mario", "Rossi", "mariorossi@gmail.com", 1990, 8, 12, GenderType.M);
        /*peopleDAO.save(person1);*/

        //CREATE A LOCATION AND ADDS IT TO THE DB
        Location location1 = new Location("Stadio Olimpico", "Roma");
        /*locationsDAO.save(location1);*/

        //CREATE AN EVENT AND ADDS IT TO THE DB
        Location location1FromDB = locationsDAO.getById("44384b41-8572-4d05-93b3-6099115d0dab");
        Event event1 = new Event("Coldplay Concert", 2026, 6, 15, "Amazing concert", EventType.PUBLIC, 70634, location1FromDB);
        /*eventsDAO.save(event1);*/

        //CREATE A PARTECIPATION AND ADDS IT TO THE DB
        Event event1FromDB = eventsDAO.getById("26e4a30e-2de9-4467-9179-90ece8fcc94f");
        Person person1FromDB = peopleDAO.getById("29feac3b-98f3-4d49-b74c-0a81111ea9b4");
        Participation participation1 = new Participation(event1FromDB, person1FromDB, StateType.PENDING);
        /*participationsDAO.save(participation1);*/

        System.out.println("Hello World!");
    }
}
