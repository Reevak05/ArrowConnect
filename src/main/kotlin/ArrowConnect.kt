import java.util.*

//TODO("Use inheritance to reduce redundancy in classes")

class ArrowConnect() {
    val national = National()

    fun run() {
        val input = Scanner(System.`in`)
        national.runCommands(input)
        input.close()
    }
}

fun main() {
    ArrowConnect().run()
}

fun createEvent(input : Scanner): Event {
    println("Enter event title:")
    val title = input.nextLine()
    println("Enter event year:")
    val year = input.nextLine()
    println("Enter event month number:")
    val month = input.nextLine()
    println("Enter event date:")
    val day = input.nextLine()
    return Event(year.toInt(), month.toInt(), day.toInt(), title)
}

fun printCalendar(calendar: Set<Event>) {
    calendar.sortedBy { event -> GregorianCalendar(event.year, event.month, event.day).time }
        .forEach { println(it) }
}