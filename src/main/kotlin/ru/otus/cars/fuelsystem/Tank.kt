package ru.otus.cars.fuelsystem

import ru.otus.cars.CarOutput
import ru.otus.cars.fuelsystem.Fuel
import kotlin.math.min

abstract class Tank(
    private val tankMouth: TankMouth,
    private val capacity: Int = 100,
) : CarOutput {
    private var fuelVolume: Int = 0

    override fun getFuelVolume(): Int = fuelVolume

    fun addFuel(type: Fuel, liters: Int) {
        if (tankMouth.fuelType() != type) {
            throw ExplosiveException(tankMouth.fuelType())
        }
        fuelVolume = min(fuelVolume + liters, capacity)
        println("addFuel: \'${tankMouth.fuelType()}\' fuel volume: $fuelVolume")
    }

    override fun toString(): String {
        return "fuel (type: ${tankMouth.fuelType()}, volume: $fuelVolume)"
    }
}