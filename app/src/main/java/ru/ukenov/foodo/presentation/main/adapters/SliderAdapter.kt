package ru.ukenov.foodo.presentation.main.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.ukenov.foodo.presentation.main.MainPageSlideFragment

class SliderAdapter(
    fragment: Fragment,
    private val imageList: List<String>
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = imageList.size

    override fun createFragment(position: Int): Fragment {
        return MainPageSlideFragment(imageList[position])
    }
}