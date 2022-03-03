package com.tp.testcoppel.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import androidx.navigation.fragment.navArgs
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.bumptech.glide.Glide
import com.tp.testcoppel.R
import com.tp.testcoppel.core.Resource
import com.tp.testcoppel.data.local.SectionLocal
import com.tp.testcoppel.data.remote.RemoteCharacterDataSource
import com.tp.testcoppel.databinding.FragmentCharacterDetailBinding
import com.tp.testcoppel.presentation.CharactersViewModel
import com.tp.testcoppel.presentation.CharactersViewModelFactory
import com.tp.testcoppel.repository.CharacterRepositoryImpl
import com.tp.testcoppel.repository.RetrofitClient
import com.tp.testcoppel.ui.adapters.GenericAdapter
import com.tp.testcoppel.ui.adapters.SectionAdapter
import com.tp.testcoppel.ui.adapters.typeAdapter
import com.tp.testcoppel.ui.utils.gone
import com.tp.testcoppel.ui.utils.invisible
import com.tp.testcoppel.ui.utils.visible

class CharacterDetailFragment : Fragment(R.layout.fragment_character_detail),
    SectionAdapter.OnListener {

    private lateinit var binding: FragmentCharacterDetailBinding
    private val args by navArgs<CharacterDetailFragmentArgs>()
    private lateinit var concatAdapter: ConcatAdapter

    private val viewmodel by activityViewModels<CharactersViewModel> {
        CharactersViewModelFactory(
            CharacterRepositoryImpl(
                RemoteCharacterDataSource(RetrofitClient.webService)
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCharacterDetailBinding.bind(view)
        setUpToolbar()
        setDataView()
        getDetails()
        onclicks()
    }

    private fun onclicks() {
        binding.mToolbar.actionBar.ivBack.setOnClickListener{
            findNavController().navigateUp()
        }
    }

    private fun getDetails() {
        concatAdapter = ConcatAdapter()
        viewmodel.fetchCharacterDetailById(args.idCharacter).observe(viewLifecycleOwner) { result ->
            when (result) {
                is Resource.Loading -> {
                    binding.progressBar.visible()
                }
                is Resource.Success -> {
                    concatAdapter.apply {
                        addAdapter(0, GenericAdapter(SectionAdapter(result.data.t1, this@CharacterDetailFragment) , typeAdapter.COMICS))
                        addAdapter(1, GenericAdapter(SectionAdapter(result.data.t2, this@CharacterDetailFragment) , typeAdapter.SERIES))
                        addAdapter(2, GenericAdapter(SectionAdapter(result.data.t3, this@CharacterDetailFragment) , typeAdapter.EVENTS))
                        addAdapter(3, GenericAdapter(SectionAdapter(result.data.t4, this@CharacterDetailFragment) , typeAdapter.STORIES))
                    }
                    binding.rvSections.adapter = concatAdapter
                    binding.progressBar.gone()
                }
                is Resource.Failure -> {
                    binding.progressBar.gone()
                }
            }
        }
    }

    private fun setDataView() {
        binding.txtTitle.text = args.name
        binding.txtOverview.text = args.description
        Glide.with(requireContext())
            .load(args.resource)
            .centerCrop()
            .into(binding.imgMovie)

        Glide.with(requireContext())
            .load(args.resource)
            .centerCrop()
            .into(binding.imgBackground)
    }

    private fun setUpToolbar() {
        binding.mToolbar.actionBar.tvTitle.text = args.name
    }

    override fun onClick(section: SectionLocal) {

    }

}