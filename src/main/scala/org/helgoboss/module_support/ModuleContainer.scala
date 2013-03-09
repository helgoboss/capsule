package org.helgoboss.module_support

/**
 * This is a module container. It does nothing else than hosting several modules and stopping all of them on request.
 */
trait ModuleContainer {
  def +=(module: Module)
  def stop()
}
