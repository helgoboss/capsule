package org.helgoboss.capsule

trait CapsuleConvenience {
  protected def capsuleContext: CapsuleContext

  def onStart(f: => Unit) {
    val capsule = new Capsule {
      def start() {
        f
      }
      def stop() {}
    }
    
    capsuleContext.addCapsule(capsule)
  }

  def onStop(f: => Unit) {
    val capsule = new Capsule {
      def start() {}
      def stop() {
        f
      }
    }
    
    capsuleContext.addCapsule(capsule)
  }
}
