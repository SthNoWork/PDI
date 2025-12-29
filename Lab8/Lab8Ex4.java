interface CallDevice {
    void call();
}

interface SMSDevice {
    void sendSMS();
}

interface InternetDevice {
    void browseInternet();
}

interface CameraDevice {
    void takePhoto();
}

class BasicPhone implements CallDevice, SMSDevice, CameraDevice {
    public int battery;
    public int service;
    public final String version = "Nokia";

    public BasicPhone(int battery, int service) {
        this.battery = battery;
        this.service = service;
    }

    public void call() {
        System.out.println("Barely calling...");
    }

    public void sendSMS() {
        System.out.println("Sending pigeon mail...");
    }

    public void takePhoto() {
        System.out.println("Taking a low quality photo...");
    }
}

class SmartPhone implements CallDevice, SMSDevice, CameraDevice, InternetDevice {
    public int battery;
    public int service;
    public final String version = "Red Magic";

    public SmartPhone(int battery, int service) {
        this.battery = battery;
        this.service = service;
    }

    public void call() {
        System.out.println("Calling...");
    }

    public void sendSMS() {
        System.out.println("Sending SMS...");
    }

    public void takePhoto() {
        System.out.println("Taking Photo...");
    }

    public void browseInternet() {
        if (service > 50) {
            System.out.println("Searching on google...");
        } else {
            System.out.println("Slowly searching on google...");
        }
    }
}

public class Lab8Ex4 {
    public static void main(String[] args) {
        BasicPhone basicPhone = new BasicPhone(100, 100);
        SmartPhone smartPhone = new SmartPhone(90, 50);

        basicPhone.call();
        smartPhone.call();
        basicPhone.sendSMS();
        smartPhone.sendSMS();
        basicPhone.takePhoto();
        smartPhone.takePhoto();

        smartPhone.browseInternet();

    }
}