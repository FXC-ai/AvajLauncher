package Exceptions;

public class TokenNumberException extends Exception
{
    public TokenNumberException (String message)
    {
        super(message + " : cette ligne comporte un nombre incorrect de tokens.");
    }
}
