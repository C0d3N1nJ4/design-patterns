# Your guide to learning design patterns

This repository is a set of **guided, executable exercises** for Java developers. You don't need to deploy anything.

## Set up once

Install Java Development Kit 25 and verify `java -version`. Clone the project. Run `./mvnw clean verify` from the project root. On Windows use `mvnw.cmd clean verify`.

You should see `BUILD SUCCESS` after Maven compiles the source, runs JUnit tests and checks style. If Maven reports an unsupported JDK, confirm your active `JAVA_HOME` and `java -version`. The first run requires internet access to retrieve Maven plugins.

## Choose a lesson

1. **[Strategy — varying behavior](guides/strategy.md):** start here if an application needs multiple ways to perform one task.
2. **[Builder — configuring complex objects](guides/builder.md):** use this when constructors become difficult to read.
3. **[Chain of Responsibility — escalating work](guides/chain-of-responsibility.md):** learn how requests move through an approval workflow.

Each lesson shows why you might need the pattern, a complete example, the command to run it, expected results, tests, a UML diagram and limitations.

## Practice effectively

- First, predict the output before running each demonstration.
- Then, run the example and find the method that produced each line.
- Change a supported input and observe what happens.
- Read the corresponding test class to learn the intended edge cases.
- Finally, explain when a simpler approach would be more appropriate.

### Your local command reference

```bash
./mvnw clean verify
./mvnw -Dtest=StrategyTest test
./mvnw -Dtest=BuilderTest test
./mvnw -Dtest=ApprovalChainTest test
```

`verify` runs the configured quality checks; `test` runs the relevant JUnit tests. Do not run the Java demos until classes have been compiled with `./mvnw compile` or `./mvnw clean verify`.

## Where to find the code

Production examples are under `src/main/java/com/design/patterns/` and matching tests are under `src/test/java/com/design/patterns/`. Look for `*Demo.java` as a runnable entry point. No example connects to an external service.

## Common errors

- **Permission denied when running `./mvnw`:** use `bash mvnw clean verify` or restore execute permission on a Unix clone.
- **Unsupported Java version:** use JDK 25, not only a Java 25 runtime.
- **`ClassNotFoundException`:** compile before calling `java -cp target/classes ...`; copy the class name exactly.
- **Dependency download failure:** check your connection or configured Maven mirror. Once dependencies are cached, the examples themselves run offline.
