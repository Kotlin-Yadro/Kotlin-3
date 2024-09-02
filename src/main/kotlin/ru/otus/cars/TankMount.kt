package ru.otus.cars

/**
 * Fuel load mounting
 */
sealed interface TankMouth {
    fun open()
    fun close()
}