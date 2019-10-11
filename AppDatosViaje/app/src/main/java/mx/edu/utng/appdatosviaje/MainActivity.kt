package mx.edu.utng.appdatosviaje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCal.setOnClickListener(){
            val km = txvKm.text.toString().toInt()
            val gas = txvGas.text.toString().toInt()
            val gasto = txvGasto.text.toString().toDouble()
            val date = txvTiempo.text.toString().toDouble()

            val km1 = ((gasto / km)*100)
            val km12 = (((gasto/gas)/km) *100)
            val km2 = (gasto/km)
            val km22 = ((gasto/gas)/km)
            val vel = (km/date)

            txvCon.text = ("Por cada 100 km se gasto ${km1.toString()} litros y $ ${km12.toString()} pesos")
            txvConKm.text= ("Por cada kilometro se gasto ${km2.toString()} litros y $ ${km22.toString()} pesos")
            txvVel.text= ("Velocidad: ${vel.toString()} km/h")
        }
    }
}
