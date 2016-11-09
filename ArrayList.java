import java.util.Scanner;
import employeeType.subTypes.HourlyEmployee;
import employeeType.subTypes.SalaryEmployee;
import employeeType.subTypes.CommissionEmployee;
import employeeType.employee.Employee;
import exceptions.InvalidSizeException;
import exceptions.InvalidCharacterException;
import java.util.InputMismatchException;
import exceptions.MaximumCapacityException;




@SuppressWarnings("unchecked")
public class ArrayList <E extends Comparable<E>>{
    private final int DEFCAP = 50;
    private int origCap;
    private int numElements;
    private Object[] list;

    public void ArrayList( )
    {
        origCap = DEFCAP;
        list = new Object[origCap];
        numElements = 0;

    }
    public void ArrayList(int size)throws InvalidSizeException
    {
        numElements = 0;
        if( size > DEFCAP || size < 1)
            throw new InvalidSizeException();
        origCap = size;
        
        list = new Object[origCap];
        
    }

    public void addItem(E item)throws MaximumCapacityException
    {
        if( numElements == DEFCAP)
        {
            throw new MaximumCapacityException();
        }
        if(numElements == list.length)
        {
            enlarge();
        }
        list[numElements] = item; 
        numElements++;
    }

    public E getItem(int index)throws IndexOutOfBoundsException
    {
        if(index >= numElements || index < 0)
        {
            throw new IndexOutOfBoundsException("Index out of Range");
        }
        return (E) list[index];
    }

    public void setItem(int index, E item)throws IndexOutOfBoundsException
    {
        if(index >= numElements || index < 0)
        {
            throw new IndexOutOfBoundsException("Index out of Range");
        }
        list[numElements] = item;

    }

    public E removeItem(int index) throws IndexOutOfBoundsException
    {
        if(index < 0 || numElements < 0)
        {
            throw new IndexOutOfBoundsException("Index out of Range");
        }
        E ret = (E)list[index];
        for(int i = index; i < numElements - 1; i++)
        {
            list[i] = list[i + 1];
        }
        numElements--;
        return ret;
    }

    public int findItem(E item)
    {
        for(int i = 0; i < numElements; i++)
        {
            if(list[i] == item)
            {
                return i;
            }

        }
        return -1;

    }

    public boolean isEmpty()
    {
        return numElements == 0;
    }

    public int lengthIs()
    {

        return numElements;
    }

    public void clear()
    {
        if(list.length != origCap)
            list = new Object[origCap];

        numElements = 0;
    }

    @Override
    public String toString()
    {
        String name = "";
        for(int i = 0; i < numElements; i++)
        {
            name = name + list[i].toString() + "\n";
        }
        return name;
    }
    public void sort()
    {
        E temp;

        for (int i = 1; i < list.length; i++) {
            for(int j = i ; j > 0 ; j--){
                temp = (E) list[j];

                if( temp.compareTo((E) list[j-1]) == -1)
                {
                    list[j] = list[j-1];
                    list[j-1] = temp;
                }

            }
        }
        //10, 34, 2, 56, 7, 67, 88, 42
        //10, 34, 2, 56, 7, 67, 88, 42
        //10, 2, 34, 56
        //2, 10, 34, 56, 7
        // 2,10, 34, 7, 56
        // 2, 10, 7, 34, 56,

    }

    private void enlarge() throws MaximumCapacityException
    {
        int newsize = list.length + origCap;
        if(list.length == DEFCAP)
            throw new MaximumCapacityException();
        else if (newsize > DEFCAP)
            newsize = DEFCAP;
        Object[] tempArray = new Object[newsize];
        System.arraycopy(list, 0, tempArray, 0, numElements);
        list = tempArray;
    }
}

