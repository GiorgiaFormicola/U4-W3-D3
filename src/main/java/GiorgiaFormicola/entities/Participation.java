/*package GiorgiaFormicola.entities;

import GiorgiaFormicola.enums.ParticipationState;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "participations")
public class Participation {
    //ATTRIBUTES
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private ParticipationState state;

    //RELATION WITH EVENT
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private String persone

    //CONSTRUCTOR FOR DB
    protected Participation(){};

    //CONSTRUCTOR FOR JAVA
    public Participation()



}*/
