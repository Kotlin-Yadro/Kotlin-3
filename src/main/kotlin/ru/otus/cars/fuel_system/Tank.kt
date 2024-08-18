package ru.otus.cars.fuel_system

import ru.otus.cars.CarOutput
import kotlin.math.max
import kotlin.math.min

abstract class Tank(
    private var liters: Int,
    private val capacity: Int = Int.MAX_VALUE,
    val tankMouth: TankMouth,
) : CarOutput {

    fun receiveFuel(liters: Int): Int {
        val remains = max(this.liters + liters - capacity, 0)
        this.liters = min(this.liters + liters, capacity)
        return remains
    }

    override fun getFuelContents() = liters

    override fun toString() =
        "tank capacity $capacity, The tank has $liters liters of ${tankMouth.fuelType}"
}