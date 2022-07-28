import java.util.*

class Section(val name: String, val national: National) {
    val lodges = mutableSetOf<Lodge>()
    val calendar = mutableSetOf<Event>()

    fun runCommands() {
        val input = Scanner(System.`in`)
        while (true) {
            println("Viewing: $name section")
            println("Available commands: createevent, printevents, listlodges, createlodge, viewlodge, exit")
            val command = input.nextLine()
            when (command.lowercase()) {
                "createevent" -> {
                    calendar.add(createEvent())
                }
                "printevents" -> {
                    println("--- $name Section Events ---")
                    printCalendar(calendar)
                }
                "listlodges" -> {
                    println("--- $name Section Lodges ---")
                    lodges.forEach { println(it.name) }
                }
                "createlodge" -> {
                    println("Enter new lodge name:")
                    val name = input.nextLine()
                    lodges.add(Lodge(name, this))
                }
                "viewlodge" -> {
                    println("Enter lodge name:")
                    lodges.find { it.name == input.nextLine() }?.runCommands()
                }
                "exit" -> {
                    break
                }
                else -> {
                    println("Invalid command. Please try again.")
                }
            }
        }
        input.close()
    }
}