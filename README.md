# Java Design Patterns — hands-on Java 25 guide

A hands-on collection of **all 23 Gang of Four design patterns**, with executable examples, JUnit tests, Mermaid diagrams and user-focused documentation.

## Get started

Install JDK 25, clone this repository and run:

```bash
./mvnw clean verify
java -cp target/classes com.design.patterns.behavioral.command.CommandDemo
```

Expected output:

```text
Light on: true
After undo: false
```

On Windows use `mvnw.cmd clean verify` for the build. None of the sample applications require a database, Docker or external services.

## Choose your pattern

- **Creational (5/5):** [Builder](docs/guides/builder.md), [Singleton](docs/guides/singleton.md), [Factory Method](docs/guides/factory-method.md), [Abstract Factory](docs/guides/abstract-factory.md), [Prototype](docs/guides/prototype.md)
- **Structural (7/7):** [Adapter](docs/guides/adapter.md), [Bridge](docs/guides/bridge.md), [Composite](docs/guides/composite.md), [Decorator](docs/guides/decorator.md), [Facade](docs/guides/facade.md), [Flyweight](docs/guides/flyweight.md), [Proxy](docs/guides/proxy.md)
- **Behavioral (11/11):** [Strategy](docs/guides/strategy.md), [Chain of Responsibility](docs/guides/chain-of-responsibility.md), [Command](docs/guides/command.md), [Interpreter](docs/guides/interpreter.md), [Iterator](docs/guides/iterator.md), [Mediator](docs/guides/mediator.md), [Memento](docs/guides/memento.md), [Observer](docs/guides/observer.md), [State](docs/guides/state.md), [Template Method](docs/guides/template-method.md), [Visitor](docs/guides/visitor.md)

The [user guide](docs/USER_GUIDE.md) helps you choose a pattern based on the problem and provides all runnable commands. Each lesson includes expected output, tests, UML, practical applications and guidance on when **not** to use the pattern.

For a simple catalog listing:

```bash
java -cp target/classes com.design.patterns.DesignPatternsApplication
```

## More

- [User guide](docs/USER_GUIDE.md)
- [Roadmap](docs/ROADMAP.md)
- [Contributor standards](docs/CONTRIBUTING_EXAMPLES.md)
- [Mermaid UML notation](docs/UML.md)

Enterprise and Spring-specific examples are planned as optional follow-up work; they are not included in the GoF count.
