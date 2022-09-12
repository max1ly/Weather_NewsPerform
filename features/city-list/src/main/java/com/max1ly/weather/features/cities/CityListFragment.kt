package com.max1ly.weather.features.cities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.max1ly.weather.features.cities.databinding.CityListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CityListFragment : Fragment() {

    private var binding: CityListFragmentBinding? = null
    private var citiesAdapter: CitiesAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CityListFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        citiesAdapter = CitiesAdapter()
        binding?.apply {
            cityList.adapter = citiesAdapter
        }
        // citiesAdapter?.submitList()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
        citiesAdapter = null
    }
}