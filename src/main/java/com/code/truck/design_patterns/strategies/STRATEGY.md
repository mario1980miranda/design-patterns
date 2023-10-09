# Strategy

Is a behavioral design pattern that lest you define a family of algorithms, put them into a separate class, and make
their objects interchangeable.

Strategy pattern suggests that you take a class that does something specific in a lot of different ways and extract
all of these algorithms into separated classes called **strategies**.

```mermaid
---
title: Route planning strategies
---
classDiagram
    note "Strategy pattern"
    note for Navigator "route = routeStrategy.buildRoute(A, B)"
    RouteStrategy <|.. RoadStrategy
    RouteStrategy <|.. PublicTransportStrategy
    RouteStrategy <|.. WalkingStrategy
    Navigator o--> RouteStrategy
    class RouteStrategy {
        <<interface>>
        + buildRoute(A, B)
    }
    class Navigator {
        - routeStrategy
        + buildRoute(A, B)
    }
```