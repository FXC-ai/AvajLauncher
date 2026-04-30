

public class NonUniqueNameException extends Exception
{
    public NonUniqueNameException (String message)
    {
        super(message + " : ce nom a déjà été utilisé.");
    }
}
