package co.benveli.layoutcreator.Activitys

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.ExperimentalMaterial3Api
import co.benveli.layoutcreator.R
import co.benveli.layoutcreator.TelaDeEntrada

@ExperimentalMaterial3Api
class SplashScreen : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            val itent = Intent(this, TelaDeEntrada::class.java)
            startActivity(itent)
            finish()
        }, 2000)
    }
}