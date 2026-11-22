# Learning paths — from first pattern to enterprise Java

All exercises use JDK 25. Run `./mvnw clean verify` once, then copy the demo command from each linked guide or the [runnable index](run-examples.md).

## Track A — first steps (about six lessons)

| Order | Lesson | What to practice |
| --- | --- | --- |
| 1 | [Strategy](guides/strategy.md) | Swap sharing implementations and add a lambda |
| 2 | [Builder](guides/builder.md) | Create two immutable configurations from one builder |
| 3 | [Factory Method](guides/factory-method.md) | Introduce a third notification product |
| 4 | [Adapter](guides/adapter.md) | Add input validation and test fractional cents |
| 5 | [Observer](guides/observer.md) | Add a third subscriber and inspect failure behavior |
| 6 | [Decorator](guides/decorator.md) | Change wrapper order and compare results |

**Checkpoint:** explain when a simple interface or factory is enough without a full pattern hierarchy.

## Track B — application design and behavior

| Order | Lesson | What to practice |
| --- | --- | --- |
| 1 | [State](guides/state.md) | Test an invalid lifecycle transition |
| 2 | [Command](guides/command.md) and [Memento](guides/memento.md) | Compare action undo with state snapshots |
| 3 | [Chain of Responsibility](guides/chain-of-responsibility.md) | Test exact approval thresholds |
| 4 | [Composite](guides/composite.md) | Calculate a nested directory size |
| 5 | [Facade](guides/facade.md) and [Proxy](guides/proxy.md) | Separate orchestration from access control |
| 6 | [Bridge](guides/bridge.md) and [Template Method](guides/template-method.md) | Contrast independent variation and subclass hooks |
| 7 | [Visitor](guides/visitor.md), [Interpreter](guides/interpreter.md), [Iterator](guides/iterator.md), [Mediator](guides/mediator.md), [Flyweight](guides/flyweight.md), [Singleton](guides/singleton.md), [Prototype](guides/prototype.md), [Abstract Factory](guides/abstract-factory.md) | Review specialized problems in the complete catalog |

**Checkpoint:** justify choosing each pattern over a simpler record, enum, lambda or composition-based approach.

## Track C — enterprise Java

| Order | Lesson | What to practice |
| --- | --- | --- |
| 1 | [Repository](enterprise/repository.md) | Replace the in-memory repository through an interface |
| 2 | [Specification](enterprise/specification.md) | Compose AND/OR eligibility rules |
| 3 | [Retry](enterprise/retry.md) | Classify transient failures and inject a fake sleeper |
| 4 | [Circuit Breaker](enterprise/circuit-breaker.md) | Exercise OPEN and HALF_OPEN via a clock seam |
| 5 | [CQRS](enterprise/cqrs.md) | Show stale reads and replay-safe projection |
| 6 | [Optional Spring integration](enterprise/spring-integration.md) | Run the opt-in profile and inspect constructor injection |

**Checkpoint:** explain which production safeguards the examples intentionally omit, including durable transactions, idempotency, concurrency control, observability and authorization.

## A repeatable approach for every lesson

1. Read the problem and predict the demo output.
2. Run the example locally and compare the expected output in the guide.
3. Inspect the implementation and its UML collaboration diagram.
4. Run the focused JUnit test, then change one input and add one edge-case assertion.
5. Decide whether the pattern solves a real problem or introduces unnecessary complexity.

Use the [comparison matrix](pattern-comparison.md) before using patterns in your own service.
