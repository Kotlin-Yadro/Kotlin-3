package ru.otus.cars

import java.lang.IllegalArgumentException

open class PetrolMouth(val maxCapacity: Int): TankMouth() {
    var capacity = 0
        private set
    fun fuelPetrol(liters: Int) {
        if (!isOpened) {
            throw IllegalStateException("Бак закрыт, не могу загрузить топливо")
        }
        capacity += liters
        if (capacity > maxCapacity) {
            capacity = maxCapacity
            throw IllegalArgumentException("Бак переполнен")
        }
    }
}