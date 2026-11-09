package com.dilki.medicare.service;

import com.dilki.medicare.entity.*;
import com.dilki.medicare.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final UserRepository userRepository;


    public Appointment bookAppointment(Long doctorId, Long patientId, LocalDateTime dateTime, String reason) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));


        List<Appointment> conflicts = appointmentRepository.findConflictingAppointments(doctorId, dateTime);
        if (!conflicts.isEmpty()) {
            throw new RuntimeException("Doctor is already booked at this time!");
        }

        Appointment appointment = Appointment.builder()
                .doctor(doctor)
                .patient(patient)
                .appointmentDateTime(dateTime)
                .status(Appointment.AppointmentStatus.SCHEDULED)
                .reason(reason)
                .build();

        return appointmentRepository.save(appointment);
    }


    public List<Appointment> getDoctorAppointments(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }


    public List<Appointment> getPatientAppointments(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }


    public Appointment updateAppointmentStatus(Long appointmentId, String status) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        try {
            appointment.setStatus(Appointment.AppointmentStatus.valueOf(status.toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid status. Use SCHEDULED, COMPLETED, CANCELLED, or NO_SHOW");
        }

        return appointmentRepository.save(appointment);
    }
}