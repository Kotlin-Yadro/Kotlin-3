package ru.otus.cars.fuel_system

abstract class TankMouth() {
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