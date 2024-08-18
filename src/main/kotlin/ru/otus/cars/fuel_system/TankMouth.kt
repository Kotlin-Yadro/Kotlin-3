package ru.otus.cars.fuel_system

sealed class TankMouth(val fuelType: String) {
    class TankMouthVaz2107 : TankMouth("Газ")
    class TankMouthVaz2108 : TankMouth("Бензин")
    class TankMouthTaz : TankMouth("Спирт") {
        override fun open() {
            throw NotImplementedError("Взрываюсь при попытке заправить")
        }
    }

    private var mouthState: Boolean = false

    open fun open() {
        if (mouthState) {
            throw Error("Попытка открыть не закрытый бак")
        }
        //println("Открываю бак")
        mouthState = true
    }

    open fun close() {
        if (!mouthState) {
            throw Error("Попытка закрыть не открытый бак")
        }
        mouthState = false
        //println("Закрыл бак")
    }
}
