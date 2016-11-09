// Name     : Michael Monical
// Class    : 1620-001
// Program #    : 3
// Due Date     : Oct. 20, 2016
//
// Honor Pledge:  On my honor as a student of the University
//                of Nebraska at Omaha, I have neither given nor received
//                unauthorized help on this homework assignment.
//
// NAME: Michael Monical
// NUID: 9263
// EMAIL: mikemonical@gmail.com

// Partners:None

// This sets up a little manager interface the user can then use to add or remove up to ten employees. Calculting various 
// things.


import employeeType.employee.Employee;
//import employeeType.subTypes.*; Why would this not work?
import employeeType.subTypes.HourlyEmployee;
import employeeType.subTypes.CommissionEmployee;
import employeeType.subTypes.SalaryEmployee;
import exceptions.InvalidCharacterException;
import exceptions.InvalidSizeException;
import exceptions.MaximumCapacityException;
import exceptions.InvalidEmployeeNumberException;
import java.util.Scanner;


public class EmployeeManager {

    private ArrayList<Employee> employees;
    private final int employeeMax = 10;



    public EmployeeManager(){
        try
        {
            employees.ArrayList(3);
        }
        catch(InvalidSizeException E)
        {
            employees.ArrayList();
        }

    }
    public void addEmployee(int type, String fn, String ln, char m, char g, int en, boolean ft, double amount)throws InvalidEmployeeNumberException{
        if (employees.lengthIs() == employeeMax)
        {
            System.out.println("Cannot add more Employees");
            return;
        }
        for(int i = 0;i <= employees.lengthIs();i++){
            if(en == employees.getItem(i).getEmployeeNumber())
            {
                System.out.println("Duplicate Not Added");
                return;
            }

        } 
        switch (type) {
            case 1:
                try{
                    employees.addItem(new HourlyEmployee(fn, ln, m, g, en, ft, amount));
                }
                catch(MaximumCapacityException E)
                {
                    System.out.println("At maximum capacity cannot add the employee");
                }
                break;
            case 2:
                try{
                    employees.addItem(new CommissionEmployee(fn, ln, m, g, en, ft, amount));
                }
                catch(MaximumCapacityException E)
                {
                    System.out.println("At maximum capacity cannot add the employee");
                }
                break;
            case 3:
                try{
                    employees.addItem(new SalaryEmployee(fn, ln, m, g, en, ft, amount));
                }
                catch(MaximumCapacityException E)
                {
                    System.out.println("At maximum capacity cannot add the employee");
                }
                break;
            default:
                System.out.println("Invalid Employee Type, None Added");
                break;
        }
    }

    public void removeEmployee(int index)
    {
        employees.removeItem(index);
    }


    public void listAll()
    {
        if (employees.lengthIs() == 0){
            System.out.println("No Employees.\n");
        }    
        else
        {
            System.out.println("\n" + employees.toString() ); 
        }
    }
    public void listHourly()
    {
        if (employees.lengthIs() == 0)
        {    
            System.out.println("No Employees.\n");
        }
        else
        {
            for(int i = 0; i <= employees.lengthIs(); i++)
            {
                if(employees.getItem(i) instanceof HourlyEmployee){
                    System.out.println(employees.getItem(i).toString());
                }
            }
        }
    }    

    public void listSalary()
    {
        if (employees.lengthIs() == 0)
        {    
            System.out.println("No Employees.\n");
        }
        else
        {
            for(int i = 0; i <= employees.lengthIs(); i++){
                if(employees.getItem(i) instanceof SalaryEmployee){
                    System.out.println(employees.getItem(i).toString());
                }
            }
        }   
    }
    public void listCommission()
    {
        if (employees.lengthIs() == 0)
        {    
            System.out.println("No Employees.\n");
        }
        else
        {
            for(int i = 0; i <= employees.lengthIs(); i++)
            {
                if(employees.getItem(i) instanceof CommissionEmployee){
                    System.out.println(employees.getItem(i).toString());
                }

            }
        }
    }

    public void resetWeek(){
        for(int i = 0; i <= employees.lengthIs(); i++){
            employees.getItem(i).resetWeek();
        }
    }

    public double calculatePayout(){
        double sum = 0.0;
        for(int i = 0; i <= employees.lengthIs(); i++){
            sum += employees.getItem(i).calculateWeeklyPay(); 
        }
        return sum;
    }

