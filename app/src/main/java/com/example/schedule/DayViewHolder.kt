package com.example.schedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class DayViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val lessonsRecyclerView: RecyclerView = view.findViewById(R.id.list_subject)
}