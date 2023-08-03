package com.fashionism.favorite

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fashionism.favorite.databinding.FragmentFavoriteBinding
import com.fashionism.capstonesepakbola.detail.DetailActivity
import com.fashionism.capstonesepakbola.detail.DetailActivity.Companion.EXTRA_DATA
import com.fashionism.capstonesepakbola.di.FavoriteDependencies
import com.fashionism.core.ui.PlayerAdapter
import com.fashionism.favorite.viewmodel.ViewModelFactory
import com.google.android.material.textview.MaterialTextView
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject
import com.fashionism.favorite.di.DaggerFavoriteComponent

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding

    @Inject
    lateinit var factory: ViewModelFactory
    private val favoriteViewModel: FavoriteViewModel by viewModels {
        factory
    }

    override fun onAttach(context: Context) {
        DaggerFavoriteComponent.builder()
            .context(requireActivity())
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    requireActivity().applicationContext,
                    FavoriteDependencies::class.java
                )
            ).build().inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding?.root ?: inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val playerAdapter = PlayerAdapter()
            playerAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            val viewEmpty = view.findViewById<MaterialTextView>(R.id.tv_not_found)
            favoriteViewModel.favoritePlayer.observe(viewLifecycleOwner) { dataPlayer ->
                playerAdapter.submitList(dataPlayer)
                viewEmpty.visibility =
                    if (dataPlayer.isNotEmpty()) View.GONE else View.VISIBLE
            }

            val rvFavPlayer = view.findViewById<RecyclerView>(com.fashionism.capstonesepakbola.R.id.rv_player)
            with(rvFavPlayer) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = playerAdapter
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}