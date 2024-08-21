package ru.otus.cars

/**
 * Горловина бензобака
 */
sealed interface TankMouth {
    fun open()
    fun close()
}
