package Assigment5;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Project extends Employees{ //class for project
    public int projectId;
    private String description;
    private String bonus;
    private int employeeId;

    public Project() { //default constructor
    }

    //constructor to initialize variables
    public Project(int projectId,String description, String bonus, int employeeId) {
        this.projectId = projectId;
        this.description=description;
        this.bonus = bonus;
        this.employeeId = employeeId;
    }

    //constructor that refer to superclass
    public Project(int employeeId, String employeeName, String surname, String address, String jobName, int salary, int projectId, String description,String bonus, int employeeId1) {
        super(employeeId, employeeName, surname, address, jobName, salary);
        this.projectId = projectId;
        this.description=description;
        this.bonus = bonus;
        this.employeeId = employeeId1;
    }

    //getters and setters to work with private variables and that refer to variables
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    @Override
    public int getEmployeeId() {
        return employeeId;
    }

    @Override
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    //method to get all data from column
    public static void projectInfo(){
        Main m =new Main();
        m.getCon(); //connecting with database
        try{
            //make request
            PreparedStatement ps=m.con.prepareStatement("select*from Project");
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                //get all data
                int projectId=rs.getInt("project_id");
                String description=rs.getString("description");
                String bonus=rs.getString("bonus");
                int employeeId=rs.getInt("employee_id");
                System.out.println("project_id"+":"+projectId+", "+"description"+":"+description
                +", "+"bonusPercentForSalary"+":"+bonus+", "+"employeeId"+":"+employeeId);
            }
            ps.close();
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //method to add new project
    public static void addNewP(Project project){
        Main m =new Main();
        m.getCon(); //connecting with database
        try {
            //make request
            PreparedStatement ps=m.con.prepareStatement("insert into Project(project_id,description,bonus,employee_id)" +
                    "values(?,?,?,?)");
            //add values
            ps.setInt(1,project.projectId);
            ps.setString(2,project.description);
            ps.setString(3,project.bonus);
            ps.setInt(4,project.employeeId);
            ps.executeUpdate();
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //method to delete projects by id
    public static void deleteProject(int projectId){
        Main m =new Main();
        m.getCon(); //get connection
        try{
            PreparedStatement ps=m.con.prepareStatement("delete from Project where project_id=?");
            ps.setInt(1,projectId);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
