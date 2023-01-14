package com.example.infokampus2.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.infokampus2.R
import com.example.infokampus2.model.Photo
import kotlinx.android.synthetic.main.activity_negeri.view.*
import kotlinx.android.synthetic.main.activity_negeri2.view.*
import kotlinx.android.synthetic.main.item_list.view.*
import kotlinx.android.synthetic.main.item_list.view.imageview
import kotlinx.android.synthetic.main.item_list.view.tvTitle
import kotlinx.android.synthetic.main.tes_bismillah.view.*

class PhotoListAdapter(var data: ArrayList<Photo>):
    RecyclerView.Adapter<PhotoListAdapter.ViewHolder>() {
    fun updatePhotos(newPhotos: List<Photo>){
        data.clear()
        data.addAll(newPhotos)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder (parent: ViewGroup, p1: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.activity_negeri2, parent, false)
    )

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(data: Photo){
            val foto_dosen: ImageView = itemView.imageview2
            val requestOp = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
            itemView.tvTitle2.text = data.nama_univ
            itemView.tvTitle3.text = data.desk
//            itemView.rBar.animation = data.rating
            itemView.setOnClickListener{ view ->
                Toast.makeText(itemView.context,"Hello", Toast.LENGTH_LONG).show()
            }

            val alamaturl =data.thumbnail
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOp)
                .load("$alamaturl.png")
                .into(foto_dosen)
        }


    }

}