package ru.otus.cars

/*
* Gas station
* */
class GasStation {
    companion object {
        /**
         * Функция заправки, на вход получает машину
         * в зависимости от того, какая на машине горловина - использует разный метод заправки
         * заправка должна быть безопасной: если бак взорвался - должна обработать исключение
         */
        fun doLoadFuel(car: Car, liters: Int) {
            try {
                when (val mouth = car.tankMouth) {
                    is PetrolMouth -> {
                        println("Loading petrol to  $car for $liters l")
                        mouth.open()
                        mouth.loadPetrol(liters)
                        mouth.close()
                        println("$car loaded by $liters l.")
                    }
                    is LpgMount -> {
                        println("Loading $car to $liters l.")
                        mouth.open()
                        mouth.loadNaturalGas(liters)
                        mouth.close()
                        println("Car $car loaded with naturalgas for $liters l.")
                    }
                }
            } catch (e: Throwable) {
                println("error fuelling $car : $e")
            }
        }

        fun doLoadFuel(cars: List<Car>, liters: Int) {
            for (car in cars) {
                doLoadFuel(car, liters)
            }
        }
    }
}