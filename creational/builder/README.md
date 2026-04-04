# Builder Pattern

## Theory

The **Builder** is a **creational design pattern** whose main idea is to **separate the construction of an object from its representation**.

This means that the process of creating an object is handled by a dedicated builder class, instead of constructing the object directly with one large constructor call.

The Builder pattern is especially useful when an object:
- has many fields,
- contains optional parameters,
- may be created in different configurations,
- or requires step-by-step construction.

Instead of passing everything directly to the constructor, the client uses a builder to configure the object gradually and then calls `build()` to get the final result.

---

## Main idea

The core idea of the Builder pattern is:

> **separate the construction of an object from its representation**

In practice, this means:
- the **product** class represents the final object,
- the **builder** class is responsible for assembling that object step by step,
- the client does not need to know all construction details.

Because of that, the same object can be created in different configurations while keeping the code more readable and easier to maintain.

---

## Bad Example

In the bad example, the `House` object is created directly using the constructor

## Why it is bad

This is a bad example in the context of the Builder pattern because the object is created directly in the client code, without a dedicated builder.

### Where the idea is violated

The Builder pattern should **separate the construction of an object from its representation**.

In this example, that separation does not exist, because:
- `House` is the final representation of the object,
- but the construction logic is also handled directly in `main()`,
- there is no separate class responsible for the building process.

As a result, the way the object is built is tightly connected to the object itself.

### Problems with this approach

- The client must know all constructor parameters.
- The client is responsible for passing all values manually.
- Optional data must be handled directly in constructor calls.
- Object creation becomes harder to read as the number of fields grows.
- The construction logic may be repeated in many places.
- There is no dedicated place for validation or controlled creation.

This approach may still be acceptable for very small and simple objects, but it becomes less practical when the object becomes more complex.

---

## Good Example

In the good example, object creation is handled by a separate `HouseBuilder` class.

The client does not construct `House` directly.  
Instead, it configures the builder step by step and finally calls `build()`.

This means:
- `House` represents the final object,
- `HouseBuilder` manages the construction process,
- optional values can be skipped more naturally,
- and the client code becomes cleaner and more expressive.

---

## Why it is better

This version is better because it follows the main idea of the Builder pattern:

- the construction process is separated from the object representation,
- the object is built step by step,
- the client does not need to pass everything into one large constructor,
- optional configuration becomes easier to handle,
- and the code is more readable.
