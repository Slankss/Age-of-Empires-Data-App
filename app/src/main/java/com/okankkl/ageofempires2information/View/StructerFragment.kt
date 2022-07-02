package com.okankkl.ageofempires2information.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.okankkl.ageofempires2information.Adapter.CivilizationAdapter
import com.okankkl.ageofempires2information.Adapter.StructerAdapter
import com.okankkl.ageofempires2information.Model.Civilization
import com.okankkl.ageofempires2information.Model.Structer
import com.okankkl.ageofempires2information.R
import com.okankkl.ageofempires2information.ViewModel.CivilizationViewModel
import com.okankkl.ageofempires2information.ViewModel.StructerViewModel
import com.okankkl.ageofempires2information.databinding.FragmentStructerBinding


class StructerFragment : Fragment() {

    private lateinit var binding : FragmentStructerBinding
    private val viewModel by lazy { StructerViewModel() }
    private lateinit var adapter : StructerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progressBar2.visibility = View.VISIBLE
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStructerBinding.inflate(layoutInflater)

        viewModel.apiList.observe(viewLifecycleOwner){ apis ->
            val structerList = apis as ArrayList<Structer>
            println("girdi")
            for(item in structerList){
                println("Bina adı : "+item.name)
            }
            binding.progressBar2.visibility = View.GONE

            context?.let {
                val layoutManager = LinearLayoutManager(it)
                binding.recylerView.layoutManager = layoutManager
                adapter= StructerAdapter(structerList)
                binding.recylerView.adapter = adapter

                adapter.onOpenClick = {
                    /*activity?.let { itActivity ->
                        var bundle = Bundle()
                        bundle.putInt("id",it)
                        parentFragmentManager.setFragmentResult("id",bundle)
                        val transaction = itActivity.supportFragmentManager.beginTransaction()
                        transaction.replace(R.id.navHost,CivilizationDetailFragment())
                        transaction.addToBackStack(null)
                        transaction.commit()
                    } */
                }


            }

        }

        return binding.root
    }

}