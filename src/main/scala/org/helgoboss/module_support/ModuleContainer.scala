package org.helgoboss.module_support
    
/**
 * This is a module container. It does nothing else than hosting several modules and starting and stopping all of them on request.
 */
class ModuleContainer {
    private val modules = new collection.mutable.HashSet[Module]
    
    def +=(module: Module) = {
        modules += module
    }
    
    def start {
        modules.foreach(_.start)
    }
    
    def stop {
        modules.foreach(_.stop)
    }
}