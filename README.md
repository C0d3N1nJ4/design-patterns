# Java Design Patterns — hands-on Java 25 guide

Learn design patterns by **running small examples, reading their tests and comparing the design choices**. The examples need only Java 25 and Maven; no database, message broker, containers or credentials.

## Start here

1. Install JDK 25 and verify it with `java -version`.
2. Clone this repository and enter its directory.
3. Run the complete test and quality suite:
   ```bash
   ./mvnw clean verify
   ```
4. Choose an example and run it:
   ```bash
   java -cp target/classes com.design.patterns.behavioral.strategy.StrategyDemo
   java -cp target/classes com.design.patterns.creational.builder.BuilderDemo
   java -cp target/classes com.design.patterns.behavioral.chainofresponsibility.ApprovalChainDemo
   ```

On Windows use `mvnw.cmd clean verify` to build; the `java -cp` commands are the same. The first Maven run downloads build and test dependencies.

## Pick a pattern by your problem

| Your problem | Start with | What you'll learn |
| --- | --- | --- |
| The same operation needs different algorithms | [Strategy](docs/guides/strategy.md) | Swap photo-sharing methods without changing the camera |
| An object has required properties and many optional settings | [Builder](docs/guides/builder.md) | Create validated, immutable cars using fluent methods |
| Requests need escalation to different decision-makers | [Chain of Responsibility](docs/guides/chain-of-responsibility.md) | Route purchase approvals to the first authorized handler |

These are **3 implemented patterns out of 23 planned**. Explore the full list with:

```bash
java -cp target/classes com.design.patterns.DesignPatternsApplication
```

The catalog lists future lessons as well as implemented ones. It is not a menu for executing all patterns.

## Follow a lesson

Read the problem in the guide, execute the example and compare the displayed result with the explanation. Open the linked Java source and tests. Change one input or choice and rerun the demo or the targeted test:

```bash
./mvnw -Dtest=StrategyTest test
./mvnw -Dtest=BuilderTest test
./mvnw -Dtest=ApprovalChainTest test
```

The guides include UML diagrams, concrete Java snippets, gotchas and advice on when *not* to use the pattern.

## More help

- [Learning path](docs/USER_GUIDE.md) — how to work through examples and tests
- [Implementation roadmap](docs/ROADMAP.md) — what's implemented and what comes next
- [Contributing an example](docs/CONTRIBUTING_EXAMPLES.md) — standards for code and lessons
- [Reading the UML diagrams](docs/UML.md) — quick Mermaid notation guide

All pattern examples use plain Java. Optional Spring and enterprise integrations are a future separate workstream.
