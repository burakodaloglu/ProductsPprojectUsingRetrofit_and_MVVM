package com.burakkodaloglu.retrofit.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.burakkodaloglu.retrofit.R
import com.burakkodaloglu.retrofit.common.viewBinding
import com.burakkodaloglu.retrofit.databinding.FragmentDetailBinding
import com.burakkodaloglu.retrofit.databinding.FragmentHomeBinding

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val binding by viewBinding(FragmentDetailBinding::bind)

    private val args:DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

            args.product.let {

                tvTitle.text = it.title
                tvPrice.text = "${it.price} ₺"
                tvDescription.text = it.description
                Glide.with(imgProduct).load(it.image).into(imgProduct)
            }
        }
    }
}