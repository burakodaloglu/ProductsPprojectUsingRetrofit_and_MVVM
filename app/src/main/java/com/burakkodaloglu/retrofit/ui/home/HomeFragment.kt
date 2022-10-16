package com.burakkodaloglu.retrofit.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.burakkodaloglu.retrofit.R
import com.burakkodaloglu.retrofit.common.viewBinding
import com.burakkodaloglu.retrofit.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    private val productAdapter by lazy { ProductAdapter() }

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productAdapter.onProductClick = {
            val action = HomeFragmentDirections.homeToDetail(it)
            findNavController().navigate(action)
        }
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                if (newText.isNullOrEmpty()) {
                    homeViewModel.products()
                } else {
                    homeViewModel.searchProduct(newText)
                }
                return false
            }
        })
        homeViewModel.productList.observe(viewLifecycleOwner) {
            if (it != null) {
                productAdapter.submitList(it)
                binding.rvProducts.adapter = productAdapter
            } else {
                Toast.makeText(requireContext(), "Empty List!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}