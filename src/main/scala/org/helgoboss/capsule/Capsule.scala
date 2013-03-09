package org.helgoboss.capsule

/**
 * An instance of this class represents something which can be started and stopped. After being started and before being stopped,
 * we say the capsule is active. Otherwise we say it's inactive.
 */
trait Capsule {
  def start()
  def stop()
}
