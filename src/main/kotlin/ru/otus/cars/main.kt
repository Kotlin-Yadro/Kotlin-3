package ru.otus.cars

import ru.otus.cars.gas_station.GasStation
import ru.otus.cars.gas_station.GasStationImpl

fun main() {
    println("\n===> drive cars...")
    driveCars()
    println("\n===> inner test...")
    innerNestedCheck()
    println("\n===> garage make...")
    garageMake()
    println("\n===> model special...")
    println("\n===> get equipment...")
    getEquipment()
    println("\n===> get color...")
    getColor()
    println("\n===> tech checks...")
    techChecks()
    println("\n===> Taz...")
    println(Taz.color)
    // */
    println("\n===> Refueling of cars")
    refuelingCars(GasStationImpl())
    println("\n===> Refueling list of cars")
    refuelingCarList(GasStationImpl())
}

fun driveCars() {
    val vaz1 = Togliatti.buildCar(Vaz2107, Car.Plates("123", 77))
    val vaz2 = Togliatti.buildCar(Vaz2108, Car.Plates("321", 78))

    println("Экземпляры класса имеют разное внутреннее состояние:")
    vaz1.wheelToRight(10)
    println(vaz1.toString()) // Выводит 10 и случайную скорость
    vaz2.wheelToLeft(20)
    println(vaz2.toString()) // Выводит -20 и случайную скорость
}

fun innerNestedCheck() {
    val vaz = Vaz2107.build(Car.Plates("123", 77))
    val output = vaz.VazOutput() // Создаем новый объект ИЗ ЭКЗЕМПЛЯРА МАШИНЫ

    println("Скорость до проверки: ${output.getCurrentSpeed()}") // Выводит 0
    Vaz2107.test(vaz) // Газуем...
    println("Скорость после проверки: ${output.getCurrentSpeed()}") // Выводит случайную скорость
}

fun garageMake() {
    val maker = "Дядя Вася"
    val garage = object : CarFactory {
        override fun buildCar(builder: CarBuilder, plates: Car.Plates): Car {
            println("Запил Жигулей у: $maker...")
            println("Машину не проверяем... и в продакшн...")
            return builder.build(plates)
        }
    }

    val vaz = garage.buildCar(Vaz2107, Car.Plates("500", 50))
    println(vaz.toString())
}

fun getEquipment() {
    val cars = listOf(
        Vaz2107.build(Car.Plates("123", 77)),
        Vaz2108.build(Car.Plates("321", 78))
    )

    cars.forEach { car ->
        println("Оборудование: ${car.getEquipment()}")
    }
}

fun getColor() {
    val cars = listOf(
        Vaz2107.build(Car.Plates("123", 77)),
        Vaz2108.build(Car.Plates("321", 78))
    )

    cars.forEach { car ->
        println("Цвет: ${car.color}")
    }
}

fun techChecks() {
    val vaz1 = Vaz2107.build(Car.Plates("123", 77))
    val vaz2 = Vaz2108.build(Car.Plates("321", 78))

    repairEngine(vaz1)
    repairEngine(vaz2)
}

fun repairEngine(car: VazPlatform) {
    // Проверяем тип двигателя
    // В зависимости от типа двигателя выполняем разные действия
    // when обеспечивает обход всех вариантов перечисления
    when (car.engine) {
        is VazEngine.LADA_2107 -> println("Чистка карбюратора у двигателя объемом ${car.engine.volume} куб.см у машины $car")
        is VazEngine.SAMARA_2108 -> println("Угол зажигания у двигателя объемом ${car.engine.volume} куб.см у машины $car")
    }
}

fun refuelingCars(gasStation: GasStation) {
    val vaz1 = Vaz2107.build(Car.Plates("123", 77))
    val vaz2 = Vaz2108.build(Car.Plates("321", 78))
    println("\n===> Refueling of Vaz2107")
    gasStation.refuelCar(vaz1, 15)
    println("\n===> Refueling of Vaz2108")
    gasStation.refuelCar(vaz2, 15)
    println("\n===> Refueling 100 litres of Vaz2107")
    gasStation.refuelCar(vaz1, 100)
    println("\n===> Refueling of Taz")
    gasStation.refuelCar(Taz, 1)
}

fun refuelingCarList(gasStation: GasStation) {
    /*listOf(
        Vaz2107.build(Car.Plates("123", 77)) to 15,
        Vaz2108.build(Car.Plates("321", 78)) to 15,
        Vaz2107.build(Car.Plates("123", 77)) to 115,
        Taz to 1,
    ).let {
        println("\n===> Refueling of Vaz2107, Vaz2108, overflow of Vaz2107, Taz")
        gasStation.refuelCar(it)
    }// */
    val cars = listOf(
        Vaz2107.build(Car.Plates("123", 77)),
        Vaz2108.build(Car.Plates("321", 78)),
        Vaz2107.build(Car.Plates("123", 77)).also { // Предварительно заправим, чтоб увидеть переполнение
            gasStation.refuelCar(it, 20)
        },
        Taz,
    ).let {
        println("\n===> Refueling of Vaz2107, Vaz2108, Taz")
        it.print()
        gasStation.refuelCar(it, 25)
        it.print()
    }
}

fun List<Car>.print() {
    forEach {
        println(it)
    }
}
