package org.helgoboss.module_support
    
import scala.util.DynamicVariable

/**
 * Mix this trait into your class if you want to build a DSL for defining a tree of modules which can be started and stopped.
 * See class "OsgiContext" for an example.
 */
trait ModuleContext {
    private val dynamicModuleContainer = new DynamicVariable[Option[ModuleContainer]](None)
    
    /**
     * Adds a module to the currently active module container and starts it.
     */
    protected def addModule(module: Module) {
        module.start
        dynamicModuleContainer.value.foreach(_ += module)
    }
    
    /**
     * Executes the given function and makes this function see the given module container as active module container instead of the currently active one.
     */
    protected def executeWithinNewModuleContainer(f: => Unit): ModuleContainer = {
        val newModuleContainer = new ModuleContainer
        dynamicModuleContainer.withValue(Some(newModuleContainer)) {
            f
        }
        newModuleContainer
    }
    
    
    protected def onStart(f: => Unit) = this addModule new Module {
        def start {
            f
        }
        def stop {}
    }
    
    protected def onStop(f: => Unit) = this addModule new Module {
        def start {}
        def stop {
            f
        }
    }
    
}