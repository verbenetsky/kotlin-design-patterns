# Decorator Pattern

Decorator is a **structural design pattern** that allows you to add new behavior to an object **without changing the original class**.

Instead of putting every feature into one big class, you create small wrapper classes.  
Each wrapper adds one extra behavior and passes the work to the wrapped object.

So the main idea is:

- start with a simple object
- wrap it with decorators
- each decorator adds one feature

This gives more flexibility and cleaner code.

---

# Bad Example

## Why is it a bad example?

The bad example is bad because **everything is placed in one class**.

The `Logger` class:
- decides what parts should be included in the message
- formats the message
- prints the message

That means one class is responsible for too many things.

It is also hard to extend.  
If you want to add a new feature, for example log level or app name, you must go back and modify the same `Logger` class again.

So this solution becomes bigger and bigger over time:
- more boolean flags
- more `if` statements
- more logic inside one method

Because of that, the code is less clean, less flexible, and harder to maintain.

### In simple words

It is a bad example because:
- one class does too much
- one class knows too much
- adding new behavior means changing existing code
- it does not really show the Decorator pattern

---

# Good Example

## Why is it a good example?

The good example is good because **behavior is split into small separate classes**.

Each class has one simple job:
- `ConsoleLogger` prints the message
- `DateTimeLogger` adds date and time
- `ThreadNameLogger` adds thread name
- `UniqueIdLogger` adds unique ID

This makes the code cleaner and easier to understand.

It is also a real Decorator example because:
- all classes use the same `Logger` interface
- each decorator wraps another `Logger`
- each decorator adds something extra before passing the message further

This means you can combine features very easily without changing old code.

For example, you can create:
- only a console logger
- console logger with date
- console logger with date and UUID
- console logger with date, UUID, and thread name

And you do this by combining objects, not by rewriting one big class.
