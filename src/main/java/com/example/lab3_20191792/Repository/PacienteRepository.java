package com.example.lab3_20191792.Repository;

import com.example.lab3_20191792.Entity.Doctor;
import com.example.lab3_20191792.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    List<Paciente> findByDoctorId(int id);
    List<Paciente> findByHospitalId(int id);

}

