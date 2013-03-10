package org.helgoboss.capsule

/**
 * Represents the tree structure made of capsule scopes and contained capsules. This interface is used by clients to add
 * starting and stopping logic to the current scope.
 */
trait CapsuleContext {
  /**
   * Starts the given capsule and adds it to the current capsule scope.
   *
   * @param capsule capsule
   */
  def addCapsule(capsule: Capsule)

  /**
   * Creates a new capsule scope on top of the active one and executes the given function in it. So the function
   * sees the new capsule scope as the current one.
   *
   * @param f the function which might add capsules to the new scope
   * @return the new scope
   */
  def executeWithinNewCapsuleScope(f: => Unit): CapsuleScope
}
