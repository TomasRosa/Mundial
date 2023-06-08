public class Entrenador extends Integrante implements Jugar,Entrenar
{
    private int sistJuego;
    private String estilo;

    public Entrenador(String nombre, String apellido, int edad, int sistJuego, String estilo) {
        super(nombre, apellido, edad);
        this.sistJuego = sistJuego;
        this.estilo = estilo;
    }

    public Entrenador()
    {
        super();
    }

    public int getSistJuego() {
        return sistJuego;
    }

    public void setSistJuego(int sistJuego) {
        this.sistJuego = sistJuego;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    @Override
    public String toString() {
        return super.toString() +
                "sistJuego=" + sistJuego +
                ", estilo='" + estilo + '\'' +
                '}';
    }

    @Override
    public void viajar()
    {
        System.out.println("Entrenador viajando...");
    }

    @Override
    public void concentrar()
    {
        System.out.println("Entrenador concentrando...");
    }

    @Override
    public void prepararEntrenamiento()
    {
        System.out.println("Entrenador preparando entrenamiento...");
    }

    @Override
    public void jugarPartido()
    {
        System.out.println("Entrenador jugando el partido...");
    }
}
