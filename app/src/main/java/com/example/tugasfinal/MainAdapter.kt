package com.example.tugasfinal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasfinal.User.PenumpangEntity
import kotlinx.android.synthetic.main.item_penumpang.view.*

class MainAdapter(private val list: List<PenumpangEntity>, private val listener: Listener): RecyclerView.Adapter<MainAdapter.Holder>() {

    interface Listener {
        fun onViewClick(penumpangEntity: PenumpangEntity)
    }

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(penumpangEntity: PenumpangEntity, listener: Listener) {
            with(itemView) {
                when(penumpangEntity.jenisKelamin) {
                    "Laki-laki" -> {
                        imgView.setImageResource(R.drawable.ic_man)
                    }
                    "Perempuan" -> {
                        imgView.setImageResource(R.drawable.ic_woman)
                    }
                }
                nama.text = penumpangEntity.nama
                umur.text = penumpangEntity.umur
                alamat.text = penumpangEntity.alamat
                tempat_keberangkatan.text = penumpangEntity.tempatKeberangkatan
                tujuan_keberangkatan.text = penumpangEntity.tujuanKeberangkatan
                itemView.setOnClickListener {
                    listener.onViewClick(penumpangEntity)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_penumpang, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list[position], listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}