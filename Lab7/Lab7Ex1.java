//• Create an abstract class Animal.
// • Declare an abstract method makeSound() and getAnimalType().
// • Create subclasses like Dog, Cat, Chicken.
// • Each animal produces a different sound.
import java.util.*;
public class Lab7Ex1 {
    abstract static class Animal {
        abstract void makeSound ();
        abstract void getAnimalType();
    }
    public static class Dog extends Animal {

        @Override
        void makeSound() {
            System.out.println("wolf...");
        }
        @Override
        void getAnimalType() {
            System.out.println(this.getClass().getSimpleName());
        }
    }

    public static class Cat extends Animal {

        @Override
        void makeSound() {
            System.out.println("meow...");
        }
        @Override
        void getAnimalType() {
            System.out.println(this.getClass().getSimpleName());
        }
    }

    public static class Chicken extends Animal {

        @Override
        void makeSound() {
            System.out.println("bok...");
        }
        @Override
        void getAnimalType() {
            System.out.println(this.getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {
        Animal animals[] = {
            new Dog(),
            new Cat(),
            new Chicken()
        };
        Arrays.stream(animals).forEach(x->{
            x.makeSound();
            x.getAnimalType();
            System.out.println("---");
        });
    }
}
