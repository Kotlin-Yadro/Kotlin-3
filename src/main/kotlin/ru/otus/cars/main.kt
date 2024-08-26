package ru.otus.cars

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
    println("\n===> Emelyanov Vitaliy homework")
    totalTest()
}

fun totalTest() {
    val vaz2108 = Togliatti.buildCar(Vaz2108, Car.Plates("111", 11)) as Vaz2108
    val vaz2107 = Togliatti.buildCar(Vaz2107, Car.Plates("112", 12)) as Vaz2107
    val cars = listOf(
        vaz2108,
        vaz2107,
        Taz
    )
    val lpgStation = LpgStation()
    val petrolStation = PetrolStation()
    val stations = listOf(lpgStation, petrolStation)
    val driverCanOnlyDriveVaz2107 = UnexperenciedDriver<Vaz2107>(
        {
            println("Неопытный водитель ведет семерку")
            it.drdrdrdrdr()
        },
        {
            println("Неопытный водитель заправляет семерку, заправку выбирает наугад")
            stations.random().fillTheTankOf(it)
        }
    )
    val driverCanOnlyDriveVaz2108 = UnexperenciedDriver<Vaz2108>(
        {
            println("Неопытный водитель ведет восьмерку")
            it.zhzhzhzh()
        },
        {
            println("Неопытный водитель заправляет восьмерку, заправку выбирает наугад")
            stations.random().fillTheTankOf(it)
        }
    )
    val driverCanOnlyDriveTaz = UnexperenciedDriver<Taz>(
        {
            println("Я катаюсь на тазике с крысой, уууу") // это прям очень неопытный водитель
        },
        {
            stations.random().fillTheTankOf(it)
        }
    )
    // опытный водитель знает, где можно заправиться
    val experenciedDriver = ExperenciedDriver(lpgStation, petrolStation)
    driverCanOnlyDriveVaz2107.drive(vaz2107)
    println()
    driverCanOnlyDriveVaz2108.drive(vaz2108)
    println()
    driverCanOnlyDriveTaz.drive(Taz)
    println()
    for (car in cars) {
        experenciedDriver.drive(car)
        println()
    }
    // в конце дня менеджер заправляет все машины разом (на всех заправках)
    for (station in stations) {
        station.fillTheTankOf(cars)
        println()
    }
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