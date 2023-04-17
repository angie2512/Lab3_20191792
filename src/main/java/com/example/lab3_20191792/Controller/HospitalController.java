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
public class HospitalController {

    @Autowired
    HospitalRepository hospitalRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping("hospitales/lista")
    public String listaHospitales(Model model) {
        List<Hospital> listaHospitales = hospitalRepository.findAll(); //listatodo
        model.addAttribute("listaHospitales", listaHospitales);
        return "hospitales/lista";
    }

    @GetMapping("hospitales/listadoctores")
    public String listaDoctores(Model model, @RequestParam("id") int id){

        List<Doctor> listaDoctores = doctorRepository.findByHospitalId(id);
        model.addAttribute("listaDoctores", listaDoctores);


        return "hospitales/listadoctores";
    }

    @GetMapping("hospitales/listapacientes")
    public String listaPacientes(Model model, @RequestParam("id") int id){

        List<Paciente> listaPacientes = pacienteRepository.findByHospitalId(id);
        model.addAttribute("listaPacientes", listaPacientes);


        return "hospitales/listapacientes";
    }

}
