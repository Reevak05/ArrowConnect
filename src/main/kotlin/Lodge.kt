import java.util.*

class Lodge(val name: String, val section: Section) {
    val arrowmen = mutableSetOf<Arrowman>()
    val calendar = mutableSetOf<Event>()

    fun runCommands() {
        val input = Scanner(System.`in`)
        while (true) {
            println("Viewing: $name lodge")
            println("Available commands: createevent, printevents, listarrowmen, createarrowman, viewarrowman, exit")
            val command = input.nextLine()
            when (command.lowercase()) {
                "createevent" -> {
                    calendar.add(createEvent())
                }
                "printevents" -> {
                    println("--- $name Lodge Events ---")
                    printCalendar(calendar)
                }
                "listarrowmen" -> {
                    println("--- Arrowmen ---")
                    arrowmen.forEach { println(it.name) }
                }
                "createarrowman" -> {
                    println("Enter new arrowman's name:")
                    val name = input.nextLine()
                    arrowmen.add(Arrowman(name, this))
                }
                "viewarrowman" -> {
                    println("Enter arrowman's name:")
                    arrowmen.find { it.name == input.nextLine() }?.runCommands()
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