# Java Design Patterns — user guide

Learn by picking a real problem, running an example and reading the accompanying tests. This project includes **all 23 GoF patterns**: five creational, seven structural and eleven behavioral. None of the examples require databases, containers or external credentials.

## Set up

1. Install JDK 25 and check with `java -version`.
2. Clone the repository and open a terminal in its root.
3. Run `./mvnw clean verify` (Windows: `mvnw.cmd clean verify`).
4. Choose a guide below and use its exact example command.

## Choose a lesson based on your problem

### Creational — creating objects

- [Builder](guides/builder.md), [Singleton](guides/singleton.md), [Factory Method](guides/factory-method.md), [Abstract Factory](guides/abstract-factory.md), [Prototype](guides/prototype.md)

### Structural — composing objects

- [Adapter](guides/adapter.md), [Bridge](guides/bridge.md), [Composite](guides/composite.md), [Decorator](guides/decorator.md), [Facade](guides/facade.md), [Flyweight](guides/flyweight.md), [Proxy](guides/proxy.md)

### Behavioral — coordinating behavior

- [Strategy](guides/strategy.md) — swap algorithms dynamically
- [Chain of Responsibility](guides/chain-of-responsibility.md) — escalate requests through handlers

| Problem | Read this lesson |
| --- | --- |
| Turn requests into objects and support undo | [Command](guides/command.md) |
| Evaluate a small domain language | [Interpreter](guides/interpreter.md) |
| Traverse elements without exposing collection internals | [Iterator](guides/iterator.md) |
| Coordinate collaborating objects through one hub | [Mediator](guides/mediator.md) |
| Restore earlier state without exposing mutable internals | [Memento](guides/memento.md) |
| Notify subscribers when an event happens | [Observer](guides/observer.md) |
| Represent legal behavior based on lifecycle state | [State](guides/state.md) |
| Keep an algorithm fixed while varying specific steps | [Template Method](guides/template-method.md) |
| Add operations to a stable hierarchy without modifying its types | [Visitor](guides/visitor.md) |

## Run the new behavioral demos

After `./mvnw compile`:

```bash
java -cp target/classes com.design.patterns.behavioral.command.CommandDemo
java -cp target/classes com.design.patterns.behavioral.interpreter.InterpreterDemo
java -cp target/classes com.design.patterns.behavioral.iterator.IteratorDemo
java -cp target/classes com.design.patterns.behavioral.mediator.MediatorDemo
java -cp target/classes com.design.patterns.behavioral.memento.MementoDemo
java -cp target/classes com.design.patterns.behavioral.observer.ObserverDemo
java -cp target/classes com.design.patterns.behavioral.state.StateDemo
java -cp target/classes com.design.patterns.behavioral.templatemethod.TemplateMethodDemo
java -cp target/classes com.design.patterns.behavioral.visitor.VisitorDemo
```

Each pattern guide gives the expected output, UML diagram, tests and trade-offs.

## Testing and troubleshooting

Run all tests and Checkstyle with `./mvnw clean verify`; target a lesson with `./mvnw -Dtest=CommandTest test` (replace the test class name with the one in your chosen guide).

If Java is rejected, check `JAVA_HOME` points to JDK 25. If `java -cp` cannot find a class, compile first and copy the complete class name. The first Maven run needs internet access for its dependencies, but all compiled examples are local.

## Continue with enterprise patterns

After the 23 GoF patterns, the [enterprise learning path](enterprise/README.md) walks through Repository, Specification, Retry, Circuit Breaker and CQRS. Each example is runnable without external infrastructure. [Spring DI integration](enterprise/spring-integration.md) is optional and activated with a Maven profile.

See the [roadmap](ROADMAP.md) for upcoming improvements, and [contribution guidelines](CONTRIBUTING_EXAMPLES.md) for how to add a lesson.
