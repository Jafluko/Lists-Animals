package com.example.animalslists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.animalslists.model.data.Cat
import com.example.animalslists.view.AllFragment
import com.example.animalslists.view.CatFragment
import com.example.animalslists.view.DogFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.lang.reflect.Type

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(AllFragment())
        val navigation = findViewById<BottomNavigationView>(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.all -> loadFragment(AllFragment())
            R.id.cat -> loadFragment(CatFragment())
            R.id.dog -> loadFragment(DogFragment())
            else -> false
        }
    }

    private fun loadFragment(fragment: Fragment): Boolean {
        return run {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
                .commit()
            true
        }
    }
}