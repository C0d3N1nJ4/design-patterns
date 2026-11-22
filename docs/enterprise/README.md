# Enterprise Java patterns — learning path

These patterns complement the 23 classic GoF patterns; **they are not counted in the GoF total**.

| What you need | Lesson | Runnable example |
| --- | --- | --- |
| Business logic needs customer storage without depending on a SQL driver or an in-memory map. | [Repository](repository.md) | `RepositoryDemo` |
| Eligibility rules become hard to maintain when each combination requires another conditional or query method. | [Specification](specification.md) | `SpecificationDemo` |
| A transient downstream failure should not necessarily fail an operation immediately. | [Retry](retry.md) | `RetryDemo` |
| Repeated calls to an unavailable dependency waste resources and amplify failures. | [Circuit Breaker](circuit-breaker.md) | `CircuitBreakerDemo` |
| Write operations and read queries have different requirements and may need different models. | [CQRS](cqrs.md) | `CqrsDemo` |
| Inject domain ports using Spring only when opted in | [Spring integration](spring-integration.md) | `SpringIntegrationDemo` |

## Follow along

Install JDK 25, then run `./mvnw clean verify`. Open a lesson and copy its `java -cp target/classes` command. Each guide contains expected output, Java class responsibilities, UML diagrams, edge-case tests and enterprise trade-offs.

Use the [Spring integration guide](spring-integration.md) only when you want to see the same dependency-inversion design wired through Spring Framework. It requires `-Pspring-integration` and downloads extra dependencies.

## Scope

These examples deliberately use in-memory implementations and simulated failures so users can learn locally. They do not make durability, transactional semantics, distributed locking, backoff jitter or production authorization guarantees.
