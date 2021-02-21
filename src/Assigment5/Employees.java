package Assigment5;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Here another class for employees in company
public class Employees extends Job {
    public int employeeId;
    private String employeeName;
    private String surname;
    private String address;
    private String jobName;
    private int salary;

    public Employees() { //default empty constructor
    }
    //constructor to initialize all variables
    public Employees(int employeeId, String employeeName, String surname, String address, String jobName, int salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.surname = surname;
        this.address = address;
        this.jobName=jobName;
        this.salary = salary;
    }

    //another constructor with refer to superclass Job
    public Employees(int companyId, String companyName, String foundationDate, String jobName, int salary, int companyId1, int employeeId, String employeeName, String surname, String address, String jobName1, int salary1) {
        super(companyId, companyName, foundationDate, jobName, salary, companyId1);
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.surname = surname;
        this.address = address;
        this.jobName=jobName1;
        this.salary = salary1;
    }

    //getters and setters to work with private variables and to refer to variables
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getJobName() {
        return jobName;
    }

    @Override
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public void setSalary(int salary) {
        this.salary = salary;
    }

    //method to show all data from Employees column
    public static void allEmployees(){
        Main m=new Main();
        m.getCon();//connecting with database
        try {
            //make request to database
            PreparedStatement preparedStatement=m.con.prepareStatement("select *from Employees");
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                //get data from column
              int employeeId=resultSet.getInt("employee_id");
              String employeeName=resultSet.getString("employee_name");
              String surname=resultSet.getString("surname");
              String address=resultSet.getString("address");
              String jobName=resultSet.getString("job_name");
              int salary=resultSet.getInt("salary");

                System.out.println("name" + ":" + employeeName
                        + ", " + "surname" +  ":"+surname+", "+"address"+":"+address+", "+"position"+":"+jobName
                +", "+"salary"+":"+salary);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //method to insert new employees
    public static void addNew(Employees e) {
        Main m=new Main();
        m.getCon(); //connecting with database
        try {
            //make request. "?" to add values in future
            PreparedStatement ps = m.con.prepareStatement("insert into Employees(employee_id,employee_name,surname,address,job_name,salary) values (?,?,?,?,?,?)");
            //adding values, firstly, parameter of variable, then variable
            ps.setInt(1,e.employeeId);
            ps.setString(2, e.employeeName);
            ps.setString(3, e.surname);
            ps.setString(4, e.address);
            ps.setString(5,e.jobName);
            ps.setInt(6,e.salary);
            //execute query
            ps.executeUpdate();
            ps.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    //here method to update column
    /* I really don't know why, but when I try to make update console gives me error about that I add character
    varying input even if I enter integer(for "salary" row) */
    public static void updateEmployee(Employees e){
        Main m=new Main();
        m.getCon(); //connecting with database
        try{
            //make request
            PreparedStatement ps=m.con.prepareStatement("update Employees set employee_name=?, surname=?, address=?, job_name=?, salary=? where employee_id=?");
            //adding new values
            ps.setInt(1,e.getEmployeeId());
            ps.setString(2,e.getEmployeeName());
            ps.setString(3,e.getSurname());
            ps.setString(4, e.getAddress());
            ps.setString(5,e.getJobName());
            ps.setInt(6,e.getSalary());
            //execute query
            ps.executeUpdate();
            ps.close();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
    //method to delete employee by id
    public static void deleteEmployee(int employeeId){
        Main m=new Main();
        m.getCon(); //connecting with database
        try {
            //make request
            PreparedStatement ps = m.con.prepareStatement("delete from Employees where employee_id=?");
           //add value
            ps.setInt(1,employeeId);
            //execute query
            ps.executeUpdate();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
