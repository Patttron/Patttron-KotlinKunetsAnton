package teach.meskills.unit15

class FlyingFish(name: String): Animal(name),CanSwim,CanFly {
    override fun live(){
        println("This animal $name live under the water")
    }

    override fun canFly() {
        println("This animal can fly")
    }

    override fun canSwim() {
        println("This animal can swim")
    }

}