# Java design patterns — user guide

This is a **hands-on learning guide**: choose a problem, execute an example and inspect its source and unit tests. No database, containers, cloud account or external APIs are needed.

## Get started

1. Install JDK 25; confirm `java -version` reports 25.
2. Clone the repository and open a terminal at its root.
3. Run `./mvnw clean verify` (Windows: `mvnw.cmd clean verify`). Maven downloads dependencies on the first run.
4. Pick a lesson below and run the exact command in its guide.

## Choose by the problem you want to solve

| I need to… | Pattern | Example |
| --- | --- | --- |
| Share photos through different interchangeable algorithms | [Strategy](guides/strategy.md) | Email, text, social |
| Configure an immutable object with optional values | [Builder](guides/builder.md) | Car options |
| Escalate a request until someone can approve | [Chain of Responsibility](guides/chain-of-responsibility.md) | Purchase approval |
| Access a single shared, immutable settings snapshot | [Singleton](guides/singleton.md) | Default application settings |
| Vary which product a common workflow creates | [Factory Method](guides/factory-method.md) | Email vs SMS notification |
| Create a consistent *family* of products | [Abstract Factory](guides/abstract-factory.md) | Light vs dark UI widgets |
| Make independent copies of a configured starting point | [Prototype](guides/prototype.md) | Report templates |

These seven are implemented; the remaining 16 GoF patterns are [planned](ROADMAP.md).

## Run the available examples

Run `./mvnw compile` first, then any of these commands:

```bash
java -cp target/classes com.design.patterns.behavioral.strategy.StrategyDemo
java -cp target/classes com.design.patterns.creational.builder.BuilderDemo
java -cp target/classes com.design.patterns.behavioral.chainofresponsibility.ApprovalChainDemo
java -cp target/classes com.design.patterns.creational.singleton.SingletonDemo
java -cp target/classes com.design.patterns.creational.factorymethod.FactoryMethodDemo
java -cp target/classes com.design.patterns.creational.abstractfactory.AbstractFactoryDemo
java -cp target/classes com.design.patterns.creational.prototype.PrototypeDemo
```

Each lesson shows expected output and explicitly identifies simulated behavior (no real notification or approval service calls).

## Learn from the tests

Run all tests and Checkstyle with `./mvnw clean verify`. To focus on a lesson:

```bash
./mvnw -Dtest=SingletonTest test
./mvnw -Dtest=FactoryMethodTest test
./mvnw -Dtest=AbstractFactoryTest test
./mvnw -Dtest=PrototypeTest test
```

Also available: `StrategyTest`, `BuilderTest` and `ApprovalChainTest`. Try modifying the demo input, predicting the output and checking the matching test assertions.

## Common setup problems

- **Wrong Java version:** confirm your JDK and `JAVA_HOME` both point to JDK 25.
- **Permission denied on `mvnw`:** use `bash mvnw clean verify` on Unix or restore executable permission.
- **Class not found:** run `./mvnw compile` before `java -cp target/classes`.
- **Maven dependency download failure:** check the network or Maven mirror; running the compiled examples requires no external connection.

Want to understand class relationships? Every guide includes a Mermaid UML diagram. Want to contribute? Read the [example standards](CONTRIBUTING_EXAMPLES.md).
