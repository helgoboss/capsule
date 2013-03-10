package org.helgoboss.capsule

/**
 * A capsule represents something which is startable and stoppable. After being started and before being stopped, we say
 * the capsule is active. Otherwise we say it's inactive.
 *
 * Implement this if you want to provide logic which will be started and stopped on certain events. Use
 * [[org.helgoboss.capsule.CapsuleContext]] to add the logic to the current capsule scope.
 */
trait Capsule {
  /**
   * Starts the capsule. After that, the capsule is active.
   */
  def start()

  /**
   * Stops the capsule. After that, the capsule is inactive.
   */
  def stop()
}
