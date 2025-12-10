package com.example.helpplanet.ui.listar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.helpplanet.databinding.FragmentListaDesafiosBinding
import com.example.helpplanet.ui.adapter.DesafioAdapter

class ListarDesafiosFragment : Fragment() {

    private var _binding: FragmentListaDesafiosBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ListarDesafiosViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListaDesafiosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.recyclerDesafios.layoutManager = LinearLayoutManager(requireContext())

        viewModel.state.observe(viewLifecycleOwner) { state ->
            when (state) {

                is DesafioState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                is DesafioState.Sucesso -> {
                    binding.progressBar.visibility = View.GONE
                    binding.recyclerDesafios.adapter = DesafioAdapter(state.lista) { desafio ->
                        // ação ao clicar no card
                    }
                }

                is DesafioState.Erro -> {
                    binding.progressBar.visibility = View.GONE
                    binding.txtErro.visibility = View.VISIBLE
                    binding.txtErro.text = state.mensagem
                }
            }
        }

        viewModel.carregarDesafios()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