    public int getIndex(int empNum){
        for(int i = 0; i <= employees.lengthIs(); i++){
            if (employees.getItem(i).getEmployeeNumber() == empNum)
                return i;
        }
        return -1;
    }

    public void annualRaises(){
        for(int i = 0; i <= employees.lengthIs(); i++){
            employees.getItem(i).annualRaise();
        }
    }

    public double holidayBonuses(){
        double bonus = 0.0;
        for(int i = 0; i <= employees.lengthIs(); i++){
            bonus += employees.getItem(i).holidayBonus();
        }
        return bonus;
    }

    public void increaseHours(int index, double amount){

        HourlyEmployee Employee = (HourlyEmployee)employees.getItem(index);
        Employee.increaseHours(amount);

    }


    public void increaseSales(int index, double amount){

        CommissionEmployee Employee = (CommissionEmployee)employees.getItem(index);
        Employee.increaseSales(amount);

    }

    public ArrayList<Employee> findAllBySubstring(String find)
    {
        String name;
        ArrayList<Employee> ea = null;
        //Is there anyother way of initializing this ea?
        ea.ArrayList();

        for(int i = 0 ; i < employees.lengthIs();i++)
        {
            name = employees.getItem(i).getFirstName() + employees.getItem(i).getLastName();
            if (RabinKarp(name, find) != -1)
            {
                try
                {
                    ea.addItem(employees.getItem(i));
                }
                catch(MaximumCapacityException E)
                {    

                }
            }


        }
        return  ea;
    }
    private int charNumericValue(char c) throws InvalidCharacterException
    {        
        switch( c )
        {
            case 'a': 
            case 'A':
                return 0;
            case 'b': 
            case 'B':
                return 1;
            case 'c': 
            case 'C':
                return 2;     
            case 'd': 
            case 'D':
                return 3;    
            case 'e': 
            case 'E':
                return 4;
            case 'f': 
            case 'F':
                return 5;
            case 'g': 
            case 'G':
                return 6;
            case 'h': 
            case 'H' :
                return 7;
            case 'i': 
            case 'I':
                return 8;
            case 'j': 
            case 'J':
                return 9;
            case 'k':
            case 'K':
                return 10;
            case 'l':
            case 'L':
                return 11;
            case 'm': 
            case 'M':
                return 12;
            case 'n': 
            case 'N':
                return 13;
            case 'o': 
            case 'O':
                return 14;
            case 'p': 
            case 'P':
                return 15;
            case 'q': 
            case 'Q':
                return 16;
            case 'r': 
            case 'R':
                return 17;
            case 's': 
            case 'S':
                return 18;
            case 't': 
            case 'T':
                return 19;
            case 'u': 
            case 'U':
                return 20;
            case 'v': 
            case 'V':
                return 21;
            case 'w': 
            case 'W':
                return 22;
            case 'x': 
            case 'X':
                return 23;
            case 'y': 
            case 'Y':
                return 24;
            case 'z': 
            case 'Z':
                return 25;
            default: 
                throw new InvalidCharacterException( c );
        }    
    }
    private int stringHash (String s)
    {
        int hash = 0;
        int l = s.length();
        for(int i = 0; i < l; i++)
        {
            hash = charNumericValue(s.charAt(i))* (int) Math.pow(26,l-i-1);
        }
        return hash;
    }

    private int RabinKarpHashes(String s, int[] hashes, int pos, int length )
    {
        if(pos < 0)
        {
            return 0;
        }
        hashes[pos] = stringHash(s.substring(pos - length, pos));

        return RabinKarpHashes(s, hashes, pos,pos + length);

        //for(int i = 0; i < s.length() - length; i++)
        // {
        //     hashes[i] = stringHash(s.substring(pos - length, pos));
        //     pos--;
        // }

        //return 1;
    }

    private int linearSearchRecursive(int[] data, int key, int pos)
    {
        if (pos < 0 ) 
        {
            return -1;
        }
        if(key == data[pos-1])
        {
            return pos - 1;
        } 
        return linearSearchRecursive( data, key, pos - 1);
    }

    private int RabinKarp(String name, String find)
    {
        if (find.length() > name.length() )
        {    
            return -1;
        }
        int findhash = stringHash(find);
        int[] nameHashes = new int[name.length() - find.length()+1];
        RabinKarpHashes(name, nameHashes, name.length() - find.length(), find.length());
        return linearSearchRecursive(nameHashes, findhash, nameHashes.length);
    }

    public void sort()
    {
        employees.sort();
    }
}

