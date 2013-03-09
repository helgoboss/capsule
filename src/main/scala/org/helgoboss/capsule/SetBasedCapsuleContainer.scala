package org.helgoboss.capsule

class SetBasedCapsuleContainer extends CapsuleContainer {
  private val capsules = new collection.mutable.HashSet[Capsule]

  def +=(capsule: Capsule) {
    capsules += capsule
  }

  def stop() {
    capsules foreach { _.stop() }
  }
}
