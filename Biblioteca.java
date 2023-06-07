/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.biblioteca;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mushit
 */
public class Biblioteca {

    Scanner tec = new Scanner(System.in);
    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Prestamo> prestamos;

    public Biblioteca() {
        libros = new ArrayList();
        usuarios = new ArrayList();
        prestamos = new ArrayList();
    }

    public static void main(String[] args) {
        Biblioteca b = new Biblioteca();

        b.libros.add(new Libro("1-11", "El Hobbit", "JRR Tolkien", 3));
        b.libros.add(new Libro("1-22", "El Silmarillon", "JRR Tolkien", 3));
        b.libros.add(new Libro("1-33", "El Médico", "N. Gordon", 4));
        b.libros.add(new Libro("1-44", "Chamán", "N. Gordon", 3));
        b.libros.add(new Libro("1-55", "Momo", "M. Ende", 2));
        b.libros.add(new Libro("1-66", "Paraíso inhabitado", "A.M.Matute", 2));
        b.libros.add(new Libro("1-77", "Olvidado Rey Gudú", "A.M.Matute", 2));
        b.libros.add(new Libro("1-88", "El último barco", "D.Villar", 3));
        b.libros.add(new Libro("1-99", "Ojos de agua", "D.Villar", 2));

        b.usuarios.add(new Usuario("11", "Ana", "apellido", "621111111"));
        b.usuarios.add(new Usuario("22", "David", "apellido", "622222222"));
        b.usuarios.add(new Usuario("33", "Bea", "apellido", "623333333"));
        b.usuarios.add(new Usuario("44", "Lucas", "apellido", "624444444"));
        b.usuarios.add(new Usuario("55", "Carlota", "apellido", "625555555"));
        b.usuarios.add(new Usuario("66", "Juan", "apellido", "626666666"));

        b.prestamos.add(new Prestamo(b.usuarios.get(0), b.libros.get(0), LocalDate.now(), LocalDate.now().plusDays(15)));
        b.menu();
    }
//MENÚ PRINCIPAL****************************************************************

    private void menu() {
        int var = 0;
        do {
            System.out.println("MENÚ DE OPCIONES");
            System.out.println("1- GESTION DE USUARIOS/AS");
            System.out.println("2- GESTION LIBROS");
            System.out.println("3- GESTION PRESTAMOS/DEVOLUCIONES");
            System.out.println("9- SALIR");
            var = tec.nextInt();
            switch (var) {
                case 1:
                    gestiondeusuarios();
                    break;
                case 2:
                    gestiondelibros();
                    break;
                case 3:
                    gestiondeprestamos();
                    break;
                default:
                    System.out.println("Introduce un numero entre 1-9");
            }
        } while (var != 9);
    }
//FIN MENÚ PRINCIPAL************************************************************

//GESTIONES*********************************************************************
    private void gestiondeusuarios() {
        int var = 0;
        do {
            System.out.println("GESTION USUARIOS/AS");
            System.out.println("1- ALTA NUEVO USUARIO/A");
            System.out.println("2- BAJA USUARIO/A");
            System.out.println("3- LISTADO USUARIOS/AS");
            System.out.println("9- VOLVER");
            var = tec.nextInt();
            switch (var) {
                case 1:
                    altausuario();
                    break;
                case 2:
                    bajausuario();
                    break;
                case 3:
                    listadousuario();
                    break;
                default:
                    System.out.println("Introduce un numero entre 1-9");
            }
        } while (var != 9);
    }

    private void gestiondelibros() {
        int var = 0;
        do {
            System.out.println("GESTION DE LIBROS");
            System.out.println("1- ALTA NUEVO LIBRO");
            System.out.println("2- BAJA LIBRO");
            System.out.println("3- MODIFICACION DATOS LIBRO");
            System.out.println("4- LISTADO DE LIBROS DISPONIBLE");
            System.out.println("9- VOLVER");
            var = tec.nextInt();
            switch (var) {
                case 1:
                    altalibro();
                    break;
                case 2:
                    bajalibro();
                    break;
                case 3:
                    modificacionlibro();
                    break;
                case 4:
                    listadolibro();
                    break;
                default:
                    System.out.println("Introduce un numero entre 1-9");
            }
        } while (var != 9);
    }

