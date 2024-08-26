package ru.otus.cars

class LpgStation: FuelStation {
    override fun fillTheTankOf(car: Car) {
        val tankMouth = car.tankMouth
        if (tankMouth is LpgMouth) {
            println("Заправляю машину $car газом")
            val needed = tankMouth.maxCapacity - tankMouth.capacity
            tankMouth.open()
            try {
                tankMouth.fuelLpg(needed)
            } catch (e: IllegalArgumentException) {
                println("И че оно бахнуло? Я же всего-то $needed литров туда заправил")
            }
            tankMouth.close()
        } else {
            println("Че ты сюда пригнал свой $car? Мы только газ заправляем")
        }
    }
}