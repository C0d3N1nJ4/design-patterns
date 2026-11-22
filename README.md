# Java Design Patterns — hands-on Java 25 guide

Learn Java design patterns with **runnable examples, tests and practical user guides**. No database, Docker, cloud credentials or live external services are required.

## Start here

1. Install JDK 25 and verify with `java -version`.
2. Clone this repository and change into its directory.
3. Build and test everything:

```bash
./mvnw clean verify
```

4. Choose a pattern below, then follow its guide. On Windows use `mvnw.cmd clean verify` instead.

## Choose a lesson

| Problem | Pattern | Runnable demo |
| --- | --- | --- |
| Configuring a complex object | [Builder](docs/guides/builder.md) | `com.design.patterns.creational.builder.BuilderDemo` |
| Shared immutable configuration | [Singleton](docs/guides/singleton.md) | `com.design.patterns.creational.singleton.SingletonDemo` |
| Creating different products in a shared workflow | [Factory Method](docs/guides/factory-method.md) | `com.design.patterns.creational.factorymethod.FactoryMethodDemo` |
| Creating compatible groups of products | [Abstract Factory](docs/guides/abstract-factory.md) | `com.design.patterns.creational.abstractfactory.AbstractFactoryDemo` |
| Copying a configured starting object | [Prototype](docs/guides/prototype.md) | `com.design.patterns.creational.prototype.PrototypeDemo` |
| Choosing algorithms dynamically | [Strategy](docs/guides/strategy.md) | `com.design.patterns.behavioral.strategy.StrategyDemo` |
| Escalating decisions through handlers | [Chain of Responsibility](docs/guides/chain-of-responsibility.md) | `com.design.patterns.behavioral.chainofresponsibility.ApprovalChainDemo` |

To run any demo after compiling, paste its fully qualified class name after `java -cp target/classes`:

```bash
java -cp target/classes com.design.patterns.creational.factorymethod.FactoryMethodDemo
```

**7 of the 23 classic GoF patterns are implemented.** The CLI lists the entire planned catalog; it does not execute every pattern:

```bash
java -cp target/classes com.design.patterns.DesignPatternsApplication
```

## How to learn

Start with the [User Guide](docs/USER_GUIDE.md). Every pattern guide explains the motivating problem, the implementation, the exact command to run, the expected output, the Mermaid UML, edge cases, and when not to use it. Explore the JUnit tests to understand the behavior.

## More resources

- [User Guide](docs/USER_GUIDE.md)
- [Roadmap](docs/ROADMAP.md)
- [Contributing examples](docs/CONTRIBUTING_EXAMPLES.md)
- [UML diagram guide](docs/UML.md)

The examples use plain Java 25. Enterprise and Spring integrations will be documented as optional future lessons rather than prerequisites.
