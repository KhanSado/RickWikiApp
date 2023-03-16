package io.github.bersoncrios.rickpedia.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.bersoncrios.rickpedia.databinding.CharRowBinding
import io.github.bersoncrios.rickpedia.models.Char
import io.github.bersoncrios.rickpedia.models.CharactersList

class CharAdapter(val context: Context, var charList: CharactersList, val onClickListener: OnClickListener)
    : RecyclerView.Adapter<CharAdapter.MyViewHolder>() {

    lateinit var binding: CharRowBinding

    class MyViewHolder(var binding: CharRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(char: Char) {
            binding.character = char
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = CharRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val person = charList.char[position]
        holder.bind(person)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(person)
        }
    }

    class OnClickListener(val clickListener: (char: Char) -> Unit) {
        fun onClick(char: Char) =
            clickListener(char)
    }

    override fun getItemCount(): Int = charList.char.size
}