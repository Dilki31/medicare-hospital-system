package com.dilki.medicare.repository;

import com.dilki.medicare.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByDoctorId(Long doctorId);

    List<Appointment> findByPatientId(Long patientId);


    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :doctorId " +
            "AND a.status = 'SCHEDULED' " +
            "AND a.appointmentDateTime = :dateTime")
    List<Appointment> findConflictingAppointments(
            @Param("doctorId") Long doctorId,
            @Param("dateTime") LocalDateTime dateTime
    );


    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :doctorId " +
            "AND DATE(a.appointmentDateTime) = DATE(:date) " +
            "AND a.status = 'SCHEDULED' ORDER BY a.appointmentDateTime")
    List<Appointment> findDoctorScheduleForDay(
            @Param("doctorId") Long doctorId,
            @Param("date") LocalDateTime date
    );
}