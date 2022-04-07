package com.windrose.coliseum.view.end

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.windrose.coliseum.R
import com.windrose.coliseum.databinding.FragmentGameEndBinding
import com.windrose.coliseum.view.start.StartGameFragment
import com.windrose.coliseum.view.utils.routeToFragment
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class GameEndFragment : Fragment(), GameEndContract.View {

    private val presenter: GameEndPresenter by inject { parametersOf(this) }

    private lateinit var binding: FragmentGameEndBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentGameEndBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.restartGameButton.setOnClickListener { goStartGame() }
        presenter.start()
    }

    override fun setContent(winners: List<String>) {
        binding.winnerText.text = resources.getQuantityString(R.plurals.game_over, winners.size, winners)
    }

    private fun goStartGame() =
        routeToFragment(StartGameFragment.newInstance())

    companion object Factory {
        fun newInstance() = GameEndFragment()
    }
}
