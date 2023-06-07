/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca;

import java.time.LocalDate;

/**
 *
 * @author mushit
 */
public class Prestamo {
    Usuario usuarioPrest;
    Libro libroPrest;
    LocalDate fechaPrest;
    LocalDate fechaDev;

    public Prestamo(Usuario usuarioPrest, Libro libroPrest, LocalDate fechaPrest, LocalDate fechaDev) {
        this.usuarioPrest = usuarioPrest;
        this.libroPrest = libroPrest;
        this.fechaPrest = fechaPrest;
        this.fechaDev = fechaDev;
    }

    public Usuario getUsuarioPrest() {
        return usuarioPrest;
    }

    public Libro getLibroPrest() {
        return libroPrest;
    }

    public LocalDate getFechaPrest() {
        return fechaPrest;
    }

    public LocalDate getFechaDev() {
        return fechaDev;
    }

    public void setUsuarioPrest(Usuario usuarioPrest) {
        this.usuarioPrest = usuarioPrest;
    }

    public void setLibroPrest(Libro libroPrest) {
        this.libroPrest = libroPrest;
    }

    public void setFechaPrest(LocalDate fechaPrest) {
        this.fechaPrest = fechaPrest;
    }

    public void setFechaDev(LocalDate fechaDev) {
        this.fechaDev = fechaDev;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "usuarioPrest=" + usuarioPrest + ", libroPrest=" + libroPrest + ", fechaPrest=" + fechaPrest + ", fechaDev=" + fechaDev + '}';
    }
    
    
}
