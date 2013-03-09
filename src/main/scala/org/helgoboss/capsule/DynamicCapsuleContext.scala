package org.helgoboss.capsule

import scala.util.DynamicVariable

class SimpleDynamicCapsuleContext extends DynamicCapsuleContext

/**
 * Mix this trait into your class if you want to build a DSL for defining a tree of capsules which can be started and stopped.
 * See class "OsgiContext" in Dominoe for an example.
 */
trait DynamicCapsuleContext extends CapsuleContext {
  private val dynamicCapsuleContainer = new DynamicVariable[Option[CapsuleContainer]](None)

  /**
   * Adds a capsule to the currently active capsule container and starts it.
   */
  def addCapsule(capsule: Capsule) {
    capsule.start()
    dynamicCapsuleContainer.value foreach { _ += capsule }
  }

  /**
   * Executes the given function and makes this function see the given capsule container as active capsule container instead of the currently active one.
   */
  def executeWithinNewCapsuleContainer(f: => Unit): CapsuleContainer = {
    val newCapsuleContainer = new SetBasedCapsuleContainer
    dynamicCapsuleContainer.withValue(Some(newCapsuleContainer)) {
      f
    }
    newCapsuleContainer
  }
}
