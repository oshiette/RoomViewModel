import java.nio.DoubleBuffer
import kotlin.system.exitProcess

import kotlin.reflect.typeOf

val scan = java.util.Scanner(System.`in`)

const val GRAVITY: Double = 9.8

fun calcEven(digit: Int): Int {
    var sm: Int = 0
    var n = digit
    while (n > 0) {
        if (n % 10 % 2 == 0) {
            sm += n % 10
        }
        n /= 10
    }
    return sm
}

var COURS_USD: Double = 62.60

fun usdToRub(rub: Double): Double {
    // здесь можно обратится к базе данных в которой хранится курс доллара на текущий день
    return rub * COURS_USD
}

fun eurToRub(rub: Double): Double {
    return 1.1
}

fun sum3(a: Int = 1, b: Int = 1, c: Int = 1): Int {

    fun f1(d: Int): Int {
        return d * 5
    }

    return (f1(a) + b + c) * 2
}


abstract class Person(
    var name: String = "",
    var age: Int = 0,
    var race: String = "") {
    //    init {
//        println("Создан новый перонаж:")
//        println(this.info())
//    }
    var heals: Int = 10
    var stamina: Int = 1

    open fun info(): String {
        //println("Персонаж ${this.race} Имя ${this.name} Возраст ${this.age}")
        return "Персонаж ${this.race} Имя ${this.name} Возраст ${this.age}"
    }

    fun add_age(age: Int = 0) {
        this.age += age
    }
}

class Human(name: String = "", age: Int = 0,
            race: String = "Человек",
            var type: String = "Мечник") : Person(name, age, race) {

    override fun info(): String {
        //println(super.info())
        return "Человек: Имя ${this.name} Возраст ${this.age} Класс: ${this.type}"
    }
}

class Elf(name: String = "", age: Int = 0,
          race: String = "Эльф",
          var power: Int = 10) : Person(name, age, race) {

    override fun info(): String {
        //println(super.info())
        return "Эльф: Имя ${this.name} Возраст ${this.age} Волшебство: ${this.power}"
    }
}

class Orc(name: String = "", age: Int = 0,
          race: String = "Орк",
          var Intellect: Int = -100) : Person(name, age, race) {

    override fun info(): String {
        //println(super.info())
        return "Орк: Имя ${this.name} Возраст ${this.age} Интеллект: ${this.Intellect}"
    }
}

fun main() {

    val nameWomen = listOf("Елена", "Анна", "Ольга")
    val nameMan = listOf("Иван", "Антон", "Семён")
    val nameOrc = listOf("Grifor", "Abavarlg", "Gorosh")

    var nameElf = listOf("Legalas", "ashgdjhas", "ahjgsajhas")
    var listTypeHuman = listOf("Мечник", "Лучник", "Ассасин")
    val numberTypeNPC = listOf(1,2,3)

    var listNPC = listOf(Human(name = nameMan.random(),
        age = (17..35).random(), type=listTypeHuman.random()),
        Orc(name = nameOrc.random(), age = (55..135).random()),
        Elf(name = nameMan.random(), age = (150..235).random()))

    println("Создаем 1000 персонажей NPC")
    for (i in 3..10) {
        var number = numberTypeNPC.random()

        when (number) {
            1 -> {
                listNPC = listNPC + Human(name = nameMan.random(),
                    age = (17..35).random(),
                    type=listTypeHuman.random())
            }
            2 -> {
                listNPC = listNPC + Orc(name = nameOrc.random(),
                    age = (55..135).random())
            }
            3 -> {
                listNPC = listNPC + Elf(name = nameElf.random(),
                    age = (150..235).random())
            }
        }
    }
    // Выводим на экран
    for (npc in listNPC) {
        println(npc.info())
    }

    var hls : Int
    print("Введите на сколько увеличился параметр AGE: ")
    try {
        hls = readln().toInt()
        println()
        println(listNPC[0].age)
        listNPC[0].add_age()
        listNPC[0].add_age(hls)
        println(listNPC[0].age)

    }
    catch (e:NumberFormatException){
        println("Введен неверный формат числа дурак.")
    }

}








