# Abstract Factory

**Abstract Factory** is a creational design pattern used to create families of related objects without specifying their concrete classes directly.

In this example, the families are:

- cheap furniture
- average furniture
- expensive furniture

Each family contains:

- chair
- sofa
- coffee table

## Why this example is correct

This implementation is correct because the client code can use the `FurnitureFactory` interface instead of creating concrete objects directly.

Each concrete factory creates one consistent family of products:

- `CheapFurnitureFactory` creates cheap furniture
- `AverageFurnitureFactory` creates average furniture
- `ExpensiveFurnitureFactory` creates expensive furniture

Because of this, when the client uses one selected factory, all created objects come from the same family.

## Bad example

A bad approach would be creating concrete furniture objects directly in the client code.

For example, the client could manually create a cheap chair, an expensive sofa, and an average coffee table. This is technically possible, but it makes the client responsible for choosing matching objects.

In this case, the client code knows too much about concrete classes and can easily mix objects from different families.

With Abstract Factory, the preferred approach is to use one factory, for example `CheapFurnitureFactory`, so all created objects come from the same family.

## Main idea

The main idea of Abstract Factory is to separate object creation from object usage and to make it easy to create related objects together as one consistent set.
