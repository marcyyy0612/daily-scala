trait Number {
  def value: Int
}

case class Integer(num: Int) extends Number {
  
}

case class Rational(n: Number, p: Number) extends Number {

}

case class Calc(value: Number) {
  def +(value: Number) = {

  }
}
