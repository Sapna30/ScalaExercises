object Test {
  val f : String => String ={case "ping" => "pong"}
  f("ping")

  val fun : PartialFunction[String,String] ={case "ping" => "pong"}
  fun("ping")
  fun.isDefinedAt("abc") //False
  fun.isDefinedAt("ping") //True

  val fu :PartialFunction[List[Int],String] ={
    case Nil  => "one"
    case x::y:: rest => "two"
  }

  fu.isDefinedAt(List(1,2,3)) //true
  fu(List(1,2,3)) //"two"

  val g : PartialFunction[List[Int],String] = {
    case Nil => "one"
    case x::rest =>
      rest match {
        case Nil => "one"
      }
  }

  g.isDefinedAt(List(1,2,3)) //true //partial function evaluates outer case and as x:: rest avaialble it returns true
  g(List(1,2,3)) //will throw match exception
}