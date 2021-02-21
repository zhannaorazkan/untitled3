package Assigment5;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
/*Here superclass Company that includes basic information about company*/
public class Company {
    public int companyId; //Make it public to give access to the subclasses
    public String companyName;
    public String foundationDate;

    public Company() { //default empty constructor
    }
/*create constructors  to initialize objects*/
    public Company(int companyId, String companyName, String foundationDate) {
        this.companyId = companyId; //"this" to the class
        this.companyName = companyName;
        this.foundationDate = foundationDate;
    }

/*create getters and setters to refer to variables */
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(String foundationDate) {
        this.foundationDate = foundationDate;
    }
/*Here method to show all data from sql table*/
    public static void companyInfo(){ //especially here data from "Company" table
        Main m =new Main();
        m.getCon();
        try {
            //make request to database
            PreparedStatement preparedStatement=m.con.prepareStatement("select *from Company");
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                //get data from all columns
                int companyId=resultSet.getInt("company_id");
                String companyName=resultSet.getString("company_name");
                String foundationDate=resultSet.getString("foundation_date");
                System.out.println("companyId" + ":"+companyId + ", " + "companyName" + ":" + companyName
                        + ", " + "foundationDate" +  ":" + foundationDate);
                preparedStatement.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
