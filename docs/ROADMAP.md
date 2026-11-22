# Implementation roadmap

Follow the lessons in the [user guide](USER_GUIDE.md). This is the delivery plan for a **23-pattern GoF collection** and additional enterprise Java examples.

| PR | Outcome | State |
| --- | --- | --- |
| #2 | Java 25, catalog, JUnit, CI and quality foundation | Merged |
| #3 | Strategy, Builder and Chain of Responsibility with demos, tests and learner guides | Draft — awaiting review |
| #4 | Finish the five creational patterns | Planned |
| #5 | Finish all seven structural patterns | Planned |
| #6 | Finish all eleven behavioral patterns | Planned |
| #7 | Enterprise examples: Repository, Specification, Retry, Circuit Breaker, CQRS and optional Spring integrations | Planned |
| #8 | Catalog navigation, cross-pattern comparisons and polished learning experience | Planned |

## What you can use now

The three [working examples](USER_GUIDE.md) have deterministic local demos, JUnit tests and a Mermaid diagram in each guide. The CLI catalog lists the other 20 **planned** patterns; those are not yet implementations.

## Why the original branches were adapted

The 2023 `behavioural-strategy-pattern`, `behavioural-chain-of-responsibility-pattern` and `creational-builder-pattern` branches supplied the original camera, approval-chain and car scenarios. Their examples were rebuilt into consistent lowercase Java packages with input validation and testable return values instead of interactive input or console-only logic.

## Standard for future lessons

Every pattern needs a motivating problem, an executable example without external services, focused unit tests including failure scenarios, UML, a real-world use case and a trade-off section. See [contributing examples](CONTRIBUTING_EXAMPLES.md).

The enterprise examples are separate from the 23 GoF patterns.
