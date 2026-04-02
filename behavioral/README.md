# Observer Pattern

## Theory

The **Observer** is a behavioral design pattern in which one object, called the **subject**, keeps a list of dependent objects, called **observers**, and automatically notifies them whenever its state changes.

This pattern is useful when:
- one object changes its state,
- many other objects need to react to that change,
- and we want to avoid tight coupling between them.

Instead of hardcoding all reactions inside the subject, the subject only knows that it has observers to notify. It does not need to know the details of what each observer does.

## Main roles

- **Subject / Observable**  
  Stores state and notifies observers when something changes.

- **Observer**  
  Defines a common interface for objects that want to react to updates.

- **Concrete Observers**  
  Implement the observer interface and define specific reactions.

---

## Bad Example

In the bad example, the `Game` class directly depends on concrete classes:


class Game(
    private val scoreAnnouncer: ScoreAnnouncer,
    private val leadingTeamAnnouncer: LeadingTeamAnnouncer
)

## Why it is bad

This creates tight coupling between `Game` and specific announcer classes.

### Problems with this approach

- `Game` knows exactly which classes should react to score changes.
- If we want to add another reaction, for example a logger or UI updater, we must modify the `Game` class.
- The code becomes less flexible and harder to extend.
- It does not fully follow the Observer pattern, because there is no common observer abstraction and no observer list.

In this version, `Game` is responsible not only for managing the score, but also for directly calling specific reaction classes. That makes the design less reusable and less maintainable.

### Conclusion

This is a bad example because the subject depends on concrete implementations instead of an abstraction.

---

## Good Example

In the good example, the `Game` class works with observers through a common `Observer` interface and inherits observer management from `Subject`.

## Why it is better

This version is much closer to the real Observer pattern because:

- `Game` does not depend on concrete announcer classes,
- observers can be attached and detached,
- the subject only sends notifications,
- each observer handles its own reaction.

### For example

- `ScoreAnnouncer` announces the current score,
- `LeadingTeamAnnouncer` announces which team is leading.

The `Game` class does not need to know how observers react. It only informs them that something has changed.

## Benefits

### Loose coupling

The subject does not depend on specific observer implementations.

### Better extensibility

New observers can be added without changing the `Game` class.

### Cleaner separation of responsibilities

`Game` manages the score, while observers handle reactions.

### Closer to the Open/Closed Principle

The code is easier to extend without modifying existing logic.

---

## note

In Kotlin, another possible approach would be to use **Flow**, for example, `MutableStateFlow`, to propagate state changes to observers. 
