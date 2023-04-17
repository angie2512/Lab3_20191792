package com.example.lab3_20191792.Controller;

import com.example.lab3_20191792.Entity.Doctor;
import com.example.lab3_20191792.Entity.Hospital;
import com.example.lab3_20191792.Entity.Paciente;
import com.example.lab3_20191792.Repository.DoctorRepository;
import com.example.lab3_20191792.Repository.HospitalRepository;
import com.example.lab3_20191792.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DoctorController {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    HospitalRepository hospitalRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping("doctores/lista")
    public String listaDoctores(Model model) {
        List<Doctor> listaDoctores = doctorRepository.findAll(); //listatodo
        List<Hospital> listaHospitales = hospitalRepository.findAll();
        model.addAttribute("listaHospitales", listaHospitales);
        model.addAttribute("listaDoctores", listaDoctores);
        return "doctores/lista";
    }

    @GetMapping("doctores/listapacientes")
    public String listaPacientes(Model model, @RequestParam("id") int id){

        List<Paciente> listaPacientes = pacienteRepository.findByDoctorId(id);
        model.addAttribute("listaPacientes", listaPacientes);


        return "doctores/listapacientes";
    }

    @GetMapping("doctores/listaproximascitas")
    public String listaProximasCitas(Model model, @RequestParam("id") int id){

        List<Paciente> listaProximasCitas = pacienteRepository.encontrarfecha(id);
        model.addAttribute("listaEncontrar", listaProximasCitas);

        return "doctores/listaproximascitas";
    }






}
