package com.practice.apphero

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.practice.apphero.MainActivity.Companion.KEY_HERO
import com.practice.apphero.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hero = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Hero>(KEY_HERO, Hero::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Hero>(KEY_HERO)
        }

        if (hero != null) {
            val name = hero.name
            val description = hero.description
            val photo = hero.photo

            binding.tvHeroName.text = name
            binding.tvHeroDescription.text = description
            Glide.with(this)
                .load(photo)
                .into(binding.imgDetailHero)
        }
    }
}