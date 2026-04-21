package AvajLauncher;

public class InvalidAircraftNameException extends Exception
{
	
    public InvalidAircraftNameException (String message)
    {
        super(message + " : ce nom comporte des caractères interdits. Seuls les caracatères alphanumériques sont acceptés.");
    }
}
