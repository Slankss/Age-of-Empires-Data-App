package com.okankkl.ageofempires2information.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentResultListener
import com.okankkl.ageofempires2information.Model.Civilization
import com.okankkl.ageofempires2information.Model.Structer
import com.okankkl.ageofempires2information.R
import com.okankkl.ageofempires2information.Service.ApiDAOInterface
import com.okankkl.ageofempires2information.databinding.FragmentStructerDetailBinding
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class StructerDetailFragment : Fragment() {

    var gelenId = 0
    private lateinit var binding : FragmentStructerDetailBinding
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
        binding = FragmentStructerDetailBinding.inflate(layoutInflater)

        return binding.root
    }

    fun loadData(gelenId : Int) {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ApiDAOInterface::class.java)
        val call = service.getStructure(gelenId)


        call.enqueue(object : retrofit2.Callback<Structer> {
            override fun onResponse(
                call: Call<Structer>,
                response: Response<Structer>
            ) {
                if (response.isSuccessful) {
                    //binding.progressBar2.visibility = View.GONE
                    response.body()?.let {
                        var structer = it


                        context?.let {
                            binding.apply {
                                binding.iconName.text = structer.name.substring(0,2).capitalize()
                                lblStructerName.text = structer.name
                                lblStructerAge.text = structer.age
                                lblStructerCost.text = structer.cost.toString()
                                lblStructerHitpoint.text = structer.hit_points.toString()
                                lblStructerLineOfSight.text = structer.line_of_sight.toString()
                                if(structer.special == null){
                                    lblStructerSpecialInfo.visibility  =View.GONE
                                    lblStructerSpecial.visibility  =View.GONE
                                }
                                else{
                                    var special_text = ""
                                    for(item in structer.special){
                                        special_text +="►"+item+"\n"
                                    }
                                    lblStructerSpecial.text = special_text
                                }
                                if(structer.attack == null){
                                    linearAttack.visibility = View.GONE
                                }
                                else{ lblStructerAttack.text = structer.attack.toString() }

                                if(structer.reload_time == null) { linearReloadTime.visibility == View.GONE }
                                else{ lblStructerReloadTime.text = structer.reload_time.toString() }



                            }

                        }

                    }
                }
            }

            override fun onFailure(call: Call<Structer>, t: Throwable) {
                Toast.makeText(context, "Veriler Yüklenmedi", Toast.LENGTH_LONG).show()
                println(t.localizedMessage)
            }
        })



    }


}