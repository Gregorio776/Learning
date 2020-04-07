package cn.edu.tsu.scala

/**
 * @author Gregorio
 * @date 2020/4/7 11:16
 */
object For extends App{
  for(i<- 1 to 10;if i%2==0;if i>5){
    print(i+"  ")
  }


  var even=for(i<- 1 to 10;if i%2==0;if i>5)yield i
  print(even)
}
