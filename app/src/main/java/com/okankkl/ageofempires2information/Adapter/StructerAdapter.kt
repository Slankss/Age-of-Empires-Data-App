package com.okankkl.ageofempires2information.Adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.okankkl.ageofempires2information.Model.Civilization
import com.okankkl.ageofempires2information.Model.Structer
import com.okankkl.ageofempires2information.R
import com.okankkl.ageofempires2information.databinding.CivilizationListRecyclerRowBinding
import com.okankkl.ageofempires2information.databinding.StructerListRecyclerRowBinding

class StructerAdapter(private var structerList: ArrayList<Structer>)
    : RecyclerView.Adapter<StructerAdapter.apiViewHolder>() {

    var colorList : Array<String> = arrayOf("#403F4C","#FFFFFFFF")
    var onOpenClick : (Int) -> Unit = {}

    class apiViewHolder(val binding : StructerListRecyclerRowBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): apiViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = StructerListRecyclerRowBinding.inflate(layoutInflater, parent, false)
        return apiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: apiViewHolder, position: Int) {
        val structer = structerList[position]

        holder.binding.apply {
            cardViewCivilization.setBackgroundColor(Color.parseColor(colorList.get(position % 2)))
            //txtStructerName.setTextColor(Color.parseColor(colorList.get(position % 2)))
            //txtAge.setTextColor(Color.parseColor(colorList.get(position+1 % 2)))
            if(position % 2 == 0){
                txtStructerName.setTextColor(Color.parseColor(colorList.get(1)))
                txtAge.setTextColor(Color.parseColor(colorList.get(1)))
            }
            else{
                txtStructerName.setTextColor(Color.parseColor(colorList.get(0)))
                txtAge.setTextColor(Color.parseColor(colorList.get(0)))
            }

            txtStructerName.text = structer.name
            txtAge.text = structer.age
            cardViewCivilization.setOnClickListener {
                onOpenClick(structer.id)
            }
        }
    }

    override fun getItemCount(): Int {
        return structerList.size
    }




}