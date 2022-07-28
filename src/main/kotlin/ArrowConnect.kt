import java.util.*

//TODO("Use inheritance to reduce redundancy in classes")

class ArrowConnect() {
    val national = National()

    fun run() {
        national.runCommands()
    }
}

fun main() {
    ArrowConnect().run()
}

fun createEvent(): Event {
    val input = Scanner(System.`in`)
    println("Enter event title:")
    val title = input.nextLine()
    println("Enter event year:")
    val year = input.nextLine()
    println("Enter event month number:")
    val month = input.nextLine()
    println("Enter event date:")
    val day = input.nextLine()
    input.close()
    return Event(year.toInt(), month.toInt(), day.toInt(), title)
}

fun printCalendar(calendar: Set<Event>) {
    calendar.sortedBy { event -> GregorianCalendar(event.year, event.month, event.day).time }
        .forEach { println(it) }
}