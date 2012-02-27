package exceptions;


/**
 * Represents an exceptional situation specific to this project.
 * 
 * @author Robert C. Duvall
 */
@SuppressWarnings("serial")
public class HtmlOutputException extends RuntimeException
{
    public static enum Type { BAD_SYNTAX, EXTRA_CHARACTERS, UNKNOWN_COMMAND };
    private Type myType;

    /**
     * Create exception with given meesage
     *  
     * @param message explanation of problem
     */
    public HtmlOutputException (String message)
    {
        this(message, Type.BAD_SYNTAX);
    }
    
    public HtmlOutputException (String message, Type type)
    {
        super(message);
        myType = type;
    }
    
    public Type getType()
    {
    	return myType;
    }
}
