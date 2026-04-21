package Exceptions;

public class InvalidHeightException extends Exception
{
    public InvalidHeightException (String message)
    {
        super(message + " : cet alititude est trop élevé (100 max).");
    }
}
