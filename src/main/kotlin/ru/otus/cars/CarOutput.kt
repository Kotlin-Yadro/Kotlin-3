package ru.otus.cars

/**
 * Следит за машиной
 */
interface CarOutput {
    /**
     * Скажи текущую скорость
     */
    fun getCurrentSpeed(): Int

    /**
     * Get current fuel reserve
     */
    fun getFuelContents(): Int
}