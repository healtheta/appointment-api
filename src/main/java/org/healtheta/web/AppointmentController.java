package org.healtheta.web;

import org.healtheta.model.appointment.Appointment;
import org.healtheta.model.appointment.repo.AppointmentParticipantRepo;
import org.healtheta.model.appointment.repo.AppointmentRepo;
import org.healtheta.model.common.Identifier;
import org.healtheta.model.common.OperationOutcome;
import org.healtheta.model.common.Reference;
import org.healtheta.model.common.repos.IdentifierRepo;
import org.healtheta.model.common.repos.ReferenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/appointment")
public class AppointmentController {
    @Autowired
    AppointmentRepo appointmentRepo;
    @Autowired
    AppointmentParticipantRepo appointmentParticipantRepo;
    @Autowired
    private IdentifierRepo identifierRepo;
    @Autowired
    private ReferenceRepo referenceRepo;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Appointment appointment){
        Identifier tmpId = appointment.getIdentifier();
        if(tmpId.getValue() == null){
            return new ResponseEntity<OperationOutcome>(OperationOutcome.InvalidParameter(),
                    HttpStatus.OK);
        }

        if(identifierRepo.findIdentifierByValue(tmpId.getValue()) != null){
            return new ResponseEntity<OperationOutcome>(OperationOutcome.RecordExists(),
                    HttpStatus.OK);
        }

        try{
            Appointment tmp = new Appointment();
            tmp = appointmentRepo.save(tmp);
            appointment.setId(tmp.getId());

            Reference ref = new Reference();
            ref.setIdentifier(appointment.getIdentifier());
            ref.setDisplay("appointment-reference");
            appointment.setReference(ref);
            appointment = appointmentRepo.save(appointment);
            return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<OperationOutcome>(OperationOutcome.InternalError(),
                    HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> read(@PathVariable String id){
        try{
            Long lId = Long.parseLong(id);
            Appointment appointment = appointmentRepo.findAppointmentById(lId);
            if(appointment != null){
                return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
            }else{
                return new ResponseEntity<OperationOutcome>(OperationOutcome.RecordNotFound(), HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            return new ResponseEntity<OperationOutcome>(OperationOutcome.InternalError(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody Appointment appointment){
        Long id = appointment.getId();
        Appointment tmp = appointmentRepo.findAppointmentById(id);
        if ( tmp != null){
            //record exists let;s update.
            //reference and identifiers are not to be updated.
            appointment.setIdentifier(tmp.getIdentifier());
            appointment.setReference(tmp.getReference());
            appointment = appointmentRepo.save(appointment);
            return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
        }else{
            return new ResponseEntity<OperationOutcome>(OperationOutcome.RecordNotFound(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> delete(String id) {
        return null;
    }

    @RequestMapping(value = "/search",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> search(@RequestParam(value = "participant", required=false) Long patient){
        //to do think in detail

        return null;
    }

    @RequestMapping(value = "/format",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> format(){
        Appointment appointment = new Appointment();
        Identifier identifier = new Identifier();
        identifier.setValue("APPOINTMENT:KDJMDMKD-92929229-DKDKDKDDK-92929292");
        appointment.setIdentifier(identifier);
        return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
    }

}
