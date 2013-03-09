package org.helgoboss.module_support

trait ModuleConvenience {
  protected def moduleContext: ModuleContext

  def onStart(f: => Unit) {
    moduleContext addModule new Module {
      def start() {
        f
      }
      def stop() {}
    }
  }

  def onStop(f: => Unit) {
    moduleContext addModule new Module {
      def start() {}
      def stop() {
        f
      }
    }
  }
}
