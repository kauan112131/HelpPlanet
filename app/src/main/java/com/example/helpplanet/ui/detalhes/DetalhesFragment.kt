package com.example.helpplanet.ui.detalhes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.helpplanet.databinding.FragmentDetalhesBinding

class DetalhesFragment : Fragment() {

    private var _binding: FragmentDetalhesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetalhesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = DetalhesFragmentArgs.fromBundle(requireArguments())

        binding.txtTitulo.text = args.titulo
        binding.txtDescricao.text = args.descricao
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
