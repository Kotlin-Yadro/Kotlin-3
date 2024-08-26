package ru.otus.cars

import java.lang.IllegalStateException

class ExperenciedDriver(private val lpgStation: LpgStation, private val petrolStation: PetrolStation): Driver<Car> {
    override fun drive(car: Car) {
        when (car) {
            is Vaz2107 -> {
                println("На семерочке надо drdrdrdr")
                car.drdrdrdrdr()
            }
            is Vaz2108 -> {
                println("На восьмерочке надо zhzhzhzh")
                car.zhzhzhzh()

            }
            is Taz -> {
                println("На тазе ничего не надо")
            }
            else -> {
                println("Я такую чуду-юду впервые вижу")
                return
            }
        }
        println("Надо заправиться")
        when (car) {
            is Vaz2107 -> {
                println("Семерка на газу, ее повезем на газовую заправку")
                lpgStation.fillTheTankOf(car)
            }
            is Vaz2108 -> {
                println("Восьмка на бензине, будем искать 92й")
                petrolStation.fillTheTankOf(car)
            }
            is Taz -> {
                println("Тазик в покое оставьте")
            }
            else -> {
                throw IllegalStateException("Мы тут не можем оказаться, должны были словить return раньше")
            }
        }
    }
}