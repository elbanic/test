


object SBTtest {

  def main(args: Array[String]) = {
    println("Hello World")

    val test = new TestClass()
    test.run(args)

    Singleton.run()
    Singleton.Afunc()
  }
}
