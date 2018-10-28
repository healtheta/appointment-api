package org.healtheta.model.appointment.repo;

import org.healtheta.model.appointment.Appointment;
import org.healtheta.model.appointment.AppointmentParticipant;
import org.healtheta.model.common.Identifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    public Appointment findAppointmentById(Long id);
    public Appointment findAppointmentByIdentifier(Identifier identifier);
    public List<Appointment> findAppointmentByParticipantIn(List<AppointmentParticipant> appointmentParticipantList);
}
