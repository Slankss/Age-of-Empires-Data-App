package com.okankkl.ageofempires2information.Adapter

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.okankkl.ageofempires2information.Model.Civilization
import com.okankkl.ageofempires2information.R
import com.okankkl.ageofempires2information.databinding.CivilizationListRecyclerRowBinding

class CivilizationRecyclerAdapter(private var civilizationList: ArrayList<Civilization>)
    : RecyclerView.Adapter<CivilizationRecyclerAdapter.apiViewHolder>() {

    var colorList : Array<String> = arrayOf("#A7CECB","#E84855","#F9DC5C","#3185FC","#EFBCD5")
    var onOpenClick : (Int) -> Unit = {}

    class apiViewHolder(val binding : CivilizationListRecyclerRowBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): apiViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CivilizationListRecyclerRowBinding.inflate(layoutInflater, parent, false)
        return apiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: apiViewHolder, position: Int) {
        val civilization = civilizationList[position]



        holder.binding.apply {
            cardViewCivilization.setBackgroundColor(Color.parseColor(colorList.get(position % 5)))
            txtCivilizationName.text = civilization.name
            txtArmyType.text = civilization.army_type
            var army_type =civilization.army_type
            var is_first_fill = false


            if (army_type.contains("Archer") && is_first_fill.equals(false)) {
                imgFirstIcon.setImageResource(R.drawable.ic_bow)
                is_first_fill = true
                army_type=army_type.replace("Archer","").trim()
            }
            if (army_type.contains("Infantry") && is_first_fill.equals(false)) {
                imgFirstIcon.setImageResource(R.drawable.ic_sword)
                is_first_fill = true
                army_type = army_type.replace("Infantry","").trim()
            }
            if (army_type.contains("Cavalry") && is_first_fill.equals(false)) {
                imgFirstIcon.setImageResource(R.drawable.ic_knight)
                is_first_fill = true
                army_type = army_type.replace("Cavalry","").trim()
            }
            if (army_type.contains("Monk") && is_first_fill.equals(false)) {
                imgFirstIcon.setImageResource(R.drawable.ic_siege)
                is_first_fill = true
                army_type = army_type.replace("Monk","").trim()
            }
            if (army_type.contains("Tower") && is_first_fill.equals(false)) {
                imgFirstIcon.setImageResource(R.drawable.ic_tower)
                is_first_fill = true
                army_type=army_type.replace("Tower","").trim()
            }
            if (army_type.contains("Defence") && is_first_fill.equals(false)) {
                imgFirstIcon.setImageResource(R.drawable.ic_defence)
                is_first_fill = true
                army_type=army_type.replace("Defence","").trim()
            }
            if (army_type.contains("Gunpowder") && is_first_fill.equals(false)) {
                imgFirstIcon.setImageResource(R.drawable.ic_gunpowder)
                is_first_fill = true
                army_type=army_type.replace("Gunpowder","").trim()
            }
            if ( ( army_type.contains("naval") || army_type.contains("Naval")) && is_first_fill.equals(false)) {
                imgFirstIcon.setImageResource(R.drawable.ic_ship)
                is_first_fill = true
                if(army_type.contains("naval")){
                    army_type=army_type.replace("naval","").trim()
                }
                else{
                    army_type=army_type.replace("Naval","").trim()
                }

            }

            if (army_type.contains("Archer")) { imgSecondIcon.setImageResource(R.drawable.ic_bow)}
            if (army_type.contains("Infantry")) { imgSecondIcon.setImageResource(R.drawable.ic_sword)}
            if (army_type.contains("Cavalry")) { imgSecondIcon.setImageResource(R.drawable.ic_knight)}
            if (army_type.contains("Monk")) { imgSecondIcon.setImageResource(R.drawable.ic_siege)}
            if (army_type.contains("Tower")) { imgSecondIcon.setImageResource(R.drawable.ic_tower)}
            if (army_type.contains("Defensive")) { imgSecondIcon.setImageResource(R.drawable.ic_defence)}
            if (army_type.contains("Gunpowder")) { imgSecondIcon.setImageResource(R.drawable.ic_gunpowder)}
            if (army_type.contains("naval") || army_type.contains("Naval")) { imgSecondIcon.setImageResource(R.drawable.ic_ship)}

            cardViewCivilization.setOnClickListener {
                onOpenClick(civilization.id)
            }


        }
    }

    override fun getItemCount(): Int {
        return civilizationList.size
    }




}