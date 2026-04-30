package ajexceptions;

public class InvalidAircraftTypeException extends Exception
{
    public InvalidAircraftTypeException (String message)
    {
        super(message + " : ce type n'existe pas.");
    }
}
