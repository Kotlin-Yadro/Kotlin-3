package ru.otus.cars

class Tank {
    fun getContents(): Int {
        println("Current fuel level: $fuelLevel")
        return fuelLevel
    }

    fun receiveFuel(liters: Int) {
        fuelLevel += liters
        println("Added $liters liters of fuel")
    }

    private var fuelLevel: Int = 0
}