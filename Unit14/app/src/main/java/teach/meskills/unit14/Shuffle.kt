package teach.meskills.unit14

class Shuffle(var size: Int) {
    fun doShuffle(): Int {
        return (Math.random() * size).toInt()
    }
}