# Java Design Patterns — hands-on Java 25 guide

Learn design patterns through **runnable examples, focused tests, Mermaid UML and practical user guides**. No database, Docker or cloud credentials are needed.

## Quick start

1. Install JDK 25 and confirm `java -version`.
2. Clone this repository and open its root.
3. Build and run all tests with `./mvnw clean verify` (Windows: `mvnw.cmd clean verify`).
4. Choose a lesson from the [user guide](docs/USER_GUIDE.md), then run the demo it describes.

For example:

```bash
java -cp target/classes com.design.patterns.structural.adapter.AdapterDemo
```

Expected output: `LEGACY charged 1250 cents`. This is a simulated integration, not a real payment.

## Available patterns

**14 of 23 GoF patterns are implemented** with runnable examples and focused tests.

- **Creational (5/5):** [Builder](docs/guides/builder.md), [Singleton](docs/guides/singleton.md), [Factory Method](docs/guides/factory-method.md), [Abstract Factory](docs/guides/abstract-factory.md), [Prototype](docs/guides/prototype.md)
- **Structural (7/7):** [Adapter](docs/guides/adapter.md), [Bridge](docs/guides/bridge.md), [Composite](docs/guides/composite.md), [Decorator](docs/guides/decorator.md), [Facade](docs/guides/facade.md), [Flyweight](docs/guides/flyweight.md), [Proxy](docs/guides/proxy.md)
- **Behavioral (2/11):** [Strategy](docs/guides/strategy.md), [Chain of Responsibility](docs/guides/chain-of-responsibility.md)

Find a suitable pattern using the [problem-to-pattern table](docs/USER_GUIDE.md). Every lesson includes exact run commands, expected output, UML, tests, use cases and limitations.

The catalog executable lists all 23 *planned* GoF names, including the 9 not yet implemented:

```bash
java -cp target/classes com.design.patterns.DesignPatternsApplication
```

## More resources

- [Hands-on user guide](docs/USER_GUIDE.md)
- [Delivery roadmap](docs/ROADMAP.md)
- [Contributing examples](docs/CONTRIBUTING_EXAMPLES.md)
- [Reading Mermaid UML](docs/UML.md)

All current examples use plain Java. Optional enterprise Spring integrations are planned separately.
