# Implementation roadmap

This repository is a hands-on [Java 25 user guide](USER_GUIDE.md) and executable collection of the 23 Gang of Four (GoF) patterns, plus optional enterprise examples.

| PR | Outcome | State |
| --- | --- | --- |
| #2 | Java 25, catalog, JUnit, CI and quality foundation | Merged |
| #3 | Strategy, Builder and Chain of Responsibility with runnable demos and user guides | Merged |
| #4 | Singleton, Factory Method, Abstract Factory and Prototype | Draft — awaiting review |
| #5 | Seven structural patterns | Planned |
| #6 | Remaining nine behavioral patterns | Planned |
| #7 | Enterprise examples: Repository, Specification, Retry, Circuit Breaker, CQRS and optional Spring integrations | Planned |
| #8 | Catalog navigation, comparisons and polished learning experience | Planned |

## Learn what's implemented

Seven patterns have executable examples and step-by-step guides:

- [Builder](guides/builder.md)
- [Singleton](guides/singleton.md)
- [Factory Method](guides/factory-method.md)
- [Abstract Factory](guides/abstract-factory.md)
- [Prototype](guides/prototype.md)
- [Strategy](guides/strategy.md)
- [Chain of Responsibility](guides/chain-of-responsibility.md)

The CLI catalog includes the remaining sixteen **planned** patterns. Listing a pattern does not mean its implementation is complete.

## How new lessons are added

Every pattern includes a practical problem, dependency-free runnable example, expected output, JUnit tests (including failure scenarios), Mermaid UML and trade-offs. See [the example guide](CONTRIBUTING_EXAMPLES.md).

The original 2023 experimental branches supplied the first three scenarios, recovered and refactored in PR #3. Future enterprise examples are distinct from the 23 GoF patterns.
