package org.stairwaybooks.variance


class NonvariantCell[T](init: T) {

  private[this] var current = init

  def get = current
  def set(x: T) { current = x }

}
