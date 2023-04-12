package com.example.lab3_20191792.Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Paciente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "edad")
    private int edad;
    @Basic
    @Column(name = "genero")
    private String genero;
    @Basic
    @Column(name = "diagnostico")
    private String diagnostico;
    @Basic
    @Column(name = "fecha_cita")
    private Date fechaCita;
    @Basic
    @Column(name = "numero_habitacion")
    private int numeroHabitacion;
    @Basic
    @Column(name = "doctor_id")
    private int doctorId;
    @Basic
    @Column(name = "hospital_id")
    private int hospitalId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return id == paciente.id && edad == paciente.edad && numeroHabitacion == paciente.numeroHabitacion && doctorId == paciente.doctorId && hospitalId == paciente.hospitalId && Objects.equals(nombre, paciente.nombre) && Objects.equals(genero, paciente.genero) && Objects.equals(diagnostico, paciente.diagnostico) && Objects.equals(fechaCita, paciente.fechaCita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, edad, genero, diagnostico, fechaCita, numeroHabitacion, doctorId, hospitalId);
    }
}
