package ru.otus.cars

sealed class TankMouth {

    fun open(liters: Int, tank: Tank) {
        tank.receiveFuel(liters)
    }

    fun close() {
        TODO()
    }
}

internal class PetrolMouth(private val tank: Tank) : TankMouth() {

    fun fuelPetrol(liters: Int) {
        open(liters, tank)
    }
}

internal class LpgMouth(private val tank: Tank) : TankMouth() {

    fun fuelLpg(liters: Int) {
        open(liters, tank)
    }
}