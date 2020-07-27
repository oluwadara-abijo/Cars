package com.dara.cars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var cars : List<Car>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val blueCar = Car("Blue Kia Cerato", 4.5F, "18", 188F, R.drawable.car_blue)
        val redCar = Car("Red Tesla", 4.3F, "10", 179F, R.drawable.car_red)
        cars = listOf(blueCar, redCar)

        setupSearchView(search_view)
        setupImagesRecyclerView()
    }

    private fun setupSearchView(searchView: SearchView) {
        search_view.apply {
            queryHint = "Florida, USA"
            setIconifiedByDefault(false)
        }
        //Get ImageView of icon
        val searchViewIcon: ImageView =
            searchView.findViewById(androidx.appcompat.R.id.search_mag_icon) as ImageView
        //Get parent of icon
        searchViewIcon.setImageResource(R.drawable.calendar)
        val linearLayoutSearchView = searchViewIcon.parent as ViewGroup
        //Remove it from the left
        linearLayoutSearchView.removeView(searchViewIcon)
        //then put it back (to the right by default)
        linearLayoutSearchView.addView(searchViewIcon)
    }

    private fun setupImagesRecyclerView() {
        val carAdapter = CarAdapter(cars)
        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_cars.apply {
            adapter = carAdapter
            layoutManager = linearLayoutManager
        }
    }

}