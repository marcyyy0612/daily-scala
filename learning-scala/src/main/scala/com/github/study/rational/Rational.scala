package com.github.study.rational

// 分数
case class Rational(n: Int, d: Int) {
  def +(that: Rational): Rational =
    (that.n, that.d) match {
      case (n, d) if (this.d == d) =>
        new Rational(this.n + n, d)
      case (n, d) if (this.d != d) =>
        new Rational(this.n * d + n * this.d, this.d * d)
    }

  def <(that: Rational): Boolean =
    (that.n, that.d) match {
      case (n, d) if (this.n / this.d < n / d) => true
      case _                                   => false
    }

  def >(that: Rational): Boolean =
    (that.n, that.d) match {
      case (n, d) if (this.n / this.d > n / d) => true
      case _                                   => false
    }

  def <=(that: Rational): Boolean =
    (that.n, that.d) match {
      case (n, d) if (this.n / this.d <= n / d) => true
      case _                                    => false
    }

  def >=(that: Rational): Boolean =
    (that.n, that.d) match {
      case (n, d) if (this.n / this.d >= n / d) => true
      case _                                    => false
    }
}
