package com.okankkl.ageofempires2information.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.okankkl.ageofempires2information.Adapter.CivilizationRecyclerAdapter
import com.okankkl.ageofempires2information.Model.Civilization
import com.okankkl.ageofempires2information.R
import com.okankkl.ageofempires2information.ViewModel.CivilizationViewModel
import com.okankkl.ageofempires2information.databinding.FragmentCivilizationListBinding


class CivilizationListFragment : Fragment() {

     private lateinit var binding : FragmentCivilizationListBinding
    private val viewModel by lazy { CivilizationViewModel() }
    private lateinit var adapter : CivilizationRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progressBar.visibility = View.VISIBLE

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCivilizationListBinding.inflate(layoutInflater)

        viewModel.apiList.observe(viewLifecycleOwner){ apis ->
            val civilizationList = apis as ArrayList<Civilization>
            binding.progressBar.visibility = View.GONE

            context?.let {
                val layoutManager = LinearLayoutManager(it)
                binding.recyclerView.layoutManager = layoutManager
                adapter= CivilizationRecyclerAdapter(civilizationList)
                binding.recyclerView.adapter = adapter
            }


        }


        return binding.root
    }


}