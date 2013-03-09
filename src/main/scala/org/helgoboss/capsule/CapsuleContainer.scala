package org.helgoboss.capsule

/**
 * This is a capsule container. It does nothing else than hosting several capsules and stopping all of them on request.
 */
trait CapsuleContainer {
  def +=(capsule: Capsule)
  def stop()
}
