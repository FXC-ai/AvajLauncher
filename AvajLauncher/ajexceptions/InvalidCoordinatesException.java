package ajexceptions;

public class InvalidCoordinatesException extends Exception
{
    public InvalidCoordinatesException (String message)
    {
        super(message + " : la longitude, la latitude ou l'altitude est/sont incorrect(s).");
    }
}
