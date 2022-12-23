package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.constant.QuestionList
import com.example.quizapp.databinding.ActivityMainBinding
import com.example.quizapp.databinding.FragmentMainBinding
import com.example.quizapp.model.Question
import com.example.quizapp.ui.MainFragment
import com.example.quizapp.ui.ResultActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    var counter = 0
    lateinit var questionList: ArrayList<Question>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE;
        questionList = QuestionList.questionList
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }


        if (savedInstanceState == null) {
            updateCounterUI()
            val fragment = MainFragment.newInstance()
            val bundle = Bundle()
            bundle.putSerializable("question", questionList[counter])
            fragment.arguments = bundle
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commitNow()
        }
        updateCounterUI()
        binding.btnNext.setOnClickListener {
            if (counter<questionList.size-1) {
                counter++
                updateCounterUI()
                val question = questionList[counter]
                val fragment = MainFragment.newInstance()
                val bundle = Bundle()
                bundle.putSerializable("question", question)
                fragment.arguments = bundle
                supportFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in_right,  // enter
                        R.anim.slide_out_left,  // exit
                        R.anim.slide_in_left,   // popEnter
                        R.anim.slide_out_right  // popExit
                    )
                    .replace(R.id.container, fragment)
                    .addToBackStack(null)
                    .commit()
            }else{
                startActivity(Intent(this@MainActivity, ResultActivity::class.java))
                finish()
            }
        }

        binding.btnPrevious.setOnClickListener {

            if (counter>=1) {
                counter--
                onBackPressed()
            }
            updateCounterUI()
        }
    }

    private fun updateCounterUI() {
        val progress = ((counter+1).toFloat() /questionList.size.toFloat())*100
        binding.progressIndicator.progress = progress.toInt()
        binding.counterIndicator.text = "${counter+1}/${questionList.size}"
    }
}