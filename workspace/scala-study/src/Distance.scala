object Distance extends App {
    val kilometersPerHours: Double = 11.0
    val minutes: Double = 100.0
    val distance: Double = kilometersPerHours * minutes / 60.0
    println(s"走った距離は${distance}キロメートルです")
}
