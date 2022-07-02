package com.okankkl.ageofempires2information.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentResultListener
import com.okankkl.ageofempires2information.Model.Civilization
import com.okankkl.ageofempires2information.Service.ApiDAOInterface
import com.okankkl.ageofempires2information.databinding.FragmentCivilizationDetailBinding
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CivilizationDetailFragment : Fragment() {

    var gelenId =0
    private lateinit var binding: FragmentCivilizationDetailBinding
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
        binding = FragmentCivilizationDetailBinding.inflate(layoutInflater)

        return binding.root
    }



    fun loadData(gelenId : Int) {

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(ApiDAOInterface::class.java)
            val call = service.getCivilization(gelenId)


            call.enqueue(object : retrofit2.Callback<Civilization> {
                override fun onResponse(
                    call: Call<Civilization>,
                    response: Response<Civilization>
                ) {
                    if (response.isSuccessful) {
                        //binding.progressBar2.visibility = View.GONE
                        response.body()?.let {
                            var civilization = it

                            context?.let {
                                binding.iconName.text = civilization.name.substring(0,2).capitalize()
                                binding.lblCivilizationName.text = civilization.name
                                binding.lblCivilizationExpansion.text = civilization.expansion
                                binding.lblCivilizationArmyType.text = civilization.army_type
                                binding.lblCivilizationTeamBonus.text = civilization.team_bonus
                                var civilization_bonus_text =""
                                var civilization_bonus = civilization.civilization_bonus
                                for(item in civilization_bonus){
                                    civilization_bonus_text+="►"+item+"\n"
                                }
                                binding.lblCivilizationCivilizationBonus.text = civilization_bonus_text

                            }

                        }
                    }
                }

                override fun onFailure(call: Call<Civilization>, t: Throwable) {
                    Toast.makeText(context, "Veriler Yüklenmedi", Toast.LENGTH_LONG).show()
                    println(t.localizedMessage)
                }
            })



    }

}