package com.devdhruv.minesweeper.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.devdhruv.minesweeper.R

class GameMenu : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_game_menu, container, false)

        var difficulty = 1
        updateDifficulty(difficulty, view)

        val ivLeft: ImageView = view.findViewById(R.id.ivLeft)
        val ivRight: ImageView = view.findViewById(R.id.ivRight)
        val btPlay: Button = view.findViewById(R.id.btPlay)
        ivLeft.setOnClickListener {
            if (difficulty == 2) difficulty = 1
            else difficulty = 2
            updateDifficulty(difficulty, view)
        }

        ivRight.setOnClickListener {
            if (difficulty == 1) difficulty = 2
            else difficulty = 1
            updateDifficulty(difficulty, view)
        }

        btPlay.setOnClickListener {
            when (difficulty) {
                1 -> view.findNavController().navigate(R.id.action_gameMenu_to_easyPlay)
                2 -> view.findNavController().navigate(R.id.action_gameMenu_to_mediumPlay)
            }
        }

        val btAbout: Button = view.findViewById(R.id.btAbout)
        btAbout.setOnClickListener {
            view.findNavController().navigate(R.id.action_gameMenu_to_aboutFragment)
        }

        return view
    }

    @SuppressLint("SetTextI18n")
    private fun updateDifficulty(difficulty: Int, view: View) {

        val tv: TextView = view.findViewById(R.id.tvDifficulty)
        if (difficulty == 1) tv.text = "Easy"
        else tv.text = "Medium"

    }

}