package org.healtheta.model.appointment.repo;

import org.healtheta.model.appointment.AppointmentParticipant;
import org.healtheta.model.common.Identifier;
import org.healtheta.model.common.Reference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AppointmentParticipantRepo extends JpaRepository<AppointmentParticipant, Long> {
    List<AppointmentParticipant> findAppointmentByActor(Reference actor);
}
