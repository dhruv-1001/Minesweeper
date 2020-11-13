package com.devdhruv.minesweeper.Fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.devdhruv.minesweeper.R

class MediumPlay : Fragment(), View.OnClickListener, View.OnLongClickListener {

    private val textMap = HashMap<TextView, String>()
    private val reverseTextMap = HashMap<String, TextView>()
    private val board   = Array(22) {IntArray(12) {0} }
    private var openedTiles = Array(22) {BooleanArray(12) {false} }
    private var markedTiles = Array(22) {BooleanArray(12) {false} }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view:View =  inflater.inflate(R.layout.fragment_medium_play, container, false)

        init(view)
        generateMines()

        return view
    }

    private fun init(view: View){

        val t1_1: TextView =  view.findViewById(R.id.t1_1)
        val t1_2: TextView =  view.findViewById(R.id.t1_2)
        val t1_3: TextView =  view.findViewById(R.id.t1_3)
        val t1_4: TextView =  view.findViewById(R.id.t1_4)
        val t1_5: TextView =  view.findViewById(R.id.t1_5)
        val t1_6: TextView =  view.findViewById(R.id.t1_6)
        val t1_7: TextView =  view.findViewById(R.id.t1_7)
        val t1_8: TextView =  view.findViewById(R.id.t1_8)
        val t1_9: TextView =  view.findViewById(R.id.t1_9)
        val t1_10: TextView = view.findViewById(R.id.t1_10)
        val t1_11: TextView = view.findViewById(R.id.t1_11)
        val t1_12: TextView = view.findViewById(R.id.t1_12)
        val t2_1: TextView =  view.findViewById(R.id.t2_1)
        val t2_2: TextView =  view.findViewById(R.id.t2_2)
        val t2_3: TextView =  view.findViewById(R.id.t2_3)
        val t2_4: TextView =  view.findViewById(R.id.t2_4)
        val t2_5: TextView =  view.findViewById(R.id.t2_5)
        val t2_6: TextView =  view.findViewById(R.id.t2_6)
        val t2_7: TextView =  view.findViewById(R.id.t2_7)
        val t2_8: TextView =  view.findViewById(R.id.t2_8)
        val t2_9: TextView =  view.findViewById(R.id.t2_9)
        val t2_10: TextView = view.findViewById(R.id.t2_10)
        val t2_11: TextView = view.findViewById(R.id.t2_11)
        val t2_12: TextView = view.findViewById(R.id.t2_12)
        val t3_1: TextView =  view.findViewById(R.id.t3_1)
        val t3_2: TextView =  view.findViewById(R.id.t3_2)
        val t3_3: TextView =  view.findViewById(R.id.t3_3)
        val t3_4: TextView =  view.findViewById(R.id.t3_4)
        val t3_5: TextView =  view.findViewById(R.id.t3_5)
        val t3_6: TextView =  view.findViewById(R.id.t3_6)
        val t3_7: TextView =  view.findViewById(R.id.t3_7)
        val t3_8: TextView =  view.findViewById(R.id.t3_8)
        val t3_9: TextView =  view.findViewById(R.id.t3_9)
        val t3_10: TextView = view.findViewById(R.id.t3_10)
        val t3_11: TextView = view.findViewById(R.id.t3_11)
        val t3_12: TextView = view.findViewById(R.id.t3_12)
        val t4_1: TextView =  view.findViewById(R.id.t4_1)
        val t4_2: TextView =  view.findViewById(R.id.t4_2)
        val t4_3: TextView =  view.findViewById(R.id.t4_3)
        val t4_4: TextView =  view.findViewById(R.id.t4_4)
        val t4_5: TextView =  view.findViewById(R.id.t4_5)
        val t4_6: TextView =  view.findViewById(R.id.t4_6)
        val t4_7: TextView =  view.findViewById(R.id.t4_7)
        val t4_8: TextView =  view.findViewById(R.id.t4_8)
        val t4_9: TextView =  view.findViewById(R.id.t4_9)
        val t4_10: TextView = view.findViewById(R.id.t4_10)
        val t4_11: TextView = view.findViewById(R.id.t4_11)
        val t4_12: TextView = view.findViewById(R.id.t4_12)
        val t5_1: TextView =  view.findViewById(R.id.t5_1)
        val t5_2: TextView =  view.findViewById(R.id.t5_2)
        val t5_3: TextView =  view.findViewById(R.id.t5_3)
        val t5_4: TextView =  view.findViewById(R.id.t5_4)
        val t5_5: TextView =  view.findViewById(R.id.t5_5)
        val t5_6: TextView =  view.findViewById(R.id.t5_6)
        val t5_7: TextView =  view.findViewById(R.id.t5_7)
        val t5_8: TextView =  view.findViewById(R.id.t5_8)
        val t5_9: TextView =  view.findViewById(R.id.t5_9)
        val t5_10: TextView = view.findViewById(R.id.t5_10)
        val t5_11: TextView = view.findViewById(R.id.t5_11)
        val t5_12: TextView = view.findViewById(R.id.t5_12)
        val t6_1: TextView =  view.findViewById(R.id.t6_1)
        val t6_2: TextView =  view.findViewById(R.id.t6_2)
        val t6_3: TextView =  view.findViewById(R.id.t6_3)
        val t6_4: TextView =  view.findViewById(R.id.t6_4)
        val t6_5: TextView =  view.findViewById(R.id.t6_5)
        val t6_6: TextView =  view.findViewById(R.id.t6_6)
        val t6_7: TextView =  view.findViewById(R.id.t6_7)
        val t6_8: TextView =  view.findViewById(R.id.t6_8)
        val t6_9: TextView =  view.findViewById(R.id.t6_9)
        val t6_10: TextView = view.findViewById(R.id.t6_10)
        val t6_11: TextView = view.findViewById(R.id.t6_11)
        val t6_12: TextView = view.findViewById(R.id.t6_12)
        val t7_1: TextView =  view.findViewById(R.id.t7_1)
        val t7_2: TextView =  view.findViewById(R.id.t7_2)
        val t7_3: TextView =  view.findViewById(R.id.t7_3)
        val t7_4: TextView =  view.findViewById(R.id.t7_4)
        val t7_5: TextView =  view.findViewById(R.id.t7_5)
        val t7_6: TextView =  view.findViewById(R.id.t7_6)
        val t7_7: TextView =  view.findViewById(R.id.t7_7)
        val t7_8: TextView =  view.findViewById(R.id.t7_8)
        val t7_9: TextView =  view.findViewById(R.id.t7_9)
        val t7_10: TextView = view.findViewById(R.id.t7_10)
        val t7_11: TextView = view.findViewById(R.id.t7_11)
        val t7_12: TextView = view.findViewById(R.id.t7_12)
        val t8_1: TextView =  view.findViewById(R.id.t8_1)
        val t8_2: TextView =  view.findViewById(R.id.t8_2)
        val t8_3: TextView =  view.findViewById(R.id.t8_3)
        val t8_4: TextView =  view.findViewById(R.id.t8_4)
        val t8_5: TextView =  view.findViewById(R.id.t8_5)
        val t8_6: TextView =  view.findViewById(R.id.t8_6)
        val t8_7: TextView =  view.findViewById(R.id.t8_7)
        val t8_8: TextView =  view.findViewById(R.id.t8_8)
        val t8_9: TextView =  view.findViewById(R.id.t8_9)
        val t8_10: TextView = view.findViewById(R.id.t8_10)
        val t8_11: TextView = view.findViewById(R.id.t8_11)
        val t8_12: TextView = view.findViewById(R.id.t8_12)
        val t9_1: TextView =  view.findViewById(R.id.t9_1)
        val t9_2: TextView =  view.findViewById(R.id.t9_2)
        val t9_3: TextView =  view.findViewById(R.id.t9_3)
        val t9_4: TextView =  view.findViewById(R.id.t9_4)
        val t9_5: TextView =  view.findViewById(R.id.t9_5)
        val t9_6: TextView =  view.findViewById(R.id.t9_6)
        val t9_7: TextView =  view.findViewById(R.id.t9_7)
        val t9_8: TextView =  view.findViewById(R.id.t9_8)
        val t9_9: TextView =  view.findViewById(R.id.t9_9)
        val t9_10: TextView = view.findViewById(R.id.t9_10)
        val t9_11: TextView = view.findViewById(R.id.t9_11)
        val t9_12: TextView = view.findViewById(R.id.t9_12)
        val t10_1: TextView =  view.findViewById(R.id.t10_1)
        val t10_2: TextView =  view.findViewById(R.id.t10_2)
        val t10_3: TextView =  view.findViewById(R.id.t10_3)
        val t10_4: TextView =  view.findViewById(R.id.t10_4)
        val t10_5: TextView =  view.findViewById(R.id.t10_5)
        val t10_6: TextView =  view.findViewById(R.id.t10_6)
        val t10_7: TextView =  view.findViewById(R.id.t10_7)
        val t10_8: TextView =  view.findViewById(R.id.t10_8)
        val t10_9: TextView =  view.findViewById(R.id.t10_9)
        val t10_10: TextView = view.findViewById(R.id.t10_10)
        val t10_11: TextView = view.findViewById(R.id.t10_11)
        val t10_12: TextView = view.findViewById(R.id.t10_12)
        val t11_1: TextView =  view.findViewById(R.id.t11_1)
        val t11_2: TextView =  view.findViewById(R.id.t11_2)
        val t11_3: TextView =  view.findViewById(R.id.t11_3)
        val t11_4: TextView =  view.findViewById(R.id.t11_4)
        val t11_5: TextView =  view.findViewById(R.id.t11_5)
        val t11_6: TextView =  view.findViewById(R.id.t11_6)
        val t11_7: TextView =  view.findViewById(R.id.t11_7)
        val t11_8: TextView =  view.findViewById(R.id.t11_8)
        val t11_9: TextView =  view.findViewById(R.id.t11_9)
        val t11_10: TextView = view.findViewById(R.id.t11_10)
        val t11_11: TextView = view.findViewById(R.id.t11_11)
        val t11_12: TextView = view.findViewById(R.id.t11_12)
        val t12_1: TextView =  view.findViewById(R.id.t12_1)
        val t12_2: TextView =  view.findViewById(R.id.t12_2)
        val t12_3: TextView =  view.findViewById(R.id.t12_3)
        val t12_4: TextView =  view.findViewById(R.id.t12_4)
        val t12_5: TextView =  view.findViewById(R.id.t12_5)
        val t12_6: TextView =  view.findViewById(R.id.t12_6)
        val t12_7: TextView =  view.findViewById(R.id.t12_7)
        val t12_8: TextView =  view.findViewById(R.id.t12_8)
        val t12_9: TextView =  view.findViewById(R.id.t12_9)
        val t12_10: TextView = view.findViewById(R.id.t12_10)
        val t12_11: TextView = view.findViewById(R.id.t12_11)
        val t12_12: TextView = view.findViewById(R.id.t12_12)
        val t13_1: TextView =  view.findViewById(R.id.t13_1)
        val t13_2: TextView =  view.findViewById(R.id.t13_2)
        val t13_3: TextView =  view.findViewById(R.id.t13_3)
        val t13_4: TextView =  view.findViewById(R.id.t13_4)
        val t13_5: TextView =  view.findViewById(R.id.t13_5)
        val t13_6: TextView =  view.findViewById(R.id.t13_6)
        val t13_7: TextView =  view.findViewById(R.id.t13_7)
        val t13_8: TextView =  view.findViewById(R.id.t13_8)
        val t13_9: TextView =  view.findViewById(R.id.t13_9)
        val t13_10: TextView = view.findViewById(R.id.t13_10)
        val t13_11: TextView = view.findViewById(R.id.t13_11)
        val t13_12: TextView = view.findViewById(R.id.t13_12)
        val t14_1: TextView =  view.findViewById(R.id.t14_1)
        val t14_2: TextView =  view.findViewById(R.id.t14_2)
        val t14_3: TextView =  view.findViewById(R.id.t14_3)
        val t14_4: TextView =  view.findViewById(R.id.t14_4)
        val t14_5: TextView =  view.findViewById(R.id.t14_5)
        val t14_6: TextView =  view.findViewById(R.id.t14_6)
        val t14_7: TextView =  view.findViewById(R.id.t14_7)
        val t14_8: TextView =  view.findViewById(R.id.t14_8)
        val t14_9: TextView =  view.findViewById(R.id.t14_9)
        val t14_10: TextView = view.findViewById(R.id.t14_10)
        val t14_11: TextView = view.findViewById(R.id.t14_11)
        val t14_12: TextView = view.findViewById(R.id.t14_12)
        val t15_1: TextView =  view.findViewById(R.id.t15_1)
        val t15_2: TextView =  view.findViewById(R.id.t15_2)
        val t15_3: TextView =  view.findViewById(R.id.t15_3)
        val t15_4: TextView =  view.findViewById(R.id.t15_4)
        val t15_5: TextView =  view.findViewById(R.id.t15_5)
        val t15_6: TextView =  view.findViewById(R.id.t15_6)
        val t15_7: TextView =  view.findViewById(R.id.t15_7)
        val t15_8: TextView =  view.findViewById(R.id.t15_8)
        val t15_9: TextView =  view.findViewById(R.id.t15_9)
        val t15_10: TextView = view.findViewById(R.id.t15_10)
        val t15_11: TextView = view.findViewById(R.id.t15_11)
        val t15_12: TextView = view.findViewById(R.id.t15_12)
        val t16_1: TextView =  view.findViewById(R.id.t16_1)
        val t16_2: TextView =  view.findViewById(R.id.t16_2)
        val t16_3: TextView =  view.findViewById(R.id.t16_3)
        val t16_4: TextView =  view.findViewById(R.id.t16_4)
        val t16_5: TextView =  view.findViewById(R.id.t16_5)
        val t16_6: TextView =  view.findViewById(R.id.t16_6)
        val t16_7: TextView =  view.findViewById(R.id.t16_7)
        val t16_8: TextView =  view.findViewById(R.id.t16_8)
        val t16_9: TextView =  view.findViewById(R.id.t16_9)
        val t16_10: TextView = view.findViewById(R.id.t16_10)
        val t16_11: TextView = view.findViewById(R.id.t16_11)
        val t16_12: TextView = view.findViewById(R.id.t16_12)
        val t17_1: TextView =  view.findViewById(R.id.t17_1)
        val t17_2: TextView =  view.findViewById(R.id.t17_2)
        val t17_3: TextView =  view.findViewById(R.id.t17_3)
        val t17_4: TextView =  view.findViewById(R.id.t17_4)
        val t17_5: TextView =  view.findViewById(R.id.t17_5)
        val t17_6: TextView =  view.findViewById(R.id.t17_6)
        val t17_7: TextView =  view.findViewById(R.id.t17_7)
        val t17_8: TextView =  view.findViewById(R.id.t17_8)
        val t17_9: TextView =  view.findViewById(R.id.t17_9)
        val t17_10: TextView = view.findViewById(R.id.t17_10)
        val t17_11: TextView = view.findViewById(R.id.t17_11)
        val t17_12: TextView = view.findViewById(R.id.t17_12)
        val t18_1: TextView =  view.findViewById(R.id.t18_1)
        val t18_2: TextView =  view.findViewById(R.id.t18_2)
        val t18_3: TextView =  view.findViewById(R.id.t18_3)
        val t18_4: TextView =  view.findViewById(R.id.t18_4)
        val t18_5: TextView =  view.findViewById(R.id.t18_5)
        val t18_6: TextView =  view.findViewById(R.id.t18_6)
        val t18_7: TextView =  view.findViewById(R.id.t18_7)
        val t18_8: TextView =  view.findViewById(R.id.t18_8)
        val t18_9: TextView =  view.findViewById(R.id.t18_9)
        val t18_10: TextView = view.findViewById(R.id.t18_10)
        val t18_11: TextView = view.findViewById(R.id.t18_11)
        val t18_12: TextView = view.findViewById(R.id.t18_12)
        val t19_1: TextView =  view.findViewById(R.id.t19_1)
        val t19_2: TextView =  view.findViewById(R.id.t19_2)
        val t19_3: TextView =  view.findViewById(R.id.t19_3)
        val t19_4: TextView =  view.findViewById(R.id.t19_4)
        val t19_5: TextView =  view.findViewById(R.id.t19_5)
        val t19_6: TextView =  view.findViewById(R.id.t19_6)
        val t19_7: TextView =  view.findViewById(R.id.t19_7)
        val t19_8: TextView =  view.findViewById(R.id.t19_8)
        val t19_9: TextView =  view.findViewById(R.id.t19_9)
        val t19_10: TextView = view.findViewById(R.id.t19_10)
        val t19_11: TextView = view.findViewById(R.id.t19_11)
        val t19_12: TextView = view.findViewById(R.id.t19_12)
        val t20_1: TextView =  view.findViewById(R.id.t20_1)
        val t20_2: TextView =  view.findViewById(R.id.t20_2)
        val t20_3: TextView =  view.findViewById(R.id.t20_3)
        val t20_4: TextView =  view.findViewById(R.id.t20_4)
        val t20_5: TextView =  view.findViewById(R.id.t20_5)
        val t20_6: TextView =  view.findViewById(R.id.t20_6)
        val t20_7: TextView =  view.findViewById(R.id.t20_7)
        val t20_8: TextView =  view.findViewById(R.id.t20_8)
        val t20_9: TextView =  view.findViewById(R.id.t20_9)
        val t20_10: TextView = view.findViewById(R.id.t20_10)
        val t20_11: TextView = view.findViewById(R.id.t20_11)
        val t20_12: TextView = view.findViewById(R.id.t20_12)
        val t21_1: TextView =  view.findViewById(R.id.t21_1)
        val t21_2: TextView =  view.findViewById(R.id.t21_2)
        val t21_3: TextView =  view.findViewById(R.id.t21_3)
        val t21_4: TextView =  view.findViewById(R.id.t21_4)
        val t21_5: TextView =  view.findViewById(R.id.t21_5)
        val t21_6: TextView =  view.findViewById(R.id.t21_6)
        val t21_7: TextView =  view.findViewById(R.id.t21_7)
        val t21_8: TextView =  view.findViewById(R.id.t21_8)
        val t21_9: TextView =  view.findViewById(R.id.t21_9)
        val t21_10: TextView = view.findViewById(R.id.t21_10)
        val t21_11: TextView = view.findViewById(R.id.t21_11)
        val t21_12: TextView = view.findViewById(R.id.t21_12)
        val t22_1: TextView =  view.findViewById(R.id.t22_1)
        val t22_2: TextView =  view.findViewById(R.id.t22_2)
        val t22_3: TextView =  view.findViewById(R.id.t22_3)
        val t22_4: TextView =  view.findViewById(R.id.t22_4)
        val t22_5: TextView =  view.findViewById(R.id.t22_5)
        val t22_6: TextView =  view.findViewById(R.id.t22_6)
        val t22_7: TextView =  view.findViewById(R.id.t22_7)
        val t22_8: TextView =  view.findViewById(R.id.t22_8)
        val t22_9: TextView =  view.findViewById(R.id.t22_9)
        val t22_10: TextView = view.findViewById(R.id.t22_10)
        val t22_11: TextView = view.findViewById(R.id.t22_11)
        val t22_12: TextView = view.findViewById(R.id.t22_12)

        textMap[t1_1]   = "t1_1"
        textMap[t1_2]   = "t1_2"
        textMap[t1_3]   = "t1_3"
        textMap[t1_4]   = "t1_4"
        textMap[t1_5]   = "t1_5"
        textMap[t1_6]   = "t1_6"
        textMap[t1_7]   = "t1_7"
        textMap[t1_8]   = "t1_8"
        textMap[t1_9]   = "t1_9"
        textMap[t1_10]  = "t1_10"
        textMap[t1_11]  = "t1_11"
        textMap[t1_12]  = "t1_12"
        textMap[t2_1]   = "t2_1"
        textMap[t2_2]   = "t2_2"
        textMap[t2_3]   = "t2_3"
        textMap[t2_4]   = "t2_4"
        textMap[t2_5]   = "t2_5"
        textMap[t2_6]   = "t2_6"
        textMap[t2_7]   = "t2_7"
        textMap[t2_8]   = "t2_8"
        textMap[t2_9]   = "t2_9"
        textMap[t2_10]  = "t2_10"
        textMap[t2_11]  = "t2_11"
        textMap[t2_12]  = "t2_12"
        textMap[t3_1]   = "t3_1"
        textMap[t3_2]   = "t3_2"
        textMap[t3_3]   = "t3_3"
        textMap[t3_4]   = "t3_4"
        textMap[t3_5]   = "t3_5"
        textMap[t3_6]   = "t3_6"
        textMap[t3_7]   = "t3_7"
        textMap[t3_8]   = "t3_8"
        textMap[t3_9]   = "t3_9"
        textMap[t3_10]  = "t3_10"
        textMap[t3_11]  = "t3_11"
        textMap[t3_12]  = "t3_12"
        textMap[t4_1]   = "t4_1"
        textMap[t4_2]   = "t4_2"
        textMap[t4_3]   = "t4_3"
        textMap[t4_4]   = "t4_4"
        textMap[t4_5]   = "t4_5"
        textMap[t4_6]   = "t4_6"
        textMap[t4_7]   = "t4_7"
        textMap[t4_8]   = "t4_8"
        textMap[t4_9]   = "t4_9"
        textMap[t4_10]  = "t4_10"
        textMap[t4_11]  = "t4_11"
        textMap[t4_12]  = "t4_12"
        textMap[t5_1]   = "t5_1"
        textMap[t5_2]   = "t5_2"
        textMap[t5_3]   = "t5_3"
        textMap[t5_4]   = "t5_4"
        textMap[t5_5]   = "t5_5"
        textMap[t5_6]   = "t5_6"
        textMap[t5_7]   = "t5_7"
        textMap[t5_8]   = "t5_8"
        textMap[t5_9]   = "t5_9"
        textMap[t5_10]  = "t5_10"
        textMap[t5_11]  = "t5_11"
        textMap[t5_12]  = "t5_12"
        textMap[t6_1]   = "t6_1"
        textMap[t6_2]   = "t6_2"
        textMap[t6_3]   = "t6_3"
        textMap[t6_4]   = "t6_4"
        textMap[t6_5]   = "t6_5"
        textMap[t6_6]   = "t6_6"
        textMap[t6_7]   = "t6_7"
        textMap[t6_8]   = "t6_8"
        textMap[t6_9]   = "t6_9"
        textMap[t6_10]  = "t6_10"
        textMap[t6_11]  = "t6_11"
        textMap[t6_12]  = "t6_12"
        textMap[t7_1]   = "t7_1"
        textMap[t7_2]   = "t7_2"
        textMap[t7_3]   = "t7_3"
        textMap[t7_4]   = "t7_4"
        textMap[t7_5]   = "t7_5"
        textMap[t7_6]   = "t7_6"
        textMap[t7_7]   = "t7_7"
        textMap[t7_8]   = "t7_8"
        textMap[t7_9]   = "t7_9"
        textMap[t7_10]  = "t7_10"
        textMap[t7_11]  = "t7_11"
        textMap[t7_12]  = "t7_12"
        textMap[t8_1]   = "t8_1"
        textMap[t8_2]   = "t8_2"
        textMap[t8_3]   = "t8_3"
        textMap[t8_4]   = "t8_4"
        textMap[t8_5]   = "t8_5"
        textMap[t8_6]   = "t8_6"
        textMap[t8_7]   = "t8_7"
        textMap[t8_8]   = "t8_8"
        textMap[t8_9]   = "t8_9"
        textMap[t8_10]  = "t8_10"
        textMap[t8_11]  = "t8_11"
        textMap[t8_12]  = "t8_12"
        textMap[t9_1]   = "t9_1"
        textMap[t9_2]   = "t9_2"
        textMap[t9_3]   = "t9_3"
        textMap[t9_4]   = "t9_4"
        textMap[t9_5]   = "t9_5"
        textMap[t9_6]   = "t9_6"
        textMap[t9_7]   = "t9_7"
        textMap[t9_8]   = "t9_8"
        textMap[t9_9]   = "t9_9"
        textMap[t9_10]  = "t9_10"
        textMap[t9_11]  = "t9_11"
        textMap[t9_12]  = "t9_12"
        textMap[t10_1]  = "t10_1"
        textMap[t10_2]  = "t10_2"
        textMap[t10_3]  = "t10_3"
        textMap[t10_4]  = "t10_4"
        textMap[t10_5]  = "t10_5"
        textMap[t10_6]  = "t10_6"
        textMap[t10_7]  = "t10_7"
        textMap[t10_8]  = "t10_8"
        textMap[t10_9]  = "t10_9"
        textMap[t10_10] = "t10_10"
        textMap[t10_11] = "t10_11"
        textMap[t10_12] = "t10_12"
        textMap[t11_1]  = "t11_1"
        textMap[t11_2]  = "t11_2"
        textMap[t11_3]  = "t11_3"
        textMap[t11_4]  = "t11_4"
        textMap[t11_5]  = "t11_5"
        textMap[t11_6]  = "t11_6"
        textMap[t11_7]  = "t11_7"
        textMap[t11_8]  = "t11_8"
        textMap[t11_9]  = "t11_9"
        textMap[t11_10] = "t11_10"
        textMap[t11_11] = "t11_11"
        textMap[t11_12] = "t11_12"
        textMap[t12_1]  = "t12_1"
        textMap[t12_2]  = "t12_2"
        textMap[t12_3]  = "t12_3"
        textMap[t12_4]  = "t12_4"
        textMap[t12_5]  = "t12_5"
        textMap[t12_6]  = "t12_6"
        textMap[t12_7]  = "t12_7"
        textMap[t12_8]  = "t12_8"
        textMap[t12_9]  = "t12_9"
        textMap[t12_10] = "t12_10"
        textMap[t12_11] = "t12_11"
        textMap[t12_12] = "t12_12"
        textMap[t13_1]  = "t13_1"
        textMap[t13_2]  = "t13_2"
        textMap[t13_3]  = "t13_3"
        textMap[t13_4]  = "t13_4"
        textMap[t13_5]  = "t13_5"
        textMap[t13_6]  = "t13_6"
        textMap[t13_7]  = "t13_7"
        textMap[t13_8]  = "t13_8"
        textMap[t13_9]  = "t13_9"
        textMap[t13_10] = "t13_10"
        textMap[t13_11] = "t13_11"
        textMap[t13_12] = "t13_12"
        textMap[t14_1]  = "t14_1"
        textMap[t14_2]  = "t14_2"
        textMap[t14_3]  = "t14_3"
        textMap[t14_4]  = "t14_4"
        textMap[t14_5]  = "t14_5"
        textMap[t14_6]  = "t14_6"
        textMap[t14_7]  = "t14_7"
        textMap[t14_8]  = "t14_8"
        textMap[t14_9]  = "t14_9"
        textMap[t14_10] = "t14_10"
        textMap[t14_11] = "t14_11"
        textMap[t14_12] = "t14_12"
        textMap[t15_1]  = "t15_1"
        textMap[t15_2]  = "t15_2"
        textMap[t15_3]  = "t15_3"
        textMap[t15_4]  = "t15_4"
        textMap[t15_5]  = "t15_5"
        textMap[t15_6]  = "t15_6"
        textMap[t15_7]  = "t15_7"
        textMap[t15_8]  = "t15_8"
        textMap[t15_9]  = "t15_9"
        textMap[t15_10] = "t15_10"
        textMap[t15_11] = "t15_11"
        textMap[t15_12] = "t15_12"
        textMap[t16_1]  = "t16_1"
        textMap[t16_2]  = "t16_2"
        textMap[t16_3]  = "t16_3"
        textMap[t16_4]  = "t16_4"
        textMap[t16_5]  = "t16_5"
        textMap[t16_6]  = "t16_6"
        textMap[t16_7]  = "t16_7"
        textMap[t16_8]  = "t16_8"
        textMap[t16_9]  = "t16_9"
        textMap[t16_10] = "t16_10"
        textMap[t16_11] = "t16_11"
        textMap[t16_12] = "t16_12"
        textMap[t17_1]  = "t17_1"
        textMap[t17_2]  = "t17_2"
        textMap[t17_3]  = "t17_3"
        textMap[t17_4]  = "t17_4"
        textMap[t17_5]  = "t17_5"
        textMap[t17_6]  = "t17_6"
        textMap[t17_7]  = "t17_7"
        textMap[t17_8]  = "t17_8"
        textMap[t17_9]  = "t17_9"
        textMap[t17_10] = "t17_10"
        textMap[t17_11] = "t17_11"
        textMap[t17_12] = "t17_12"
        textMap[t18_1]  = "t18_1"
        textMap[t18_2]  = "t18_2"
        textMap[t18_3]  = "t18_3"
        textMap[t18_4]  = "t18_4"
        textMap[t18_5]  = "t18_5"
        textMap[t18_6]  = "t18_6"
        textMap[t18_7]  = "t18_7"
        textMap[t18_8]  = "t18_8"
        textMap[t18_9]  = "t18_9"
        textMap[t18_10] = "t18_10"
        textMap[t18_11] = "t18_11"
        textMap[t18_12] = "t18_12"
        textMap[t19_1]  = "t19_1"
        textMap[t19_2]  = "t19_2"
        textMap[t19_3]  = "t19_3"
        textMap[t19_4]  = "t19_4"
        textMap[t19_5]  = "t19_5"
        textMap[t19_6]  = "t19_6"
        textMap[t19_7]  = "t19_7"
        textMap[t19_8]  = "t19_8"
        textMap[t19_9]  = "t19_9"
        textMap[t19_10] = "t19_10"
        textMap[t19_11] = "t19_11"
        textMap[t19_12] = "t19_12"
        textMap[t20_1]  = "t20_1"
        textMap[t20_2]  = "t20_2"
        textMap[t20_3]  = "t20_3"
        textMap[t20_4]  = "t20_4"
        textMap[t20_5]  = "t20_5"
        textMap[t20_6]  = "t20_6"
        textMap[t20_7]  = "t20_7"
        textMap[t20_8]  = "t20_8"
        textMap[t20_9]  = "t20_9"
        textMap[t20_10] = "t20_10"
        textMap[t20_11] = "t20_11"
        textMap[t20_12] = "t20_12"
        textMap[t21_1]  = "t21_1"
        textMap[t21_2]  = "t21_2"
        textMap[t21_3]  = "t21_3"
        textMap[t21_4]  = "t21_4"
        textMap[t21_5]  = "t21_5"
        textMap[t21_6]  = "t21_6"
        textMap[t21_7]  = "t21_7"
        textMap[t21_8]  = "t21_8"
        textMap[t21_9]  = "t21_9"
        textMap[t21_10] = "t21_10"
        textMap[t21_11] = "t21_11"
        textMap[t21_12] = "t21_12"
        textMap[t22_1]  = "t22_1"
        textMap[t22_2]  = "t22_2"
        textMap[t22_3]  = "t22_3"
        textMap[t22_4]  = "t22_4"
        textMap[t22_5]  = "t22_5"
        textMap[t22_6]  = "t22_6"
        textMap[t22_7]  = "t22_7"
        textMap[t22_8]  = "t22_8"
        textMap[t22_9]  = "t22_9"
        textMap[t22_10] = "t22_10"
        textMap[t22_11] = "t22_11"
        textMap[t22_12] = "t22_12"

        reverseTextMap["t1_1"]   = t1_1
        reverseTextMap["t1_2"]   = t1_2
        reverseTextMap["t1_3"]   = t1_3
        reverseTextMap["t1_4"]   = t1_4
        reverseTextMap["t1_5"]   = t1_5
        reverseTextMap["t1_6"]   = t1_6
        reverseTextMap["t1_7"]   = t1_7
        reverseTextMap["t1_8"]   = t1_8
        reverseTextMap["t1_9"]   = t1_9
        reverseTextMap["t1_10"]  = t1_10
        reverseTextMap["t1_11"]  = t1_11
        reverseTextMap["t1_12"]  = t1_12
        reverseTextMap["t2_1"]   = t2_1
        reverseTextMap["t2_2"]   = t2_2
        reverseTextMap["t2_3"]   = t2_3
        reverseTextMap["t2_4"]   = t2_4
        reverseTextMap["t2_5"]   = t2_5
        reverseTextMap["t2_6"]   = t2_6
        reverseTextMap["t2_7"]   = t2_7
        reverseTextMap["t2_8"]   = t2_8
        reverseTextMap["t2_9"]   = t2_9
        reverseTextMap["t2_10"]  = t2_10
        reverseTextMap["t2_11"]  = t2_11
        reverseTextMap["t2_12"]  = t2_12
        reverseTextMap["t3_1"]   = t3_1
        reverseTextMap["t3_2"]   = t3_2
        reverseTextMap["t3_3"]   = t3_3
        reverseTextMap["t3_4"]   = t3_4
        reverseTextMap["t3_5"]   = t3_5
        reverseTextMap["t3_6"]   = t3_6
        reverseTextMap["t3_7"]   = t3_7
        reverseTextMap["t3_8"]   = t3_8
        reverseTextMap["t3_9"]   = t3_9
        reverseTextMap["t3_10"]  = t3_10
        reverseTextMap["t3_11"]  = t3_11
        reverseTextMap["t3_12"]  = t3_12
        reverseTextMap["t4_1"]   = t4_1
        reverseTextMap["t4_2"]   = t4_2
        reverseTextMap["t4_3"]   = t4_3
        reverseTextMap["t4_4"]   = t4_4
        reverseTextMap["t4_5"]   = t4_5
        reverseTextMap["t4_6"]   = t4_6
        reverseTextMap["t4_7"]   = t4_7
        reverseTextMap["t4_8"]   = t4_8
        reverseTextMap["t4_9"]   = t4_9
        reverseTextMap["t4_10"]  = t4_10
        reverseTextMap["t4_11"]  = t4_11
        reverseTextMap["t4_12"]  = t4_12
        reverseTextMap["t5_1"]   = t5_1
        reverseTextMap["t5_2"]   = t5_2
        reverseTextMap["t5_3"]   = t5_3
        reverseTextMap["t5_4"]   = t5_4
        reverseTextMap["t5_5"]   = t5_5
        reverseTextMap["t5_6"]   = t5_6
        reverseTextMap["t5_7"]   = t5_7
        reverseTextMap["t5_8"]   = t5_8
        reverseTextMap["t5_9"]   = t5_9
        reverseTextMap["t5_10"]  = t5_10
        reverseTextMap["t5_11"]  = t5_11
        reverseTextMap["t5_12"]  = t5_12
        reverseTextMap["t6_1"]   = t6_1
        reverseTextMap["t6_2"]   = t6_2
        reverseTextMap["t6_3"]   = t6_3
        reverseTextMap["t6_4"]   = t6_4
        reverseTextMap["t6_5"]   = t6_5
        reverseTextMap["t6_6"]   = t6_6
        reverseTextMap["t6_7"]   = t6_7
        reverseTextMap["t6_8"]   = t6_8
        reverseTextMap["t6_9"]   = t6_9
        reverseTextMap["t6_10"]  = t6_10
        reverseTextMap["t6_11"]  = t6_11
        reverseTextMap["t6_12"]  = t6_12
        reverseTextMap["t7_1"]   = t7_1
        reverseTextMap["t7_2"]   = t7_2
        reverseTextMap["t7_3"]   = t7_3
        reverseTextMap["t7_4"]   = t7_4
        reverseTextMap["t7_5"]   = t7_5
        reverseTextMap["t7_6"]   = t7_6
        reverseTextMap["t7_7"]   = t7_7
        reverseTextMap["t7_8"]   = t7_8
        reverseTextMap["t7_9"]   = t7_9
        reverseTextMap["t7_10"]  = t7_10
        reverseTextMap["t7_11"]  = t7_11
        reverseTextMap["t7_12"]  = t7_12
        reverseTextMap["t8_1"]   = t8_1
        reverseTextMap["t8_2"]   = t8_2
        reverseTextMap["t8_3"]   = t8_3
        reverseTextMap["t8_4"]   = t8_4
        reverseTextMap["t8_5"]   = t8_5
        reverseTextMap["t8_6"]   = t8_6
        reverseTextMap["t8_7"]   = t8_7
        reverseTextMap["t8_8"]   = t8_8
        reverseTextMap["t8_9"]   = t8_9
        reverseTextMap["t8_10"]  = t8_10
        reverseTextMap["t8_11"]  = t8_11
        reverseTextMap["t8_12"]  = t8_12
        reverseTextMap["t9_1"]   = t9_1
        reverseTextMap["t9_2"]   = t9_2
        reverseTextMap["t9_3"]   = t9_3
        reverseTextMap["t9_4"]   = t9_4
        reverseTextMap["t9_5"]   = t9_5
        reverseTextMap["t9_6"]   = t9_6
        reverseTextMap["t9_7"]   = t9_7
        reverseTextMap["t9_8"]   = t9_8
        reverseTextMap["t9_9"]   = t9_9
        reverseTextMap["t9_10"]  = t9_10
        reverseTextMap["t9_11"]  = t9_11
        reverseTextMap["t9_12"]  = t9_12
        reverseTextMap["t10_1"]  = t10_1
        reverseTextMap["t10_2"]  = t10_2
        reverseTextMap["t10_3"]  = t10_3
        reverseTextMap["t10_4"]  = t10_4
        reverseTextMap["t10_5"]  = t10_5
        reverseTextMap["t10_6"]  = t10_6
        reverseTextMap["t10_7"]  = t10_7
        reverseTextMap["t10_8"]  = t10_8
        reverseTextMap["t10_9"]  = t10_9
        reverseTextMap["t10_10"] = t10_10
        reverseTextMap["t10_11"] = t10_11
        reverseTextMap["t10_12"] = t10_12
        reverseTextMap["t11_1"]  = t11_1
        reverseTextMap["t11_2"]  = t11_2
        reverseTextMap["t11_3"]  = t11_3
        reverseTextMap["t11_4"]  = t11_4
        reverseTextMap["t11_5"]  = t11_5
        reverseTextMap["t11_6"]  = t11_6
        reverseTextMap["t11_7"]  = t11_7
        reverseTextMap["t11_8"]  = t11_8
        reverseTextMap["t11_9"]  = t11_9
        reverseTextMap["t11_10"] = t11_10
        reverseTextMap["t11_11"] = t11_11
        reverseTextMap["t11_12"] = t11_12
        reverseTextMap["t12_1"]  = t12_1
        reverseTextMap["t12_2"]  = t12_2
        reverseTextMap["t12_3"]  = t12_3
        reverseTextMap["t12_4"]  = t12_4
        reverseTextMap["t12_5"]  = t12_5
        reverseTextMap["t12_6"]  = t12_6
        reverseTextMap["t12_7"]  = t12_7
        reverseTextMap["t12_8"]  = t12_8
        reverseTextMap["t12_9"]  = t12_9
        reverseTextMap["t12_10"] = t12_10
        reverseTextMap["t12_11"] = t12_11
        reverseTextMap["t12_12"] = t12_12
        reverseTextMap["t13_1"]  = t13_1
        reverseTextMap["t13_2"]  = t13_2
        reverseTextMap["t13_3"]  = t13_3
        reverseTextMap["t13_4"]  = t13_4
        reverseTextMap["t13_5"]  = t13_5
        reverseTextMap["t13_6"]  = t13_6
        reverseTextMap["t13_7"]  = t13_7
        reverseTextMap["t13_8"]  = t13_8
        reverseTextMap["t13_9"]  = t13_9
        reverseTextMap["t13_10"] = t13_10
        reverseTextMap["t13_11"] = t13_11
        reverseTextMap["t13_12"] = t13_12
        reverseTextMap["t14_1"]  = t14_1
        reverseTextMap["t14_2"]  = t14_2
        reverseTextMap["t14_3"]  = t14_3
        reverseTextMap["t14_4"]  = t14_4
        reverseTextMap["t14_5"]  = t14_5
        reverseTextMap["t14_6"]  = t14_6
        reverseTextMap["t14_7"]  = t14_7
        reverseTextMap["t14_8"]  = t14_8
        reverseTextMap["t14_9"]  = t14_9
        reverseTextMap["t14_10"] = t14_10
        reverseTextMap["t14_11"] = t14_11
        reverseTextMap["t14_12"] = t14_12
        reverseTextMap["t15_1"]  = t15_1
        reverseTextMap["t15_2"]  = t15_2
        reverseTextMap["t15_3"]  = t15_3
        reverseTextMap["t15_4"]  = t15_4
        reverseTextMap["t15_5"]  = t15_5
        reverseTextMap["t15_6"]  = t15_6
        reverseTextMap["t15_7"]  = t15_7
        reverseTextMap["t15_8"]  = t15_8
        reverseTextMap["t15_9"]  = t15_9
        reverseTextMap["t15_10"] = t15_10
        reverseTextMap["t15_11"] = t15_11
        reverseTextMap["t15_12"] = t15_12
        reverseTextMap["t16_1"]  = t16_1
        reverseTextMap["t16_2"]  = t16_2
        reverseTextMap["t16_3"]  = t16_3
        reverseTextMap["t16_4"]  = t16_4
        reverseTextMap["t16_5"]  = t16_5
        reverseTextMap["t16_6"]  = t16_6
        reverseTextMap["t16_7"]  = t16_7
        reverseTextMap["t16_8"]  = t16_8
        reverseTextMap["t16_9"]  = t16_9
        reverseTextMap["t16_10"] = t16_10
        reverseTextMap["t16_11"] = t16_11
        reverseTextMap["t16_12"] = t16_12
        reverseTextMap["t17_1"]  = t17_1
        reverseTextMap["t17_2"]  = t17_2
        reverseTextMap["t17_3"]  = t17_3
        reverseTextMap["t17_4"]  = t17_4
        reverseTextMap["t17_5"]  = t17_5
        reverseTextMap["t17_6"]  = t17_6
        reverseTextMap["t17_7"]  = t17_7
        reverseTextMap["t17_8"]  = t17_8
        reverseTextMap["t17_9"]  = t17_9
        reverseTextMap["t17_10"] = t17_10
        reverseTextMap["t17_11"] = t17_11
        reverseTextMap["t17_12"] = t17_12
        reverseTextMap["t18_1"]  = t18_1
        reverseTextMap["t18_2"]  = t18_2
        reverseTextMap["t18_3"]  = t18_3
        reverseTextMap["t18_4"]  = t18_4
        reverseTextMap["t18_5"]  = t18_5
        reverseTextMap["t18_6"]  = t18_6
        reverseTextMap["t18_7"]  = t18_7
        reverseTextMap["t18_8"]  = t18_8
        reverseTextMap["t18_9"]  = t18_9
        reverseTextMap["t18_10"] = t18_10
        reverseTextMap["t18_11"] = t18_11
        reverseTextMap["t18_12"] = t18_12
        reverseTextMap["t19_1"]  = t19_1
        reverseTextMap["t19_2"]  = t19_2
        reverseTextMap["t19_3"]  = t19_3
        reverseTextMap["t19_4"]  = t19_4
        reverseTextMap["t19_5"]  = t19_5
        reverseTextMap["t19_6"]  = t19_6
        reverseTextMap["t19_7"]  = t19_7
        reverseTextMap["t19_8"]  = t19_8
        reverseTextMap["t19_9"]  = t19_9
        reverseTextMap["t19_10"] = t19_10
        reverseTextMap["t19_11"] = t19_11
        reverseTextMap["t19_12"] = t19_12
        reverseTextMap["t20_1"]  = t20_1
        reverseTextMap["t20_2"]  = t20_2
        reverseTextMap["t20_3"]  = t20_3
        reverseTextMap["t20_4"]  = t20_4
        reverseTextMap["t20_5"]  = t20_5
        reverseTextMap["t20_6"]  = t20_6
        reverseTextMap["t20_7"]  = t20_7
        reverseTextMap["t20_8"]  = t20_8
        reverseTextMap["t20_9"]  = t20_9
        reverseTextMap["t20_10"] = t20_10
        reverseTextMap["t20_11"] = t20_11
        reverseTextMap["t20_12"] = t20_12
        reverseTextMap["t21_1"]  = t21_1
        reverseTextMap["t21_2"]  = t21_2
        reverseTextMap["t21_3"]  = t21_3
        reverseTextMap["t21_4"]  = t21_4
        reverseTextMap["t21_5"]  = t21_5
        reverseTextMap["t21_6"]  = t21_6
        reverseTextMap["t21_7"]  = t21_7
        reverseTextMap["t21_8"]  = t21_8
        reverseTextMap["t21_9"]  = t21_9
        reverseTextMap["t21_10"] = t21_10
        reverseTextMap["t21_11"] = t21_11
        reverseTextMap["t21_12"] = t21_12
        reverseTextMap["t22_1"]  = t22_1
        reverseTextMap["t22_2"]  = t22_2
        reverseTextMap["t22_3"]  = t22_3
        reverseTextMap["t22_4"]  = t22_4
        reverseTextMap["t22_5"]  = t22_5
        reverseTextMap["t22_6"]  = t22_6
        reverseTextMap["t22_7"]  = t22_7
        reverseTextMap["t22_8"]  = t22_8
        reverseTextMap["t22_9"]  = t22_9
        reverseTextMap["t22_10"] = t22_10
        reverseTextMap["t22_11"] = t22_11
        reverseTextMap["t22_12"] = t22_12

        t1_1.setOnClickListener(this)
        t1_2.setOnClickListener(this)
        t1_3.setOnClickListener(this)
        t1_4.setOnClickListener(this)
        t1_5.setOnClickListener(this)
        t1_6.setOnClickListener(this)
        t1_7.setOnClickListener(this)
        t1_8.setOnClickListener(this)
        t1_9.setOnClickListener(this)
        t1_10.setOnClickListener(this)
        t1_11.setOnClickListener(this)
        t1_12.setOnClickListener(this)
        t2_1.setOnClickListener(this)
        t2_2.setOnClickListener(this)
        t2_3.setOnClickListener(this)
        t2_4.setOnClickListener(this)
        t2_5.setOnClickListener(this)
        t2_6.setOnClickListener(this)
        t2_7.setOnClickListener(this)
        t2_8.setOnClickListener(this)
        t2_9.setOnClickListener(this)
        t2_10.setOnClickListener(this)
        t2_11.setOnClickListener(this)
        t2_12.setOnClickListener(this)
        t3_1.setOnClickListener(this)
        t3_2.setOnClickListener(this)
        t3_3.setOnClickListener(this)
        t3_4.setOnClickListener(this)
        t3_5.setOnClickListener(this)
        t3_6.setOnClickListener(this)
        t3_7.setOnClickListener(this)
        t3_8.setOnClickListener(this)
        t3_9.setOnClickListener(this)
        t3_10.setOnClickListener(this)
        t3_11.setOnClickListener(this)
        t3_12.setOnClickListener(this)
        t4_1.setOnClickListener(this)
        t4_2.setOnClickListener(this)
        t4_3.setOnClickListener(this)
        t4_4.setOnClickListener(this)
        t4_5.setOnClickListener(this)
        t4_6.setOnClickListener(this)
        t4_7.setOnClickListener(this)
        t4_8.setOnClickListener(this)
        t4_9.setOnClickListener(this)
        t4_10.setOnClickListener(this)
        t4_11.setOnClickListener(this)
        t4_12.setOnClickListener(this)
        t5_1.setOnClickListener(this)
        t5_2.setOnClickListener(this)
        t5_3.setOnClickListener(this)
        t5_4.setOnClickListener(this)
        t5_5.setOnClickListener(this)
        t5_6.setOnClickListener(this)
        t5_7.setOnClickListener(this)
        t5_8.setOnClickListener(this)
        t5_9.setOnClickListener(this)
        t5_10.setOnClickListener(this)
        t5_11.setOnClickListener(this)
        t5_12.setOnClickListener(this)
        t6_1.setOnClickListener(this)
        t6_2.setOnClickListener(this)
        t6_3.setOnClickListener(this)
        t6_4.setOnClickListener(this)
        t6_5.setOnClickListener(this)
        t6_6.setOnClickListener(this)
        t6_7.setOnClickListener(this)
        t6_8.setOnClickListener(this)
        t6_9.setOnClickListener(this)
        t6_10.setOnClickListener(this)
        t6_11.setOnClickListener(this)
        t6_12.setOnClickListener(this)
        t7_1.setOnClickListener(this)
        t7_2.setOnClickListener(this)
        t7_3.setOnClickListener(this)
        t7_4.setOnClickListener(this)
        t7_5.setOnClickListener(this)
        t7_6.setOnClickListener(this)
        t7_7.setOnClickListener(this)
        t7_8.setOnClickListener(this)
        t7_9.setOnClickListener(this)
        t7_10.setOnClickListener(this)
        t7_11.setOnClickListener(this)
        t7_12.setOnClickListener(this)
        t8_1.setOnClickListener(this)
        t8_2.setOnClickListener(this)
        t8_3.setOnClickListener(this)
        t8_4.setOnClickListener(this)
        t8_5.setOnClickListener(this)
        t8_6.setOnClickListener(this)
        t8_7.setOnClickListener(this)
        t8_8.setOnClickListener(this)
        t8_9.setOnClickListener(this)
        t8_10.setOnClickListener(this)
        t8_11.setOnClickListener(this)
        t8_12.setOnClickListener(this)
        t9_1.setOnClickListener(this)
        t9_2.setOnClickListener(this)
        t9_3.setOnClickListener(this)
        t9_4.setOnClickListener(this)
        t9_5.setOnClickListener(this)
        t9_6.setOnClickListener(this)
        t9_7.setOnClickListener(this)
        t9_8.setOnClickListener(this)
        t9_9.setOnClickListener(this)
        t9_10.setOnClickListener(this)
        t9_11.setOnClickListener(this)
        t9_12.setOnClickListener(this)
        t10_1.setOnClickListener(this)
        t10_2.setOnClickListener(this)
        t10_3.setOnClickListener(this)
        t10_4.setOnClickListener(this)
        t10_5.setOnClickListener(this)
        t10_6.setOnClickListener(this)
        t10_7.setOnClickListener(this)
        t10_8.setOnClickListener(this)
        t10_9.setOnClickListener(this)
        t10_10.setOnClickListener(this)
        t10_11.setOnClickListener(this)
        t10_12.setOnClickListener(this)
        t11_1.setOnClickListener(this)
        t11_2.setOnClickListener(this)
        t11_3.setOnClickListener(this)
        t11_4.setOnClickListener(this)
        t11_5.setOnClickListener(this)
        t11_6.setOnClickListener(this)
        t11_7.setOnClickListener(this)
        t11_8.setOnClickListener(this)
        t11_9.setOnClickListener(this)
        t11_10.setOnClickListener(this)
        t11_11.setOnClickListener(this)
        t11_12.setOnClickListener(this)
        t12_1.setOnClickListener(this)
        t12_2.setOnClickListener(this)
        t12_3.setOnClickListener(this)
        t12_4.setOnClickListener(this)
        t12_5.setOnClickListener(this)
        t12_6.setOnClickListener(this)
        t12_7.setOnClickListener(this)
        t12_8.setOnClickListener(this)
        t12_9.setOnClickListener(this)
        t12_10.setOnClickListener(this)
        t12_11.setOnClickListener(this)
        t12_12.setOnClickListener(this)
        t13_1.setOnClickListener(this)
        t13_2.setOnClickListener(this)
        t13_3.setOnClickListener(this)
        t13_4.setOnClickListener(this)
        t13_5.setOnClickListener(this)
        t13_6.setOnClickListener(this)
        t13_7.setOnClickListener(this)
        t13_8.setOnClickListener(this)
        t13_9.setOnClickListener(this)
        t13_10.setOnClickListener(this)
        t13_11.setOnClickListener(this)
        t13_12.setOnClickListener(this)
        t14_1.setOnClickListener(this)
        t14_2.setOnClickListener(this)
        t14_3.setOnClickListener(this)
        t14_4.setOnClickListener(this)
        t14_5.setOnClickListener(this)
        t14_6.setOnClickListener(this)
        t14_7.setOnClickListener(this)
        t14_8.setOnClickListener(this)
        t14_9.setOnClickListener(this)
        t14_10.setOnClickListener(this)
        t14_11.setOnClickListener(this)
        t14_12.setOnClickListener(this)
        t15_1.setOnClickListener(this)
        t15_2.setOnClickListener(this)
        t15_3.setOnClickListener(this)
        t15_4.setOnClickListener(this)
        t15_5.setOnClickListener(this)
        t15_6.setOnClickListener(this)
        t15_7.setOnClickListener(this)
        t15_8.setOnClickListener(this)
        t15_9.setOnClickListener(this)
        t15_10.setOnClickListener(this)
        t15_11.setOnClickListener(this)
        t15_12.setOnClickListener(this)
        t16_1.setOnClickListener(this)
        t16_2.setOnClickListener(this)
        t16_3.setOnClickListener(this)
        t16_4.setOnClickListener(this)
        t16_5.setOnClickListener(this)
        t16_6.setOnClickListener(this)
        t16_7.setOnClickListener(this)
        t16_8.setOnClickListener(this)
        t16_9.setOnClickListener(this)
        t16_10.setOnClickListener(this)
        t16_11.setOnClickListener(this)
        t16_12.setOnClickListener(this)
        t17_1.setOnClickListener(this)
        t17_2.setOnClickListener(this)
        t17_3.setOnClickListener(this)
        t17_4.setOnClickListener(this)
        t17_5.setOnClickListener(this)
        t17_6.setOnClickListener(this)
        t17_7.setOnClickListener(this)
        t17_8.setOnClickListener(this)
        t17_9.setOnClickListener(this)
        t17_10.setOnClickListener(this)
        t17_11.setOnClickListener(this)
        t17_12.setOnClickListener(this)
        t18_1.setOnClickListener(this)
        t18_2.setOnClickListener(this)
        t18_3.setOnClickListener(this)
        t18_4.setOnClickListener(this)
        t18_5.setOnClickListener(this)
        t18_6.setOnClickListener(this)
        t18_7.setOnClickListener(this)
        t18_8.setOnClickListener(this)
        t18_9.setOnClickListener(this)
        t18_10.setOnClickListener(this)
        t18_11.setOnClickListener(this)
        t18_12.setOnClickListener(this)
        t19_1.setOnClickListener(this)
        t19_2.setOnClickListener(this)
        t19_3.setOnClickListener(this)
        t19_4.setOnClickListener(this)
        t19_5.setOnClickListener(this)
        t19_6.setOnClickListener(this)
        t19_7.setOnClickListener(this)
        t19_8.setOnClickListener(this)
        t19_9.setOnClickListener(this)
        t19_10.setOnClickListener(this)
        t19_11.setOnClickListener(this)
        t19_12.setOnClickListener(this)
        t20_1.setOnClickListener(this)
        t20_2.setOnClickListener(this)
        t20_3.setOnClickListener(this)
        t20_4.setOnClickListener(this)
        t20_5.setOnClickListener(this)
        t20_6.setOnClickListener(this)
        t20_7.setOnClickListener(this)
        t20_8.setOnClickListener(this)
        t20_9.setOnClickListener(this)
        t20_10.setOnClickListener(this)
        t20_11.setOnClickListener(this)
        t20_12.setOnClickListener(this)
        t21_1.setOnClickListener(this)
        t21_2.setOnClickListener(this)
        t21_3.setOnClickListener(this)
        t21_4.setOnClickListener(this)
        t21_5.setOnClickListener(this)
        t21_6.setOnClickListener(this)
        t21_7.setOnClickListener(this)
        t21_8.setOnClickListener(this)
        t21_9.setOnClickListener(this)
        t21_10.setOnClickListener(this)
        t21_11.setOnClickListener(this)
        t21_12.setOnClickListener(this)
        t22_1.setOnClickListener(this)
        t22_2.setOnClickListener(this)
        t22_3.setOnClickListener(this)
        t22_4.setOnClickListener(this)
        t22_5.setOnClickListener(this)
        t22_6.setOnClickListener(this)
        t22_7.setOnClickListener(this)
        t22_8.setOnClickListener(this)
        t22_9.setOnClickListener(this)
        t22_10.setOnClickListener(this)
        t22_11.setOnClickListener(this)
        t22_12.setOnClickListener(this)

        t1_1.setOnLongClickListener(this)
        t1_2.setOnLongClickListener(this)
        t1_3.setOnLongClickListener(this)
        t1_4.setOnLongClickListener(this)
        t1_5.setOnLongClickListener(this)
        t1_6.setOnLongClickListener(this)
        t1_7.setOnLongClickListener(this)
        t1_8.setOnLongClickListener(this)
        t1_9.setOnLongClickListener(this)
        t1_10.setOnLongClickListener(this)
        t1_11.setOnLongClickListener(this)
        t1_12.setOnLongClickListener(this)
        t2_1.setOnLongClickListener(this)
        t2_2.setOnLongClickListener(this)
        t2_3.setOnLongClickListener(this)
        t2_4.setOnLongClickListener(this)
        t2_5.setOnLongClickListener(this)
        t2_6.setOnLongClickListener(this)
        t2_7.setOnLongClickListener(this)
        t2_8.setOnLongClickListener(this)
        t2_9.setOnLongClickListener(this)
        t2_10.setOnLongClickListener(this)
        t2_11.setOnLongClickListener(this)
        t2_12.setOnLongClickListener(this)
        t3_1.setOnLongClickListener(this)
        t3_2.setOnLongClickListener(this)
        t3_3.setOnLongClickListener(this)
        t3_4.setOnLongClickListener(this)
        t3_5.setOnLongClickListener(this)
        t3_6.setOnLongClickListener(this)
        t3_7.setOnLongClickListener(this)
        t3_8.setOnLongClickListener(this)
        t3_9.setOnLongClickListener(this)
        t3_10.setOnLongClickListener(this)
        t3_11.setOnLongClickListener(this)
        t3_12.setOnLongClickListener(this)
        t4_1.setOnLongClickListener(this)
        t4_2.setOnLongClickListener(this)
        t4_3.setOnLongClickListener(this)
        t4_4.setOnLongClickListener(this)
        t4_5.setOnLongClickListener(this)
        t4_6.setOnLongClickListener(this)
        t4_7.setOnLongClickListener(this)
        t4_8.setOnLongClickListener(this)
        t4_9.setOnLongClickListener(this)
        t4_10.setOnLongClickListener(this)
        t4_11.setOnLongClickListener(this)
        t4_12.setOnLongClickListener(this)
        t5_1.setOnLongClickListener(this)
        t5_2.setOnLongClickListener(this)
        t5_3.setOnLongClickListener(this)
        t5_4.setOnLongClickListener(this)
        t5_5.setOnLongClickListener(this)
        t5_6.setOnLongClickListener(this)
        t5_7.setOnLongClickListener(this)
        t5_8.setOnLongClickListener(this)
        t5_9.setOnLongClickListener(this)
        t5_10.setOnLongClickListener(this)
        t5_11.setOnLongClickListener(this)
        t5_12.setOnLongClickListener(this)
        t6_1.setOnLongClickListener(this)
        t6_2.setOnLongClickListener(this)
        t6_3.setOnLongClickListener(this)
        t6_4.setOnLongClickListener(this)
        t6_5.setOnLongClickListener(this)
        t6_6.setOnLongClickListener(this)
        t6_7.setOnLongClickListener(this)
        t6_8.setOnLongClickListener(this)
        t6_9.setOnLongClickListener(this)
        t6_10.setOnLongClickListener(this)
        t6_11.setOnLongClickListener(this)
        t6_12.setOnLongClickListener(this)
        t7_1.setOnLongClickListener(this)
        t7_2.setOnLongClickListener(this)
        t7_3.setOnLongClickListener(this)
        t7_4.setOnLongClickListener(this)
        t7_5.setOnLongClickListener(this)
        t7_6.setOnLongClickListener(this)
        t7_7.setOnLongClickListener(this)
        t7_8.setOnLongClickListener(this)
        t7_9.setOnLongClickListener(this)
        t7_10.setOnLongClickListener(this)
        t7_11.setOnLongClickListener(this)
        t7_12.setOnLongClickListener(this)
        t8_1.setOnLongClickListener(this)
        t8_2.setOnLongClickListener(this)
        t8_3.setOnLongClickListener(this)
        t8_4.setOnLongClickListener(this)
        t8_5.setOnLongClickListener(this)
        t8_6.setOnLongClickListener(this)
        t8_7.setOnLongClickListener(this)
        t8_8.setOnLongClickListener(this)
        t8_9.setOnLongClickListener(this)
        t8_10.setOnLongClickListener(this)
        t8_11.setOnLongClickListener(this)
        t8_12.setOnLongClickListener(this)
        t9_1.setOnLongClickListener(this)
        t9_2.setOnLongClickListener(this)
        t9_3.setOnLongClickListener(this)
        t9_4.setOnLongClickListener(this)
        t9_5.setOnLongClickListener(this)
        t9_6.setOnLongClickListener(this)
        t9_7.setOnLongClickListener(this)
        t9_8.setOnLongClickListener(this)
        t9_9.setOnLongClickListener(this)
        t9_10.setOnLongClickListener(this)
        t9_11.setOnLongClickListener(this)
        t9_12.setOnLongClickListener(this)
        t10_1.setOnLongClickListener(this)
        t10_2.setOnLongClickListener(this)
        t10_3.setOnLongClickListener(this)
        t10_4.setOnLongClickListener(this)
        t10_5.setOnLongClickListener(this)
        t10_6.setOnLongClickListener(this)
        t10_7.setOnLongClickListener(this)
        t10_8.setOnLongClickListener(this)
        t10_9.setOnLongClickListener(this)
        t10_10.setOnLongClickListener(this)
        t10_11.setOnLongClickListener(this)
        t10_12.setOnLongClickListener(this)
        t11_1.setOnLongClickListener(this)
        t11_2.setOnLongClickListener(this)
        t11_3.setOnLongClickListener(this)
        t11_4.setOnLongClickListener(this)
        t11_5.setOnLongClickListener(this)
        t11_6.setOnLongClickListener(this)
        t11_7.setOnLongClickListener(this)
        t11_8.setOnLongClickListener(this)
        t11_9.setOnLongClickListener(this)
        t11_10.setOnLongClickListener(this)
        t11_11.setOnLongClickListener(this)
        t11_12.setOnLongClickListener(this)
        t12_1.setOnLongClickListener(this)
        t12_2.setOnLongClickListener(this)
        t12_3.setOnLongClickListener(this)
        t12_4.setOnLongClickListener(this)
        t12_5.setOnLongClickListener(this)
        t12_6.setOnLongClickListener(this)
        t12_7.setOnLongClickListener(this)
        t12_8.setOnLongClickListener(this)
        t12_9.setOnLongClickListener(this)
        t12_10.setOnLongClickListener(this)
        t12_11.setOnLongClickListener(this)
        t12_12.setOnLongClickListener(this)
        t13_1.setOnLongClickListener(this)
        t13_2.setOnLongClickListener(this)
        t13_3.setOnLongClickListener(this)
        t13_4.setOnLongClickListener(this)
        t13_5.setOnLongClickListener(this)
        t13_6.setOnLongClickListener(this)
        t13_7.setOnLongClickListener(this)
        t13_8.setOnLongClickListener(this)
        t13_9.setOnLongClickListener(this)
        t13_10.setOnLongClickListener(this)
        t13_11.setOnLongClickListener(this)
        t13_12.setOnLongClickListener(this)
        t14_1.setOnLongClickListener(this)
        t14_2.setOnLongClickListener(this)
        t14_3.setOnLongClickListener(this)
        t14_4.setOnLongClickListener(this)
        t14_5.setOnLongClickListener(this)
        t14_6.setOnLongClickListener(this)
        t14_7.setOnLongClickListener(this)
        t14_8.setOnLongClickListener(this)
        t14_9.setOnLongClickListener(this)
        t14_10.setOnLongClickListener(this)
        t14_11.setOnLongClickListener(this)
        t14_12.setOnLongClickListener(this)
        t15_1.setOnLongClickListener(this)
        t15_2.setOnLongClickListener(this)
        t15_3.setOnLongClickListener(this)
        t15_4.setOnLongClickListener(this)
        t15_5.setOnLongClickListener(this)
        t15_6.setOnLongClickListener(this)
        t15_7.setOnLongClickListener(this)
        t15_8.setOnLongClickListener(this)
        t15_9.setOnLongClickListener(this)
        t15_10.setOnLongClickListener(this)
        t15_11.setOnLongClickListener(this)
        t15_12.setOnLongClickListener(this)
        t16_1.setOnLongClickListener(this)
        t16_2.setOnLongClickListener(this)
        t16_3.setOnLongClickListener(this)
        t16_4.setOnLongClickListener(this)
        t16_5.setOnLongClickListener(this)
        t16_6.setOnLongClickListener(this)
        t16_7.setOnLongClickListener(this)
        t16_8.setOnLongClickListener(this)
        t16_9.setOnLongClickListener(this)
        t16_10.setOnLongClickListener(this)
        t16_11.setOnLongClickListener(this)
        t16_12.setOnLongClickListener(this)
        t17_1.setOnLongClickListener(this)
        t17_2.setOnLongClickListener(this)
        t17_3.setOnLongClickListener(this)
        t17_4.setOnLongClickListener(this)
        t17_5.setOnLongClickListener(this)
        t17_6.setOnLongClickListener(this)
        t17_7.setOnLongClickListener(this)
        t17_8.setOnLongClickListener(this)
        t17_9.setOnLongClickListener(this)
        t17_10.setOnLongClickListener(this)
        t17_11.setOnLongClickListener(this)
        t17_12.setOnLongClickListener(this)
        t18_1.setOnLongClickListener(this)
        t18_2.setOnLongClickListener(this)
        t18_3.setOnLongClickListener(this)
        t18_4.setOnLongClickListener(this)
        t18_5.setOnLongClickListener(this)
        t18_6.setOnLongClickListener(this)
        t18_7.setOnLongClickListener(this)
        t18_8.setOnLongClickListener(this)
        t18_9.setOnLongClickListener(this)
        t18_10.setOnLongClickListener(this)
        t18_11.setOnLongClickListener(this)
        t18_12.setOnLongClickListener(this)
        t19_1.setOnLongClickListener(this)
        t19_2.setOnLongClickListener(this)
        t19_3.setOnLongClickListener(this)
        t19_4.setOnLongClickListener(this)
        t19_5.setOnLongClickListener(this)
        t19_6.setOnLongClickListener(this)
        t19_7.setOnLongClickListener(this)
        t19_8.setOnLongClickListener(this)
        t19_9.setOnLongClickListener(this)
        t19_10.setOnLongClickListener(this)
        t19_11.setOnLongClickListener(this)
        t19_12.setOnLongClickListener(this)
        t20_1.setOnLongClickListener(this)
        t20_2.setOnLongClickListener(this)
        t20_3.setOnLongClickListener(this)
        t20_4.setOnLongClickListener(this)
        t20_5.setOnLongClickListener(this)
        t20_6.setOnLongClickListener(this)
        t20_7.setOnLongClickListener(this)
        t20_8.setOnLongClickListener(this)
        t20_9.setOnLongClickListener(this)
        t20_10.setOnLongClickListener(this)
        t20_11.setOnLongClickListener(this)
        t20_12.setOnLongClickListener(this)
        t21_1.setOnLongClickListener(this)
        t21_2.setOnLongClickListener(this)
        t21_3.setOnLongClickListener(this)
        t21_4.setOnLongClickListener(this)
        t21_5.setOnLongClickListener(this)
        t21_6.setOnLongClickListener(this)
        t21_7.setOnLongClickListener(this)
        t21_8.setOnLongClickListener(this)
        t21_9.setOnLongClickListener(this)
        t21_10.setOnLongClickListener(this)
        t21_11.setOnLongClickListener(this)
        t21_12.setOnLongClickListener(this)
        t22_1.setOnLongClickListener(this)
        t22_2.setOnLongClickListener(this)
        t22_3.setOnLongClickListener(this)
        t22_4.setOnLongClickListener(this)
        t22_5.setOnLongClickListener(this)
        t22_6.setOnLongClickListener(this)
        t22_7.setOnLongClickListener(this)
        t22_8.setOnLongClickListener(this)
        t22_9.setOnLongClickListener(this)
        t22_10.setOnLongClickListener(this)
        t22_11.setOnLongClickListener(this)
        t22_12.setOnLongClickListener(this)

    }

    override fun onClick(view: View?){
        val tapBox = view as TextView
        var row = 0
        var col = 0
        val tv = textMap[tapBox]

        if (tv != null) {
            row = tv.substring(1, tv.indexOf('_')).toInt() - 1
        }
        if (tv != null) {
            col = tv.substring(tv.indexOf('_')+1).toInt() - 1
        }

        if (openedTiles[row][col]) return
        if (markedTiles[row][col]) return
        if (board[row][col] == -1){
            tapBox.setBackgroundResource(R.drawable.round_mine_tile)
        }
        else if (board[row][col] != 0){
            tapBox.setBackgroundResource(R.drawable.round_blank_tile)
            tapBox.text = board[row][col].toString()
            tapBox.setTextColor(Color.parseColor("#bdd0e1"))
            openedTiles[row][col] = true
        }
        else{
            tapBox.setBackgroundResource(R.drawable.round_blank_tile)
            openBoard(row, col)
        }
    }

    override fun onLongClick(view: View?): Boolean {
        val tapBox = view as TextView
        var row = 0
        var col = 0
        val tv = textMap[tapBox]

        if (tv != null) {
            row = tv.substring(1, tv.indexOf('_')).toInt() - 1
        }
        if (tv != null) {
            col = tv.substring(tv.indexOf('_')+1).toInt() - 1
        }

        if (openedTiles[row][col]) return false
        if (markedTiles[row][col]){
            markedTiles[row][col] = false
            tapBox.setBackgroundResource(R.drawable.round_idle_tile)
        }
        else{
            markedTiles[row][col] = true
            tapBox.setBackgroundResource(R.drawable.round_marked_tile)
        }
        return true
    }

    private fun openBoard(row:Int, col:Int){

        if (row < 0 || row > 21 || col < 0 || col > 11) return
        if (openedTiles[row][col]) return
        openedTiles[row][col] = true
        val tv = "t${row+1}_${col+1}"
        if (board[row][col] == 0){
            reverseTextMap[tv]?.setBackgroundResource(R.drawable.round_blank_tile)
            openBoard(row-1, col-1)
            openBoard(row-1, col)
            openBoard(row-1, col+1)
            openBoard(row, col-1)
            openBoard(row, col+1)
            openBoard(row+1, col-1)
            openBoard(row+1, col)
            openBoard(row+1, col+1)
        }
        else {
            reverseTextMap[tv]?.setBackgroundResource(R.drawable.round_blank_tile)
            reverseTextMap[tv]?.text = board[row][col].toString()
            reverseTextMap[tv]?.setTextColor(Color.parseColor("#bdd0e1"))
        }

    }

    private fun generateMines(){
        var totalMines = 0
        while (totalMines != 40){
            for (i in 0..21){
                for (j in 0..11){
                    if ((totalMines == 40) || (board[i][j] == -1)) continue
                    val rand = (1..3300).random()
                    if (rand <= 500){
                        board[i][j] = -1
                        totalMines++
                    }
                }
            }
        }
        setBoardValues()
    }

    private fun setBoardValues(){

        for (i in 0..21){
            for (j in 0..11){
                if (board[i][j] == -1){
                    setVal(i-1, j-1)
                    setVal(i-1, j)
                    setVal(i-1, j+1)
                    setVal(i, j-1)
                    setVal(i, j+1)
                    setVal(i+1, j-1)
                    setVal(i+1, j)
                    setVal(i+1, j+1)
                }
            }
        }
    }

    private fun setVal(i:Int, j:Int){

        if (i < 0 || i > 21 || j < 0 || j > 11) return
        if (board[i][j] == -1) return
        board[i][j]++

    }

}