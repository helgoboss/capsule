Capsule
=======

Capsule is a simple Scala API for building, using and extending a [domain-specific language](http://en.wikipedia.org/wiki/Domain-specific_language) (DSL) for managing start and stop logic.

## Example

A Capsule DSL utilization might look like this:

```scala
// Somewhere in your code
whenTurnedOn {
  whenDevicePluggedIn {
    lightLED()
  }
}
```

## Documentation

- [Scaladoc](http://helgoboss.github.com/capsule/scaladoc/#org.helgoboss.capsule.package)

## Further reading

See project [Domino](http://github.com/helgoboss/domino) for a real-world application of this API.
