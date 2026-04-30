public class NoAircraftException extends Exception
{
    public NoAircraftException ()
    {
        super("La liste des aircrafts est vide.");
    }
}
