package org.healtheta.model.appointment.repo;

import org.healtheta.model.appointment.AppointmentResponse;
import org.healtheta.model.common.Identifier;
import org.healtheta.model.common.Reference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AppointmentResponseRepo extends JpaRepository<AppointmentResponse, Long> {
    public AppointmentResponse findAppointmentResponseById(Long id);
    public AppointmentResponse findAppointmentResponseByIdentifier(Identifier identifier);
    public List<AppointmentResponse> findAppointmentResponseByAppointment(Reference identifier);
    public List<AppointmentResponse> findAppointmentResponseByActor(Reference actor);
}
