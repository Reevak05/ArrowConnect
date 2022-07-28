import java.util.*

class Arrowman(val name: String, val lodge : Lodge) {
    var serviceHours = 0
    var level = "Ordeal"

    fun runCommands() {
        val input = Scanner(System.`in`)
        while (true) {
            println("Viewing: $name")
            println("Available commands: calendar, info, loghours, setlevel, exit")
            val command = input.nextLine()
            when (command.lowercase()) {
                "calendar" -> {
                    println("--- Your Calendar ---")
                    println("Lodge events:")
                    printCalendar(lodge.calendar)
                    println("Section events:")
                    printCalendar(lodge.section.calendar)
                    println("National events:")
                    printCalendar(lodge.section.national.calendar)
                }
                "info" -> {
                    println("--- Your Information: ---")
                    println("Name: $name\nLevel: $level\nService Hours: $serviceHours")

                }
                "loghours" -> {
                    println("Enter number of additional service hours: ")
                    serviceHours += input.nextInt()
                    println("New total: $serviceHours hours.")
                }
                "setlevel" -> {
                    println("Enter new level: ")
                    if (level == "Ordeal" || level == "Brotherhood" || level == "Vigil") {
                        this.level = level
                        println("Level set to $level.")
                    } else {
                        println("Invalid level. Please enter Ordeal, Brotherhood, or Vigil.")
                    }
                }
                "exit" -> break // if this doesn't exit the while loop change it to return and move the close scanner to immediately before this line
                else -> {
                    println("Invalid command. Please try again.")
                }
            }
        }
        input.close()
    }
}