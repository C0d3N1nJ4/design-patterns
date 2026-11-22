# Pattern catalog — all 28 executable examples

Start with the [decision guide](DECISION_GUIDE.md) if you're choosing a pattern, or the [learning paths](LEARNING_PATHS.md) if you're working through them systematically.

The 23 **Gang of Four (GoF)** patterns are grouped below by original category. The five **enterprise Java** patterns are additional examples, not part of the GoF count. Every entry links to a user guide and a corresponding runnable demo in [the command index](RUN_EXAMPLES.md).

## Creational (5)

| Pattern | When it helps | Primary trade-off |
| --- | --- | --- |
| [Abstract Factory](guides/abstract-factory.md) | Create a matching family of objects | Adding product types requires changing factory contracts |
| [Builder](guides/builder.md) | Assemble complex immutable objects with optional settings | Adds a builder type for relatively simple objects |
| [Factory Method](guides/factory-method.md) | Let specialized creators choose the product | Inheritance can be unnecessary for simple selection |
| [Prototype](guides/prototype.md) | Copy an existing configured object | Mutable nested data needs deep copying |
| [Singleton](guides/singleton.md) | Ensure a JVM-wide immutable instance | Global state and testing can become difficult |

## Structural (7)

| Pattern | When it helps | Primary trade-off |
| --- | --- | --- |
| [Adapter](guides/adapter.md) | Translate an incompatible interface | Bad conversion rules can hide errors |
| [Bridge](guides/bridge.md) | Vary two dimensions independently | More abstractions than simpler designs need |
| [Composite](guides/composite.md) | Treat trees and leaves uniformly | Must prevent cycles in mutable trees |
| [Decorator](guides/decorator.md) | Add behavior by wrapping objects | Decoration order may change results |
| [Facade](guides/facade.md) | Expose a simple entry point to a subsystem | Can become an oversized orchestration layer |
| [Flyweight](guides/flyweight.md) | Share immutable repeated state | Cache growth must be controlled |
| [Proxy](guides/proxy.md) | Control or defer access to an object | Proxies can hide expensive work |

## Behavioral (11)

| Pattern | When it helps | Primary trade-off |
| --- | --- | --- |
| [Chain of Responsibility](guides/chain-of-responsibility.md) | Pass a request through candidate handlers | Order and missing handlers need clear policies |
| [Command](guides/command.md) | Make a request executable, queueable or undoable | Undo is not always a real reversal |
| [Interpreter](guides/interpreter.md) | Evaluate a small language or rule expression | Complex grammars benefit from parsers |
| [Iterator](guides/iterator.md) | Traverse a collection without exposing its storage | Iterator consistency needs to be defined |
| [Mediator](guides/mediator.md) | Coordinate collaborating objects in one hub | A hub can become a god object |
| [Memento](guides/memento.md) | Restore a snapshot of earlier state | Snapshots can consume substantial memory |
| [Observer](guides/observer.md) | Notify registered listeners about events | Synchronous failure affects delivery |
| [State](guides/state.md) | Represent varying behavior across a lifecycle | Enums are often simpler for few states |
| [Strategy](guides/strategy.md) | Swap an algorithm at runtime | Overkill for stable, simple branches |
| [Template Method](guides/template-method.md) | Fix a workflow while subclasses vary steps | Subclass coupling limits flexibility |
| [Visitor](guides/visitor.md) | Add operations over a stable type hierarchy | Every new element type affects visitors |

## Enterprise Java (5)

| Pattern | When it helps | Primary trade-off |
| --- | --- | --- |
| [Repository](enterprise/repository.md) | Isolate domain logic from data storage | Interfaces still need well-designed domain operations |
| [Specification](enterprise/specification.md) | Compose reusable domain eligibility rules | In-memory predicates are not database queries |
| [Retry](enterprise/retry.md) | Recover from selected transient failures | Idempotency, bounded delays and time budgets matter |
| [Circuit Breaker](enterprise/circuit-breaker.md) | Stop repeated calls into a failing dependency | Thresholds, concurrency and recovery need tuning |
| [CQRS](enterprise/cqrs.md) | Separate writes and read projections | Eventual consistency adds operational complexity |

### Optional Spring integration

[Spring dependency injection example](enterprise/spring-integration.md) demonstrates wiring the Repository pattern in a separate Maven profile; it does **not** add a 29th design pattern.

To run the example classes, first execute `./mvnw compile` and then copy the command from [Run examples](RUN_EXAMPLES.md).
