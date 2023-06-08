public class Futbolista extends Integrante implements Jugar
{
    private int nCamiseta;
    private String puesto;

    public Futbolista(String nombre, String apellido, int edad, int nCamiseta, String puesto)
    {
        super(nombre, apellido, edad);
        this.nCamiseta = nCamiseta;
        this.puesto = puesto;
    }

    public Futbolista()
    {
        super();
    }

    public int getnCamiseta() {
        return nCamiseta;
    }

    public void setnCamiseta(int nCamiseta) {
        this.nCamiseta = nCamiseta;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return super.toString() + "Futbolista{" +
                "nCamiseta=" + nCamiseta +
                ", puesto='" + puesto + '\'' +
                '}';
    }

    @Override
    public void viajar()
    {
        System.out.println("Futbolista viajando...");
    }

    @Override
    public void concentrar()
    {
        System.out.println("Futbolista concentrando...");
    }

    @Override
    public void jugarPartido()
    {
        System.out.println("Futbolista jugando...");
    }
}
