package Assigment5;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static Connection con;
    //method to get connection with database
    public static void getCon() {
        Statement statement = null;
        String connectionUrl = "jdbc:postgresql://localhost:5432/Assigment5";
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "gift111");
            System.out.println("Connected!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        getCon();
        Scanner scan =new Scanner(System.in);
        while (true){
            System.out.println("Please, choose");
            System.out.println("Company {1}");
            System.out.println("Job {2}");
            System.out.println("Employees {3}");
            System.out.println("Project {4}");
            int option= scan.nextInt();
            if(option==1){
                System.out.println("Here all information about company");
                Company c=new Company();
                c.companyInfo();
            }else if(option==2){
                System.out.println("Here list of positions in company");
                Job job=new Job();
                job.positionInfo();
            }else if(option==3){
                System.out.println("List of employees {1}");
                System.out.println("Add employee {2}");
                System.out.println("Update employee {3}");
                System.out.println("Delete employee {4}");
                int option1=scan.nextInt();
                if(option1==1){
                    Employees employees=new Employees();
                    employees.allEmployees();
                }else if(option1==2){
                    System.out.println("Enter id: ");
                    int id = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter name: ");
                    String name = scan.nextLine();
                    System.out.println("Enter surname: ");
                    String surname = scan.nextLine();
                    System.out.println("Enter address: ");
                    String address = scan.nextLine();
                    System.out.println("Enter salary: ");
                    int salary= scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter position: ");
                    String jobName= scan.nextLine();
                    Employees employees = new Employees(id, name, surname, address,jobName,salary);
                    System.out.println("Values was added...");
                    employees.addNew(employees);
                }else if(option1==3){
                    System.out.println("Enter id: ");
                    int id = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter name: ");
                    String name = scan.nextLine();
                    System.out.println("Enter surname: ");
                    String surname = scan.nextLine();
                    System.out.println("Enter new salary: ");
                    int salary= scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter new address: ");
                    String address = scan.nextLine();
                    System.out.println("Enter new position: ");
                    String jobName= scan.nextLine();
                    Employees employees = new Employees(id,name,surname,address,jobName,salary);
                    employees.updateEmployee(employees);
                    System.out.println("Updated successfully");
                }else if(option1==4){
                    System.out.println("Enter id for delete: ");
                    int employeeId= scan.nextInt();
                    Employees employees=new Employees();
                    employees.deleteEmployee(employeeId);
                    System.out.println("Deleted successfully");
                }
            }else if(option==4){
                System.out.println("About projects {1}");
                System.out.println("Add new project {2}");
                System.out.println("Delete project {3}");
                int option2=scan.nextInt();
                if(option2==1){
                    Project p=new Project();
                    p.projectInfo();
                }else if(option2==2){
                    System.out.println("Enter project id: ");
                    int projectId=scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter project description: ");
                    String description=scan.nextLine();
                    System.out.println("Enter bonus percent for salary(in percent): ");
                    String bonus=scan.nextLine();
                    System.out.println("Enter employee id: ");
                    int employeeId= scan.nextInt();
                    Project p=new Project(projectId,description,bonus,employeeId);
                    p.addNewP(p);
                    System.out.println("Values was added");
                }else if(option2==3){
                    System.out.println("Enter id of project: ");
                    Project p=new Project();
                    int projectId=scan.nextInt();
                    p.deleteProject(projectId);
                    System.out.println("Deleted successfully");
                }
            }
        }
    }
}






