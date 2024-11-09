package com.example.todoapp
import kotlin.random.Random
import kotlin.math.pow

class Kotlin_Bucles_Avanzado {
    fun main() {
        while (true) {
            println("\n=== Menú de Ejercicios Kotlin ===")
            println("1. Serie Fibonacci")
            println("2. Calcular Factorial")
            println("3. Sumar Dígitos")
            println("4. Números Primos en un Rango")
            println("5. Tablas de Multiplicar con Formato")
            println("6. Juego de Adivinanza")
            println("7. Triángulo de Asteriscos")
            println("8. Contar Frecuencia de Caracteres")
            println("9. Tabla de Potencias de 2")
            println("10. Máximo y Mínimo de una Lista")
            println("11. Cuadrado de Asteriscos")
            println("12. Salir")
            println("Seleccione una opción:")

            when (readLine()?.toIntOrNull()) {
                1 -> {
                    print("Introduce el límite para la serie Fibonacci: ")
                    val limite = readLine()?.toIntOrNull() ?: 0
                    serieFibonacci(limite)
                }
                2 -> {
                    print("Introduce el número para calcular el factorial: ")
                    val numero = readLine()?.toIntOrNull() ?: 0
                    println("El factorial de $numero es: ${calcularFactorial(numero)}")
                }
                3 -> {
                    print("Introduce un número para sumar sus dígitos: ")
                    val numero = readLine()?.toIntOrNull() ?: 0
                    println("La suma de los dígitos es: ${sumarDigitos(numero)}")
                }
                4 -> {
                    print("Introduce el límite para encontrar números primos: ")
                    val limite = readLine()?.toIntOrNull() ?: 0
                    numerosPrimosEnRango(limite)
                }
                5 -> tablasMultiplicarConFormato()
                6 -> jugarAdivinanza()
                7 -> {
                    print("Introduce la altura del triángulo de asteriscos: ")
                    val altura = readLine()?.toIntOrNull() ?: 0
                    trianguloAsteriscos(altura)
                }
                8 -> {
                    print("Introduce una cadena para contar la frecuencia de caracteres: ")
                    val cadena = readLine() ?: ""
                    println("Frecuencia de caracteres: ${contarFrecuenciaCaracteres(cadena)}")
                }
                9 -> tablaPotencias()
                10 -> {
                    print("Introduce los números separados por comas: ")
                    val numeros = readLine()?.split(",")?.mapNotNull { it.trim().toIntOrNull() } ?: listOf()
                    val (maximo, minimo) = maximoYMinimo(numeros)
                    println("Máximo: $maximo, Mínimo: $minimo")
                }
                11 -> {
                    print("Introduce el tamaño del cuadrado de asteriscos: ")
                    val tamano = readLine()?.toIntOrNull() ?: 0
                    cuadradoAsteriscos(tamano)
                }
                12 -> {
                    println("Saliendo del programa.")
                    break
                }
                else -> println("Opción no válida, intenta de nuevo.")
            }
        }
    }

    //Ejercicio 1
    fun serieFibonacci(limite: Int) {
        var num1 = 0
        var num2 = 1
        while (num1 <= limite) {
            print("$num1 ")
            val siguiente = num1 + num2
            num1 = num2
            num2 = siguiente
        }
        println()
    }

    //Ejercicio 2
    fun calcularFactorial(numero: Int): Int {
        var factorial = 1
        for (i in 1..numero) {
            factorial *= i
        }
        return factorial
    }

    //Ejercicio 3
    fun sumarDigitos(numero: Int): Int {
        var num = numero
        var suma = 0
        do {
            suma += num % 10
            num /= 10
        } while (num > 0)
        return suma
    }

    //Ejercicio 4
    fun numerosPrimosEnRango(limite: Int) {
        for (num in 2..limite) {
            var esPrimo = true
            for (i in 2 until num) {
                if (num % i == 0) {
                    esPrimo = false
                    break
                }
            }
            if (esPrimo) {
                print("$num ")
            }
        }
        println()
    }

    //Ejercicio 5
    fun tablasMultiplicarConFormato() {
        for (i in 1..10) {
            for (j in 1..10) {
                print(String.format("%2d x %2d = %3d   ", i, j, i * j))
            }
            println()
        }
    }

    //Ejercicio 6
    fun jugarAdivinanza() {
        val numeroAleatorio = Random.nextInt(1, 101)
        var adivinanza: Int = 0;
        do {
            print("Adivina el número entre 1 y 100: ")
            adivinanza = readLine()?.toIntOrNull() ?: continue
            when {
                adivinanza < numeroAleatorio -> println("Demasiado bajo")
                adivinanza > numeroAleatorio -> println("Demasiado alto")
                else -> println("¡Correcto!")
            }
        } while (adivinanza != numeroAleatorio)
    }

    //Ejercicio 7
    fun trianguloAsteriscos(altura: Int) {
        for (i in 1..altura) {
            println(" ".repeat(altura - i) + "*".repeat(2 * i - 1))
        }
    }

    //Ejercicio 8
    fun contarFrecuenciaCaracteres(cadena: String): Map<Char, Int> {
        val frecuencia = mutableMapOf<Char, Int>()
        for (caracter in cadena) {
            frecuencia[caracter] = frecuencia.getOrDefault(caracter, 0) + 1
        }
        return frecuencia
    }

    //Ejercicio 9
    fun tablaPotencias() {
        for (i in 0..10) {
            println("2^$i = ${2.0.pow(i).toInt()}")
        }
    }

    //Ejercicio 10
    fun maximoYMinimo(numeros: List<Int>): Pair<Int, Int> {
        var maximo = numeros[0]
        var minimo = numeros[0]
        for (numero in numeros) {
            if (numero > maximo) maximo = numero
            if (numero < minimo) minimo = numero
        }
        return Pair(maximo, minimo)
    }

    //Ejercicio 11
    fun cuadradoAsteriscos(tamanho: Int) {
        for (i in 1..tamanho) {
            println("*".repeat(tamanho))
        }
    }
}