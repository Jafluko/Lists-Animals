package com.example.animalslists.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.Observer
import com.example.animalslists.R
import com.example.animalslists.databinding.DogFragmentBinding
import com.example.animalslists.viewmodel.DogViewModel

class DogFragment : Fragment() {

    private var fragmentBinding: DogFragmentBinding? = null

    companion object {
        fun newInstance() = DogFragment()
    }

    private lateinit var viewModel: DogViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentBinding = DogFragmentBinding.inflate(
            inflater, container, false
        )
        requireActivity().title = "Собаки"
        return fragmentBinding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DogViewModel::class.java)
        fragmentBinding!!.viewModel = viewModel
        viewModel.dogs.observe(viewLifecycleOwner, Observer {
            it?.let {
                viewModel.adapter.setItems(it)
                viewModel.adapter.notifyDataSetChanged()
            }
        })
        viewModel.setList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentBinding = null
    }
}