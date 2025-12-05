package ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.helpplanet.databinding.FragmentHomeBinding
import com.example.helpplanet.ui.home.HomeAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Exemplo simples de configuração da RecyclerView
        binding.recyclerDesafios.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = HomeAdapter(getFakeList())
        }
    }

    private fun getFakeList(): List<String> {
        return listOf(
            "Desafio 1: Economizar Água",
            "Desafio 2: Reduzir Resíduos",
            "Desafio 3: Usar Transporte Sustentável"
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
