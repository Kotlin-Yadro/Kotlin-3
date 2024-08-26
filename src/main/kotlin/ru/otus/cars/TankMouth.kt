package ru.otus.cars

/**
 * Горловина топливного бака
 */
sealed class TankMouth {
    /**
     * Открывает бензобак
     */
    abstract fun open()

    /**
     * Закрывает бензобак
     */
    abstract fun close()
}

/**
 * Горловина бензинового бака
 */
open class PetrolMouth : TankMouth() {
    override fun open() {
        println("Открываем бензиновый бак")
    }

    override fun close() {
        println("Закрываем бензиновый бак")
    }

    /**
     * Заправляет бак бензином на [litres] литров
     */
    open fun fuelPetrol(liters: Int) {
        println("Заправляем бак бензином на $liters литров")
    }
}

/**
 * Горловина газового бака
 */
open class LgpMouth : TankMouth() {
    override fun open() {
        println("Открываем газовый бак")
    }

    override fun close() {
        println("Закрываем газовый бак")
    }

    /**
     * Заправляет бак газом на [litres] литров
     */
    open fun fuelLgp(liters: Int) {
        println("Заправляем бак газом на $liters литров")
    }
}
