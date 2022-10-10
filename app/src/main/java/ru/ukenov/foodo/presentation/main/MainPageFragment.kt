package ru.ukenov.foodo.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat.TYPE_TOUCH
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.ukenov.foodo.databinding.FragmentMainPageBinding
import ru.ukenov.foodo.domain.models.Images
import ru.ukenov.foodo.presentation.main.adapters.MainAdapter
import ru.ukenov.foodo.presentation.main.adapters.SliderAdapter
import ru.ukenov.foodo.presentation.main.view_model.MainPageViewModel


class MainPageFragment : Fragment() {

    private lateinit var binding: FragmentMainPageBinding
    private val viewModel by viewModels<MainPageViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getImages()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMainPageBinding.inflate(layoutInflater, container, false)
        binding.slider.adapter = createSliderAdapter()

        viewModel.images.observe(viewLifecycleOwner) {
            attachRecyclerView(it)
        }

        return binding.root
    }


    private fun attachRecyclerView(images: Images) {

        binding.rvMain.adapter = MainAdapter(images.imageList)
        binding.rvMain.isNestedScrollingEnabled = false
        binding.nsMain.onStartNestedScroll(binding.nsMain, binding.rvMain, binding.nsMain.nestedScrollAxes)
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