class Student {
    private String name;
    private int marks;
    private String email;

    public Student(String name, int marks, String email) {
        this.name = name;
        this.marks = marks;
        this.email = email;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

class GradeCalculator {
    private double score, total, grade;

    public GradeCalculator(double score, double total) {
        this.score = score;
        this.total = total;
        grade = Calculate();
    }

    private double Calculate() {
        return score * 100 / total;
    }

    public void getGrade() {
        System.out.println(grade);
    }
}

class StudentRepository {
    private String Url;
    private String username;
    private String fileName;

    public StudentRepository(String Url, String username, String fileName) {
        this.Url = Url;
        this.username = username;
        this.fileName = fileName;
    }

    public void saveFileToRepository() {
        System.out.println(username + " Saved " + fileName + " to " + Url);
    }

    public void deleteFileFromRepository() {
        System.out.println(username + " deleted " + fileName + " from " + Url);
    }
}

class EmailService {
    private String service;
    private String reciverEmail;
    private String location;

    public EmailService(String service, String reciverEmail, String location) {
        this.service = service;
        this.reciverEmail = reciverEmail;
        this.location = location;
    }

    public void sendEmail(Student student) {
        System.out.println(student.getEmail() + "is sending email to " + reciverEmail + " using " + service);
    }
    
    public void serviceLocation () {
        System.out.println("Service location: " + location);
    }
}

public class Lab8Ex1 {
    public static void main(String[] args) {
        Student student = new Student("Alice", 85, "alice@example.com");
        
        System.out.println("=".repeat(20));

        GradeCalculator gradeCalculator = new GradeCalculator(student.getMarks(), 100);
        System.out.print("Grade: ");
        gradeCalculator.getGrade();

        StudentRepository repository = new StudentRepository("Github.com/wsdq/PDI", "AliceUser", "AliceFile.txt");
        repository.saveFileToRepository();
        repository.deleteFileFromRepository();
        
        EmailService emailService = new EmailService("Gmail", "bob@example.com", "US Server");
        emailService.sendEmail(student);
        emailService.serviceLocation();

        System.out.println("=".repeat(20));
    }

}

