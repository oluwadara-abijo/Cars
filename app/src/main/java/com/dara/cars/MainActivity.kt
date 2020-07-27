package com.dara.cars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.SearchView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupSearchView(search_view)
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

}