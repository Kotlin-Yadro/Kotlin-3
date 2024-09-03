package ru.otus.cars

/**
 * Следит за машиной
 */
interface CarOutput {
    val tank: Tank

    /**
     * Скажи текущую скорость
     */
    fun getCurrentSpeed(): Int

    fun getFuelContents(): Int
}