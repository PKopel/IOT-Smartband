package generator

val cardiacArrest = SensorData(frequency = 0.1, mean = 70.0, std = 50.0)

val ovulationTemp = SensorData(frequency = 100.0, mean = 0.5, std = 0.05)

suspend fun delayLoop(delay: Long, condition: () -> Boolean = { true }, func: (suspend () -> Unit)) {
    while (condition()) {
        func()
        kotlinx.coroutines.delay(delay)
    }
}

operator fun SensorData.plus(other: SensorData): SensorData = SensorData(
    frequency + other.frequency,
    mean + other.mean,
    std + other.std
)