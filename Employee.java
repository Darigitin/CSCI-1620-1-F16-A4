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

// This sets up my superclass or parent class for my Employee information. In here you will find setters, getters.
// along with many default values used in this assignment.



package employeeType.employee;
import exceptions.InvalidEmployeeNumberException;
import java.util.Scanner;


public abstract class Employee implements Comparable<Employee>{
    private String firstName, lastName;
    private char middleInitial, gender;
    private boolean Fulltime;
    private int employeeNum;

    public Employee(String fn, String ln, char m, char g, int empNum, boolean ft)throws InvalidEmployeeNumberException {
        setEmployeeNumber(empNum);
        setFirstName(fn);
        setLastName(ln);
        setMiddleInitial(m);
        setGender(g);


    }

    public int getEmployeeNumber()
    {
        return employeeNum;
    }

    public void setEmployeeNumber(int empNum)throws InvalidEmployeeNumberException
    {

        boolean flag = false;
        while (!flag)
        {
            if(10000 <= empNum && empNum <= 99999)
            {
                employeeNum = empNum;
                flag = true;
            }
            else 
            {
                throw new InvalidEmployeeNumberException(empNum);
            }
        }
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }
    public char getMiddleInitial(){
        return middleInitial;
    }
    public char getGender() {
        return gender;
    }

    public boolean getFulltime(){
        return Fulltime;
    }
    public void setFirstName(String fn){
        firstName = fn;
    }
    public void setLastName(String ln){
        lastName = ln;
    }

    public void setMiddleInitial(char m){
        middleInitial = m; 
    }

    public void setGender(char g) {
        if(g == 'M' || g == 'F' )
            gender = g;
        else
            gender = 'F';

    }

    public void setFulltime(boolean ft){
        Fulltime = ft;
    }


    public boolean equals(Employee e2){
        return (employeeNum == e2.getEmployeeNumber());
    }

    @Override
    public String toString(){
        String toString = null;
        toString = toString + employeeNum + "\n" + lastName + ',' + firstName
            + middleInitial + '.' + "\n" + "Gender: " + gender + "Status: ";
        if (getFulltime())
            toString = toString + "Full Time";
        else
            toString = toString + "Part Time";
        return toString;
    }

    public abstract double calculateWeeklyPay();

    public abstract void annualRaise();

    public abstract double holidayBonus();

    public abstract void resetWeek();

    @Override
    public int compareTo(Employee e)
    {
        if(getEmployeeNumber() > e.getEmployeeNumber())
            return 1;
        else if(getEmployeeNumber() < e.getEmployeeNumber())
            return -1;
        else
            return 0;
    }

}


