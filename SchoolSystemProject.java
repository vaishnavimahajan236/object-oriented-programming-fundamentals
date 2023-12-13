/*Part 1: Exploring the School System Project
Create a new Java project using IntelliJ Idea.
Create a Student class. This class must have the following attributes:
   public class Student {
       String firstName;
       String lastName;
       int registration;
       int grade;
       int year;
   }
Now, make the Student class implement the following methods:
   public void printFullName(){
      //TODO implement
   }

   public void isApproved(){
       //TODO implement: should return true if grade >= 60
   }

   public int changeYearIfApproved(){
       //TODO implement: the student should advance to the next year if he/she grade is >= 60
       // Make year = year + 1, and print "Congragulations" if the student has been approved
       return 0;
   }
Add constructors to your Student class:

Make the class with at least three different constructors.
Create a Java class for Courses

Your Course class must have, as attributes: courseName, professorName, year.
Your class must also contain a collection that lists all students enrolled in them.
Implement the following methods.
   public void enroll(Student student){
      //TODO add the student to the collection
   }

   public void unEnroll(Student student){
       //TODO remove this student from the collection
       // Hint: check if that really is this student
   }

   public int countStudents(){
       //TODO implement
       return 0;
   }
   
   public int bestGrade(){
       //TODO implement
       return 0;
   }
Run the main method and verify that your implementation works.

Method Overload:

Overload the enroll method to take in an array of students.
   public void enroll(Student[] students){
      //TODO add all the students to the collection
   }
Add on to the main method and call enroll with a list of students. Verify that your implementation works. */
package OOPS_Fundamentals;

import java.util.ArrayList;
import java.util.List;

class Student {
    String firstName;
    String lastName;
    int registration;
    int grade;
    int year;

    public Student(String firstName, String lastName, int registration, int grade, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registration = registration;
        this.grade = grade;
        this.year = year;
    }

    public Student(String firstName, String lastName, int registration) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registration = registration;
        this.grade = 0;
        this.year = 1;
    }

    public Student() {
        this.firstName = "";
        this.lastName = "";
        this.registration = 0;
        this.grade = 0;
        this.year = 1;
    }

    public void printFullName() {
        System.out.println(firstName + " " + lastName);
    }

    public boolean isApproved() {
        return grade >= 60;
    }

    public int changeYearIfApproved() {
        if (isApproved()) {
            year++;
            System.out.println("Congratulations, " + firstName + " " + lastName + ", you have been approved and moved to year " + year);
        }
        return year;
    }
}

class Course {
    String courseName;
    String professorName;
    int year;
    List<Student> students = new ArrayList<>();

    public Course(String courseName, String professorName, int year) {
        this.courseName = courseName;
        this.professorName = professorName;
        this.year = year;
    }

    public void enroll(Student student) {
        students.add(student);
    }

    public void enroll(Student[] students) {
        for (Student student : students) {
            enroll(student);
        }
    }

    public void unEnroll(Student student) {
        students.remove(student);
    }

    public int countStudents() {
        return students.size();
    }

    public int bestGrade() {
        int maxGrade = 0;
        for (Student student : students) {
            if (student.grade > maxGrade) {
                maxGrade = student.grade;
            }
        }
        return maxGrade;
    }
}

public class SchoolSystemProject {
    public static void main(String[] args) {
    	Student student1 = new Student("Kesav Kumar", "JayaKumar", 001, 88, 1);
        Student student2 = new Student("Vinoth", "Sanjay", 002, 80, 2);
        Student student3 = new Student("Vignesh", "Kumar", 003, 75, 3);
        Student student4 = new Student("Gokul", "Sridhar", 004, 55, 4);
        

        Course course = new Course("Java Full Stack Developer", "James", 2023);

        course.enroll(student1);
        course.enroll(student2);
        course.enroll(student3);
        course.unEnroll(student4);
        System.out.println(student4.firstName + " " + student4.lastName + ", removed from course.");
        
        
        student1.changeYearIfApproved();
        student2.changeYearIfApproved();
        student3.changeYearIfApproved();
        System.out.println("**************************************************************************************");
        

        System.out.println("Enrolled students in " + course.courseName + ":");
        System.out.println("**************************************************************************************");
        for (Student student : course.students) {
            student.printFullName();
        }
        System.out.println("**************************************************************************************");
        System.out.println("Total enrolled students: " + course.countStudents());
        System.out.println("Best grade in the course: " + course.bestGrade());

        Student[] newStudents = {new Student("Ravi", "Velu", 789), new Student("Gautham", "Menon", 901)};
        course.enroll(newStudents);
        
        System.out.println("**************************************************************************************");
        System.out.println("Updated enrolled students:");
        for (Student student : course.students) {
            student.printFullName();
        }
    }
}
