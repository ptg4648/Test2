package com.android.healthcareproject

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.healthcareproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding


    companion object {
        lateinit var sharedPreferences : SharedPreferences
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        init()
    }


    private fun init() {
        // SharedPreferences 초기화
        sharedPreferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE)

        // 초기 화면 설정
        supportFragmentManager.beginTransaction().replace(R.id.layout_container, FragmentHome()).commit()


        // BottomNavigationView 이벤트 설정
        binding.navBottom.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction().replace(R.id.layout_container, FragmentHome()).commit()
                    true
                }
                R.id.nav_food -> {
                    supportFragmentManager.beginTransaction().replace(R.id.layout_container, FragmentFood()).commit()
                    true
                }

                R.id.nav_profile -> {
                    supportFragmentManager.beginTransaction().replace(R.id.layout_container, FragmentProfile()).commit()
                    true
                }
                else -> false
            }
        }
    }
}