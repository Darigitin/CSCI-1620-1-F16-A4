


package exceptions;



public class InvalidEmployeeNumberException extends Exception
{
    public InvalidEmployeeNumberException(int num)
    {
        super(num + " is not a valid EmployeeNumber\n");
    }

    InvalidEmployeeNumberException() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

