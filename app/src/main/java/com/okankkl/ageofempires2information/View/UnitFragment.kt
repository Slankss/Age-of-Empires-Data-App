package com.okankkl.ageofempires2information.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.okankkl.ageofempires2information.Adapter.StructerAdapter
import com.okankkl.ageofempires2information.Adapter.UnitAdapter
import com.okankkl.ageofempires2information.Model.Unite
import com.okankkl.ageofempires2information.R
import com.okankkl.ageofempires2information.ViewModel.UnitViewModel
import com.okankkl.ageofempires2information.databinding.FragmentUnitBinding


class UnitFragment : Fragment() {

    private lateinit var binding : FragmentUnitBinding
    private val viewModel by lazy { UnitViewModel() }
    private lateinit var adapter : UnitAdapter

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
        binding = FragmentUnitBinding.inflate(layoutInflater)


        viewModel.apiList.observe(viewLifecycleOwner) { apis ->
            val unitList =  apis as ArrayList<Unite>
            binding.progressBar2.visibility = View.GONE

            context?.let {
                val layoutManager = LinearLayoutManager(it)
                binding.recylerView.layoutManager = layoutManager
                adapter= UnitAdapter(unitList)
                binding.recylerView.adapter = adapter
            }
        }

        return binding.root
    }


}