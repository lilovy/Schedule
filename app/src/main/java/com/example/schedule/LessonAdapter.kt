package com.example.schedule

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LessonAdapter : RecyclerView.Adapter<LessonViewHolder>() {
    private var subjectList = emptyList<SubjectItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.subject_item_layout, parent, false)
        return LessonViewHolder(view)
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        val subject = subjectList[position]
        holder.numberLesson.text = subject.numberLesson
        holder.time.text = subject.time
        holder.subject.text = subject.subject
        holder.currentWeek.text = subject.currentWeek
        holder.classroom.text = subject.classroom
        holder.fcs.text = subject.fcs
    }

    override fun getItemCount(): Int {
        return subjectList.size
    }

    @SuppressLint("notifyDataSetChanged")
    fun setList(list: List<SubjectItem>) {
        subjectList = list
        notifyDataSetChanged()
    }
}