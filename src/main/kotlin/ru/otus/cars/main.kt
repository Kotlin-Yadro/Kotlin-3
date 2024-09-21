package ru.otus.cars

import javax.print.attribute.SetOfIntegerSyntax
import ru.otus.cars.Vaz2107
import ru.otus.cars.Vaz2107.VazOutput
import ru.otus.cars.Vaz2108
import kotlin.random.Random

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

    part2()
    part21()
}
fun part2(){
    println("Заправляем ТАЗ:")
    val gs = GasStation()
    gs.loadCar(Taz, 10)
}
fun part21(){
    println("Заправляем коллекцию машин")
    val gs = GasStation()
    val vaz1 = Vaz2107.build(Car.Plates("123", 77), Tank.FuelType.FTLPG)
    val vaz2 = Vaz2108.build(Car.Plates("321", 88), Tank.FuelType.FTPETROL)

    val cars = listOf(vaz1, vaz2, Taz)
    for(c in cars) {
        try {
            println("Уровень топлива до: " + c.carOutput.getFuelContents())
        }
        catch(e: NotImplementedError){
            println("Exception: " + e.message)
        }
        try {
            gs.loadCar(c as Car, Random.nextInt(0,20))
        }
        catch(e: NotImplementedError){
            println("Exception: " + e.message)
        }
        try {
            println("Уровень топлива после: " + (c as Car).carOutput.getFuelContents().toString())
        }
        catch(e: NotImplementedError){
            println("Exception: " + e.message)
        }
    }
}
fun driveCars() {
    val vaz1 = Togliatti.buildCar(Vaz2107, Car.Plates("123", 77), Tank.FuelType.FTLPG)
    val vaz2 = Togliatti.buildCar(Vaz2108, Car.Plates("321", 78), Tank.FuelType.FTPETROL)

    println("Экземпляры класса имеют разное внутреннее состояние:")
    vaz1.wheelToRight(10)
    vaz1.tank.receiveFuel(10)
    vaz2.wheelToLeft(20)
    vaz2.tank.receiveFuel(15)
    println(vaz1.toString()) // Выводит 10 и случайную скорость
    println(vaz2.toString()) // Выводит -20 и случайную скорость
}

fun innerNestedCheck() {
    val vaz = Vaz2107.build(Car.Plates("123", 77), Tank.FuelType.FTLPG)
    val output = vaz.VazOutput() // Создаем новый объект ИЗ ЭКЗЕМПЛЯРА МАШИНЫ

    println("Скорость до проверки: ${output.getCurrentSpeed()}") // Выводит 0
    Vaz2107.test(vaz) // Газуем...
    println("Скорость после проверки: ${output.getCurrentSpeed()}") // Выводит случайную скорость
    println("Уровень топлива: ${output.getFuelContents()}") // Выводит уровень топлива
}

fun garageMake() {
    val maker = "Дядя Вася"
    val garage = object : CarFactory {
        override fun buildCar(builder: CarBuilder, plates: Car.Plates, type: Tank.FuelType): Car {
            println("Запил Жигулей у: $maker...")
            println("Машину не проверяем... и в продакшн...")
            return builder.build(plates, type)
        }
    }

    val vaz = garage.buildCar(Vaz2107, Car.Plates("500", 50), Tank.FuelType.FTDISEL)
    println(vaz.toString())
}

fun getEquipment() {
    val cars = listOf(
        Vaz2107.build(Car.Plates("123", 77), Tank.FuelType.FTLPG),
        Vaz2108.build(Car.Plates("321", 78), Tank.FuelType.FTPETROL)
    )

    cars.forEach { car ->
        println("Оборудование: ${car.getEquipment()}")
    }
}

fun getColor() {
    val cars = listOf(
        Vaz2107.build(Car.Plates("123", 77), Tank.FuelType.FTLPG),
        Vaz2108.build(Car.Plates("321", 78), Tank.FuelType.FTPETROL)
    )

    cars.forEach { car ->
        println("Цвет: ${car.color}")
    }
}

fun techChecks() {
    val vaz1 = Vaz2107.build(Car.Plates("123", 77), Tank.FuelType.FTLPG)
    val vaz2 = Vaz2108.build(Car.Plates("321", 78), Tank.FuelType.FTPETROL)

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