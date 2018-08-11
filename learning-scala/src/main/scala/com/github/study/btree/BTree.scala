package com.github.study.btree

/**
  * Created by shintaro.tamaki on 2015/10/29.
  */
sealed trait Node {
  def size: Int
  def max: Int
  def min: Int
  def avg: Int
  def sum: Int
  def find(value: Int): Option[Node]
}

case class Leaf(value: Int) extends Node {
  def size: Int = 1
  def max: Int = value
  def min: Int = value
  def avg: Int = value
  def sum: Int = value
  def find(_value: Int): Option[Node] =
    if (value == _value) Some(Leaf(value)) else None
}

case class Branch(left: Node, value: Int, right: Node) extends Node {
  def size: Int = left.size + 1 + right.size
  def max: Int = right.max
  def min: Int = left.min
  def avg: Int = List(left.avg, value, right.avg).sum / 3
  def sum: Int = List(left.sum, value, right.sum).sum
  def find(_value: Int): Option[Node] =
    (left.find(_value), right.find(_value)) match {
      case (Some(_), _) => Option(Leaf(_value))
      case (_, Some(_)) => Option(Leaf(_value))
      case (_, _) =>
        if (value == _value) Option(Branch(left, value, right)) else None
    }
}

case class BTree(node: Node) {
  def size: Int = node.size
  def max: Int = node.max
  def min: Int = node.min
  def avg: Int = node.avg
  def sum: Int = node.sum
  def find(value: Int): Option[Node] = node.find(value)
}

// object BTree {
//   def apply(list: List[Int]): BTree = {
//     def listToBTree(_list: List[Int], tree: BTree): BTree =
//       _list match {
//         case Nil    => tree
//         case h :: t => {}
//       }
//     listToTree(list, Nil)
//   }
// }
