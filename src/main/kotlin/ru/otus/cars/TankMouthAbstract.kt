package ru.otus.cars

abstract class TankMouthAbstract: TankMouth {
    override fun open() {
        println("TankMouthAbstract.open()")
    }
    override fun close() {
        println("TankMouthAbstract.close()")
    }
}