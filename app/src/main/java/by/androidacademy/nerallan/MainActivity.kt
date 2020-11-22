package by.androidacademy.nerallan

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import by.androidacademy.nerallan.ext.bind
import by.androidacademy.nerallan.ext.launchActivity

class MainActivity : AppCompatActivity() {

    private val greetingTextView by bind<TextView>(R.id.main_screen_greeting_message)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        greetingTextView.setOnClickListener { moveToMovieDetailsScreen() }
    }

    private fun moveToMovieDetailsScreen() {
        launchActivity<MovieDetailsActivity> { }
    }
}