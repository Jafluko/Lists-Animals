package com.example.animalslists.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.animalslists.R
import com.example.animalslists.databinding.CatFragmentBinding
import com.example.animalslists.viewmodel.CatViewModel

class CatFragment : Fragment() {

    private var fragmentBinding: CatFragmentBinding? = null

    companion object {
        fun newInstance() = CatFragment()
    }

    private lateinit var viewModel: CatViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentBinding = CatFragmentBinding.inflate(
            inflater, container, false
        )
        requireActivity().title = getString(R.string.title_cat_fragment)
        return fragmentBinding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CatViewModel::class.java)
        fragmentBinding!!.viewModel = viewModel
        viewModel.cats.observe(viewLifecycleOwner, Observer {
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