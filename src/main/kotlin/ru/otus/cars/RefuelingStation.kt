package ru.otus.cars

/*
* Класс заправки
* */
class RefuelingStation {
    companion object {
        /**
         * Функция заправки, на вход получает машину
         * в зависимости от того, какая на машине горловина - использует разный метод заправки
         * заправка должна быть безопасной: если бак взорвался - должна обработать исключение
         */
        fun refuelCar(car: Car, liters: Int) {
            try {
                when (val mouth = car.tankMouth) {
                    is LpgMouth -> {
                        println("Заправляем газом машину $car на $liters литров.")
                        mouth.open()
                        println("Заправка....")
                        mouth.fuelLpg(liters)
                        mouth.close()
                        println("Машина $car заправлена газом на $liters литров.")
                    }
                    is PetrolMouth -> {
                        println("Заправляем бензином машину $car на $liters литров.")
                        mouth.open()
                        println("Заправка....")
                        mouth.fuelPetrol(liters)
                        mouth.close()
                        println("Машина $car заправлена бензином на $liters литров.")
                    }
                }
            } catch (e: Throwable) {
                println("Машина $car не заправлена. Произошла ошибка: $e")
            }
        }

        fun refuelCar(cars: List<Car>, liters: Int) {
            for (car in cars) {
                refuelCar(car, liters)
            }
        }
    }
}