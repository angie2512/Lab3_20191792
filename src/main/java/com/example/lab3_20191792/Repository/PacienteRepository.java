package com.example.lab3_20191792.Repository;

import com.example.lab3_20191792.Entity.Paciente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente,Integer> {

    List<Paciente> findByDoctorId(int id);
    List<Paciente> findByHospitalId(int id);

    @Query(value = "SELECT * FROM paciente WHERE fecha_cita > NOW() and doctor_id = ?", nativeQuery = true)
    List <Paciente> encontrarfecha(int id);

    @Transactional
    @Modifying
    @Query(value= "UPDATE paciente SET numero_habitacion = ?1 WHERE id = ?2", nativeQuery = true)
    void actualizarHabitacionById(int numeroHabitacion, int id);

    @Transactional
    @Modifying
    @Query(value= "UPDATE paciente SET doctor_id = ?1 WHERE doctor_id = ?2", nativeQuery = true)
    void actualizarDoctor(int doctorid2, int doctorid1);
}


