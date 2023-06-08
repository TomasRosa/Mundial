import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList integrantes = new ArrayList<Integrante>();

        Federacion federacionArgentina = new Federacion<>("AFA", "20/02/1983", 15, integrantes);

        Futbolista f1 = new Futbolista("Enzo", "Fernandez", 18, 8, "Mediocampista");
        Futbolista f2 = new Futbolista("Lucas", "Martinez", 25, 10, "Delantero");
        Masajista m1 = new Masajista("Lauti", "Ruiz", 17, "Boludo", 5);
        Masajista m2 = new Masajista("Luquita", "Gomez", 17, "Tarado", 3);
        AyudanteDeCampo a1 = new AyudanteDeCampo("Tomas", "Rosa", 17, "Capo");
        Entrenador e1 = new Entrenador("Ricardo", "Zielinski", 14, 433, "Ofensivo");
        Entrenador e2 = new Entrenador("Ricardo", "Milos", 14, 433, "Ofensivo");


        ArrayList<Integrante> listaExcepcion = new ArrayList<>();
        listaExcepcion.add(f1);
        listaExcepcion.add(f2);
        listaExcepcion.add(m1);
        listaExcepcion.add(m2);
        listaExcepcion.add(a1);
        listaExcepcion.add(e1);

        for (Integrante agregar : listaExcepcion) {
            try {
                federacionArgentina.agregar(agregar);
            } catch (MasDe23Jugadores e) {
                System.out.printf(e.getMessage());
            } catch (YaHayEntrenadorException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Antes de borrar:");
        federacionArgentina.mostrarListaGenerica();

        System.out.println("Luego de borrar:");
        federacionArgentina.quitar(m1);
        federacionArgentina.mostrarListaGenerica();


        try
        {
            federacionArgentina.exportarAArchivoJson(federacionArgentina,"mi_archivo.json");
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("Mostrando...");
        try
        {
            federacionArgentina.mostrarArchivoJson("mi_archivo.json");
        }
        catch (IOException e)
        {
            System.out.printf(e.getMessage());
        }

    }

    public static void funcionamientoJson() {
        File file = new File("mi_archivo.json");

        ObjectMapper objectMapper = new ObjectMapper();

        String palabra = "Tomi";
        String xd = " ";

        try {
            objectMapper.writeValue(file, palabra);
        } catch (IOException e) {
            System.out.printf(e.getMessage());
        }

        try {
            xd = objectMapper.readValue(file, String.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(xd);
    }
}