fun main() {
    println("cargando juego...")
    Thread.sleep(20000)
    val rm = ReproductorMidi("pugnodollari.mid")
    var frutas = listOf(
        "manzana", "pera", "banana", "uva", "naranja",
        "fresa", "kiwi", "melon", "sandia", "piña",
        "mango", "papaya", "cereza", "ciruela", "higo",
        "arandano", "frambuesa", "grosella", "limon", "maracuya"
    )
    var palabraAleatoria = frutas.random()
    var fallos = 0

    var pedirPalabra = ""
    for (i in 1..palabraAleatoria.length) {
        pedirPalabra += "_"
    }

    while (fallos != 7 && pedirPalabra != palabraAleatoria) {
        println("Introduzca una letra: ")
        var letra = readln()
        if (letra !in palabraAleatoria) {
            fallos++
            DibujoAhorcado.dibujar(fallos)
            println("Incorrecto.Fallos restantes: ${7-fallos}")
        } else if (letra in pedirPalabra) {
            fallos++
            DibujoAhorcado.dibujar(fallos)
            println("Incorrecto.Fallos restantes: ${7-fallos}")
            println("****ERROR****")
            println("La letra está repetida")

        } else {
            var descubierto = ""
            for (i in palabraAleatoria.indices) {
                if (letra[0] == palabraAleatoria[i]) {
                    descubierto += letra

                } else {
                    descubierto += pedirPalabra[i]
                }
            }
            pedirPalabra = descubierto
            println("****ACIERTO****")
        }
        println("Lo descubierto de la palabra: ")
        println(pedirPalabra)

    }
    if (pedirPalabra == palabraAleatoria) {
        println("Has ganado")
    } else {
        println("Has perdido")
    }

    //1º pedir una letra mientras los fallos no sean siete o no se adivine paLabra
    //2º cada vez que se haga un fallo debemos sumar un fallo y llamar a dibujoAhorcado.dibujar
    //0 en algun lado guardar la palabra en las letras descubiertas e imprimirlas despues de cada acierto
    //3º en caso de acierto debemos descubrir la letra en pedirPalabra,tienes que buscar la posicion en la plabra aleatoria y si las encuentras debes sustiuir en la misma posicion de  pedir palabra cambiar por letra
}
