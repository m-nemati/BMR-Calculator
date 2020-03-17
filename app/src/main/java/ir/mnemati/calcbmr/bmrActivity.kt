package ir.mnemati.calcbmr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bmr.*

class bmrActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmr)

        /* ***** Go Back to BMR MAin Activity ***** */
        btnBack.setOnClickListener {

            val intentback = Intent(this, MainActivity::class.java)
            startActivity(intentback)
        }
    }
}
