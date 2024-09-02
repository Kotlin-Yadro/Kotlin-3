package ru.otus.cars

abstract class TankMouth {

    var tank: Tank? = null

    abstract fun close()
    abstract fun open()
    open fun receiveFuel(liters: Int) {
        tank
            ?.receiveFuel(liters)
            ?: run {
                println("not connected")
                throw NotImplementedError("горловина взорвалась: не подключена")
            }
    }
    fun connect(tankIFace : Tank) {
        tank = tankIFace
    }
}