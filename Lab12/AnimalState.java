/**
 * State pattern (cat-themed)
 *
 * Case-study notes:
 * - Intent: Allow an object (a cat) to alter its behavior when its internal
 * state
 * changes (Idle, Eating, Sleeping) without large conditional statements.
 * - When to use: modeling objects with distinct modes of behavior that change
 * at runtime.
 * - Participants in this example:
 * - Context: `AnimalContext` (holds current state)
 * - State interface: `AnimalStateBehavior`
 * - ConcreteStates: `IdleState`, `EatingState`, `SleepingState`
 *
 * The cat example demonstrates how calls like `performEat` or `performSound`
 * produce different outputs depending on the current state.
 *
 *
 * Simple cat State example: Idle -> Eating -> Sleeping
 */
public class AnimalState {
    public static void main(String[] args) {
        AnimalContext kitty = new AnimalContext(new IdleState());

        kitty.performSound(); // Meow
        kitty.performEat(); // starts eating (transitions to Eating)
        kitty.performSound(); // Purr
        kitty.performSleep(); // finishes and sleeps
        kitty.performSound(); // Soft snore
    }
}

class AnimalContext {
    private AnimalStateBehavior state;

    public AnimalContext(AnimalStateBehavior state) {
        this.state = state;
    }

    public void setState(AnimalStateBehavior s) {
        this.state = s;
    }

    public void performEat() {
        state.eat(this);
    }

    public void performSleep() {
        state.sleep(this);
    }

    public void performSound() {
        state.sound(this);
    }
}

interface AnimalStateBehavior {
    void eat(AnimalContext ctx);

    void sleep(AnimalContext ctx);

    void sound(AnimalContext ctx);
}

class IdleState implements AnimalStateBehavior {
    public void eat(AnimalContext ctx) {
        System.out.println("Kitty starts nibbling (idle->eating)");
        ctx.setState(new EatingState());
    }

    public void sleep(AnimalContext ctx) {
        System.out.println("Kitty curls up (idle->sleeping)");
        ctx.setState(new SleepingState());
    }

    public void sound(AnimalContext ctx) {
        System.out.println("Meow");
    }
}

class EatingState implements AnimalStateBehavior {
    public void eat(AnimalContext ctx) {
        System.out.println("Kitty is eating: crunch");
    }

    public void sleep(AnimalContext ctx) {
        System.out.println("Kitty finishes and dozes off");
        ctx.setState(new SleepingState());
    }

    public void sound(AnimalContext ctx) {
        System.out.println("Purr");
    }
}

class SleepingState implements AnimalStateBehavior {
    public void eat(AnimalContext ctx) {
        System.out.println("Kitty is asleep; won't eat now");
    }

    public void sleep(AnimalContext ctx) {
        System.out.println("Kitty snores softly");
    }

    public void sound(AnimalContext ctx) {
        System.out.println("Soft snore");
    }
}
