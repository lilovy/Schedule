package com.example.schedule

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LessonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val numberLesson: TextView = view.findViewById(R.id.number_lesson)
    val time: TextView = view.findViewById(R.id.time)
    val subject: TextView = view.findViewById(R.id.subject)
    val currentWeek: TextView = view.findViewById(R.id.current_week)
    val classroom: TextView = view.findViewById(R.id.classroom)
    val fcs: TextView = view.findViewById(R.id.fcs)
}