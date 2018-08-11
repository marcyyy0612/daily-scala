package com.github.study.nnp

/**
  * Created by tamaki on 2015/02/08.
  */
trait NNP10 {

  // P01 (*) Find the last element of a list.
  def last(list: List[Int]): Int =
    list match {
      case Nil      => throw new Exception
      case h :: Nil => h
      case h :: t   => last(t)
    }

  // P02 (*) Find the last but one element of a list.
  def penultimate(list: List[Int]): Int =
    list match {
      case Nil           => throw new Exception
      case h :: t :: Nil => h
      case h :: t        => penultimate(t)
    }

  def nth(n: Int, list: List[Int]): Int =
    list match {
      case Nil      => throw new Exception
      case h :: Nil => h
      case h :: t =>
        n match {
          case 0 => h
          case _ => nth(n - 1, t)
        }
    }

  def length(list: List[Int]): Int = {
    def _length(_list: List[Int], count: Int): Int =
      _list match {
        case Nil      => throw new Exception
        case h :: Nil => count + 1
        case h :: t   => _length(t, count + 1)
      }
    _length(list, 0)
  }

  def reverse(list: List[Int]): List[Int] = {
    def _reverse(_list: List[Int], revList: List[Int]): List[Int] =
      _list match {
        case Nil      => throw new Exception
        case h :: Nil => h :: revList
        case h :: t   => _reverse(t, h :: revList)
      }
    _reverse(list, List())
  }

  def isPalindrome(list: List[Int]): Boolean =
    list == reverse(list)

  def flatten(nested: List[Any]): List[Any] =
    nested.flatMap {
      case l: List[Any] => flatten(l)
      case v            => List(v)
    }

  def compress(list: List[Symbol]): List[Symbol] = {
    def _compress(_list: List[Symbol], prev: Symbol, retList: List[Symbol]): List[Symbol] =
      _list match {
        case Nil      => throw new Exception
        case h :: Nil => retList
        case h :: t =>
          if (h == prev) {
            _compress(t, h, retList)
          } else {
            _compress(t, h, retList ::: List(h))
          }
      }
    _compress(list, null, List())
  }

  def pack(list: List[Symbol]): List[List[Symbol]] = {
    def _pack[A](result: List[List[A]], tempList: List[A], _ls: List[A]): List[List[A]] =
      (tempList, _ls) match {
        case (_, Nil)      => result :+ tempList
        case (Nil, h :: t) => _pack(result, List(h), t)
        case (tempH :: tempT, h :: t) if tempH == h =>
          _pack(result, tempList :+ h, t)
        case (tempH :: tempT, h :: t) if tempH != h =>
          _pack(result :+ tempList, List(h), t)
      }
    _pack(Nil, Nil, list)
  }

  def encode(list: List[Symbol]): List[(Int, Symbol)] =
    ???
  // def _encode[A](_ls: List[List[A]], result: List[(Int, A)]): List[(Int, A)] =
  //   _ls match {
  //     case h :: Nil => result :+ (h.length, h.head)
  //     case h :: t   => _encode(t, result :+ (h.length, h.head))
  //   }
  // _encode(pack(list), Nil)

  def encodeModified(list: List[Symbol]): List[(Int, Symbol)] =
    ???
  // def _encodeModified[A](_list: List[A], prevList: List[A], retList: List[List[A]]): List[List[A]] = {
  //   (_list, prevList) match {
  //     case (Nil, _) => retList :+ prevList
  //     case (h :: t, Nil) =>
  //   }
  // }

  def decode(list: List[(Int, Symbol)]): List[Symbol] =
    ???

  def encodeDirect(list: List[Symbol]): List[(Int, Symbol)] =
    ???

  def duplicate(list: List[Symbol]): List[Symbol] =
    ???

  def duplicateN(num: Int, list: List[Symbol]): List[Symbol] =
    ???

}
