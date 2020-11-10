package com.devdhruv.minesweeper.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.devdhruv.minesweeper.R

class EasyPlay : Fragment(), View.OnClickListener {

    private val textMap = HashMap<TextView, String>()
    private var board   = Array(10) {IntArray(7) {0} }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view:View =  inflater.inflate(R.layout.fragment_easy_play, container, false)

        val t11: TextView = view.findViewById(R.id.t11)
        val t12: TextView = view.findViewById(R.id.t12)
        val t13: TextView = view.findViewById(R.id.t13)
        val t14: TextView = view.findViewById(R.id.t14)
        val t15: TextView = view.findViewById(R.id.t15)
        val t16: TextView = view.findViewById(R.id.t16)
        val t17: TextView = view.findViewById(R.id.t17)
        val t21: TextView = view.findViewById(R.id.t21)
        val t22: TextView = view.findViewById(R.id.t22)
        val t23: TextView = view.findViewById(R.id.t23)
        val t24: TextView = view.findViewById(R.id.t24)
        val t25: TextView = view.findViewById(R.id.t25)
        val t26: TextView = view.findViewById(R.id.t26)
        val t27: TextView = view.findViewById(R.id.t27)
        val t31: TextView = view.findViewById(R.id.t31)
        val t32: TextView = view.findViewById(R.id.t32)
        val t33: TextView = view.findViewById(R.id.t33)
        val t34: TextView = view.findViewById(R.id.t34)
        val t35: TextView = view.findViewById(R.id.t35)
        val t36: TextView = view.findViewById(R.id.t36)
        val t37: TextView = view.findViewById(R.id.t37)
        val t41: TextView = view.findViewById(R.id.t41)
        val t42: TextView = view.findViewById(R.id.t42)
        val t43: TextView = view.findViewById(R.id.t43)
        val t44: TextView = view.findViewById(R.id.t44)
        val t45: TextView = view.findViewById(R.id.t45)
        val t46: TextView = view.findViewById(R.id.t46)
        val t47: TextView = view.findViewById(R.id.t47)
        val t51: TextView = view.findViewById(R.id.t51)
        val t52: TextView = view.findViewById(R.id.t52)
        val t53: TextView = view.findViewById(R.id.t53)
        val t54: TextView = view.findViewById(R.id.t54)
        val t55: TextView = view.findViewById(R.id.t55)
        val t56: TextView = view.findViewById(R.id.t56)
        val t57: TextView = view.findViewById(R.id.t57)
        val t61: TextView = view.findViewById(R.id.t61)
        val t62: TextView = view.findViewById(R.id.t62)
        val t63: TextView = view.findViewById(R.id.t63)
        val t64: TextView = view.findViewById(R.id.t64)
        val t65: TextView = view.findViewById(R.id.t65)
        val t66: TextView = view.findViewById(R.id.t66)
        val t67: TextView = view.findViewById(R.id.t67)
        val t71: TextView = view.findViewById(R.id.t71)
        val t72: TextView = view.findViewById(R.id.t72)
        val t73: TextView = view.findViewById(R.id.t73)
        val t74: TextView = view.findViewById(R.id.t74)
        val t75: TextView = view.findViewById(R.id.t75)
        val t76: TextView = view.findViewById(R.id.t76)
        val t77: TextView = view.findViewById(R.id.t77)
        val t81: TextView = view.findViewById(R.id.t81)
        val t82: TextView = view.findViewById(R.id.t82)
        val t83: TextView = view.findViewById(R.id.t83)
        val t84: TextView = view.findViewById(R.id.t84)
        val t85: TextView = view.findViewById(R.id.t85)
        val t86: TextView = view.findViewById(R.id.t86)
        val t87: TextView = view.findViewById(R.id.t87)
        val t91: TextView = view.findViewById(R.id.t91)
        val t92: TextView = view.findViewById(R.id.t92)
        val t93: TextView = view.findViewById(R.id.t93)
        val t94: TextView = view.findViewById(R.id.t94)
        val t95: TextView = view.findViewById(R.id.t95)
        val t96: TextView = view.findViewById(R.id.t96)
        val t97: TextView = view.findViewById(R.id.t97)
        val t101: TextView = view.findViewById(R.id.t101)
        val t102: TextView = view.findViewById(R.id.t102)
        val t103: TextView = view.findViewById(R.id.t103)
        val t104: TextView = view.findViewById(R.id.t104)
        val t105: TextView = view.findViewById(R.id.t105)
        val t106: TextView = view.findViewById(R.id.t106)
        val t107: TextView = view.findViewById(R.id.t107)

