trait Base {
  def +(value: Int): Int
}

case class Number(value: Int) extends Base {
  def +(that: Base): Int = 
    this.value + that.value
}

case class Rational(n: Base, d: Base) extends Base {
  def +(that: Base): Base =
    (that.n, that.d) match {
      case (n, d) if (this.d == d) =>
        Rational(this.n + n, d)
      case (n, d) if (this.d != d) =>
        Rational(this.n * d + n * this.d, this.d * d)
    }
}
