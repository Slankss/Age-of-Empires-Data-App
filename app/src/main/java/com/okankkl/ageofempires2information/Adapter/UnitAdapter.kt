package com.okankkl.ageofempires2information.Adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.okankkl.ageofempires2information.Model.Structer
import com.okankkl.ageofempires2information.Model.Unite
import com.okankkl.ageofempires2information.databinding.StructerListRecyclerRowBinding
import com.okankkl.ageofempires2information.databinding.UnitListRecyclerRowBinding

class UnitAdapter(private var unitList: ArrayList<Unite>)
    : RecyclerView.Adapter<UnitAdapter.apiViewHolder>() {

    var colorList : Array<String> = arrayOf("#403F4C","#FFFFFFFF")
    var onOpenClick : (Int) -> Unit = {}

    class apiViewHolder(val binding : UnitListRecyclerRowBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): apiViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = UnitListRecyclerRowBinding.inflate(layoutInflater, parent, false)
        return apiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: apiViewHolder, position: Int) {
        val unit = unitList[position]

        holder.binding.apply {
            txtUnitName.text = unit.name
            txtUnitDescription.text = unit.description

            cardViewCivilization.setOnClickListener {
                onOpenClick(unit.id)
            }
        }
    }

    override fun getItemCount(): Int {
        return unitList.size
    }




}