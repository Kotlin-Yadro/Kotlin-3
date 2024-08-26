package ru.otus.cars

/**
 * Топливный бак
 */
interface Tank {
    /**
     * Сколько бензина/газа в баке
     */
    fun getContents(): Int

    /**
     * Заправляет бак на [litres] литров
     */
    fun receiveFuel(liters: Int)
}
