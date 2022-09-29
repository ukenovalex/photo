package ru.ukenov.foodo.presentation.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.ukenov.foodo.databinding.FragmentBottomNavigationBinding


class BottomNavigationFragment : Fragment() {
    private lateinit var binding: FragmentBottomNavigationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBottomNavigationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}