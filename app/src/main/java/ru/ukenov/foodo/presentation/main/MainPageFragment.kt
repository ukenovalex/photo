package ru.ukenov.foodo.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.ukenov.foodo.databinding.FragmentMainPageBinding
import ru.ukenov.foodo.presentation.main.adapters.items.FirstSectionItem
import ru.ukenov.foodo.presentation.main.adapters.MainAdapter
import ru.ukenov.foodo.presentation.main.adapters.items.MainItem
import ru.ukenov.foodo.presentation.main.adapters.SliderAdapter
import ru.ukenov.foodo.presentation.main.adapters.items.SecondSectionItem
import ru.ukenov.foodo.presentation.main.adapters.items.ThirdSectionItem
import java.util.ArrayList


class MainPageFragment : Fragment() {

    private lateinit var binding: FragmentMainPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMainPageBinding.inflate(layoutInflater, container, false)

        attachRecyclerView(createSliderAdapter())

        return binding.root
    }


    private fun attachRecyclerView(sliderAdapter: SliderAdapter) {
        val newsList = listOf(
            "https://api.memegen.link/images/aag/_/aliens.png",
            "https://api.memegen.link/images/ackbar/_/it's_a_trap!.png",
            "https://api.memegen.link/images/afraid/i_don't_know_what_this_meme_is_for/and_at_this_point_i'm_too_afraid_to_ask.png",
            "https://api.memegen.link/images/agnes/_/i_have_read_and_agree_to_the_terms_and_conditions.png"
        )
        val items = ArrayList<MainItem>().apply {
            add(FirstSectionItem(sliderAdapter))
            add(SecondSectionItem())
            newsList.forEach {
                add(ThirdSectionItem(it))
            }
        }
        binding.rvMainPage.adapter = MainAdapter(items)
    }

    private fun createSliderAdapter(): SliderAdapter {
        val sliderList = listOf(
            "https://api.memegen.link/images/aag/_/aliens.png",
            "https://api.memegen.link/images/ackbar/_/it's_a_trap!.png",
            "https://api.memegen.link/images/afraid/i_don't_know_what_this_meme_is_for/and_at_this_point_i'm_too_afraid_to_ask.png",
            "https://api.memegen.link/images/agnes/_/i_have_read_and_agree_to_the_terms_and_conditions.png"
        )
        return SliderAdapter(this, sliderList)
    }
}