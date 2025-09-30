import java.util.ArrayList;
import java.util.Scanner;

class Student {
  private int studentId;
  private String studentName;
  private double studentCGPA;
  ArrayList<Course> courses = new ArrayList<>();

  public Student(ArrayList<Course> courses) {
    this.courses = courses;
  }

  public Student(int studentId, String studentName, double studentCGPA) {
    this.studentId = studentId;
    this.studentName = studentName;
    this.studentCGPA = studentCGPA;

  }

  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }


  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public double getStudentCGPA() {
    return studentCGPA;
  }

  public void setStudentCGPA(double studentCGPA) {
    this.studentCGPA = studentCGPA;
  }

  public ArrayList<Course> getCourses() {
    return courses;
  }
  
  public void setCourses(ArrayList<Course> courses) {
    this.courses = courses;
  }

  public void addCourse(Course course) {
    courses.add(course);
  }
  public void removeCourse(Course course) {
    courses.remove(course);
}


  public String display() {
    return "Student ID: " + studentId + ", Name: " + studentName + ", CGPA: " + studentCGPA;
  }
  // Student taken by course list
  public void displayCourse() {
    System.out.println("Name : " + getStudentName());
    System.out.println("ID : " + getStudentId());
    System.out.println("CGPA : " + getStudentCGPA());

    System.out.print("Course List  - ");
    if (courses.isEmpty()) {
        System.out.println("No courses taken by this student.");
    } else {
        for (Course course : courses) {
            System.out.print(course.getCourseTitle() + " ");
        }
        System.out.println();
    }
}


}

class Course {
  private String courseId;
  private String courseTitle;
  private double credit;
  ArrayList<Student> students = new ArrayList<>();
  

  // Constructor for Course class
  public Course(String courseId, String courseTitle, double credit) {
    this.courseId = courseId;
    this.courseTitle = courseTitle;
    this.credit = credit;
  }

  public ArrayList<Student> getStudents() {
    return students;
  }

  public void setStudents(ArrayList<Student> students) {
    this.students = students;
  }

  public String getCourseId() {
    return courseId;
  }

  public void setCourseId(String courseId) {
    this.courseId = courseId;
  }

  public String getCourseTitle() {
    return courseTitle;
  }

  public void setCourseTitle(String courseTitle) {
    this.courseTitle = courseTitle;
  }

  public double getCredit() {
    return credit;
  }

  public void setCredit(double credit) {
    this.credit = credit;
  }

  public void addStudent(Student student) {
    students.add(student); // c1.addStudent(s1);
  }
  public void removeStudent(Student student) {
    students.remove(student);
}


  public String display() {
    return "Course ID: " + courseId + ", Title: " + courseTitle + ", Credit: " + credit;
  }

  // Course taken by student list
  public void displayStudent() {
    System.out.println("Title : " + getCourseTitle());
    System.out.println("ID : " + getCourseId());
    System.out.println("Credit : " + getCredit());

    System.out.print("Student List (IDs) - ");
    for (Student student : students) {
      System.out.print(student.getStudentId() + " ");
    }
    System.out.println();

  }

}

class Faculty {
  private int facultyId;
  private String facultyName;
  private String facultyPosition;
  ArrayList<Course> courses;

  public Faculty(ArrayList<Course> courses) {
    this.courses = courses;
  }

  public Faculty(int facultyId, String facultyName, String facultyPosition) {
    this.facultyId = facultyId;
    this.facultyName = facultyName;
    this.facultyPosition = facultyPosition;
   
  }

  public int getFacultyId() {
    return facultyId;
  }

  public void setFacultyId(int facultyId) {
    this.facultyId = facultyId;
  }

  public String getFacultyName() {
    return facultyName;
  }

  public void setFacultyName(String facultyName) {
    this.facultyName = facultyName;
  }

  public String getFacultyPosition() {
    return facultyPosition;
  }

  public void setFacultyPosition(String facultyPosition) {
    this.facultyPosition = facultyPosition;
  }

  public ArrayList<Course> getCourses() {
    return courses;
  }

  public void setCourses(ArrayList<Course> courses) {
    this.courses = courses;
  }

  public void addCourse(Course course) {
    courses.add(course);// f1.addCourse(c1);
  }
  public String display() {
    return "Faculty ID: " + facultyId + ", Name: " + facultyName + ", Position: " + facultyPosition;
}


}

public class UniversityManagementSystem {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Course> courses = new ArrayList<>();
    ArrayList<Faculty> faculties = new ArrayList<>();

