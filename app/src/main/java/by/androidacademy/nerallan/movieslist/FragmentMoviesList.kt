package by.androidacademy.nerallan.movieslist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import by.androidacademy.nerallan.R

class FragmentMoviesList : Fragment() {

    private var clickAction: MovieClickAction? = null
    private var movieCardItem: ConstraintLayout? = null

    companion object {

        fun newInstance(): Fragment {
            return FragmentMoviesList()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MovieClickAction) {
            clickAction = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    private fun initViews(view: View) {
        movieCardItem = view.findViewById(R.id.movie_item_title)
        movieCardItem?.setOnClickListener {
            clickAction?.onMovieClicked()
        }
    }

    override fun onDetach() {
        super.onDetach()
        clickAction = null
    }
}