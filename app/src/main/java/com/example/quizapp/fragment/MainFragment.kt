package com.example.quizapp.fragment

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import androidx.fragment.app.Fragment
import com.example.quizapp.R
import com.example.quizapp.constant.QuestionList
import com.example.quizapp.databinding.FragmentMainBinding
import com.example.quizapp.model.Question

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        val question = requireArguments().getSerializable("question") as Question
        binding.tvQuestion.text = question.question
        binding.ivQuestion.setBackgroundResource(question.image)

        for (id in question.options.indices) {
            val rdbtn = RadioButton(requireContext())
            rdbtn.id = id
            rdbtn.text = question.options[id]
            if (question.selectedOption!=-1 && question.selectedOption == id+1)
                rdbtn.isChecked = true
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.MATCH_PARENT,
                RadioGroup.LayoutParams.MATCH_PARENT
            )
            params.setMargins(0,40,0,0)
            rdbtn.layoutParams = params
            rdbtn.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.defaultOption))
            rdbtn.setOnClickListener {
                val questionIndex = QuestionList.questionList.indexOf(question)
                QuestionList.questionList[questionIndex].selectedOption = id+1

            }

            rdbtn.setOnCheckedChangeListener{ buttonView, isChecked ->
                if (isChecked)
                    rdbtn.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.selectedOption))
                else
                    rdbtn.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.defaultOption))
            }

            val colorStateList = ColorStateList(
                arrayOf(intArrayOf(android.R.attr.state_enabled)),
                intArrayOf(Color.parseColor("#2D2FAB"))
            )

            rdbtn.buttonTintList = colorStateList
            rdbtn.setPadding(30)
            binding.radioGroup.addView(rdbtn)
        }
        return binding.root
    }

}