package libreria.servicios;

import java.util.Calendar;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;

/**
 *
 * @author matia
 */
public class Menu {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private final EditorialServicio edSer = new EditorialServicio();
    private final AutorServicio autoSer = new AutorServicio();
    private final LibroServicio liSer = new LibroServicio();
    private final PrestamoServicio presSer = new PrestamoServicio();
    private final ClienteServicio cliSer = new ClienteServicio();

    public void Menu() throws Exception {
        edSer.setServicio(autoSer, liSer, presSer, cliSer);
        autoSer.setServicio(edSer, liSer, presSer, cliSer);
        liSer.setServicio(edSer, autoSer, presSer, cliSer);
        presSer.setServicio(autoSer, edSer, liSer, cliSer);
        cliSer.setServicio(autoSer, edSer, liSer, presSer);

        String opcion = null;
        System.out.println("Bienvenido........");
        System.out.println("----------------------------------------------------");
        while (!"Z".equals(opcion)) {
            System.out.println("Indique la opcion: ");
            System.out.println("");
            System.out.println("A- Busqueda de Autor por Nombre.");
            System.out.println("B- Busqueda de libro por ISBN.");
            System.out.println("C- Busqueda de libro por Titulo.");
            System.out.println("D- Busqueda de Editorial por nombre.");
            System.out.println("E- Listar libros segun Autor.");
            System.out.println("F- Listar libros segun Editorial.");
            System.out.println("G- Listar libros por Año.");
            System.out.println("H- Listar Autores.");
            System.out.println("I- Listar Editoriales");
            System.out.println("J- Listar todos los Libros.");
            System.out.println("K- Cargar libro.");
            System.out.println("L- Cargar Autor.");
            System.out.println("M- Cargar Editorial.");
            System.out.println("N- Eliminar libro.");
            System.out.println("O- Eliminar Autor.");
            System.out.println("P- Eliminar Editorial.");

            System.out.println("Q- Guardar nuevo Cliente.");
            System.out.println("R- Generar nuevo Prestamo.");
            System.out.println("S- Devolver Libro.");
            System.out.println("T- Buscar Prestamos segun Cliente");
            System.out.println("Z- Zalir.");

            opcion = leer.next().toUpperCase();

            switch (opcion) {
                case "A":
                    System.out.println("Ingrese el nombre del autor a buscar: ");
                    System.out.println(autoSer.buscarPorNombre(leer.next()));
                    break;
                case "B":
                    System.out.println("Ingrese el ISBN del libro que desea buscar: ");
                    System.out.println(liSer.buscarPorISBN(leer.nextLong()));
                    break;
                case "C":
                    System.out.println("Ingrese el titulo del libro que desea encontrar: ");
                    System.out.println(liSer.buscarPorTitulo(leer.next()));
                    break;
                case "D":
                    System.out.println("Ingrese el nombre de la editorial:");
                    System.out.println(edSer.buscarPorNombre(leer.next()));
                    break;
                case "E":
                    System.out.println("Ingrese el nombre del Autor: ");
                    System.out.println(liSer.buscarPorAutor(leer.next()));
                    break;
                case "F":
                    System.out.println("Ingrese el nombre de la editorial: ");
                    System.out.println(liSer.buscarPorEditorial(leer.next()));
                    break;
                case "G":
                    System.out.println("Ingrese el año: ");
                    System.out.println(liSer.buscarPorAnio(leer.nextInt()));
                    break;
                case "H":
                    System.out.println("Listando todos los autores: ");
                    System.out.println("");
                    System.out.println(autoSer.listarAutores());
                    break;
                case "I":
                    System.out.println("Listando todas las editoriales: ");
                    System.out.println("");
                    System.out.println(edSer.listarEditoriales());
                    break;
                case "J":
                    System.out.println("Listando todos los libros: ");
                    System.out.println("");
                    System.out.println(liSer.listarLibros());
                    break;
                case "K":
                    System.out.println("Cargando libro a la base de datos...");
                    System.out.println("Ingrese el ISBN: ");
                    long isbn = leer.nextLong();
                    System.out.println("Ingrese el titulo del libro: ");
                    String titulo = leer.next();
                    System.out.println("Ingrese el año de publicacion: ");
                    Integer anio = leer.nextInt();
                    System.out.println("Ingrese la cantidad de ejemplares disponibles: ");
                    Integer ejemplares = leer.nextInt();
                    System.out.println("Ingrese el autor del libro :");
                    String autor = leer.next();
                    Autor autor1;
                    if (autoSer.buscarPorNombre(autor) == null) {
                        autor1 = autoSer.crearAutor(autor, true);
                    } else {
                        autor1 = autoSer.buscarPorNombre(autor);
                    }
                    System.out.println("Ingrese el nombre de la editorial que publica el libro:");
                    String editorial12 = leer.next();
                    Editorial editorial123;
                    if (edSer.buscarPorNombre(editorial12) == null) {
                        editorial123 = edSer.crearEditorial(editorial12, true);
                    } else {
                        editorial123 = edSer.buscarPorNombre(editorial12);
                    }
                    liSer.crearLibro(isbn, titulo, anio, ejemplares, 0, ejemplares, true, autor1, editorial123);
                    System.out.println("Libro cargado.");
                    break;

                case "L":
                    System.out.println("Cargando un autor nuevo: ");
                    System.out.println("Ingrese el nombre del autor: ");
                    String nombreAutor = leer.next();
                    if (autoSer.buscarPorNombre(nombreAutor) == null) {
                        autoSer.crearAutor(nombreAutor, true);
                        System.out.println("Autor ingresado a la base de datos.");
                    } else {
                        System.out.println("El autor ya esta ingresado.");
                    }
                    break;
                case "M":
                    System.out.println("Cargando una editorial nueva: ");
                    System.out.println("Ingrese el nombre de la editorial: ");
                    String nombreEditorial = leer.next();
                    if (edSer.buscarPorNombre(nombreEditorial) == null) {
                        edSer.crearEditorial(leer.next(), true);
                        System.out.println("Editorial ingresada al sistema.");
                    } else {
                        System.out.println("La editorial ya esta ingresada.");
                    }
                    break;
                case "N":
                    System.out.println("Ingrese el titulo del libro que desea eliminar: ");
                    System.out.println("Libro eliminado: " + liSer.eliminarLibro(leer.next()));
                    break;
                case "O":
                    System.out.println("Ingrese el nombre del autor a eliminar: ");
                    System.out.println("Autor eliminado: " + autoSer.eliminarAutor(leer.next()));
                    break;
                case "P":
                    System.out.println("Ingrese el nombre de la editorial a eliminar: ");
                    System.out.println("Editorial eliminada: " + edSer.eliminarEditorial(leer.next()));
                    break;
                case "Q":
                    System.out.println("Ingrese el nombre del cliente: ");
                    String nombre = leer.next();
                    if (cliSer.buscarPorNombre(nombre) == null) {
                        System.out.println("Ingrese el apellido del cliente: ");
                        String apellido = leer.next();
                        System.out.println("Ingrese el DNI del cliente: ");
                        Long dni = leer.nextLong();
                        System.out.println("Ingrese el telefono del cliente: ");
                        String telefono = leer.next();
                        cliSer.crearCliente(dni, nombre, apellido, telefono);
                        System.out.println("Cliente ingresado.");
                    } else {
                        System.out.println("El cliente ya esta registrado en el sistema.");
                    }

                    break;
                case "R":
                    System.out.println("Usted ya es cliente de la libreria? (s/n)");
                    String opcion1 = leer.next();
                    while (!opcion1.equalsIgnoreCase("s") && !opcion1.equalsIgnoreCase("n")) {
                        System.out.println("Opcion no valida, ingrese s o n.");
                        opcion1 = leer.next();
                    }
                    while (opcion1.equalsIgnoreCase("n")) {
                        System.out.println("Creando nuevo Cliente...");
                        System.out.println("Ingrese el nombre del cliente: ");
                        String nombre2 = leer.next();
                        if (cliSer.buscarPorNombre(nombre2) == null) {
                            System.out.println("Ingrese el apellido del cliente: ");
                            String apellido2 = leer.next();
                            System.out.println("Ingrese el DNI del cliente: ");
                            Long dni2 = leer.nextLong();
                            System.out.println("Ingrese el telefono del cliente: ");
                            String telefono2 = leer.next();
                            cliSer.crearCliente(dni2, nombre2, apellido2, telefono2);
                            System.out.println("Cliente ingresado.");
                        } else {
                            System.out.println("El Cliente ya esta ingresado, sigamos...");
                        }
                        opcion1 = "s";
                    }
                    crearPrestamo();
                    break;
                case "S":
                    System.out.println("Ingrese el nombre del libro a devolver: ");
                    String titulo3 = leer.next();
                    if (liSer.buscarPorTitulo(titulo3) != null) {
                        presSer.eliminarPrestamoTitulo(titulo3);
                        Libro libro3 = liSer.buscarPorTitulo(titulo3);
                        libro3.setEjemplaresPrestados(libro3.getEjemplaresPrestados() - 1);
                        libro3.setEjemplaresRestantes(libro3.getEjemplaresRestantes() + 1);
                        System.out.println("Libro devuelto correctamente.");
                        System.out.println("Gracias por elegirnos.");
                    } else {
                        System.out.println("El libro ingresado no tiene un prestamo asociado.");
                    }
                    break;
                case "T":
                    System.out.println("Ingrese el nombre del Cliente para consultar sus prestamos: ");
                    String nombreCliente = leer.next();
                    if (presSer.buscarPorNombreCliente(nombreCliente) == null) {
                        System.out.println("El Cliente ingresado no tiene prestamos asociados.");
                    } else {
                        System.out.println(presSer.buscarPorNombreCliente(nombreCliente));
                    }
                    break;
                case "Z":
                    System.out.println("Zaliendo del programa....");
                    break;
            }
        }
    }

