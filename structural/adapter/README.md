# Adapter 

**Adapter** is a structural design pattern that allows one interface to work with a class that has a different, incompatible interface.

It acts like a translator between the client code and an existing class.

## Example idea

In this example, the application expects an encoder that can convert an **octal number to binary**.

The expected interface is `EncodeOctalToBinary`.

However, the existing class `EncodeDecimalToBinary` can only convert a **decimal number to binary**.

Because these interfaces do not match directly, we use an adapter.

## How the adapter works

`EncodingAdapter` implements the interface expected by the application.

Inside the adapter, the octal number is first converted to decimal. Then the adapter uses the old decimal-to-binary encoder.

## Why this approach is correct

This is a correct example of the Adapter pattern because the client code works with the expected interface and does not need to know how the old encoder works internally.

The old class does not need to be changed. Instead, the adapter makes it compatible with the new interface.

## Bad example

A bad approach would be changing the client code to use `EncodeDecimalToBinary` directly and manually convert octal numbers before every call.

That would make the client responsible for conversion logic and would tightly connect it to the old class.

## Main idea

The main idea of Adapter is to make an existing class usable in a place where another interface is expected, without modifying the existing class.
