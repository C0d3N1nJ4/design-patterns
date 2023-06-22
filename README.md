# design-patterns

Chain of Responsibility Pattern

The intent is to avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request. Chain the receiving objects and pass the request along the chain until an object handles it.

How does it work?

- There is a chain of receiver objects having the responsibility, each link in the chain passes the request along the chain until one of the links handles the request.
- There is a handler interface and a concrete handler class for each link in the chain. The concrete handler class implements the handler interface and implements the handleRequest() method.
- Each handler class has a reference to the next handler in the chain. If the concrete handler is not able to handle the request, it passes the request to the next handler in the chain.
- The client creates the chain (links) and sends requests to the first link in the chain.

When to use it?

- When more than one object can handle a request and the handler is not known a priori. The handler should be ascertained automatically.
- When you want to issue a request to one of several objects without specifying the receiver explicitly.
- When the set of objects that can handle a request should be specified dynamically.