    public void crearPrestamo() {
        edSer.setServicio(autoSer, liSer, presSer, cliSer);
        autoSer.setServicio(edSer, liSer, presSer, cliSer);
        liSer.setServicio(edSer, autoSer, presSer, cliSer);
        presSer.setServicio(autoSer, edSer, liSer, cliSer);
        cliSer.setServicio(autoSer, edSer, liSer, presSer);
        System.out.println("Ingrese el nombre del libro:");
        String titulo1 = leer.next();
        if (liSer.buscarPorTitulo(titulo1) != null) {
            System.out.println("Ingrese su id de Cliente: ");
            Integer id = leer.nextInt();
            Calendar fechaPrestamo = Calendar.getInstance();
            Calendar fechaDevolucion = Calendar.getInstance();
            System.out.println("Listo, retire su libro.");
            fechaDevolucion.add(Calendar.DATE, 30);
            presSer.crearPrestamo(fechaPrestamo, fechaDevolucion, liSer.buscarPorTitulo(titulo1), cliSer.buscarPorID(id));
            System.out.println("Su fecha de devolucion es: ");
            System.out.println(fechaDevolucion.getTime());
            Libro libro = liSer.buscarPorTitulo(titulo1);
            libro.setEjemplaresPrestados(libro.getEjemplaresPrestados() + 1);
            libro.setEjemplaresRestantes(libro.getEjemplaresRestantes() - 1);
        } else {
            System.out.println("Su libro no fue encontrado.");
        }
    }
}
