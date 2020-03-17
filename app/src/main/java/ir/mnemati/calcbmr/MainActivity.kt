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

        /* ***** Go to BMR Explain Activity ***** */

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
