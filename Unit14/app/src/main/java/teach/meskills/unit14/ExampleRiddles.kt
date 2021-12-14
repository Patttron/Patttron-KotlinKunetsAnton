package teach.meskills.unit14

class ExampleRiddles {
    companion object {
        fun arrayRiddles(): Map<Int, String> {
            return mapOf(
                0 to "Жёлтый шар, слегка горчит.\n" +
                        "Летом жажду утолит.",
                1 to "Этот фрукт на вкус хорош\n" +
                        "И на лампочку похож.",
                2 to "Сто одежек -\n" +
                        "Все без застежек",
                3 to "В этот гладкий коробок\n" +
                        "Бронзового цвета\n" +
                        "Спрятан маленький дубок\n" +
                        "Будущего лета."
            )
        }

        fun arrayAnswers(): Map<Int, String> {
            return mapOf(
                0 to "Грейпфрут",
                1 to "Груша",
                2 to "Капуста",
                3 to "Желудь"
            )
        }
    }
}
