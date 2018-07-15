trait A {

  val a: String
  def Afunc()
}

class B {

  val b: String
  def Bfunc(): Unit = {
    println("Call Bfunction")
  }
}


object Singleton extends A {


  val a = "hello"

  def run() = {
    println("This is Singleton")
  }

  def Afunc(): Unit ={
    println("Call Afunction")
  }
}
