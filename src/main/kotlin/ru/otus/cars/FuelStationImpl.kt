package ru.otus.cars

class FuelStationImpl: FuelStation {
    override fun refuelCar(car: Car, liters: Int) {
        val mouth = car.tankMouth
        try {
            mouth.open()
            mouth.receiveFuel(liters)
            println("Refueling ${car.javaClass.simpleName} with fuel:${mouth.fuelType} was successful")
        } catch (ex: NotImplementedError) {
            println("Error during fueling of ${car.javaClass.simpleName}: ${ex.message}")
        } finally {
            if (mouth.isOpened())
                mouth.close()
        }
    }

    override fun refuelCar(cars: List<Car>, liters: Int) = cars.forEach {
        refuelCar(it, liters)
    }
}