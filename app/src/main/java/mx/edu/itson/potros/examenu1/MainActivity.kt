package mx.edu.itson.potros.examenu1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var celsiusInput: EditText
    private lateinit var fahrenheitInput: EditText
    private lateinit var convertCtoFButton: Button
    private lateinit var convertFtoCButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        celsiusInput = findViewById(R.id.etGradosC)
        fahrenheitInput = findViewById(R.id.etGradosF)
        convertCtoFButton = findViewById(R.id.btnGradosF)
        convertFtoCButton = findViewById(R.id.btnGradosC)

        convertCtoFButton.setOnClickListener {
            convertCtoF()
        }

        convertFtoCButton.setOnClickListener {
            convertFtoC()
        }
    }

    private fun convertCtoF() {
        val celsiusValue = celsiusInput.text.toString().toDoubleOrNull()
        if (celsiusValue != null) {
            val fahrenheitValue = celsiusToFarhenheit(celsiusValue)
            fahrenheitInput.setText(formatResult(fahrenheitValue))
        }
    }

    private fun convertFtoC() {
        val fahrenheitValue = fahrenheitInput.text.toString().toDoubleOrNull()
        if (fahrenheitValue != null) {
            val celsiusValue = farhenheitToCelsius(fahrenheitValue)
            celsiusInput.setText(formatResult(celsiusValue))
        }
    }

    private fun celsiusToFarhenheit(celsius: Double): Double {
        return (celsius * 9 / 5) + 32
    }

    private fun farhenheitToCelsius(fahrenheit: Double): Double {
        return (fahrenheit - 32) * 5 / 9
    }

    private fun formatResult(value: Double): String {
        val decimalFormat = DecimalFormat("#.##")
        return decimalFormat.format(value)
    }
}