package com.johnvazna.core.bases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/** */
abstract class BaseFragment<T : ViewBinding, VM : BaseViewModel> : Fragment() {

    private var _binding: T? = null
    val binding get() = _binding!!

    protected abstract val viewModel: VM

    fun <DB : ViewDataBinding> DB.bindLayout(bind: DB.() -> Unit) = bind(this).let {
        lifecycleOwner = viewLifecycleOwner
        root
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = setupBinding(inflater, container)
        return binding.root
    }

    abstract fun setupBinding(inflater: LayoutInflater, container: ViewGroup?): T

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
