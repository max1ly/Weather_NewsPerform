package com.max1ly.weather.features.cities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.max1ly.weather.features.cities.databinding.CityListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CityListFragment : Fragment() {

    private val viewModel: CityListViewModel by viewModels()

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

        lifecycleScope.launchWhenCreated {
            viewModel.cityWeatherFlow.collect { state ->
                when (state) {
                    is CityWeatherState.Loading -> {
                        binding?.apply {
                            progressBar.visibility = View.VISIBLE
                            cityList.visibility = View.GONE
                            errorMessage.visibility = View.GONE
                        }
                    }
                    is CityWeatherState.Success -> {
                        binding?.apply {
                            progressBar.visibility = View.GONE
                            cityList.visibility = View.VISIBLE
                            errorMessage.visibility = View.GONE
                        }
                        citiesAdapter?.submitList(state.weatherList)
                    }
                    is CityWeatherState.Error -> {
                        binding?.apply {
                            progressBar.visibility = View.GONE
                            cityList.visibility = View.GONE
                            errorMessage.visibility = View.VISIBLE
                        }
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
        citiesAdapter = null
    }
}