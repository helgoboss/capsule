package org.helgoboss.capsule

import scala.util.DynamicVariable
import collection.mutable


/**
 * A [[org.helgoboss.capsule.CapsuleContext]] implementation based on [[scala.util.DynamicVariable]] and
 * [[org.helgoboss.capsule.DefaultCapsuleScope]].
 *
 * This is the trait you have to mix into your class if you want to build a capsule-based DSL. See class
 * [[org.helgoboss.dominoe.OsgiContext]] in the project "Dominoe" for an example.
 */
trait DynamicCapsuleContext extends CapsuleContext {
  /**
   * A Set representing the current scope.
   */
  private val dynamicCapsuleSet = new DynamicVariable[Option[mutable.Set[Capsule]]](None)

  def addCapsule(capsule: Capsule) {
    // Start the capsule immediately
    capsule.start()

    // Add capsule to the current set if there is one
    dynamicCapsuleSet.value foreach { _ += capsule }
  }

  def executeWithinNewCapsuleScope(f: => Unit): CapsuleScope = {
    // Create the new set of capsules
    val newCapsuleSet = new mutable.HashSet[Capsule]

    // Execute the function in the new set
    dynamicCapsuleSet.withValue(Some(newCapsuleSet)) {
      f
    }

    // Returns the set wrapped in the scope interface
    new DefaultCapsuleScope(newCapsuleSet)
  }
}
