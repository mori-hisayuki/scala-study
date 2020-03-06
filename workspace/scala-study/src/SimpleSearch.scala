object SimpleSearch extends App {
  val text = "カワカドカドカドドワンゴカドカドンゴドワドワンゴドワカワカドンゴドワ".toSeq
  val pattern = "ドワンゴ".toSeq
  val matchIndexes = search(text, pattern)


  def search(text: Seq[Char], pattern: Seq[Char]): Seq[Int] = {
    var matchIndexes = Seq[Int]()
    var index:Int = 0

    text.foreach((char:Char)=> {
      val partText = text.slice(index, index + pattern.length)
      if (isMatch(partText, pattern)) matchIndexes = matchIndexes :+ index
      index += 1
    })
    matchIndexes
  }

  def isMatch(textPart: Seq[Char], pattern: Seq[Char]): Boolean = {
    var index:Int = 0
    pattern.foreach((char:Char)=> {
      if (textPart.length < pattern.length || textPart(index) != char) return false
      index += 1
    })
    true
  }

  println(s"出現場所: ${matchIndexes}")
}
