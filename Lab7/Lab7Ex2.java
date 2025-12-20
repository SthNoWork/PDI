
//• Create an interface Printer.
// • Declare a method printDocument().
// • Implement it in InkjetPrinter and LaserPrinter.
import java.util.Arrays;

public class Lab7Ex2 {
    interface Printer {
        void printDocument();
    }

    public static class InkjetPrinter implements Printer {
        @Override
        public void printDocument() {
            System.err.println("WHERE INK");
        }
    }

    public static class LaserPrinter implements Printer {
        @Override
        public void printDocument() {
            System.err.println("WHERE LASER");
        }
    }

    public static void main(String[] args) {
        Printer[] printers = {
                new InkjetPrinter(),
                new LaserPrinter()
        };

        Arrays.stream(printers).forEach(x -> x.printDocument());
    }

}