        textMap[t11] = "t1_1"
        textMap[t12] = "t1_2"
        textMap[t13] = "t1_3"
        textMap[t14] = "t1_4"
        textMap[t15] = "t1_5"
        textMap[t16] = "t1_6"
        textMap[t17] = "t1_7"
        textMap[t21] = "t2_1"
        textMap[t22] = "t2_2"
        textMap[t23] = "t2_3"
        textMap[t24] = "t2_4"
        textMap[t25] = "t2_5"
        textMap[t26] = "t2_6"
        textMap[t27] = "t2_7"
        textMap[t31] = "t3_1"
        textMap[t32] = "t3_2"
        textMap[t33] = "t3_3"
        textMap[t34] = "t3_4"
        textMap[t35] = "t3_5"
        textMap[t36] = "t3_6"
        textMap[t37] = "t3_7"
        textMap[t41] = "t4_1"
        textMap[t42] = "t4_2"
        textMap[t43] = "t4_3"
        textMap[t44] = "t4_4"
        textMap[t45] = "t4_5"
        textMap[t46] = "t4_6"
        textMap[t47] = "t4_7"
        textMap[t51] = "t5_1"
        textMap[t52] = "t5_2"
        textMap[t53] = "t5_3"
        textMap[t54] = "t5_4"
        textMap[t55] = "t5_5"
        textMap[t56] = "t5_6"
        textMap[t57] = "t5_7"
        textMap[t61] = "t6_1"
        textMap[t62] = "t6_2"
        textMap[t63] = "t6_3"
        textMap[t64] = "t6_4"
        textMap[t65] = "t6_5"
        textMap[t66] = "t6_6"
        textMap[t67] = "t6_7"
        textMap[t71] = "t7_1"
        textMap[t72] = "t7_2"
        textMap[t73] = "t7_3"
        textMap[t74] = "t7_4"
        textMap[t75] = "t7_5"
        textMap[t76] = "t7_6"
        textMap[t77] = "t7_7"
        textMap[t81] = "t8_1"
        textMap[t82] = "t8_2"
        textMap[t83] = "t8_3"
        textMap[t84] = "t8_4"
        textMap[t85] = "t8_5"
        textMap[t86] = "t8_6"
        textMap[t87] = "t8_7"
        textMap[t91] = "t9_1"
        textMap[t92] = "t9_2"
        textMap[t93] = "t9_3"
        textMap[t94] = "t9_4"
        textMap[t95] = "t9_5"
        textMap[t96] = "t9_6"
        textMap[t97] = "t9_7"
        textMap[t101] = "t10_1"
        textMap[t102] = "t10_2"
        textMap[t103] = "t10_3"
        textMap[t104] = "t10_4"
        textMap[t105] = "t10_5"
        textMap[t106] = "t10_6"
        textMap[t107] = "t10_7"

//        generateMines()

        t11.setOnClickListener(this)
        t12.setOnClickListener(this)
        t13.setOnClickListener(this)
        t14.setOnClickListener(this)
        t15.setOnClickListener(this)
        t16.setOnClickListener(this)
        t17.setOnClickListener(this)
        t21.setOnClickListener(this)
        t22.setOnClickListener(this)
        t23.setOnClickListener(this)
        t24.setOnClickListener(this)
        t25.setOnClickListener(this)
        t26.setOnClickListener(this)
        t27.setOnClickListener(this)
        t31.setOnClickListener(this)
        t32.setOnClickListener(this)
        t33.setOnClickListener(this)
        t34.setOnClickListener(this)
        t35.setOnClickListener(this)
        t36.setOnClickListener(this)
        t37.setOnClickListener(this)
        t41.setOnClickListener(this)
        t42.setOnClickListener(this)
        t43.setOnClickListener(this)
        t44.setOnClickListener(this)
        t45.setOnClickListener(this)
        t46.setOnClickListener(this)
        t47.setOnClickListener(this)
        t51.setOnClickListener(this)
        t52.setOnClickListener(this)
        t53.setOnClickListener(this)
        t54.setOnClickListener(this)
        t55.setOnClickListener(this)
        t56.setOnClickListener(this)
        t57.setOnClickListener(this)
        t61.setOnClickListener(this)
        t62.setOnClickListener(this)
        t63.setOnClickListener(this)
        t64.setOnClickListener(this)
        t65.setOnClickListener(this)
        t66.setOnClickListener(this)
        t67.setOnClickListener(this)
        t71.setOnClickListener(this)
        t72.setOnClickListener(this)
        t73.setOnClickListener(this)
        t74.setOnClickListener(this)
        t75.setOnClickListener(this)
        t76.setOnClickListener(this)
        t77.setOnClickListener(this)
        t81.setOnClickListener(this)
        t82.setOnClickListener(this)
        t83.setOnClickListener(this)
        t84.setOnClickListener(this)
        t85.setOnClickListener(this)
        t86.setOnClickListener(this)
        t87.setOnClickListener(this)
        t91.setOnClickListener(this)
        t92.setOnClickListener(this)
        t93.setOnClickListener(this)
        t94.setOnClickListener(this)
        t95.setOnClickListener(this)
        t96.setOnClickListener(this)
        t97.setOnClickListener(this)
        t101.setOnClickListener(this)
        t102.setOnClickListener(this)
        t103.setOnClickListener(this)
        t104.setOnClickListener(this)
        t105.setOnClickListener(this)
        t106.setOnClickListener(this)
        t107.setOnClickListener(this)



        return view
    }

    @SuppressLint("ResourceAsColor")
    override fun onClick(v: View?){
        val tapBox = v as TextView
        tapBox!!.setBackgroundResource(R.drawable.round_mine_tile)
    }

    fun generateMines(){

        for (i in 0..9){
            for (j in 0..6){

            }
        }

    }

}
