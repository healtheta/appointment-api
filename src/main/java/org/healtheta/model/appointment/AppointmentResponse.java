package org.healtheta.model.appointment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.healtheta.model.common.CodeableConcept;
import org.healtheta.model.common.Identifier;
import org.healtheta.model.common.Reference;
import java.util.List;
import java.util.Date;
import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "AppointmentResponse")
public class AppointmentResponse {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(unique=true, name = "_identifier")
    private Identifier identifier;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_appointment")
    private Reference appointment;

    @Column(name = "_start")
    private Date start;

    @Column(name = "_end")
    private Date end;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_participantType")
    private List<CodeableConcept> participantType;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_actor")
    private Reference actor;

    @Column(name = "_participantStatus")
    private String participantStatus;

    @Column(name = "_comment")
    private String comment;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_reference")
    private Reference reference;

    public Long getId() {
        return id;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public Reference getAppointment() {
        return appointment;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public List<CodeableConcept> getParticipantType() {
        return participantType;
    }

    public Reference getActor() {
        return actor;
    }

    public String getParticipantStatus() {
        return participantStatus;
    }

    public String getComment() {
        return comment;
    }

    public Reference getReference() {
        return reference;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public void setAppointment(Reference appointment) {
        this.appointment = appointment;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public void setParticipantType(List<CodeableConcept> participantType) {
        this.participantType = participantType;
    }

    public void setActor(Reference actor) {
        this.actor = actor;
    }

    public void setParticipantStatus(String participantStatus) {
        this.participantStatus = participantStatus;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }
}
