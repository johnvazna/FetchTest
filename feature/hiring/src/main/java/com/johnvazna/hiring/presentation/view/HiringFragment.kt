package com.johnvazna.hiring.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.johnvazna.core.bases.BaseFragment
import com.johnvazna.hiring.databinding.FragmentHiringBinding
import com.johnvazna.hiring.presentation.ui.PersonListWithHeader
import com.johnvazna.hiring.presentation.viewmodel.HiringViewModel
import dagger.hilt.android.AndroidEntryPoint

/** */
@AndroidEntryPoint
class HiringFragment : BaseFragment<FragmentHiringBinding, HiringViewModel>() {

    override val viewModel: HiringViewModel by viewModels()

    override fun setupBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ): FragmentHiringBinding = FragmentHiringBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this

        viewModel.showLoadingDialog.observeEvent {
            if (it) showLoading() else hideLoading()
        }

        binding.composeView.setContent {
            val people = viewModel.personsState.value
            PersonListWithHeader(persons = people)
        }
    }
}
