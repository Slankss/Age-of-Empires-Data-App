package com.okankkl.ageofempires2information.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentResultListener
import com.okankkl.ageofempires2information.Model.Civilization
import com.okankkl.ageofempires2information.Model.Unite
import com.okankkl.ageofempires2information.R
import com.okankkl.ageofempires2information.Service.ApiDAOInterface
import com.okankkl.ageofempires2information.databinding.FragmentUnitDetailBinding
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class UnitDetailFragment : Fragment() {

    var gelenId =0
    private lateinit var binding : FragmentUnitDetailBinding
    private var BASE_URL = "https://age-of-empires-2-api.herokuapp.com/api/v1/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager.setFragmentResultListener("id",this, FragmentResultListener { requestKey, result ->
            if(result != null){
                var gelenId = result.getInt("id")
                loadData(gelenId)
            }
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUnitDetailBinding.inflate(layoutInflater)

        return binding.root
    }

    fun loadData(gelenId : Int) {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ApiDAOInterface::class.java)
        val call = service.getUnit(gelenId)


        call.enqueue(object : retrofit2.Callback<Unite> {
            override fun onResponse(
                call: Call<Unite>,
                response: Response<Unite>
            ) {
                if (response.isSuccessful) {
                    //binding.progressBar2.visibility = View.GONE
                    try{
                        response.body()?.let {
                            var unite = it

                            binding.apply {
                                // Fix column
                                binding.iconName.text = unite.name.substring(0,2).capitalize()
                                lblUnitName.text = unite.name
                                lblUnitDescription.text = unite.description
                                lblUnitAge.text = unite.age
                                lblUnitBuildTime.text = unite.build_time.toString()
                                lblUnitCost.text = unite.cost.toString()
                                lblUnitArmor.text = unite.armor
                                lblUnitHitPoint.text = unite.hit_points.toString()
                                lblUnitLightOfSight.text = unite.line_of_sight.toString()
                                var attack_bonus_text =""
                                for(item in unite.attack_bonus){
                                    attack_bonus_text +="►"+item+"\n"
                                }
                                lblUnitAttackBonus.text = attack_bonus_text

                                if(unite.movement_rate == null){ lblUnitMovementRate.text = "-" }
                                else{ lblUnitMovementRate.text = unite.movement_rate.toString() }

                                if(unite.attack_delay == null){ lblUnitAttackDelay.text = "-" }
                                else{ lblUnitAttackDelay.text = unite.attack_delay.toString() }

                                if(unite.accuracy == null){ lblUnitAccuracy.text = "-" }
                                else{ lblUnitAccuracy.text = unite.accuracy }


                                if(unite.reload_time == null){ lblUnitReloadTime.text = "-" }
                                else{ lblUnitReloadTime.text = unite.reload_time.toString() }


                            }

                        }
                    }catch (e:Exception){
                        println(e.localizedMessage)
                    }

                }
            }

            override fun onFailure(call: Call<Unite>, t: Throwable) {
                Toast.makeText(context, "Veriler Yüklenmedi", Toast.LENGTH_LONG).show()
                println(t.localizedMessage)
            }
        })



    }


}