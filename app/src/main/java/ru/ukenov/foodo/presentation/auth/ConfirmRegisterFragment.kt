package ru.ukenov.foodo.presentation.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.ukenov.foodo.R
import ru.ukenov.foodo.databinding.FragmentConfirmRegisterBinding


class ConfirmRegisterFragment : Fragment() {

    private lateinit var binding: FragmentConfirmRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConfirmRegisterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}