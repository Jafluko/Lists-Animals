package com.example.animalslists.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.animalslists.R
import com.example.animalslists.databinding.AllFragmentBinding
import com.example.animalslists.viewmodel.AllViewModel

class AllFragment : Fragment() {

    private var fragmentBinding: AllFragmentBinding? = null

    companion object {
        fun newInstance() = AllFragment()
    }

    private lateinit var viewModel: AllViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentBinding = AllFragmentBinding.inflate(
            inflater, container, false
        )
        requireActivity().title = getString(R.string.title_all_fragment)
        return fragmentBinding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AllViewModel::class.java)
        fragmentBinding!!.viewModel = viewModel
        viewModel.all.observe(viewLifecycleOwner, Observer {
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