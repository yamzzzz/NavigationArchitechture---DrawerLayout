package com.yamikrish.app.navigationDemo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import com.yamikrish.app.navigationDemo.R
import com.yamikrish.app.navigationDemo.model.Post
import com.yamikrish.app.navigationDemo.ui.home.HomeFragmentDirections
import kotlinx.android.synthetic.main.post_item.view.*

/* 
 * Created by Yamini on 14/5/18.
 */

class PostAdapter (val context: Context, var data : List<Post>?) : RecyclerView.Adapter<PostAdapter.Holder>() {
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindItems(data?.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val v = LayoutInflater.from(context).inflate(R.layout.post_item, parent, false)
        return Holder(v)
    }

    override fun getItemCount(): Int = data?.size?:0

    fun addItems(t: List<Post>?) {
        data = t
        notifyDataSetChanged()
    }

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView){
        fun bindItems(user: Post?){
            itemView.title.text =  user?.title
            itemView.description.text = user?.body

            itemView.setOnClickListener {
                val direction = HomeFragmentDirections.openDetails(user!!.id)
                findNavController(itemView).navigate(direction)
            }
        }
    }

}