package ru.otus.cars

class TazTank : Tank{

    private fun explode() {
        println("TazTank.explode")
    }

    override fun receiveFuel(liters: Int) {
        explode()
    }

    override fun getLevel(): Int {
        return 0
    }

    override fun consume(liters: Int): Int {
        return 0
    }

}