package com.windrose.coliseum.ludicoliseum.view.end

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.windrose.coliseum.ludicoliseum.R
import com.windrose.coliseum.ludicoliseum.databinding.FragmentGameEndBinding
import com.windrose.coliseum.ludicoliseum.view.start.StartGameFragment
import com.windrose.coliseum.ludicoliseum.view.utils.routeToFragment
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class GameEndFragment : DaggerFragment(), GameEndContract.View {

    @Inject
    lateinit var presenter: GameEndContract.Presenter

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
