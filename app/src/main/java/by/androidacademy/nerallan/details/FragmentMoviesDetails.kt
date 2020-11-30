package by.androidacademy.nerallan.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.androidacademy.nerallan.R

class FragmentMoviesDetails : Fragment() {

    companion object {

        fun newInstance(): Fragment {
            return FragmentMoviesDetails()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_details, container, false)
    }
}