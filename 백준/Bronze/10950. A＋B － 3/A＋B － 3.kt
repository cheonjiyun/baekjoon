import java.util.Scanner

fun main() = with(Scanner(System.`in`)){
    val nums = nextInt()
    for(i in 1..nums){
        println(nextInt() + nextInt())
    }
}