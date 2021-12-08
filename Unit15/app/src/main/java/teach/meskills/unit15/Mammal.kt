package teach.meskills.unit15

open class Mammal(name: String): Animal(name), DrinkMilk {
    var feedsMilk = true
    override fun live() {
        println("This animal $name live on the land")
    }

    override fun drinkMilk() {
        println("This animals drink milk")
    }
}