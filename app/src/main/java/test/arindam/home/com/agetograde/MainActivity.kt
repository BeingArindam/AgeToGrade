package test.arindam.home.com.agetograde

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener
{
    var text: TextView? = null
    private var ageText: EditText? = null
    var button:Button? = null
    override fun onClick(v: View?) {
        Log.d("Let","View ${v}")
        when (v?.id) {
            R.id.calButton -> {
                if(ageText?.text.toString() != "") text?.text = ageToGrade(ageText?.text.toString().toInt())
                else text?.text = "Please enter a value"
                ageText?.text!!.clear();
            }
            else -> text?.text = "Please enter a value"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ageText = findViewById(R.id.age) as EditText
        button = findViewById(R.id.calButton) as Button
        text = findViewById(R.id.textView) as TextView
        button?.setOnClickListener(this)
        }

    fun ageToGrade(age:Int): String {
        when (age) {
            in 1..5 -> return "Kinder Garden"
            in 6..17 -> return "Grade ${age - 5}"
            else -> return "College"
        }
    }
}

