package ru.ukenov.foodo.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import ru.ukenov.foodo.databinding.FragmentMainPageSlideBinding


class MainPageSlideFragment(val imageURL: String) : Fragment() {

    private lateinit var binding: FragmentMainPageSlideBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainPageSlideBinding.inflate(layoutInflater, container, false)
        println(imageURL)
        Glide.with(this).load(imageURL).into(binding.postImage)
        return binding.root
    }

}