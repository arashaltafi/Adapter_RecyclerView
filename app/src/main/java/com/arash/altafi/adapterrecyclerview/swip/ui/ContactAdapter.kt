package com.arash.altafi.adapterrecyclerview.swip.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arash.altafi.adapterrecyclerview.R
import com.arash.altafi.adapterrecyclerview.swip.model.Contact
import com.arash.altafi.adapterrecyclerview.swip.extension.openCall
import com.arash.altafi.adapterrecyclerview.swip.extension.openSMS

class ContactAdapter: ListAdapter<Contact, ContactAdapter.ContactHolder>(Companion) {

    companion object : DiffUtil.ItemCallback<Contact>() {
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem == newItem
        }
    }

    inner class ContactHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var txtName : TextView = itemView.findViewById(R.id.txt_name)
        var txtFamily : TextView = itemView.findViewById(R.id.txt_family)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
        return ContactHolder(view)
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        getItem(position)?.let { item ->
            holder.txtName.text = item.name
            holder.txtFamily.text = item.family
        }
    }

    fun onCall(context: Context, position: Int) {
        getItem(position)?.let { item ->
            when {
                item.phone.isEmpty().not() -> {
                    context.openCall(item.phone)
                }
                item.phone.isEmpty().not() -> {
                    context.openCall(item.phone)
                }
                else -> { Toast.makeText(context , "شماره همراه در دسترس نیست!" , Toast.LENGTH_SHORT).show() }
            }
        }
    }

    fun onSms(context: Context, position: Int) {
        getItem(position)?.let { item ->
            when {
                item.phone.isEmpty().not() -> {
                    context.openSMS(item.phone)
                }
                else -> { Toast.makeText(context , "شماره همراه در دسترس نیست!" , Toast.LENGTH_SHORT).show() }
            }
        }
    }

}