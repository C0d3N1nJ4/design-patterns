# Implementation roadmap

Read the [user guide](user-guide.md) to run the examples and the [enterprise learning path](enterprise/README.md) for architecture patterns.

| PR | Work | Status |
| --- | --- | --- |
| #2 | Java 25, JUnit, quality gates and catalog | Merged |
| #3 | First three GoF patterns | Merged |
| #4 | Complete all five creational GoF patterns | Merged |
| #5 | Complete seven structural patterns and Maven cleanup | Merged |
| #6 | Complete all eleven behavioral patterns and repair Mermaid diagrams | Merged |
| #7 | Repository, Specification, Retry, Circuit Breaker, CQRS and optional Spring integration | Merged |
| #8 | Pattern selection, learning tracks, runnable index, docs and Mermaid CI | Draft — awaiting review |

All **23 GoF patterns** are complete and run on plain Java 25. PR #7 added five separate enterprise patterns and one optional Spring Framework wiring example. PR #8 improves [discovery and learning](learning-paths.md) across all 28 examples. The GoF catalog still counts exactly 23; enterprise topics are supplementary.

The core dependency policy remains minimal: `./mvnw clean verify` must run without a Spring runtime, database or broker. The optional Spring profile is also exercised separately in CI.
