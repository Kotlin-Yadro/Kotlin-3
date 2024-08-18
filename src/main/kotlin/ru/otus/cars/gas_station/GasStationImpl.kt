package ru.otus.cars.gas_station

import ru.otus.cars.Car
import ru.otus.cars.fuel_system.Tank

class GasStationImpl : GasStation {

    override fun refuelCar(car: Car, litres: Int): Boolean {
        var isOpen = false
        val tankMouth = car.tank.tankMouth
        try {
            tankMouth.open()
            isOpen = true
            if (tankMouth is Tank) {
                val remains = tankMouth.receiveFuel(litres)
                println(
                    "Заправка ${car.javaClass.simpleName} топлива:${tankMouth.fuelType} прошла успешно" +
                            if (remains != 0) " но не вошло $remains литров"
                            else ""
                )
                return true
            }
        } catch (e: NotImplementedError) {
            println("Ошибка заправки ${car.javaClass.simpleName} ${e.message}")
        } finally {
            if (isOpen) {
                tankMouth.close()
            }
        }
        return false
    }

    override fun refuelCar(tasks: List<Pair<Car, Int>>) = tasks.forEach {
        refuelCar(it.first, it.second)
    }

    override fun refuelCar(cars: List<Car>, litres: Int) = cars.forEach {
        refuelCar(it, litres)
    }
}