    private void gestiondeprestamos() {
        int var = 0;
        do {
            System.out.println("GESTION DE PRESTAMOS");
            System.out.println("1- PRESTAMOS");
            System.out.println("2- DEVOLUCIONES");
            System.out.println("3- PRORROGAS");
            System.out.println("4- LISTADO DE PRESTAMOS(TODOS)");
            System.out.println("5- LIBROS EN PRESTAMO (POR USUARIO)");
            System.out.println("6- USUARIOS LO TIENEN (POR LIBRO)");
            System.out.println("9- VOLVER");
            var = tec.nextInt();
            switch (var) {
                case 1:
                    altaprestamos();
                    break;
                case 2:
                    bajaprestamos();
                    break;
                case 3:
                    prorrogas();
                    break;
                case 4:
                    listadoprestamos();
                    break;
                case 5:
                    listadoprestamodni();
                    break;
                case 6:
                    listadoprestamoisbn();
                    break;
                default:
                    System.out.println("Introduce un numero entre 1-9");
            }
        } while (var != 9);
    }
//FIN GESTIONES*****************************************************************

//ALTAS*************************************************************************
    private void altausuario() {
        System.out.println("Alta de nuevo usuario");

        System.out.println("Introduzca el dni,nombre,apellido y numero de telefono");

        System.out.print("DNI: ");
        String dni = tec.next();

        System.out.print("Nombre: ");
        String nombre = tec.next();

        System.out.print("Apellido: ");
        String apellido = tec.next();

        System.out.print("Telefono: ");
        String telefono = tec.next();

        usuarios.add(new Usuario(dni, nombre, apellido, telefono));
        System.out.println("Felicidades, el usuario " + nombre + " se ha añadido con exito!");

    }

    private void altalibro() {
        System.out.println("Alta de nuevo Libro");
        System.out.print("Cuantos libros nuevos quieres registrar?: ");

        System.out.println("Introduzca el isbn,titulo,autory  numero de unidades");

        System.out.print("isbn: ");
        String isbn = tec.next();

        System.out.print("Titulo: ");
        String titulo = tec.next();

        System.out.print("Autor: ");
        String autor = tec.next();

        System.out.print("Cantidad de libros: ");
        int unidades = tec.nextInt();

        libros.add(new Libro(isbn, titulo, autor, unidades));
        System.out.println("Felicidades, el libro con el titulo: " + titulo + " y el isbn: " + isbn + " se ha añadido con exito!");

    }

    private void altaprestamos() {
        System.out.println("Introduce datos de usuario y libro para iniciar el prestamo");

        System.out.print("DNI del usuario: ");
        String dni = tec.next();
        Usuario usuarioencontrado = buscardni(dni);
        if (usuarioencontrado == null) {
            System.out.println("No existe el usuario");
        }

        System.out.print("isbn del libro: ");
        String isbn = tec.next();
        Libro libroencontrado = buscarisbn(isbn);

        if (libroencontrado == null) {
            System.out.println("No existe el libro");
        }
        prestamos.add(new Prestamo(usuarioencontrado, libroencontrado, LocalDate.now(), LocalDate.now().plusDays(15)));
        System.out.println("El prestamo del libro " + libroencontrado.getTitulo() + " ha sido creado con exito!");
    }

//FIN ALTAS*********************************************************************
//BAJAS*************************************************************************
    private void bajausuario() {
        System.out.println("Introduce el dni del usuario que quieras eliminar");
        String borrado = tec.next();
        for (Usuario usuario : usuarios) {
            if (usuario.getDni().equals(borrado)) {
                usuarios.remove(usuario);
                System.out.println("El usuario con el dni: " + borrado + " ha sido eliminado de la base de datos.");
                break;
            }
        }
    }

