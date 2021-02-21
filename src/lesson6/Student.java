package lesson6;

public class Student {
    public int id;
    public String name;
    public String surname;
    public int grades;

    public Student() {
    }

    public Student(int id, String name, String surname, int grades) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.grades = grades;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getGrades() {
        return grades;
    }

    public void setGrades(int grades) {
        this.grades = grades;
    }

}
