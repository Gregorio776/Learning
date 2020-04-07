package cn.edu.tsu.scala

/**
 * @author Gregorio
 * @date 2020/4/7 12:21
 */
private class Person(val name:String)  {
  private def getSkill =name+"s skill is:"+Person.skill


}

object Person{
  private val skill = "basketball"
  private val person=new Person("Gregorio")
  def printSkill():Unit=println(person.getSkill)

  def main(args: Array[String]): Unit = {
    Person.printSkill()
  }
}