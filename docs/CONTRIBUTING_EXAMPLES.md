# Pattern lesson standard

Each pattern implementation should be small and independently runnable. Use packages of the form `com.design.patterns.<family>.<pattern>`, with lowercase identifiers only. Keep before/after examples separate and avoid accidental reliance on static state.

## Required lesson sections

- **Problem:** demonstrate a motivating design constraint or code smell
- **Solution:** explain roles, collaboration and the core invariant
- **Run:** exact local command and expected output
- **Tests:** behavioral assertions, edge cases and failure behavior
- **UML:** Mermaid class or sequence diagram
- **When not to use it:** trade-offs, alternatives and over-engineering risks
- **Enterprise application:** one realistic example with dependency-free fakes

Prefer meaningful return values and state assertions over testing println statements. Provide deterministic tests, not sleeps or network calls. Pattern packages must be isolated and compilable under Java 25.

## Review checklist

- [ ] Explain why the pattern improves the before-example
- [ ] Add a runnable entry point without external infrastructure
- [ ] Add unit tests exercising both successful and invalid inputs
- [ ] Add Mermaid diagram and trade-off notes
- [ ] Run `./mvnw clean verify`
- [ ] Ensure there are no hidden credentials or third-party services
