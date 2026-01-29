/**
 * Template Method pattern (cat-themed)
 *
 * Case-study notes:
 * - Intent: Define the skeleton of an algorithm (daily routine) in a base class
 * while allowing subclasses to override specific steps.
 * - When to use: when you have a fixed sequence of steps but some steps vary
 * between implementations (e.g., HouseCat vs OutsideCat routines).
 * - Participants in this example:
 * - AbstractClass: `AnimalTemplate` (defines `dailyRoutine` template method)
 * - ConcreteClass: `HouseCatRoutine`, `OutsideCatRoutine` (provide step
 * implementations)
 *
 * The cat routines illustrate two different concrete behaviors while preserving
 * the same routine order.
 */
public abstract class AnimalTemplate {
    public final void dailyRoutine() {
        wakeUp();
        makeSound();
        eat();
        play();
        sleep();
    }

    protected abstract void wakeUp();

    protected abstract void makeSound();

    protected abstract void eat();

    protected abstract void play();

    protected void sleep() {
        System.out.println("Zzz...");
    }
}

// Two cat-themed routines to show variation
class HouseCatRoutine extends AnimalTemplate {
    protected void wakeUp() {
        System.out.println("House Cat wakes up");
    }

    protected void makeSound() {
        System.out.println("Meow (soft)");
    }

    protected void eat() {
        System.out.println("House Cat licks food from bowl");
    }

    protected void play() {
        System.out.println("House Cat bats a toy mouse");
    }
}

class OutsideCatRoutine extends AnimalTemplate {
    protected void wakeUp() {
        System.out.println("Outside Cat wakes up");
    }

    protected void makeSound() {
        System.out.println("Loud Meow (asking for food)");
    }

    protected void eat() {
        System.out.println("Outside Cat scavenges for food");
    }

    protected void play() {
        System.out.println("Outside Cat chases a rat");
    }
}

class AnimalTemplateDemo {
    public static void main(String[] args) {
        AnimalTemplate house = new HouseCatRoutine();
        AnimalTemplate outside = new OutsideCatRoutine();

        System.out.println("House Cat routine:");
        house.dailyRoutine();

        System.out.println("---");
        System.out.println("Outside Cat routine:");
        outside.dailyRoutine();
    }
}
