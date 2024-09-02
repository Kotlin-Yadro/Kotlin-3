package ru.otus.cars

class VazTank: Tank {

    private var fuelLevel = 0

    override fun receiveFuel(liters: Int) {
        synchronized(this) {
            fuelLevel += liters
        }
    }

    override fun getLevel(): Int {
        return fuelLevel
    }

    override fun consume(liters: Int): Int {
        synchronized(this) {
            if (fuelLevel > liters) {
                fuelLevel -= liters
                return liters
            } else {
                val rFuelLevel = fuelLevel
                fuelLevel = 0
                return rFuelLevel
            }
        }
    }
}