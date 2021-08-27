package com.example.animalslists.viewmodel.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.animalslists.BR
import com.example.animalslists.model.data.Animal
import com.example.animalslists.viewmodel.AllViewModel

class AllAdapter(@LayoutRes layoutId: Int, viewModel: AllViewModel) :
    RecyclerView.Adapter<AllAdapter.GenericViewHolder>() {

    private var layoutId: Int = 0
    private var items: List<Animal> = listOf()
    private lateinit var viewModel: AllViewModel

    init {
        this.layoutId = layoutId
        this.viewModel = viewModel
    }

    fun setItems(items: List<Animal>) {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, layoutId, parent, false)
        return GenericViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {
        holder.bind(viewModel, position)
    }

    override fun getItemCount(): Int = items.size

    class GenericViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(viewModel: AllViewModel, position: Int) {
            binding.setVariable(BR.viewModel, viewModel)
            binding.setVariable(BR.position, position)
            binding.executePendingBindings()
        }
    }
}