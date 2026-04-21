

public class FirstLineErrorException extends Exception
{
    public FirstLineErrorException (String message)
    {
        super(message + " : La première ligne du fichier ne comporte pas un nombre de simulation valide.");
    }
}
