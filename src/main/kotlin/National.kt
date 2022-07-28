import java.util.*

class National() {
    val sections = mutableSetOf<Section>()
    val calendar = mutableSetOf<Event>()

    fun runCommands() {
        val input = Scanner(System.`in`)
        while (true) {
            println("Viewing: national")
            println("Available commands: createevent, printevents, listsections, createsection, viewsection, exit")
            val command = input.nextLine()
            when (command.lowercase()) {
                "createevent" -> {
                    calendar.add(createEvent())
                }
                "printevents" -> {
                    println("--- National Events ---")
                    printCalendar(calendar)
                }
                "listsections" -> {
                    println("--- Sections ---")
                    sections.forEach { println(it.name) }
                }
                "createsection" -> {
                    println("Enter new section name:")
                    val name = input.nextLine()
                    sections.add(Section(name, this))
                }
                "viewsection" -> {
                    println("Enter section name:")
                    sections.find { it.name == input.nextLine() }?.runCommands()
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