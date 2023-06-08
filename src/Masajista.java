public class Masajista extends Integrante
{
    private String titulo;
    private int aniosExp;

    public Masajista(String nombre, String apellido, int edad, String titulo, int aniosExp)
    {
        super(nombre, apellido, edad);
        this.titulo = titulo;
        this.aniosExp = aniosExp;
    }

    public Masajista()
    {
        super();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAniosExp() {
        return aniosExp;
    }

    public void setAniosExp(int aniosExp) {
        this.aniosExp = aniosExp;
    }
    public void darAsistencia ()
    {
        System.out.println("Masajista presente...");
    }

    @Override
    public String toString() {
        return super.toString() +  "Masajista{" +
                "titulo='" + titulo + '\'' +
                ", aniosExp=" + aniosExp +
                '}';
    }

    @Override
    public void viajar()
    {
        System.out.println("Masajista viajando...");
    }

    @Override
    public void concentrar()
    {
        System.out.println("Masajista concentrando...");
    }
}
