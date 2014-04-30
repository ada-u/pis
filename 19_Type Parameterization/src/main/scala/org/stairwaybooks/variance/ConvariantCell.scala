package org.stairwaybooks.variance

class ConvariantCell[+T](init: T) {

  private[this] var current = init

  def get = current
  // [Error] cannot use variance annotation position (x is mutable)
  // def set(x: T) { current = x }

}
