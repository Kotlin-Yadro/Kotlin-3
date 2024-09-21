package ru.otus.cars

/**
 * Сборщик машины
 */
sealed interface CarBuilder {
    /**
     * Собери машину
     */
    fun build(plates: Car.Plates, type: Tank.FuelType): Car
}