# Java design patterns — user guide

Learn by choosing a problem, running a small example, inspecting its UML and exploring its JUnit tests. **14 of the 23 GoF patterns** currently have executable examples.

## Getting started

1. Install JDK 25. Run `java -version` and ensure it reports 25.
2. Clone this repository and open a terminal in its root.
3. Run `./mvnw clean verify` (Windows: `mvnw.cmd clean verify`) to compile, test and check style.
4. Pick a lesson below and run the sample command.

The initial Maven build downloads dependencies. The example applications do not require any external infrastructure.

## Choose by your problem

| Problem | Pattern and user guide |
| --- | --- |
| Swap behavior at runtime | [Strategy](guides/strategy.md) |
| Configure optional values cleanly | [Builder](guides/builder.md) |
| Escalate approval requests | [Chain of Responsibility](guides/chain-of-responsibility.md) |
| Share one immutable configuration instance | [Singleton](guides/singleton.md) |
| Let subclasses choose one product | [Factory Method](guides/factory-method.md) |
| Create matching families of objects | [Abstract Factory](guides/abstract-factory.md) |
| Customize copies of existing objects | [Prototype](guides/prototype.md) |
| Integrate an incompatible legacy API | [Adapter](guides/adapter.md) |
| Vary abstractions and implementations independently | [Bridge](guides/bridge.md) |
| Treat individual and grouped objects alike | [Composite](guides/composite.md) |
| Add optional behavior by wrapping objects | [Decorator](guides/decorator.md) |
| Simplify a multi-service workflow | [Facade](guides/facade.md) |
| Share repeated immutable data efficiently | [Flyweight](guides/flyweight.md) |
| Control access through an intermediary | [Proxy](guides/proxy.md) |

## Run the structural-pattern examples

After `./mvnw compile`, copy a command:

```bash
java -cp target/classes com.design.patterns.structural.adapter.AdapterDemo
java -cp target/classes com.design.patterns.structural.bridge.BridgeDemo
java -cp target/classes com.design.patterns.structural.composite.CompositeDemo
java -cp target/classes com.design.patterns.structural.decorator.DecoratorDemo
java -cp target/classes com.design.patterns.structural.facade.FacadeDemo
java -cp target/classes com.design.patterns.structural.flyweight.FlyweightDemo
java -cp target/classes com.design.patterns.structural.proxy.ProxyDemo
```

Each pattern guide includes the exact expected output.

## Learn from tests

Run all unit tests and Checkstyle with `./mvnw clean verify`. Focus on a particular pattern with:

```bash
./mvnw -Dtest=AdapterTest test
./mvnw -Dtest=BridgeTest test
./mvnw -Dtest=CompositeTest test
./mvnw -Dtest=DecoratorTest test
./mvnw -Dtest=FacadeTest test
./mvnw -Dtest=FlyweightTest test
./mvnw -Dtest=ProxyTest test
```

Tests are organized under `src/test/java/com/design/patterns/`. Read the test cases, predict how invalid inputs behave and try extending a sample.

## Troubleshooting

- **Java or Maven version error:** check that `JAVA_HOME` and `java -version` use JDK 25.
- **Permission denied for `./mvnw`:** run `bash mvnw clean verify` or restore execute permission.
- **Class not found:** compile before launching a demo; copy the fully qualified class name exactly.
- **Dependency download error:** verify Maven repository access. The wrapper JAR remains committed to support reliable bootstrap.

To see what's planned next, read the [roadmap](ROADMAP.md).
