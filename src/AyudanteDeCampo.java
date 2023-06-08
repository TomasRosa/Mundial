public class AyudanteDeCampo extends Integrante implements Jugar,Entrenar
{
    private String metodologia;

    public AyudanteDeCampo(String nombre, String apellido, int edad, String metodologia)
    {
        super(nombre, apellido, edad);
        this.metodologia = metodologia;
    }

    public AyudanteDeCampo()
    {

    }

    @Override
    public String toString() {
        return super.toString() +
                "metodologia='" + metodologia + '\'' +
                '}';
    }

    @Override
    public void viajar() {
        System.out.println("Ayudante de campo viajando...");
    }

    @Override
    public void concentrar()
    {
        System.out.println("Ayudante de campo concentrando...");
    }

    @Override
    public void prepararEntrenamiento()
    {
        System.out.println("Ayudante de campo preparando entrenamiento...");
    }

    @Override
    public void jugarPartido()
    {
        System.out.println("Ayudante de campo charlando en el partido con el dt...");
    }
}
