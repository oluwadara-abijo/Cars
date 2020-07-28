package com.dara.cars

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarAdapter(private var cars: List<Car>, private val clickListener: ItemClickListener) :
    RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    inner class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        fun bind(car: Car) {
            itemView.findViewById<ImageView>(R.id.img_car).setImageResource(car.image)
            itemView.findViewById<TextView>(R.id.tv_car_name).text = car.name
            itemView.findViewById<TextView>(R.id.tv_rating).text = car.rating.toString()
            itemView.findViewById<TextView>(R.id.tv_deals).text = "${car.deals} Deals"
            itemView.findViewById<TextView>(R.id.tv_car_rate).text = "From $${car.rate}/day"
            itemView.findViewById<ImageView>(R.id.img_select).setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val car = cars[adapterPosition]
            clickListener.onItemClick(car)
        }
    }

    interface ItemClickListener {
        fun onItemClick(car: Car)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item_car, parent, false)
        return CarViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cars.size
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = cars[position]
        holder.bind(car)
    }
}