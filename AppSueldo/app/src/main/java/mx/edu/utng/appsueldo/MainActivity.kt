package mx.edu.utng.appsueldo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener() {
            var tiempo : Double = etxTiempo.text.toString().toDouble()
            var salario : Double
            var sueldo : Double
            var horasextras : Double = tiempo - 40
            var mensaje : String = ""
            var IST : Double

            if (tiempo==0.0) {
                mensaje = "Usted a ingresado un dato incorrecto"
            } else{
                if (rbtBase.isChecked) {
                    IST = 0.075
                    if (tiempo <40) {
                        mensaje = "Usted no ha trabajado las horas obligatorias"
                        txvDetalles.text = "Detalles: "
                    } else {
                        if (horasextras>0) {
                            sueldo = 3000 + (horasextras * 150)
                            salario = sueldo - (sueldo * IST)
                            txvDetalles.text = "Sueldo==> ${sueldo}\n" +
                                    "Salario==> ${salario}"
                        } else {
                            sueldo = 3000.0
                            salario = sueldo - (sueldo * IST)
                            txvDetalles.text = "Sueldo==> ${sueldo}\n" +
                                    "Salario==> ${salario}"
                        }
                        mensaje = "Calculos realizados"
                    }
                } else if (rbtHoras.isChecked) {
                    IST = 0.095
                    if (horasextras>0) {
                        sueldo = (40.0 * 60) + (horasextras * 120)
                        salario = sueldo - (sueldo * IST)
                        txvDetalles.text = "Sueldo==> ${sueldo}\n" +
                                "Salario==> ${salario}"
                    } else {
                        sueldo = tiempo * 120
                        salario = sueldo - (sueldo * IST)
                        txvDetalles.text = "Sueldo==> ${sueldo}\n" +
                                "Salario==> ${salario}"
                    }
                    mensaje = "Calculos realizados"
                } else {
                    mensaje = "No se realizo ningun calculo"
                }
            }
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
        }
    }
}
