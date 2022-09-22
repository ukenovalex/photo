package ru.ukenov.foodo.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import ru.ukenov.foodo.R
import ru.ukenov.foodo.databinding.FragmentFirstPageBinding


class FirstPageFragment : Fragment() {

    private lateinit var binding: FragmentFirstPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstPageBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogin.setOnClickListener {
            view.findNavController().navigate(R.id.action_firstPageFragment_to_loginFragment)
        }
        binding.btnRegister.setOnClickListener {
            view.findNavController().navigate(R.id.action_firstPageFragment_to_registerFragment)
        }
    }


}