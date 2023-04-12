package com.example.lab3_20191792.Controller;

import com.example.lab3_20191792.Entity.Doctor;
import com.example.lab3_20191792.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DoctorController {

    @Autowired
    DoctorRepository doctorRepository;

    @GetMapping("doctores/lista")
    public String listaDoctores(Model model) {
        List<Doctor> listaDoctores = doctorRepository.findAll(); //listatodo
        model.addAttribute("listaDoctores", listaDoctores);
        return "doctores/lista";
    }






}
