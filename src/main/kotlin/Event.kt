class Event(val year: Int, val month: Int, val day: Int, val title: String) {

    @Override
    override fun toString(): String {
        return "$month-$day-$year: $title"
    }
}