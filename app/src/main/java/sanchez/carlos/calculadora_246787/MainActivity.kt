package sanchez.carlos.calculadora_246787

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var btn0 : Button
    lateinit var btn1 : Button
    lateinit var btn2 : Button
    lateinit var btn3 : Button
    lateinit var btn4 : Button
    lateinit var btn5 : Button
    lateinit var btn6 : Button
    lateinit var btn7 : Button
    lateinit var btn8 : Button
    lateinit var btn9 : Button

    lateinit var btnSumar : Button
    lateinit var btnRestar : Button
    lateinit var btnMultiplicar : Button
    lateinit var btnDividir : Button

    lateinit var  btnBorrar : Button
    lateinit var  btnIgual : Button
    lateinit var  tvResultado : TextView

    var operacionActual = ""
    var resultadoActual : Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // variables
        btn0 = findViewById(R.id.numZero)
        btn1 = findViewById(R.id.num1)
        btn2 = findViewById(R.id.num2)
        btn3 = findViewById(R.id.num3)
        btn4 = findViewById(R.id.num4)
        btn5 = findViewById(R.id.num5)
        btn6 = findViewById(R.id.num6)
        btn7 = findViewById(R.id.num7)
        btn8 = findViewById(R.id.num8)
        btn9 = findViewById(R.id.num9)

        btnSumar = findViewById(R.id.sumar)
        btnRestar = findViewById(R.id.restar)
        btnMultiplicar = findViewById(R.id.multiplicar)
        btnDividir = findViewById(R.id.dividir)

        btnBorrar = findViewById(R.id.borrar)
        btnIgual = findViewById(R.id.igual)

        tvResultado = findViewById(R.id.tvRes)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val btns = listOf(btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9)
        btns.forEachIndexed {
            index, button ->
                button.setOnClickListener {
                    manejarNumero(index)
                }
        }
        
        btnSumar.setOnClickListener {
            operacionActual = "suma"
            resultadoActual = tvResultado.text.toString().toIntOrNull()
            tvResultado.text = "0"
        }

        btnRestar.setOnClickListener {
            operacionActual = "resta"
            resultadoActual = tvResultado.text.toString().toIntOrNull()
            tvResultado.text = "0"
        }

        btnMultiplicar.setOnClickListener {
            operacionActual = "multiplicar"
            resultadoActual = tvResultado.text.toString().toIntOrNull()
            tvResultado.text = "0"
        }

        btnDividir.setOnClickListener {
            operacionActual = "dividir"
            resultadoActual = tvResultado.text.toString().toIntOrNull()
            tvResultado.text = "0"
        }

        btnIgual.setOnClickListener {
            obtenerResultado()
        }

        btnBorrar.setOnClickListener {
            borrarResultado()
        }
    }

    fun manejarNumero(num: Int) {
        if(tvResultado.text == "0") {
            tvResultado.text = ""
        }

        tvResultado.append(num.toString())
    }

    fun borrarResultado() {
        tvResultado.text = ""
        resultadoActual = 0
        operacionActual = ""
    }

    fun obtenerResultado() {
        val valorActual = tvResultado.text.toString().toIntOrNull() ?: 0
        val resultado = when (operacionActual) {
            "suma" -> (resultadoActual ?: 0) + valorActual
            "resta" -> (resultadoActual ?: 0) - valorActual
            "multiplicar" -> (resultadoActual ?: 0) * valorActual
            "dividir" -> if (valorActual != 0) {
                (resultadoActual ?: 0) / valorActual
            } else {
                0
            }
            else -> valorActual
        }

        tvResultado.text = resultado.toString()
        resultadoActual = resultado
        operacionActual = ""
    }

}