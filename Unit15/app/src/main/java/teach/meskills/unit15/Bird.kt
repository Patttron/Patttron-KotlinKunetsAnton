package teach.meskills.unit15

class Bird(name: String) : Animal(name), CanFly {

    var wings = 2
    var tail = 1

    override fun live() {
        println("This animal $name can live on the air and on the land, have $wings wings and $tail tail")
    }

    override fun canFly() {
        println("This animal can fly")
    }
}