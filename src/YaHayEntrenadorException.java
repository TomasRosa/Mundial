public class YaHayEntrenadorException extends RuntimeException
{
    public YaHayEntrenadorException ()
    {
        super("Ya hay un entrenador no puede agregarse otro.");
    }
}
