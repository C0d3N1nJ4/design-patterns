# Roadmap

See the [hands-on user guide](USER_GUIDE.md) for how to run each implemented example.

| PR | Scope | Status |
| --- | --- | --- |
| #2 | Java 25, JUnit, CI and quality baseline | Merged |
| #3 | Strategy, Builder, Chain of Responsibility | Merged |
| #4 | Remaining four creational patterns | Merged |
| #5 | Adapter, Bridge, Composite, Decorator, Facade, Flyweight, Proxy and Maven cleanup | In review |
| #6 | Remaining nine behavioral patterns | Planned |
| #7 | Optional enterprise Java integration patterns | Planned |
| #8 | Cross-pattern comparisons and finished learning experience | Planned |

There are **14 implemented GoF patterns**: five creational, seven structural and two behavioral. The remaining nine behavioral patterns are planned.

## Maven cleanup decision

The historical Spring Boot `application.properties` was removed; `.gitignore` was simplified for a plain Java Maven project. The tracked Maven Wrapper JAR is intentionally **retained**: removing it would require the bootstrap script to download an extra binary before Maven can start, introducing an avoidable dependency on network availability, especially on Windows. Standard wrapper scripts and `pom.xml` remain unchanged.
