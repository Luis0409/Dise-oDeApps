package mx.edu.utng.appbuscaminas

class Casilla {
    var x: Int = 0
    var y:Int = 0
    var ancho:Int = 0
    var contenido = 0
    var destapado = false
    fun fijarxy(x: Int, y: Int, ancho: Int) {
        this.x = x
        this.y = y
        this.ancho = ancho
    }

    fun dentro(xx: Int, yy: Int): Boolean {
        return if (xx >= this.x && xx <= this.x + ancho && yy >= this.y && yy <= this.y + ancho)
            true
        else
            false
    }
}