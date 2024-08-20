package ru.otus.cars

object BangFuelStation : FuelStation {
    override fun refuel(car: Car) {
        try {
            when(car.tankMouth) {
                is VazPlatform.PetrolMouth -> car.tankMouth.fuel(19)
                is VazPlatform.LpgMouth -> car.tankMouth.fuel(30)
                is Taz.TazMouth -> car.tankMouth.fuel(1)
            }
        } catch (exc: Exception) {
            println("We have a problem: ${exc.message}")
        }
    }
}