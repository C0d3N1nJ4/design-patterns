# Run every design pattern example

All 28 examples use plain Java 25 and run without containers, databases or network calls. The first Maven run downloads dependencies.

From the repository root, first compile:

```bash
./mvnw clean verify
```

On Windows use `mvnw.cmd clean verify`. Then run any demo below. The full class name after `target/classes` is important.

## Creational (5)

| Pattern | Command |
| --- | --- |
| [Abstract Factory](guides/abstract-factory.md) | `java -cp target/classes com.design.patterns.creational.abstractfactory.AbstractFactoryDemo` |
| [Builder](guides/builder.md) | `java -cp target/classes com.design.patterns.creational.builder.BuilderDemo` |
| [Factory Method](guides/factory-method.md) | `java -cp target/classes com.design.patterns.creational.factorymethod.FactoryMethodDemo` |
| [Prototype](guides/prototype.md) | `java -cp target/classes com.design.patterns.creational.prototype.PrototypeDemo` |
| [Singleton](guides/singleton.md) | `java -cp target/classes com.design.patterns.creational.singleton.SingletonDemo` |

## Structural (7)

| Pattern | Command |
| --- | --- |
| [Adapter](guides/adapter.md) | `java -cp target/classes com.design.patterns.structural.adapter.AdapterDemo` |
| [Bridge](guides/bridge.md) | `java -cp target/classes com.design.patterns.structural.bridge.BridgeDemo` |
| [Composite](guides/composite.md) | `java -cp target/classes com.design.patterns.structural.composite.CompositeDemo` |
| [Decorator](guides/decorator.md) | `java -cp target/classes com.design.patterns.structural.decorator.DecoratorDemo` |
| [Facade](guides/facade.md) | `java -cp target/classes com.design.patterns.structural.facade.FacadeDemo` |
| [Flyweight](guides/flyweight.md) | `java -cp target/classes com.design.patterns.structural.flyweight.FlyweightDemo` |
| [Proxy](guides/proxy.md) | `java -cp target/classes com.design.patterns.structural.proxy.ProxyDemo` |

## Behavioral (11)

| Pattern | Command |
| --- | --- |
| [Chain of Responsibility](guides/chain-of-responsibility.md) | `java -cp target/classes com.design.patterns.behavioral.chainofresponsibility.ApprovalChainDemo` |
| [Command](guides/command.md) | `java -cp target/classes com.design.patterns.behavioral.command.CommandDemo` |
| [Interpreter](guides/interpreter.md) | `java -cp target/classes com.design.patterns.behavioral.interpreter.InterpreterDemo` |
| [Iterator](guides/iterator.md) | `java -cp target/classes com.design.patterns.behavioral.iterator.IteratorDemo` |
| [Mediator](guides/mediator.md) | `java -cp target/classes com.design.patterns.behavioral.mediator.MediatorDemo` |
| [Memento](guides/memento.md) | `java -cp target/classes com.design.patterns.behavioral.memento.MementoDemo` |
| [Observer](guides/observer.md) | `java -cp target/classes com.design.patterns.behavioral.observer.ObserverDemo` |
| [State](guides/state.md) | `java -cp target/classes com.design.patterns.behavioral.state.StateDemo` |
| [Strategy](guides/strategy.md) | `java -cp target/classes com.design.patterns.behavioral.strategy.StrategyDemo` |
| [Template Method](guides/template-method.md) | `java -cp target/classes com.design.patterns.behavioral.templatemethod.TemplateMethodDemo` |
| [Visitor](guides/visitor.md) | `java -cp target/classes com.design.patterns.behavioral.visitor.VisitorDemo` |

## Enterprise Java (5)

| Pattern | Command |
| --- | --- |
| [Repository](enterprise/repository.md) | `java -cp target/classes com.design.patterns.enterprise.repository.RepositoryDemo` |
| [Specification](enterprise/specification.md) | `java -cp target/classes com.design.patterns.enterprise.specification.SpecificationDemo` |
| [Retry](enterprise/retry.md) | `java -cp target/classes com.design.patterns.enterprise.retry.RetryDemo` |
| [Circuit Breaker](enterprise/circuit-breaker.md) | `java -cp target/classes com.design.patterns.enterprise.circuitbreaker.CircuitBreakerDemo` |
| [CQRS](enterprise/cqrs.md) | `java -cp target/classes com.design.patterns.enterprise.cqrs.CqrsDemo` |

## Optional Spring Framework example

The Spring dependency and extra sources are loaded **only** by the `spring-integration` profile:

```bash
./mvnw -Pspring-integration clean verify
./mvnw -Pspring-integration org.codehaus.mojo:exec-maven-plugin:3.6.2:java -Dexec.mainClass=com.design.patterns.enterprise.spring.SpringIntegrationDemo
```

See the [Spring guide](enterprise/spring-integration.md) for expected output. These are examples, not production services or external integrations.

## Run a focused test

The lesson for each pattern names its JUnit test:

```bash
./mvnw -Dtest=AdapterTest test
./mvnw -Dtest=CqrsTest test
```

For the complete Java and documentation suite run `./mvnw clean verify`. CI additionally parses Mermaid diagrams and verifies navigation links.
