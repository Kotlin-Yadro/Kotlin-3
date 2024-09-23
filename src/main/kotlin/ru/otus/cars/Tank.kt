package ru.otus.cars

/**
 * Бак
 */
interface Tank {
    /**
     * Уровень топлива
     */
    fun getContents(): Int

    /**
     * Принимает топливо
     */
    fun receiveFuel(litres: Int)
}