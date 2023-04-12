package com.example.lab3_20191792.Controller;

import com.example.lab3_20191792.Entity.Doctor;
import com.example.lab3_20191792.Entity.Paciente;
import com.example.lab3_20191792.Repository.DoctorRepository;
import com.example.lab3_20191792.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;

    @GetMapping("paciente/lista")
    public String listaPacientes(Model model) {
        List<Paciente> listaPacientes = pacienteRepository.findAll(); //listatodo
        model.addAttribute("listaPacientes", listaPacientes);
        return "paciente/lista";
    }


}