    // Sample Data
    students.add(new Student(101, "Alice", 3.8));
    students.add(new Student(102, "Ros", 2.90));
    Student s1 = new Student(103, "Jimmy", 3.5);
    Student s2 = new Student(104, "kuddus", 3.5);
    students.add(s1);
    students.add(s2);

    courses.add(new Course("CSE101", "Introduction to Computer Science", 3.0));
    courses.add(new Course("ENG101", "Basic English", 3.0));
    Course c1 = new Course("PHY109", "Physics", 3.0);
    Course c2 = new Course("CHE109", "CHemistry", 3.0);


    faculties.add(new Faculty(101, "Alamgir Khan","Lecturer" ));
    faculties.add(new Faculty(102, "Nushrah Morshed"," Professor" ));
    faculties.add(new Faculty(103, "Usama Bin Ahad","Assistant Lecturer" ));

    courses.add(c1);
    courses.add(c2);
    
    c1.addStudent(s1);
    c1.addStudent(s2);
    c2.addStudent(s2);
    s1.addCourse(c2);
    s1.addCourse(c1);
    
    s1.displayCourse();
    c1.displayStudent();

    // Menu
    while (true) {
      System.out.println("\nMenu Options:");
      System.out.println("1. Add");
      System.out.println("2. Delete");
      System.out.println("3. Update");
      System.out.println("4. Print");
      System.out.println("5. Search");
      System.out.println("6. Exit");
      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();
      scanner.nextLine(); // Consume newline

      switch (choice) {
        case 1:
          addMenu(scanner, students, courses, faculties);
          break;
        case 2:
          deleteMenu(scanner, students, courses, faculties);
          break;
        case 3:
          updateMenu(scanner, students, courses, faculties);
          break;
        case 4:
          printMenu(scanner, students, courses, faculties);

          break;
        case 5:
          searchMenu(scanner, students, courses, faculties);
          break;
        case 6:
          System.out.println("Exiting...");
          System.exit(0);
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }

  // ADD MENU...........

  private static void addMenu(Scanner scanner, ArrayList<Student> students, ArrayList<Course> courses, ArrayList<Faculty> faculties) {
    System.out.println("\nAdd Options:");
    System.out.println("a. Add a Student");
    System.out.println("b. Add a Course");
    System.out.println("c. Add a Faculty");
    System.out.println("d. Add a Student to a Course");
    System.out.println("e. Add a Course to a Student");
    System.out.print("Enter your choice: ");
    String addChoice = scanner.nextLine();

    if (addChoice.equals("a")) {
        addStudent(scanner, students);
    } else if (addChoice.equals("b")) {
        addCourse(scanner, courses);
    } else if (addChoice.equals("c")) {
        addFaculty(scanner, faculties);
    } else if (addChoice.equals("d")) {
        addStudentToCourse(scanner, students, courses);
    } else if (addChoice.equals("e")) {
        addCourseToStudent(scanner, students, courses);
    } else {
        System.out.println("Invalid choice. Please try again.");
    }
}

  private static void addStudent(Scanner scanner, ArrayList<Student> students) {
    // Input student details
    System.out.print("Enter student ID: ");
    int studentId = scanner.nextInt();
    scanner.nextLine(); 
    System.out.print("Enter student name: ");
    String studentName = scanner.nextLine();
    System.out.print("Enter student CGPA: ");
    double studentCGPA = scanner.nextDouble();
    scanner.nextLine(); 

    // Create a new student object with input details
    Student newStudent = new Student(studentId, studentName, studentCGPA);
    
   
    students.add(newStudent);
    System.out.println("Student added successfully.");
}
private static void addStudentToCourse(Scanner scanner, ArrayList<Student> students, ArrayList<Course> courses) {
  // Display available students
  System.out.println("Available students:");
  for (int i = 0; i < students.size(); i++) {
      System.out.println((i + 1) + ". " + students.get(i).getStudentName());
  }
  System.out.print("Select a student by entering its number: ");
  int studentIndex = scanner.nextInt();
  scanner.nextLine(); 

  // Display available courses
  System.out.println("Available courses:");
  for (int i = 0; i < courses.size(); i++) {
      System.out.println((i + 1) + ". " + courses.get(i).getCourseTitle());
  }
  System.out.print("Select a course by entering its number: ");
  int courseIndex = scanner.nextInt();
  scanner.nextLine(); 


  if (studentIndex >= 1 && studentIndex <= students.size() && courseIndex >= 1 && courseIndex <= courses.size()) {
    Student selectedStudent = students.get(studentIndex - 1);
    Course selectedCourse = courses.get(courseIndex - 1);
    selectedCourse.addStudent(selectedStudent);
    selectedStudent.addCourse(selectedCourse);
    System.out.println("Student added to course successfully.");
} else {
    System.out.println("Invalid student or course selection.");
}
}


  private static void addCourse(Scanner scanner, ArrayList<Course> courses) {
    System.out.print("Enter course ID: ");
    String courseId = scanner.nextLine();
    System.out.print("Enter course title: ");
    String courseTitle = scanner.nextLine();
    System.out.print("Enter course credit: ");
    double credit = scanner.nextDouble();
    scanner.nextLine(); // Consume newline
   courses.add(new Course(courseId, courseTitle, credit));
   System.out.println(courseId+ " Course added successfully.");
  }


  
  private static void addCourseToStudent(Scanner scanner, ArrayList<Student> students, ArrayList<Course> courses) {
    // Display available courses
    System.out.println("Available courses:");
    for (int i = 0; i < courses.size(); i++) {
        System.out.println((i + 1) + ". " + courses.get(i).getCourseTitle());
    }
    System.out.print("Select a course by entering its number: ");
    int courseIndex = scanner.nextInt();
    scanner.nextLine(); 

    // Display available students
    System.out.println("Available students:");
    for (int i = 0; i < students.size(); i++) {
        System.out.println((i + 1) + ". " + students.get(i).getStudentName());
    }
    System.out.print("Select a student by entering its number: ");
    int studentIndex = scanner.nextInt();
    scanner.nextLine(); 

    // Add course to student
    if (courseIndex >= 1 && courseIndex <= courses.size() && studentIndex >= 1 && studentIndex <= students.size()) {
        Course selectedCourse = courses.get(courseIndex - 1);
        Student selectedStudent = students.get(studentIndex - 1);


        selectedStudent.addCourse(selectedCourse);
        selectedCourse.addStudent(selectedStudent);
        System.out.println("Course added to student successfully.");
    } else {
        System.out.println("Invalid course or student selection.");
    }
}

  private static void addFaculty(Scanner scanner, ArrayList<Faculty> faculties) {
    System.out.print("Enter faculty ID: ");
    int facultyId = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Enter faculty name: ");
    String facultyName = scanner.nextLine();
    System.out.print("Enter faculty position: ");
    String facultyPosition = scanner.nextLine();

    faculties.add(new Faculty(facultyId, facultyName, facultyPosition));
    
    System.out.println("Faculty added successfully.");
  }
  // END OF ADD MENU.........

  // START OF DELETE MENU.......

  private static void deleteMenu(Scanner scanner, ArrayList<Student> students, ArrayList<Course> courses,
      ArrayList<Faculty> faculties) {
    System.out.println("\nDelete Options:");
    System.out.println("a. Delete a Student");
    System.out.println("b. Delete a Course");
    System.out.println("c. Delete a Faculty");
    System.out.print("Enter your choice: ");
    String deleteChoice = scanner.nextLine();

    switch (deleteChoice) {
      case "a":
        deleteStudent(scanner, students);
        break;
      case "b":
        deleteCourse(scanner, courses);
        break;
      case "c":
        deleteFaculty(scanner, faculties);
        break;
      default:
        System.out.println("Invalid choice. Please try again.");
    }
  }

  private static void deleteStudent(Scanner scanner, ArrayList<Student> students) {
    System.out.print("Enter student ID to delete: ");
    int idToDelete = scanner.nextInt();
    scanner.nextLine(); 

    for (int i = 0; i < students.size(); i++) {
      if (idToDelete == students.get(i).getStudentId()) {
        students.remove(i); // Remove 
        System.out.println("Student deleted successfully.");
        return; // Exit 
      }
    }
    
    System.out.println("Student with ID " + idToDelete + " not found.");
  }

  private static void deleteCourse(Scanner scanner, ArrayList<Course> courses) {
    System.out.print("Enter course ID to delete: ");
    String idToDelete = scanner.nextLine();

    for (int i = 0; i < courses.size(); i++) {
      if (idToDelete.equals(courses.get(i).getCourseId())) {
        courses.remove(i); // Remove the course from the ArrayList
        System.out.println("Course deleted successfully.");
        return; // Exit the method after deleting the course
      }
    }
    
    System.out.println("Course with ID " + idToDelete + " not found.");
  }

  private static void deleteFaculty(Scanner scanner, ArrayList<Faculty> faculties) {
    System.out.print("Enter faculty ID to delete: ");
    int idToDelete = scanner.nextInt();
    scanner.nextLine(); 

    for (int i = 0; i < faculties.size(); i++) {
      if (idToDelete == faculties.get(i).getFacultyId()) {
        faculties.remove(i); // Remove 
        System.out.println("Faculty deleted successfully.");
        return; // Exit the method after deleting the faculty
      }
    }
    // If the loop completes without finding the faculty
    System.out.println("Faculty with ID " + idToDelete + " not found.");
  }

  // END OF Delete MENU........

  // START OF UPdate menu
  private static void updateMenu(Scanner scanner, ArrayList<Student> students, ArrayList<Course> courses, ArrayList<Faculty> faculties) {
    System.out.println("\nUpdate Options:");
    System.out.println("a. Change student CGPA");
    System.out.println("b. Remove course association for a student");
    System.out.print("Enter your choice: ");
    String updateChoice = scanner.nextLine();

    if (updateChoice.equals("a")) {
        changeStudentCGPA(scanner, students);
    } else if (updateChoice.equals("b")) {
        removeCourseAssociation(scanner, students, courses);
    } else {
        System.out.println("Invalid choice. Please try again.");
    }
}

private static void changeStudentCGPA(Scanner scanner, ArrayList<Student> students) {
    // Prompt for student ID
    System.out.print("Enter student ID: ");
    int studentId = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    // Search for the student
    for (Student student : students) {
        if (student.getStudentId() == studentId) {
            // Prompt for new CGPA
            System.out.print("Enter new CGPA for " + student.getStudentName() + ": ");
            double newCGPA = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            // Update student's CGPA
            student.setStudentCGPA(newCGPA);
            System.out.println("CGPA updated successfully for " + student.getStudentName() + ".");
            return;
        }
    }

    // If student with given ID is not found
    System.out.println("Student not found.");
}

private static void removeCourseAssociation(Scanner scanner, ArrayList<Student> students, ArrayList<Course> courses) {
  // Prompt for student ID
  System.out.print("Enter student ID: ");
  int studentId = scanner.nextInt();
  scanner.nextLine(); // Consume newline

  // Search for the student
  for (Student student : students) {
      if (student.getStudentId() == studentId) {
          // Prompt for course ID
          System.out.println("Courses associated with " + student.getStudentName() + ":");
          student.displayCourse();
          System.out.print("Enter course ID to remove association: ");
          String courseId = scanner.nextLine();

          // Search for the course in student's courses
          for (Course course : student.getCourses()) {
              if (course.getCourseId().equals(courseId)) {
                  // Remove course association
                  student.removeCourse(course); // Issue occurs here
                  course.removeStudent(student);
                  System.out.println("Association with course " + courseId + " removed successfully.");
                  return;
              }
          }
          
          System.out.println("Course association not found for student " + student.getStudentName() + ".");
          return;
      }
  }
  // not found
  System.out.println("Student not found.");
}


  // START OF PRINT MENU.......

  private static void printMenu(Scanner scanner, ArrayList<Student> students, ArrayList<Course> courses,
      ArrayList<Faculty> faculties) {
    System.out.println("\nPrint Options:");
    System.out.println("a. Print all students");
    System.out.println("b. Print all courses");
    System.out.println("c. Print all faculties");
    System.out.println("d. Print information of a student");
    System.out.println("e. Print information of a course");
    System.out.println("f. Print information of a faculty");
    System.out.println("g. Print student list and faculty information of a course");
    System.out.println("h. Print courses taken by a student");
    System.out.print("Enter your choice: ");
    String printChoice = scanner.nextLine();

    switch (printChoice) {
      case "a":
        printAllStudents(students);
        break;
      case "b":
        printAllCourses(courses);
        break;
      case "c":
        printAllFaculties(faculties);
        break;
      case "d":
        printStudentInfo(scanner, students);
        break;
      case "e":
        printCourseInfo(scanner, courses);
        break;
      case "f":
        printFacultyInfo(scanner, faculties);
        break;
      case "g":
        printCourseStudentInfo(scanner, courses);
        break;
      case "h":
        printStudentCourses(scanner, students);
        break;
      default:
        System.out.println("Invalid choice. Please try again.");
    }
  }

  private static void printAllStudents(ArrayList<Student> students) {

    System.out.println("\nAll Students:");
    for (Student student : students) {
      System.out.println(student.display());
    }
  }

  private static void printAllCourses(ArrayList<Course> courses) {
    System.out.println("\nAll Courses:");
    for (Course course : courses) {
      System.out.println(course.display());
    }
  }

  private static void printAllFaculties(ArrayList<Faculty> faculties) {
    System.out.println("\nAll Faculties:");
    for (Faculty faculty : faculties) {
      System.out.println(faculty.display());
    }
  }

  private static void printStudentInfo(Scanner scanner, ArrayList<Student> students) {
    System.out.print("Enter student ID: ");
    int studentId = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    boolean found = false;
    for (Student student : students) {
      if (student.getStudentId() == studentId) {
        System.out.println("Student Information:");
        System.out.println(student.display());
        found = true;
        break;
      }
    }
    if (!found) {
      System.out.println("Student not found.");
    }
  }

  private static void printCourseInfo(Scanner scanner, ArrayList<Course> courses) {
    System.out.print("Enter course ID: ");
    String courseId = scanner.nextLine();

    boolean found = false;
    for (Course course : courses) {
      if (course.getCourseId().equals(courseId)) {
        System.out.println("Course Information:");
        System.out.println(course.display());
        found = true;
        break;
      }
    }
    if (!found) {
      System.out.println("Course not found.");
    }
  }

  private static void printFacultyInfo(Scanner scanner, ArrayList<Faculty> faculties) {
    System.out.print("Enter faculty ID: ");
    int facultyId = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    boolean found = false;
    for (Faculty faculty : faculties) {
      if (faculty.getFacultyId() == facultyId) {
        System.out.println("Faculty Information:");
        System.out.println(faculty.display());
        found = true;
        break;
      }
    }
    if (!found) {
      System.out.println("Faculty not found.");
    }
  }

  private static void printCourseStudentInfo(Scanner scanner, ArrayList<Course> courses) {
    System.out.print("Enter course ID: ");
    String courseId = scanner.nextLine();

    boolean found = false;
    for (Course course : courses) {
      if (course.getCourseId().equals(courseId)) {
        System.out.println("Course Information:");
        System.out.println(course.display());
        found = true;
        break;
      }
    }
    if (!found) {
      System.out.println("Course not found.");
    }
  }

  private static void printStudentCourses(Scanner scanner, ArrayList<Student> students) {
    System.out.print("Enter student ID: ");
    int studentId = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    boolean found = false;
    for (Student student : students) {
        if (student.getStudentId() == studentId) {
            System.out.println("Courses taken by Student:");
            if (student.getCourses().isEmpty()) {
                System.out.println("No courses taken by this student.");
            } else {
                for (Course course : student.getCourses()) {
                    System.out.println(course.display());
                }
            }
            found = true;
            break;
        }
    }
    if (!found) {
        System.out.println("Student not found.");
    }
}


  // END OF PRINT MENU.......
  // START OF SEARCH MENU.....
  private static void searchMenu(Scanner scanner, ArrayList<Student> students, ArrayList<Course> courses,
      ArrayList<Faculty> faculties) {
    System.out.println("\nSearch Options:");
    System.out.println("a. Search a Student");
    System.out.println("b. Search a Course");
    System.out.println("c. Search a Faculty");
    System.out.println("d. Search whether a student takes a course");
    System.out.println("e. Search whether a faculty teaches a course");
    System.out.println("f. Search courses taken by a student");
    System.out.println("g. Search courses taught by a faculty");
    System.out.print("Enter your choice: ");
    String searchChoice = scanner.nextLine();

    switch (searchChoice) {
      case "a":
        searchStudent(scanner, students);
        break;
      case "b":
        searchCourse(scanner, courses);
        break;
      case "c":
        searchFaculty(scanner, faculties);
        break;
      case "d":
        searchStudentCourse(scanner, students, courses);
        break;
      case "e":
        searchFacultyCourse(scanner, faculties, courses);
        break;
      case "f":
        searchStudentCourses(scanner, students, courses);
        break;
      case "g":
        searchFacultyCourses(scanner, faculties, courses);
        break;
      default:
        System.out.println("Invalid choice. Please try again.");
    }
  }

  private static void searchStudent(Scanner scanner, ArrayList<Student> students) {
    System.out.print("Enter student ID or name to search: ");
    String searchTerm = scanner.nextLine();

    // Search by student ID
    for (Student student : students) {
      if (String.valueOf(student.getStudentId()).equals(searchTerm)) {
        System.out.println("Student found:");
        System.out.println(student.display());
        return;
      }
    }

    // Search by student name
    for (Student student : students) {
      if (student.getStudentName().equalsIgnoreCase(searchTerm)) {
        System.out.println("Student found:");
        System.out.println(student.display());
        return;
      }
    }
    System.out.println("Student not found.");
  }

  private static void searchCourse(Scanner scanner, ArrayList<Course> courses) {
    System.out.print("Enter course ID or title to search: ");
    String searchTerm = scanner.nextLine();

    // Search by course ID
    for (Course course : courses) {
      if (course.getCourseId().equalsIgnoreCase(searchTerm)) {
        System.out.println("Course found:");
        System.out.println(course.display());
        return;
      }
    }
    // Search by course title
    for (Course course : courses) {
      if (course.getCourseTitle().equalsIgnoreCase(searchTerm)) {
        System.out.println("Course found:");
        System.out.println(course.display());
        return;
      }
    }
    System.out.println("Course not found.");
  }

  private static void searchFaculty(Scanner scanner, ArrayList<Faculty> faculties) {
    System.out.print("Enter faculty ID or name to search: ");
    String searchTerm = scanner.nextLine();

    // Search by faculty ID
    for (Faculty faculty : faculties) {
      if (String.valueOf(faculty.getFacultyId()).equals(searchTerm)) {
        System.out.println("Faculty found:");
        System.out.println(faculty.display());
        return;
      }
    }

    // Search by faculty name
    for (Faculty faculty : faculties) {
      if (faculty.getFacultyName().equalsIgnoreCase(searchTerm)) {
        System.out.println("Faculty found:");
        System.out.println(faculty.display());
        return;
      }
    }
    System.out.println("Faculty not found.");
  }

  private static void searchStudentCourse(Scanner scanner, ArrayList<Student> students, ArrayList<Course> courses) {
    System.out.print("Enter student ID: ");
    int studentId = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    // Search for the student
    Student student = findStudentById(studentId, students);
    if (student != null) {
      System.out.println("Student found:");
      System.out.println(student.display());
      System.out.println("Courses taken by the student:");
      for (Course course : courses) {
        if (course.getStudentList().contains(student)) {
          System.out.println(course.display());
        }
      }
    } else {
      System.out.println("Student not found.");
    }
  }

  private static void searchFacultyCourse(Scanner scanner, ArrayList<Faculty> faculties, ArrayList<Course> courses) {
    System.out.print("Enter faculty ID: ");
    int facultyId = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    // Search for the faculty
    Faculty faculty = findFacultyById(facultyId, faculties);
    if (faculty != null) {
      System.out.println("Faculty found:");
      System.out.println(faculty.display());
      System.out.println("Courses taught by the faculty:");
      for (Course course : courses) {
        if (course.getFaculty().equals(faculty)) {
          System.out.println(course.display());
        }
      }
    } else {
      System.out.println("Faculty not found.");
    }
  }

  private static void searchStudentCourses(Scanner scanner, ArrayList<Student> students, ArrayList<Course> courses) {
    System.out.print("Enter student ID: ");
    int studentId = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    boolean found = false;
    for (Student student : students) {
      if (student.getStudentId() == studentId) {
        found = true;
        System.out.println("Student found:");
        System.out.println(student.display());
        System.out.println("Courses taken by the student:");
        if (student.getCourses().isEmpty()) {
          System.out.println("No courses found for this student.");
        } else {
          for (Course course : student.getCourses()) {
            System.out.println(course.display());
          }
        }
        break;
      }
    }
    if (!found) {
      System.out.println("Student not found.");
    }
  }

  private static void searchFacultyCourses(Scanner scanner, ArrayList<Faculty> faculties, ArrayList<Course> courses) {
    System.out.print("Enter faculty ID: ");
    int facultyId = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    
    boolean found = false;
    for (Faculty faculty : faculties) {
      if (faculty.getFacultyId() == facultyId) {
        found = true;
        System.out.println("Faculty found:");
        System.out.println(faculty.display());
        System.out.println("Courses taught by the faculty:");
        boolean coursesFound = false;
        for (Course course : courses) {
          if (course.getFaculty().equals(faculty)) {
            coursesFound = true;
            System.out.println(course.display());
          }
        }
        if (!coursesFound) {
          System.out.println("No courses found for this faculty.");
        }
        break;
      }
    }
    if (!found) {
      System.out.println("Faculty not found.");
    }
  }

}
