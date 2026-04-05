# Strategy Pattern

## Theory

The **Strategy** is a **behavioral design pattern** that allows us to define a family of algorithms, place each of them in a separate class, and make them interchangeable.

Instead of putting all variants of behavior into one class, we extract them into separate strategy classes and use them through a common interface.

This makes the code more flexible and easier to extend.

---

## Main roles

### Strategy
The **Strategy** is a common interface that defines a shared operation for all algorithms.

### Concrete Strategies
**Concrete Strategies** are different implementations of that interface.  
Each class contains one specific algorithm or behavior.

### Context
The **Context** is the class that uses a strategy object.  
It does not need to know how the algorithm works internally it only delegates the work to the selected strategy.

---

## Why the bad example is bad

The bad example keeps all compression logic inside one class and chooses the algorithm using conditions.

Because of that, it violates the **Open/Closed Principle**, since adding a new compression type requires modifying the existing class.

It also violates the **Single Responsibility Principle**, because one class has several responsibilities:
- storing data,
- choosing the compression method,
- and implementing multiple compression algorithms.

As a result, that class has **multiple reasons to change**, which makes the code harder to maintain and extend.

---

## Why the good example is good

The good example is better because each compression algorithm is moved to its own class and all of them share one common strategy interface.

The context only uses the selected strategy and does not implement the algorithms itself.

Because of that:
- the **Open/Closed Principle** is not violated, since new strategies can be added without changing the existing context,
- the **Single Responsibility Principle** is also respected, because each class has one clear responsibility and one main reason to change.

This makes the code cleaner, more modular, and easier to extend.

---

## Note

This is a very simple example, so the good solution may look a bit longer than the bad one.

In such a small case, using the Strategy pattern can feel like overengineering. However, it is still a correct example of the pattern, and in a more realistic project with more complex logic, this approach would be much more beneficial.
