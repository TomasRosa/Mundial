import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Federacion <T>
{
    private String nombre;
    private String fecha;
    private int cantCopas;

    private ArrayList<T> integrantes;
    private int cantJugadores = 0;
    private boolean hayEntrenador = false;

    public Federacion(String nombre, String fecha, int cantCopas, ArrayList<T> integrantes)
    {
        this.nombre = nombre;
        this.fecha = fecha;
        this.cantCopas = cantCopas;
        this.integrantes = integrantes;
    }
    public Federacion ()
    {

    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public int getCantCopas() {
        return cantCopas;
    }

    public void setCantCopas(int cantCopas) {
        this.cantCopas = cantCopas;
    }

    public ArrayList<T> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(ArrayList<T> integrantes) {
        this.integrantes = integrantes;
    }

    public int getCantJugadores() {
        return cantJugadores;
    }

    public void setCantJugadores(int cantJugadores) {
        this.cantJugadores = cantJugadores;
    }

    public boolean isHayEntrenador() {
        return hayEntrenador;
    }

    public void setHayEntrenador(boolean hayEntrenador) {
        this.hayEntrenador = hayEntrenador;
    }

    @Override
    public String toString() {
        return "Federacion{" +
                "nombre='" + nombre + '\'' +
                ", fecha='" + fecha + '\'' +
                ", cantCopas=" + cantCopas +
                ", integrantes=" + integrantes +
                '}';
    }
    public boolean agregar (T miembro) throws YaHayEntrenadorException,MasDe23Jugadores
    {
        if(miembro instanceof Entrenador ||miembro instanceof Futbolista)
        {
            if(miembro instanceof Entrenador && this.hayEntrenador == true)
            {
                throw new YaHayEntrenadorException();
            }
            else if (miembro instanceof Entrenador && this.hayEntrenador == false)
            {
                this.integrantes.add(miembro);
                this.hayEntrenador = true;
                return true;
            }
            if(miembro instanceof Futbolista && this.cantJugadores == 23)
            {
                throw new MasDe23Jugadores();
            }
            else
            {
                this.integrantes.add(miembro);
                this.cantJugadores++;
                return true;
            }
        }
        else
        {
            integrantes.add(miembro);
            return true;
        }
    }
    public void quitar (T miembro)
    {
        T encontrado = buscar(miembro);

        if(encontrado == null)
        {
            System.out.println("No existe el integrante que deseas eliminar.");
        }
        else
        {
            this.integrantes.remove(encontrado);
        }
    }
    public T buscar (T miembro)
    {
        T aBuscar = null;

        for(T elemento: this.integrantes)
        {
            if(elemento.equals(miembro))
            {
                aBuscar = elemento;
            }
        }
        return aBuscar;
    }
    public void mostrarListaGenerica ()
    {
        for(T elemento: this.integrantes)
        {
            System.out.println(elemento);
        }
    }
    public void exportarAArchivoJson (Federacion fed, String name) throws IOException {
        File file = new File(name);

        ObjectMapper objectMapper = new ObjectMapper();

        if(!file.exists()) throw new IOException();

        objectMapper.writeValue(file,fed);
    }
    public void mostrarArchivoJson (String name) throws IOException {
        File file = new File(name);
        Federacion fed = null;
        ObjectMapper objectMapper = new ObjectMapper();

        if(!file.exists()) throw new IOException();

        fed = objectMapper.readValue(file,Federacion.class);
        System.out.println(fed);
    }
}
