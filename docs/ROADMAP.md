# Implementation roadmap

This document tracks the target scope, **not** completed features. The 23 GoF patterns and the later enterprise examples will be implemented through focused PRs.

| PR | Workstream | Exit criteria | Status |
| --- | --- | --- | --- |
| #2 | Foundation | Java 25, Maven build, JUnit, static checks, CI, catalog and docs | In progress |
| #3 | Recover earlier work | Strategy, Builder and Chain of Responsibility refactored, tested and documented | Planned |
| #4 | Creational | All 5 GoF creational patterns implemented and tested | Planned |
| #5 | Structural | All 7 GoF structural patterns implemented and tested | Planned |
| #6 | Behavioral | All 11 GoF behavioral patterns implemented and tested | Planned |
| #7 | Enterprise Java | Practical samples for Repository, Specification, Circuit Breaker, Retry, CQRS and Spring-oriented integration | Planned |
| #8 | Learning experience | Pattern navigation, trade-off matrices, Mermaid UML and complete getting-started guides | Planned |

## Recovery plan

The repository includes pre-existing branches `behavioural-strategy-pattern`, `behavioural-chain-of-responsibility-pattern` and `creational-builder-pattern`. The original Strategy PR #1 is open. Reuse and review their code in PR #3; **do not blindly merge** all branches into the foundation.

## Definition of done for each pattern

1. A concrete problem and a deliberately simpler before-example.
2. A small, runnable Java 25 implementation showing the pattern after refactoring.
3. Focused JUnit 5 tests for success and failure scenarios.
4. A Mermaid UML class or sequence diagram in the lesson README.
5. Guidance on applicability, costs, alternatives and Java language features.
6. No external database, broker or credentials; mock or fake integrations in tests.
7. `./mvnw clean verify` and the GitHub Actions CI gate pass.

## Candidate enterprise topics

- Repository and Specification: domain filtering without coupling to persistence
- Circuit Breaker and Retry: predictable service-failure recovery
- CQRS: separating read and write models with in-memory adapters
- Spring dependency injection and proxies: isolated optional modules only

Enterprise patterns are not included in the 23 GoF total.
