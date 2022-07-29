import java.util.*

class Arrowman(val name: String, val lodge : Lodge) {
    var serviceHours = 0
    var level = "Ordeal"

    fun runCommands(input : Scanner) {
        while (true) {
            println("\n|> Viewing: $name <|")
            println("Available commands: calendar, info, loghours, setlevel, paydues, exit")
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
                    serviceHours += input.nextLine().toInt()
                    println("New total: $serviceHours hours.")
                }
                "setlevel" -> {
                    println("Enter new level: ")
                    val level = input.nextLine()
                    if (level == "Ordeal" || level == "Brotherhood" || level == "Vigil") {
                        this.level = level
                        println("Level set to $level.")
                    } else {
                        println("Invalid level. Please enter Ordeal, Brotherhood, or Vigil.")
                    }
                }
                "paydues" -> {
                    println("Dues paid. Thank you for your commitment to the Order.")
                }
                "exit" -> {
                    break
                }
                else -> {
                    println("Invalid command. Please try again.")
                }
            }
        }

    }
}