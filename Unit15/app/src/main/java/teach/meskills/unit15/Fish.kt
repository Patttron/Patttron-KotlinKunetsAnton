package teach.meskills.unit15

class Fish(name: String): Animal(name), CanSwim {
    override fun live(){
        println("This animals $name live under the water")
    }

    override fun canSwim() {
        println("This animals can swim")
    }
}