package org.helgoboss.module_support

/**
 * An instance of this class represents something which can be started and stopped. After being started and before being stopped,
 * we say the module is active. Otherwise we say it's inactive.
 */
trait Module {
  def start()
  def stop()
}
