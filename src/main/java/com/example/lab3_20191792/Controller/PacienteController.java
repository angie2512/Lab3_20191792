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

    @GetMapping("pacientes/editar")
    public String editarVista(Model model, @RequestParam("id") int id) {
        Optional<Paciente> optPaciente = pacienteRepository.findById(id);
        if (optPaciente.isPresent()) {
            model.addAttribute("paciente", optPaciente.get());
            return "/pacientes/editar";
        } else {
            return "redirect:/pacientes/lista";
        }
    }


    @PostMapping("/pacientes/guardar")
    public String editarPacientes(Model model, Paciente paciente) {

        Optional<Paciente> optPaciente = pacienteRepository.findById(paciente.getId());
        if (optPaciente.isPresent()) {
            pacienteRepository.actualizarHabitacionById(paciente.getNumeroHabitacion(), paciente.getId());
            return "redirect:/pacientes/lista";
        } else {
            return "redirect:/pacientes/lista";
        }

    }

    @GetMapping("pacientes/derivar")
    public String listaDoctores(Model model) {
        List<Doctor> listaDoctores = doctorRepository.findAll(); //listatodo
        model.addAttribute("listaDoctores", listaDoctores);
        return "pacientes/derivar";
    }

    @PostMapping("pacientes/guardarDeriv")
    public String guardarDeriv(Model model, @RequestParam("doctorid1") int id1, @RequestParam("doctorid2") int id2 ) {
        pacienteRepository.actualizarDoctor(id1,id2);
        return "redirect:/pacientes/lista";
    }


}
