# Builder — create readable, validated objects

**Try this pattern when:** an object needs a few required values plus many optional settings. The original car idea has a required engine and transmission, with optional air conditioning and a sunroof.

## The problem

Constructors with many booleans become hard to read:

```java
// What do these flags mean?
// new Car("Electric", "Automatic", true, false);
```

A Builder names the options, checks required values and only creates the object after configuration.

## Run it

```bash
./mvnw compile
java -cp target/classes com.design.patterns.creational.builder.BuilderDemo
```

Expected output:

```text
Car[engine=Electric, transmission=Automatic, airConditioning=true, sunroof=true]
```

## Use it in your code

```java
var commuterCar = new Car.Builder("Electric", "Automatic")
        .airConditioning(true)
        .build();
System.out.println(commuterCar.sunroof()); // false by default
```

The nested `Car.Builder` accepts required values in its constructor. Optional methods return the same builder for chaining. `build()` returns a `Car` with final fields and read-only accessors; reusing the builder cannot change an already built car. Blank or null required fields are rejected immediately.

## How the classes collaborate

```mermaid
classDiagram
    class Car {
        -String engine
        -String transmission
        -boolean airConditioning
        -boolean sunroof
        +engine() String
        +transmission() String
        +airConditioning() boolean
        +sunroof() boolean
    }
    class Builder {
        +Builder(engine, transmission)
        +airConditioning(enabled) Builder
        +sunroof(enabled) Builder
        +build() Car
    }
    Car +-- Builder : nested builder
    Builder ..> Car : creates
```

## Verify and experiment

Run `./mvnw -Dtest=BuilderTest test`. Tests check defaults, fluent options, validation and immutability after builder reuse. Try constructing two cars from one builder and inspect the two independent results.

## In a real application

Builders can clarify optional attributes in a payment instruction, an HTTP request or a complex test fixture. Validate business invariants in the resulting object as needed, not only in presentation code.

**When to avoid:** Java records and a straightforward constructor are often better for a small fixed set of fields. Don't add a Builder where it makes the simplest case harder to read.
