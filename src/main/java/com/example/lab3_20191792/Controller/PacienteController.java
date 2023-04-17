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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;
    @Autowired
    HospitalRepository hospitalRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @GetMapping("pacientes/lista")
    public String listaPacientes(Model model) {
        List<Paciente> listaPacientes = pacienteRepository.findAll(); //listatodo
        List<Hospital> listaHospitales = hospitalRepository.findAll();
        List<Doctor> listaDoctores = doctorRepository.findAll();
        model.addAttribute("listaPacientes", listaPacientes);
        model.addAttribute("listaHospitales", listaHospitales);
        model.addAttribute("listaDoctores", listaDoctores);
        return "pacientes/lista";
    }

    @PostMapping("pacientes/guardar")
    public String guardarPaciente(Paciente paciente) {
        pacienteRepository.actualizarHabitacionById(paciente.getNumeroHabitacion(), paciente.getId());
        return "redirect:/pacientes/lista";
    }

    @GetMapping("pacientes/editar")
    public String editarPacientes(Model model, @RequestParam("id") int id) {

        Optional<Paciente> optPaciente = pacienteRepository.findById(id);
        if (optPaciente.isPresent()) {
            Paciente paciente = optPaciente.get();
            model.addAttribute("paciente", paciente);
            return "pacientes/editar";
        } else {
            return "redirect:/pacientes/lista";
        }

    }


}
