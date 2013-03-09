package org.helgoboss.module_support

trait ModuleContext {
  /**
   * Adds a module to the currently active module container and starts it.
   */
  def addModule(module: Module)

  /**
   * Executes the given function and makes this function see the given module container as active module container
   * instead of the currently active one.
   */
  def executeWithinNewModuleContainer(f: => Unit): ModuleContainer
}
