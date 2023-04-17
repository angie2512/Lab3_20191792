package com.example.lab3_20191792.Repository;

import com.example.lab3_20191792.Entity.Doctor;
import com.example.lab3_20191792.Entity.Hospital;
import com.example.lab3_20191792.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.Doc;
import java.util.List;

public interface DoctorRepository  extends JpaRepository<Doctor,Integer> {

    List<Doctor> findByHospitalId(int id);

}

