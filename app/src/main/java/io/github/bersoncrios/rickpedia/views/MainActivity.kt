package io.github.bersoncrios.rickpedia.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.bersoncrios.rickpedia.Application
import io.github.bersoncrios.rickpedia.R
import io.github.bersoncrios.rickpedia.databinding.ActivityMainBinding
import io.github.bersoncrios.rickpedia.viewmodel.CharViewModel
import io.github.bersoncrios.rickpedia.viewmodel.ViewModelFactory
import io.github.bersoncrios.rickpedia.views.adapters.CharAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var charViewModel: CharViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CharAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.rvChars.setHasFixedSize(true)
        binding.rvChars.layoutManager = LinearLayoutManager(this)

        val charRepository = (application as Application).charRepository
        charViewModel =
            ViewModelProvider(this, ViewModelFactory(charRepository))[CharViewModel::class.java]

        charViewModel.chars.observe(this) { charList ->
            charList.let { charList ->
                adapter = CharAdapter(this, charList,
                    CharAdapter.OnClickListener { char ->
                        Toast.makeText(applicationContext, char.url, Toast.LENGTH_SHORT).show()
                    }
                )
                binding.rvChars.adapter = adapter
                adapter.notifyDataSetChanged()
            }
        }
    }
}