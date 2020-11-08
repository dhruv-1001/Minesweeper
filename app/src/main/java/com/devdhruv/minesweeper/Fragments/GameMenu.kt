package com.devdhruv.minesweeper.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.devdhruv.minesweeper.R

class GameMenu : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_game_menu, container, false)

        val btEasy: Button = view.findViewById(R.id.btEasy)
        val btMedium: Button = view.findViewById(R.id.btMedium)
        val btHard: Button = view.findViewById(R.id.btHard)

        btEasy.setOnClickListener {
            view.findNavController().navigate(R.id.action_gameMenu_to_easyPlay)
        }
        btMedium.setOnClickListener {
            view.findNavController().navigate(R.id.action_gameMenu_to_mediumPlay)
        }
        btHard.setOnClickListener{
            view.findNavController().navigate(R.id.action_gameMenu_to_hardPlay)
        }
        return view
    }

}