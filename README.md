# Java Design Patterns

A practical **Java 25 design patterns handbook** with runnable examples, automated tests and architectural guidance.

> **Project status:** Foundation only. The catalog lists all 23 classic GoF patterns, but implementation lessons will be delivered incrementally. Previous experimental examples live on separate branches and are not yet merged.

## Quick start

Prerequisites: JDK 25 (LTS), network access for the first Maven dependency download. No database, containers, APIs or cloud accounts are required.

```bash
./mvnw clean verify
java -cp target/classes com.design.patterns.DesignPatternsApplication
```

On Windows, use `mvnw.cmd` instead of `./mvnw`. The Java application lists the planned pattern catalog; it is **not** a claim that all 23 examples are implemented.

## Pattern categories

| Family | Count | Planned patterns |
| --- | ---: | --- |
| Creational | 5 | Abstract Factory, Builder, Factory Method, Prototype, Singleton |
| Structural | 7 | Adapter, Bridge, Composite, Decorator, Facade, Flyweight, Proxy |
| Behavioral | 11 | Chain of Responsibility, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Strategy, Template Method, Visitor |

See [the roadmap](docs/ROADMAP.md), [example standards](docs/CONTRIBUTING_EXAMPLES.md) and [UML guide](docs/UML.md).

## Architecture decisions

- **Plain Java first.** No Spring Boot runtime is necessary to understand or run classic patterns.
- **Enterprise integrations later.** Spring-specific examples will be isolated from core patterns and documented as additional patterns, not counted among the 23 GoF patterns.
- **Tests are executable documentation.** Each implementation PR must introduce focused JUnit tests, including edge cases.
- **One demo per pattern.** Examples must run locally without external infrastructure.
- **Reviewable PRs.** Each delivery phase builds on `main` and must pass the GitHub Actions quality gate.

## Contributing

Run `./mvnw clean verify` before opening a pull request. Include a problem statement, after-example, unit tests, a UML diagram, and a discussion of trade-offs for every pattern.
