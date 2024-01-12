package com.example.schedule

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DayAdapter: RecyclerView.Adapter<DayViewHolder>()  {
    private var dayList = emptyList<DayItem>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DayViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.day_item_layout, parent, false)
        return DayViewHolder(view)
    }

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        val day = dayList[position]
        holder.itemView.findViewById<TextView>(R.id.day).text = day.day

        val lessonAdapter = LessonAdapter()
        holder.lessonsRecyclerView.adapter = lessonAdapter
        lessonAdapter.setList(day.lessons)
    }

    override fun getItemCount(): Int {
        return dayList.size
    }

    @SuppressLint("notifyDataSetChanged")
    fun setList(list: List<DayItem>) {
        dayList = list
        notifyDataSetChanged()
    }
}