package com.example.quizapp.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RadioGroup
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.constant.QuestionList
import com.example.quizapp.databinding.LayoutQuestionBinding


class ResultAdapter :
    RecyclerView.Adapter<ResultAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            LayoutQuestionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return QuestionList.questionList.size
    }

    inner class ViewHolder(val binding: LayoutQuestionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {

            val colorStateListCorrect = ColorStateList(
                arrayOf(intArrayOf(android.R.attr.state_enabled)),
                intArrayOf(Color.parseColor("#43A047"))
            )

            val colorStateListWrong = ColorStateList(
                arrayOf(intArrayOf(android.R.attr.state_enabled)),
                intArrayOf(Color.parseColor("#FB0000"))
            )
            
            val question = QuestionList.questionList[position]
            binding.image.setBackgroundResource(question.image)
            binding.tvQuestion.text = question.question
            for (id in question.options.indices) {
                val rdbtn = CheckBox(binding.root.context)
                rdbtn.text = question.options[id]
                val params = RadioGroup.LayoutParams(
                    RadioGroup.LayoutParams.MATCH_PARENT,
                    RadioGroup.LayoutParams.MATCH_PARENT
                )
                params.setMargins(0,40,0,0)
                rdbtn.layoutParams = params
                rdbtn.isClickable = false

                rdbtn.setBackgroundColor(ContextCompat.getColor(binding.root.context,
                    R.color.defaultOption))

                if (question.correctOption == id + 1) {
                    rdbtn.isChecked = true
                    rdbtn.buttonTintList = colorStateListCorrect
                    rdbtn.setBackgroundColor(ContextCompat.getColor(binding.root.context,
                        R.color.correct))
                }

                if (question.selectedOption!=-1 && question.selectedOption == id+1 && question.selectedOption!=question.correctOption) {
                    rdbtn.isChecked = true
                    rdbtn.buttonTintList = colorStateListWrong
                    rdbtn.setBackgroundColor(ContextCompat.getColor(binding.root.context,
                        R.color.wrong))
                }

                rdbtn.setPadding(30)
                binding.radioGroup.addView(rdbtn)
            }
        }
    }
}