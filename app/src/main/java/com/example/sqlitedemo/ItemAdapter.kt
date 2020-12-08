package com.example.sqlitedemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class ItemAdapter(var items: ArrayList<EmpModelClass> , val context: Context) :
    RecyclerView.Adapter<ItemAdapter.viewHolder>() {

    class viewHolder(view: View): RecyclerView.ViewHolder(view){
        val llMain = view.llmain
        val tvnamerv = view.tvnamerv
        val tvemailrv = view.tvEmailRv
        val ivEdit = view.ivEdit
        val ivDelete = view.ivDelete

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(LayoutInflater.from(context).
                        inflate(R.layout.item_row , parent ,false)
        )
    }

    override fun getItemCount(): Int {
       return items.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
         var item = items.get(position)

        holder.tvnamerv.text = item.name
        holder.tvemailrv.text = item.email

        if (position % 2 == 0) {
            holder.llMain.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.colorLightGray
                )
            )
        } else {
            holder.llMain.setBackgroundColor(ContextCompat.getColor(context, R.color.colorWhite))
        }

        holder.ivEdit.setOnClickListener {
            if (context is MainActivity) {
                context.updateRecordDialog(item)
            }
        }

        holder.ivDelete.setOnClickListener {
            if (context is MainActivity) {
                context.deleteRecordAlertDialog(item)
            }
        }
    }
}