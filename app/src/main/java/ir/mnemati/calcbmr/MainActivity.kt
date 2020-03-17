package ir.mnemati.calcbmr

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set Title
        title = "محاسبگر شاخص BMR"

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
