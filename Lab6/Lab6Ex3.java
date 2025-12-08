class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }
}

class Student extends Person {
    protected String student_id;

    public Student(String name, String student_id) {
        super(name);
        this.student_id = student_id;
    }
}

class OnlineStudent extends Student {
    protected String zoom_id;

    public OnlineStudent(String name, String student_id, String zoom_id) {
        super(name, student_id);
        this.zoom_id = zoom_id;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Student ID: " + student_id);
        System.out.println("Zoom ID: " + zoom_id);
    }
}

public class Lab6Ex3 {
    public static void main(String[] args) {
        OnlineStudent os = new OnlineStudent("Alice", "S12345", "ZOOM9988");

        os.displayInfo(); 
    }
}
