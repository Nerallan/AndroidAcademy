package by.androidacademy.nerallan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.androidacademy.nerallan.details.FragmentMoviesDetails
import by.androidacademy.nerallan.ext.replaceFragment
import by.androidacademy.nerallan.movieslist.FragmentMoviesList
import by.androidacademy.nerallan.movieslist.MovieClickAction

class MainActivity : AppCompatActivity(), MovieClickAction {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            replaceFragment(
                R.id.fragment_container_view,
                FragmentMoviesList.newInstance(),
                true
            )
        }
    }

    override fun onMovieClicked() {
        replaceFragment(
            R.id.fragment_container_view,
            FragmentMoviesDetails.newInstance(),
            true
        )
    }
}