    private void bajalibro() {
        System.out.println("Introduce el isbn del libro que quieras eliminar");
        String borrado = tec.next();
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(borrado)) {
                libros.remove(libro);
                System.out.println("El libro con el isbn: " + borrado + " ha sido eliminado de la base de datos.");
                break;
            }
        }
    }

    private void bajaprestamos() {
        System.out.println("Introduce datos de usuario y libro para iniciar la devolucion");

        System.out.print("DNI del usuario: ");
        String dni = tec.next();
        Usuario usuarioencontrado = buscardni(dni);
        if (usuarioencontrado == null) {
            System.out.println("No existe el usuario");
            return;
        }
        System.out.print("isbn del libro: ");
        String isbn = tec.next();
        Libro libroencontrado = buscarisbn(isbn);
        if (libroencontrado == null) {
            System.out.println("No existe el libro");
            return;
        }
        Prestamo prestamoencontrado = null;
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getUsuarioPrest().equals(usuarioencontrado) && prestamo.getLibroPrest().equals(libroencontrado)) {
                prestamoencontrado = prestamo;
                break;
            }
        }
        prestamos.remove(prestamoencontrado);
        System.out.println("El prestamo del libro " + libroencontrado.getTitulo() + " ha sido borrado con exito!");
    }

//FIN BAJAS*********************************************************************
//LISTADOS**********************************************************************
    private void listadousuario() {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    private void listadolibro() {
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    private void listadoprestamos() {
        for (Prestamo prestamo : prestamos) {
            System.out.println(prestamo);
        }
    }

    private void listadoprestamodni() {
        System.out.print("DNI del usuario: ");
        String dni = tec.next();
        Usuario usuarioencontrado = buscardni(dni);
        for (Prestamo p : prestamos) {
            if (p.getUsuarioPrest() == usuarioencontrado) {
                System.out.println(p.getLibroPrest().getTitulo());

            } else {
                System.out.println("No esiste el dni");
            }
        }
    }

    private void listadoprestamoisbn() {
        System.out.print("isbn del libro: ");
        String isbn = tec.next();
        Libro libroencontrado = buscarisbn(isbn);
        for (Prestamo p : prestamos) {
            if (p.getLibroPrest() == libroencontrado) {
                System.out.println(p.getUsuarioPrest().getNombre());
            } else {
                System.out.println("no existe el libro");
            }

        }

    }

//FIN LISTADOS******************************************************************
//MODIFICACION******************************************************************
    private void modificacionlibro() {
        System.out.println("Introduce el isbn del libro que quieras editar el nº de unidades.");
        String libromod = tec.next();
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(libromod)) {
                System.out.println("Quieres añadir unidades(+) o restar unidades(-)");
                String var = tec.next();
                int numeroUnidades = libro.getUnidades();
                switch (var) {
                    case "+":
                        System.out.println("Cuantos quieres sumar");
                        int op = tec.nextInt();
                        libro.setUnidades(numeroUnidades + op);
                        break;
                    case "-":
                        System.out.println("Cuantos quieres restar");
                        op = tec.nextInt();
                        libro.setUnidades(numeroUnidades - op);
                        break;
                    default:
                        System.out.println("Introduce + o -");
                }
                System.out.println("El libro con el isbn: " + libromod + " ha sido modificado.");
                break;
            }
        }
    }
// FIN MODIFICACION*************************************************************
// BUSCADORES

    private Libro buscarisbn(String isbn) {
        Libro libroencontrado = null;

        for (Libro l : libros) {
            if (l.getIsbn().equals(isbn)) {
                libroencontrado = l;
                break;
            }
        }
        return libroencontrado;
    }

    private Usuario buscardni(String dni) {
        Usuario usuarioencontrado = null;

        for (Usuario u : usuarios) {
            if (u.getDni().equals(dni)) {
                usuarioencontrado = u;
                break;
            }
        }
        return usuarioencontrado;
    }

//FIN BUSCADORES
//PRORROGAS
    private void prorrogas() {
        System.out.println("Introduce datos de usuario y libro para iniciar la prorroga");

        System.out.print("DNI del usuario: ");
        String dni = tec.next();
        Usuario usuarioencontrado = buscardni(dni);
        if (usuarioencontrado == null) {
            System.out.println("No existe el usuario");
            return;
        }

        System.out.print("isbn del libro: ");
        String isbn = tec.next();
        Libro libroencontrado = buscarisbn(isbn);

        if (libroencontrado == null) {
            System.out.println("No existe el libro");
            return;
        }
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getUsuarioPrest().equals(usuarioencontrado) && prestamo.getLibroPrest().equals(libroencontrado)) {
                prestamo.setFechaDev(prestamo.getFechaDev().plusDays(15));
                break;
            }
        }
        System.out.println("El prestamo del libro " + libroencontrado.getTitulo() + " ha sido prorrogado 15 dias más!");

    }
//FIN PRORROGAS

}
