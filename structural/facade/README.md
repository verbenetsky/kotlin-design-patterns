# Facade Design Pattern

## Overview

Facade is a structural design pattern that provides a simple interface to a complex system.

Its purpose is to make the code easier to use. Instead of working with many classes, the client can use one class with one simple method.

In this example, the system loads and starts a game. Internally, it may read files, download a map, load sounds, load mods, connect to multiplayer, turn on online mode, and start the game. The Facade hides these steps from the client.

## Why the version without Facade is worse

Without Facade, the client has to use many classes directly.

Because of that, the client must know:
- which classes are needed,
- in what order they should be called,
- how the whole process works.

This makes the code harder to read and harder to maintain.

It can also partially break the **Single Responsibility Principle**, because the client is not only using the system, but also controlling the whole loading process.

It may also be worse for the **Dependency Inversion Principle**, because the client depends directly on many concrete classes.

## Why the version with Facade is better

With Facade, the client uses only one class and one simple method.

This is better because:
- the code is simpler,
- the client does not need to know the internal details,
- the subsystem is easier to use,
- changes inside the loading process do not affect the client so much,
- the client is less coupled to the system.
