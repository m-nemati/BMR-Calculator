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
                val height: Double = edtHeight.text.toString().toDouble()
                val age: Double = edtAge.text.toString().toDouble()
                var bmr_Rate: Int = 0

                if (rbMen.isChecked) {

                    bmr_Rate = (66.47 + ( 13.75 * weight) + ( 5.003 * height ) - ( 6.755 * age )).toInt()
                    tvShowTxt.text = "کالری مورد نیاز بدن شما در 24 ساعت:"
                    tvCorollary.text = bmr_Rate.toString()
                  //  var bmrMan = 66.47 + ( 13.75 * weight) + ( 5.003 * height ) - ( 6.755 * age );
                  //  var bmrWoman = 655.1 + ( 9.563 * weight ) + ( 1.850 * height ) - ( 4.676 * age );


                }
                else if (rbWomen.isChecked) {

                    bmr_Rate = (655.1 + ( 9.563 * weight) + ( 1.850 * height ) - ( 4.676 * age )).toInt()
                    tvShowTxt.text = "کالری مورد نیاز بدن شما در 24 ساعت:"
                    tvCorollary.text = bmr_Rate.toString()
                }
                else {
                    Toast.makeText(this, "لطفا جنسیت خود را تعیین کنید", Toast.LENGTH_SHORT).show()
                }

            }
            catch (ex: Exception) {
                Toast.makeText(this, "مقادیر وزن، قد و سن را درست وارد نمایید.", Toast.LENGTH_SHORT).show()
            }
        }

        /* ***** Clear Button ***** */
        btnClear.setOnClickListener {
            tvCorollary.text = ""
            tvShowTxt.text = ""
            edtAge.setText("")
            edtHeight.setText("")
            edtWeigh.setText("")
            edtWeigh.requestFocus()
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
