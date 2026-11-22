# Roadmap

This project teaches all **23 classic Gang of Four patterns** with executable Java 25 demos, JUnit tests, UML and [user-focused guides](USER_GUIDE.md).

| PR | Scope | Status |
| --- | --- | --- |
| #2 | Java 25, JUnit, CI and quality foundation | Merged |
| #3 | Strategy, Builder and Chain of Responsibility | Merged |
| #4 | Remaining four creational patterns | Merged |
| #5 | All seven structural patterns and Maven cleanup | Merged |
| #6 | Nine remaining behavioral patterns, tests and guides | In review |
| #7 | Optional enterprise architecture and Java integrations | Planned |
| #8 | Comparisons, navigation and full learning experience | Planned |

## GoF coverage

All 23 examples exist in this PR: **5 creational, 7 structural and 11 behavioral**. Each example is self-contained and can be run with Java 25 after `./mvnw compile`. The optional enterprise patterns are **not** part of the GoF count.

The new behavioral guides: [Command](guides/command.md), [Interpreter](guides/interpreter.md), [Iterator](guides/iterator.md), [Mediator](guides/mediator.md), [Memento](guides/memento.md), [Observer](guides/observer.md), [State](guides/state.md), [Template Method](guides/template-method.md), [Visitor](guides/visitor.md).

## Maven baseline

The historical Spring application properties were removed in PR #5. The Maven Wrapper scripts and JAR remain committed so users can bootstrap consistently on Windows, Linux and macOS.
