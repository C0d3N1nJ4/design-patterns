# Compare patterns before choosing one

Design patterns are **trade-offs**, not a checklist of required architecture. Pick the smallest abstraction that solves your actual problem.

## Patterns commonly confused

| If you're deciding between | Choose the first when… | Choose the second when… | Key distinction |
| --- | --- | --- | --- |
| [Strategy](guides/strategy.md) vs [State](guides/state.md) | A caller selects interchangeable algorithms | Behavior changes as a lifecycle evolves | Strategy varies *how*; State varies *what's allowed now* |
| [Factory Method](guides/factory-method.md) vs [Abstract Factory](guides/abstract-factory.md) | A creator chooses one product | You need compatible families of multiple products | One product vs product family |
| [Builder](guides/builder.md) vs [Prototype](guides/prototype.md) | Construct a new object step by step | Start from an existing configured object and copy it | Configuration vs cloning |
| [Adapter](guides/adapter.md) vs [Facade](guides/facade.md) | Existing interfaces are incompatible | Several collaborating APIs need a simpler front | Compatibility vs simplification |
| [Decorator](guides/decorator.md) vs [Proxy](guides/proxy.md) | Add optional behavior around a component | Control access to the same contract | Enhancement vs mediation/access |
| [Observer](guides/observer.md) vs [Mediator](guides/mediator.md) | One source broadcasts events to listeners | Several peers coordinate through one hub | Fan-out vs interaction orchestration |
| [Command](guides/command.md) vs [Memento](guides/memento.md) | Represent an action and possibly undo it | Save and restore object state snapshots | Operations vs saved state |
| [Chain of Responsibility](guides/chain-of-responsibility.md) vs [Strategy](guides/strategy.md) | Multiple handlers may receive a request sequentially | Exactly one selected algorithm performs work | Escalation vs explicit selection |
| [Template Method](guides/template-method.md) vs [Strategy](guides/strategy.md) | A superclass fixes a workflow and subclasses override steps | Behaviors are exchanged through composition | Inheritance vs composition |
| [Retry](enterprise/retry.md) vs [Circuit Breaker](enterprise/circuit-breaker.md) | A selected transient error might succeed soon | A failing dependency needs traffic blocked temporarily | Try again vs fail fast |
| [Repository](enterprise/repository.md) vs [CQRS](enterprise/cqrs.md) | Isolate persistence operations | Writes and reads have different models or consistency needs | Storage abstraction vs command-query separation |
| [Specification](enterprise/specification.md) vs [Strategy](guides/strategy.md) | Compose domain rules using AND/OR/NOT | Swap a complete algorithm | Predicate composition vs algorithm selection |

## Architectural cost checklist

Before introducing a pattern, ask whether a plain constructor, record, enum, interface, lambda or small conditional would suffice. Consider the cost of more types, hidden indirection, runtime state, concurrency requirements and maintenance. Domain-specific correctness (authorization, money, durability and delivery guarantees) is not supplied by a GoF pattern alone.

## A few practical choices

- **External API uses a different request contract:** start with Adapter, then possibly Facade if several external APIs must be orchestrated.
- **Long chain of conditionals selects pricing algorithms:** start with Strategy; use State only if permitted actions evolve across lifecycle stages.
- **Create an object with many optional flags:** prefer Builder to positional booleans.
- **Reliable payments or notifications:** use Retry only for classified transient failures and ensure idempotency. Circuit Breaker may reduce load on a failing upstream. Neither replaces persistence or recovery.
- **Multiple read projections for event-driven writes:** CQRS may help, but use a simpler Repository model until read/write differences justify it.

Follow the [decision guide](DECISION_GUIDE.md) or [learning paths](LEARNING_PATHS.md) for a guided route.
