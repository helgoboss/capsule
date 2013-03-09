package org.helgoboss.capsule

trait CapsuleContext {
  /**
   * Adds a capsule to the currently active capsule container and starts it.
   */
  def addCapsule(capsule: Capsule)

  /**
   * Executes the given function and makes this function see the given capsule container as active capsule container
   * instead of the currently active one.
   */
  def executeWithinNewCapsuleContainer(f: => Unit): CapsuleContainer
}
