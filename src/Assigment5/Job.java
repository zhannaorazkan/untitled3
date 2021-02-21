package Assigment5;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Job extends Company{ //Here subclass Job for information about positions in company
    public String jobName;
    private int salary;
    private int companyId;

    public Job() { //default constructor
    }

    //constructor to initialize objects
    public Job(String jobName, int salary, int companyId) {
        this.jobName = jobName;
        this.salary = salary;
        this.companyId = companyId;
    }

    public Job(int companyId, String companyName, String foundationDate, String jobName, int salary, int companyId1) {
        super(companyId, companyName, foundationDate); //refers to superclass
        this.jobName = jobName;
        this.salary = salary;
        this.companyId = companyId1;
    }
    //getters and setters to refer to variables, also to work with private variables
    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    //new realization of companyId from "Company" superclass
    @Override
    public int getCompanyId() {
        return companyId;
    }

    @Override
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    //Here method to show all information about positions
    public static void positionInfo(){
        Main m =new Main();
        m.getCon(); //connecting with dbms
        try {
            //make request to database
            PreparedStatement preparedStatement=m.con.prepareStatement("select *from Job");
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                //get data from all columns
                String jobName=resultSet.getString("job_name");
                int salary=resultSet.getInt("salary");
                int companyId=resultSet.getInt("company_id");
                System.out.println("job_name" + ":"+jobName + ", " + "salary" + ":" + salary
                        + ", " + "company_id" +  ":" + companyId);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
