package ru.otus.cars

class PetrolStation: FuelStation {
    override fun fillTheTankOf(car: Car) {
        val tankMouth = car.tankMouth
        if (tankMouth is PetrolMouth) {
            println("Заправляю машину $car бензином")
            val needed = tankMouth.maxCapacity - tankMouth.capacity
            tankMouth.open()
            try {
                tankMouth.fuelPetrol(needed)
            } catch (e: IllegalStateException) {
                println("И че оно бахнуло? Я же всего-то $needed литров туда залил")
            }
            tankMouth.close()
        } else {
            println("Че ты сюда пригнал свой $car? Мы только бензин заливаем")
        }
    }
}