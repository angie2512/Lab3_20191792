package com.example.lab3_20191792.Controller;

import com.example.lab3_20191792.Entity.Doctor;
import com.example.lab3_20191792.Entity.Hospital;
import com.example.lab3_20191792.Repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HospitalController {

    @Autowired
    HospitalRepository hospitalRepository;

    @GetMapping("hospital/lista")
    public String listaHospitales(Model model) {
        List<Hospital> listaHospitales = hospitalRepository.findAll(); //listatodo
        model.addAttribute("listaDoctores", listaHospitales);
        return "hospital/lista";
    }

}
