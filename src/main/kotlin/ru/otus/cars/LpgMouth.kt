package ru.otus.cars

open class LpgMouth(val maxCapacity: Int): TankMouth() {
    var capacity = 0
        private set
    fun fuelLpg(liters: Int) {
        if (!isOpened) {
            throw IllegalStateException("Бак закрыт, не могу загрузить газ")
        }
        capacity += liters
        if (capacity >= 2 * maxCapacity) { // я понятия не имею, как работают газовые баллоны в машинах,
            capacity = 0 // поэтому в моей вселенной их можно перекачать, но не больше, чем в два раза,
            // иначе
            throw IllegalArgumentException("Бак переполнен, газ взорвался")
        }
    }
}