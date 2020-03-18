package ir.mnemati.calcbmr

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set Title
        title = "محاسبگر شاخص BMR"

        /* ***** Calculate the BMR ***** */
        btnCalcBMR.setOnClickListener {

            if (edtWeigh.text.toString()== "" || edtHeight.text.toString() == "" || edtAge.text.toString() == "") {
                Toast.makeText(this, "لطفا مقادیر وزن، قد و سن خود را وارد نمایید.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                // Save input data to variables
                val weight: Double = edtWeigh.text.toString().toDouble()
                val height: Double = edtHeight.text.toString().toDouble() / 100
                val age: Double = edtAge.text.toString().toDouble()

                if (rbMen.isChecked) {

                }
                else if (rbWomen.isChecked) {

                }
                else {
                    Toast.makeText(this, "لطفا جنسیت خود را تعیین کنید", Toast.LENGTH_SHORT).show()
                }

            }
            catch (ex: Exception) {
                Toast.makeText(this, "مقادیر وزن، قد و سن را درست وارد نمایید.", Toast.LENGTH_SHORT).show()
            }
        }
        /* ***** Go to BMR Explain Activity ***** */
        btnAboutBMR.setOnClickListener {

            val intentBmr = Intent(this, bmrActivity::class.java)
            startActivity(intentBmr)
        }
        /* ***** Go to SchoolHelp Site ***** */
        tvSiteUrl.setOnClickListener {

            val url = Uri.parse("http://schoolhelp.ir")
            val intentWeb = Intent(Intent.ACTION_VIEW, url)
            if (intentWeb.resolveActivity(packageManager) != null) {
                startActivity(intentWeb)
            }
        }
    }
}
