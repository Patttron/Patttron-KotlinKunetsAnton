package teach.meskills.unit15


fun main(){
    val bird = Bird("nightingale")
    bird.live()
    bird.canFly()
    val fish = Fish("Vobla")
    fish.live()
    fish.canSwim()
    val strangeFish = FlyingFish("Exocoetidae")
    strangeFish.live()
    strangeFish.canFly()
    strangeFish.canSwim()
    val mammal = Mammal("Elephant")
    mammal.live()
    mammal.drinkMilk()
}