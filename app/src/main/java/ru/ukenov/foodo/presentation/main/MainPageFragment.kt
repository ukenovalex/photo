package ru.ukenov.foodo.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.ukenov.foodo.databinding.FragmentMainPageBinding
import ru.ukenov.foodo.presentation.main.adapters.SliderAdapter


class MainPageFragment : Fragment() {

    private lateinit var binding: FragmentMainPageBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainPageBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createSlider()
    }

    private fun createSlider() {
        val sliderList = listOf(
            "https://api.memegen.link/images/aag/_/aliens.png",
            "https://api.memegen.link/images/ackbar/_/it's_a_trap!.png",
            "https://api.memegen.link/images/afraid/i_don't_know_what_this_meme_is_for/and_at_this_point_i'm_too_afraid_to_ask.png",
            "https://api.memegen.link/images/agnes/_/i_have_read_and_agree_to_the_terms_and_conditions.png"
        )
        val adapter = SliderAdapter(this, sliderList)
        binding.slider.adapter = adapter
    }
}