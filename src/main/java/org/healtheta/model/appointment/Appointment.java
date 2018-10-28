package org.healtheta.model.appointment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.healtheta.model.common.*;
import javax.persistence.TemporalType;

import java.util.List;
import java.util.Date;
import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(unique=true, name = "_identifier")
    private Identifier identifier;

    @Column(name = "_code")
    private String code;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_serviceCategory")
    private CodeableConcept serviceCategory;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_serviceType")
    private List<CodeableConcept> serviceType;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_speciality")
    private List<CodeableConcept> speciality;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_appointmentType")
    private CodeableConcept appointmentType;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_reason")
    private List<CodeableConcept> reason;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_indication")
    private List<CodeableConcept> indication;

    @Column(name = "_priority")
    private Integer priority;

    @Column(name = "_description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_supportingInformation")
    private List<Reference> supportingInformation;

    @Column(name = "_start")
    private Date start;

    @Column(name = "_end")
    private Date end;

    @Column(name = "_minutesDuration")
    private Integer minutesDuration;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_slot")
    private List<Reference> slot;

    @Column(name = "_created")
    private Date created;

    @Column(name = "_comment")
    private String comment;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_incomingReferal")
    private List<Reference> incomingReferal;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_participant")
    private List<AppointmentParticipant> participant;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_requestedPeriod")
    private List<Period> requestedPeriod;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_reference")
    private Reference reference;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastModifiedDate;

    public Long getId() {
        return id;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public String getCode() {
        return code;
    }

    public CodeableConcept getServiceCategory() {
        return serviceCategory;
    }

    public List<CodeableConcept> getServiceType() {
        return serviceType;
    }

    public List<CodeableConcept> getSpeciality() {
        return speciality;
    }

    public CodeableConcept getAppointmentType() {
        return appointmentType;
    }

    public List<CodeableConcept> getReason() {
        return reason;
    }

    public List<CodeableConcept> getIndication() {
        return indication;
    }

    public Integer getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    public List<Reference> getSupportingInformation() {
        return supportingInformation;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public Integer getMinutesDuration() {
        return minutesDuration;
    }

    public List<Reference> getSlot() {
        return slot;
    }

    public Date getCreated() {
        return created;
    }

    public String getComment() {
        return comment;
    }

    public List<Reference> getIncomingReferal() {
        return incomingReferal;
    }

    public List<AppointmentParticipant> getParticipant() {
        return participant;
    }

    public List<Period> getRequestedPeriod() {
        return requestedPeriod;
    }

    public Reference getReference() {
        return reference;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setServiceCategory(CodeableConcept serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    public void setServiceType(List<CodeableConcept> serviceType) {
        this.serviceType = serviceType;
    }

    public void setSpeciality(List<CodeableConcept> speciality) {
        this.speciality = speciality;
    }

    public void setAppointmentType(CodeableConcept appointmentType) {
        this.appointmentType = appointmentType;
    }

    public void setReason(List<CodeableConcept> reason) {
        this.reason = reason;
    }

    public void setIndication(List<CodeableConcept> indication) {
        this.indication = indication;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSupportingInformation(List<Reference> supportingInformation) {
        this.supportingInformation = supportingInformation;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public void setMinutesDuration(Integer minutesDuration) {
        this.minutesDuration = minutesDuration;
    }

    public void setSlot(List<Reference> slot) {
        this.slot = slot;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setIncomingReferal(List<Reference> incomingReferal) {
        this.incomingReferal = incomingReferal;
    }

    public void setParticipant(List<AppointmentParticipant> participant) {
        this.participant = participant;
    }

    public void setRequestedPeriod(List<Period> requestedPeriod) {
        this.requestedPeriod = requestedPeriod;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
