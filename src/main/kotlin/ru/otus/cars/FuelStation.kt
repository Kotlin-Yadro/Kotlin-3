package ru.otus.cars

class FuelStation {
    companion object {
        fun fuelCar(car: Car, liters: Int) {
            try {
                when (car.tankMouth) {
                    is TankMouth.GasMouth -> {
                        if (!car.tankMouth.isOpen()) car.tankMouth.open()
                        car.tankMouth.receiveFuel(liters)
                        car.tankMouth.close()
                    }
                    is TankMouth.PetrolMouth -> {
                        if (!car.tankMouth.isOpen()) car.tankMouth.open()
                        car.tankMouth.receiveFuel(liters)
                        car.tankMouth.close()
                    }
                    is TankMouth.TazMouth -> {
                        if (!car.tankMouth.isOpen()) car.tankMouth.open()
                        car.tankMouth.receiveFuel(liters)
                        car.tankMouth.close()
                    }
                }
            } catch (e:  Throwable) {
                println("Что-то не так с $car: $e")
            }
        }

        fun fuelCar(cars: List<Car>, liters: Int) {
            for (car in cars) {
                fuelCar(car, liters)
            }
        }
    }
}