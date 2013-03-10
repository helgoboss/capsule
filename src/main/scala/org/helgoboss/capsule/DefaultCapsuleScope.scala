package org.helgoboss.capsule

/**
 * A capsule scope implementation based on a [[scala.collection.Traversable]].
 *
 * @param capsules capsules in the scope
 */
class DefaultCapsuleScope(capsules: Traversable[Capsule]) extends CapsuleScope {
  def stop() {
    capsules foreach { _.stop() }
  }
}
