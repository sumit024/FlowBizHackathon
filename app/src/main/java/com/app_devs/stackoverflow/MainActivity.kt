package com.app_devs.stackoverflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.app_devs.stackoverflow.databinding.ActivityMainBinding
import com.app_devs.stackoverflow.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mViewModel:MainActivityViewModel
    private lateinit var mAdapter: QuestionsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        mAdapter= QuestionsAdapter(this)
        initRecyclerView()
        setContentView(binding.root)
    }

    private fun initViewModel() {
        mViewModel=ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mViewModel.getQuestionsObservable().observe(this, Observer {
            if(it!=null) {
                mAdapter.list= it.items
                mAdapter.notifyDataSetChanged()
            }
            else
                Toast.makeText(this,"bsdk",Toast.LENGTH_LONG).show()
        })
        mViewModel.getQuestions()
    }
    private fun initRecyclerView()
    {
        binding.rvQuestions.apply {
            layoutManager=LinearLayoutManager(this@MainActivity)
            val decoration=DividerItemDecoration(this@MainActivity,DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            adapter=mAdapter
        }
        initViewModel()
    }
}