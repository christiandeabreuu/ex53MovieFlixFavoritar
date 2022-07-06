package br.com.zup.movieflix.register.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.movieflix.R
import br.com.zup.movieflix.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}