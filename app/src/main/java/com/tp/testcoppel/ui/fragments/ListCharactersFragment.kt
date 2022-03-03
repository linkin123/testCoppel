package com.tp.testcoppel.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tp.testcoppel.R
import com.tp.testcoppel.core.Resource
import com.tp.testcoppel.data.local.CharacterLocal
import com.tp.testcoppel.data.remote.RemoteCharacterDataSource
import com.tp.testcoppel.databinding.FragmentListCharactersBinding
import com.tp.testcoppel.presentation.CharactersViewModel
import com.tp.testcoppel.presentation.CharactersViewModelFactory
import com.tp.testcoppel.repository.CharacterRepositoryImpl
import com.tp.testcoppel.repository.RetrofitClient
import com.tp.testcoppel.ui.adapters.ItemsCharactersAdapter
import com.tp.testcoppel.ui.utils.gone
import com.tp.testcoppel.ui.utils.invisible
import com.tp.testcoppel.ui.utils.visible

class ListCharactersFragment : Fragment(R.layout.fragment_list_characters),
    ItemsCharactersAdapter.OnClikListener {

    private lateinit var binding: FragmentListCharactersBinding
    private var charactersAdapter = ItemsCharactersAdapter(this)

    private val viewmodel by activityViewModels<CharactersViewModel> {
        CharactersViewModelFactory(
            CharacterRepositoryImpl(
                RemoteCharacterDataSource(RetrofitClient.webService)
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentListCharactersBinding.bind(view)
        setUpToolbar()
        initData()
        observers()
    }

    private fun setUpToolbar() {
        with(binding.mToolbar.actionBar){
            ivBack.invisible()
            tvTitle.text = "Personajes"
        }
    }

    private fun initData() {
        binding.rvCharacters.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            adapter = charactersAdapter
        }.addItemDecoration(
            DividerItemDecoration(
                binding.rvCharacters.context, LinearLayoutManager(activity).orientation
            )
        )
    }

    private fun observers() {
        viewmodel.fetchCharacters().observe(viewLifecycleOwner) { result ->
            when (result) {
                is Resource.Loading -> {
                    binding.progressBar.visible()
                }
                is Resource.Success -> {
                    charactersAdapter.submitList(result.data)
                    binding.progressBar.gone()
                }
                is Resource.Failure -> {
                    binding.progressBar.gone()
                }
            }
        }
    }

    override fun onCharacterClick(characterLocal: CharacterLocal) {

        val action = ListCharactersFragmentDirections
            .actionListCharactersFragmentToCharacterDetailFragment(
                characterLocal.id, characterLocal.resource, characterLocal.description, characterLocal.name)

        findNavController().navigate(action)
    }

}