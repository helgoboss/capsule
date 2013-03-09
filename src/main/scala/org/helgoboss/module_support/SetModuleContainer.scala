package org.helgoboss.module_support

class SetModuleContainer extends ModuleContainer {
  private val modules = new collection.mutable.HashSet[Module]

  def +=(module: Module) {
    modules += module
  }

  def stop() {
    modules foreach { _.stop() }
  }
}
