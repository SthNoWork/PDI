/**
 * Adapter pattern (cat-themed)
 *
 * Case-study notes:
 * - Intent: Convert the interface of a class (here `OldCat`) into another
 * interface
 * (`Pet`) clients expect without modifying the original class.
 * - When to use: integrating legacy or third-party code with your own
 * interfaces.
 * - Participants in this example:
 * - Target: `Pet` (the interface we want to use)
 * - Adaptee: `OldCat` (legacy class we can't change)
 * - Adapter: `OldPetAdapter` (wraps `OldCat` and implements `Pet`)
 *
 * This demo shows adapting an old cat API to a simple `Pet` interface.
 */
public class AnimalAdapter {
    public static void main(String[] args) {
        OldCat old = new OldCat();
        Pet pet = new OldPetAdapter(old);

        // Client code uses the `Pet` interface and is unaware of `OldCat` internals
        pet.sound();
        pet.eat("kibble");
    }
}

// Desired interface
interface Pet {
    void sound();
    void eat(String food);
}

// Legacy class we cannot change - represents an old cat API
class OldCat {
    void meow() {
        System.out.println("OldCat: meow-meow (old style)");
    }

    void nibble(String food) {
        System.out.println("OldCat nibbles: " + food);
    }
}

// Adapter translates Pet calls to OldCat methods
class OldPetAdapter implements Pet {
    private OldCat oldCat;

    public OldPetAdapter(OldCat oldCat) {
        this.oldCat = oldCat;
    }

    public void sound() {
        oldCat.meow();
    }

    public void eat(String food) {
        oldCat.nibble(food);
    }
}


