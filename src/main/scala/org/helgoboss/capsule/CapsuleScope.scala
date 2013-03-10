package org.helgoboss.capsule

/**
 * Represents a capsule scope, that is a collection of capsules which shall all be stopped on the same event.
 * This interface allows clients to stop all capsules in the scope when the event occurs.
 */
trait CapsuleScope {
  /**
   * Stops all capsules in this scope.
   */
  def stop()
}
