// Step 1: Create a thread class by extending Thread
class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    // Step 2: Override the run() method with the code the thread will execute
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " is running: " + i);
            try {
                Thread.sleep(200); // simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Step 3: Main class to start threads
public class lecture2 {
    public static void main(String[] args) {
        // Create threads
        MyThread thread1 = new MyThread("Thread 1");
        MyThread thread2 = new MyThread("Thread 2");

        // Start threads
        thread1.start();
        thread2.start();
    }
}
