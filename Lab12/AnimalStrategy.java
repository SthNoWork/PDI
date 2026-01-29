/**
 * Strategy pattern (cat-themed)
 *
 * Case-study notes:
 * - Intent: Define a family of algorithms (feeding behaviors) and make them
 * interchangeable at runtime.
 * - When to use: when the same task (feed) can be done in different ways
 * (kibble, fish, treats) and you want to swap behaviors without changing the
 * client.
 * - Participants in this example:
 * - Strategy: `FeedingStrategy` (interface)
 * - ConcreteStrategies: `KibbleFeeding`, `FishFeeding`, `TreatFeeding`
 * - Context: `Animal` (uses a `FeedingStrategy` to feed itself)
 *
 * The cat example shows named cats using different feeding strategies and
 * swapping them at runtime.
 */
public class AnimalStrategy {
    public static void main(String[] args) {
        Animal whiskers = new Animal("Whiskers", new KibbleFeeding());
        Animal mittens = new Animal("Mittens", new FishFeeding());
        Animal luna = new Animal("Luna", new TreatFeeding());

        whiskers.feed("dry kibble");
        mittens.feed("salmon");
        luna.feed("catnip treat");

        // Swap strategy at runtime (e.g., switching diet)
        System.out.println("-- Switching Whiskers to Fish diet --");
        whiskers.setFeedingStrategy(new FishFeeding());
        whiskers.feed("tuna");
    }
}

interface FeedingStrategy {
    void eat(String food);
}

class KibbleFeeding implements FeedingStrategy {
    public void eat(String food) {
        System.out.println("Eats kibble: " + food);
    }
}

class FishFeeding implements FeedingStrategy {
    public void eat(String food) {
        System.out.println("Eats fish: " + food);
    }
}

class TreatFeeding implements FeedingStrategy {
    public void eat(String food) {
        System.out.println("Enjoys treat: " + food);
    }
}

class Animal {
    private String name;
    private FeedingStrategy feedingStrategy;

    public Animal(String name, FeedingStrategy fs) {
        this.name = name;
        this.feedingStrategy = fs;
    }

    public void setFeedingStrategy(FeedingStrategy fs) {
        this.feedingStrategy = fs;
    }

    public void feed(String food) {
        System.out.print(name + " -> ");
        feedingStrategy.eat(food);
    }
}
