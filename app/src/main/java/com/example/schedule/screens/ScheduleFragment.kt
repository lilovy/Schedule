package com.example.schedule.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.schedule.DayItem
import com.example.schedule.R
import com.example.schedule.SubjectItem
import com.example.schedule.DayAdapter
import com.example.schedule.databinding.FragmentDayScheduleBinding
import java.util.Calendar


class ScheduleFragment(isWeek: Boolean) : Fragment() {
    private var binding: FragmentDayScheduleBinding? = null
    lateinit var adapter: DayAdapter
    lateinit var recyclerView: RecyclerView
    val isWeek = isWeek

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDayScheduleBinding.inflate(inflater, container, false)
        newInstance()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initial()
    }

    fun initial() {
        recyclerView = binding?.root?.findViewById(R.id.list_days)!!

        adapter = DayAdapter()
        recyclerView.adapter = adapter
        adapter.setList(myDays())
    }

    private fun getScheduleAdapter(): RecyclerView.Adapter<*> {
        return DayAdapter().apply {
            setList(myDays())
        }
    }

    fun myDays(): ArrayList<DayItem> {
        val dayList = ArrayList<DayItem>()

        if (!isWeek) {
            val today = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
            val todayDayItem = DayItem(getDayOfWeekString(today), myLessonsForDay(today))
            dayList.add(todayDayItem)
        } else {
            dayList.add(DayItem("Понедельник", myLessonsMonday()))
            dayList.add(DayItem("Вторник", myLessonsTuesday()))
            dayList.add(DayItem("Среда", myLessonsWednesday()))
            dayList.add(DayItem("Четверг", myLessonsThursday()))
            dayList.add(DayItem("Пятница", myLessonsFriday()))
            dayList.add(DayItem("Суббота", myLessonsSaturday()))
        }
        return dayList
    }

    private fun getDayOfWeekString(dayOfWeek: Int): String {
        val days = arrayOf("Воскресенье", "Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота")
        return days[dayOfWeek - 1]
    }

    private fun myLessonsForDay(dayOfWeek: Int): List<SubjectItem> {
        return when (dayOfWeek) {
            Calendar.MONDAY -> myLessonsMonday()
            Calendar.TUESDAY -> myLessonsTuesday()
            Calendar.WEDNESDAY -> myLessonsWednesday()
            Calendar.THURSDAY -> myLessonsThursday()
            Calendar.FRIDAY -> myLessonsFriday()
            Calendar.SATURDAY -> myLessonsSaturday()
            Calendar.SUNDAY -> emptyList()
            else -> emptyList()
        }
    }

    private fun myLessonsMonday(): ArrayList<SubjectItem> {
        val subjectList = ArrayList<SubjectItem>()

        subjectList.add(SubjectItem("7", "18:20\n   -\n19:50",
            "Интернет-Технологии (лек)", "1Н", "132A", "Ерина Н.А."))

        subjectList.add(SubjectItem("7", "18:20\n   -\n19:50",
            "Интернет-Технологии (пр)", "2Н", "132A", "Ерина Н.А."))

        subjectList.add(SubjectItem("8", "19:55\n   -\n21:55",
            "Интернет-Технологии (пр)", "1Н", "132A", "Ерина Н.А."))

        return subjectList
    }

    private fun myLessonsTuesday(): List<SubjectItem> {
        val subjectList = ArrayList<SubjectItem>()

        subjectList.add(SubjectItem("5", "15:00\n   -\n16:30",
            "Анализ данных (пр)", "1Н", "132A", "Алюков С.В."))

        subjectList.add(SubjectItem("6", "18:40\n   -\n18:10",
            "Анализ данных (пр)", "1Н", "132A", "Алюков С.В."))

        subjectList.add(SubjectItem("6", "16:40\n   -\n18:10",
            "Интернет-Маркетинг (лек)", "2Н", "132Б", "Петриченко Ю.В., Новикова М.В."))

        subjectList.add(SubjectItem("7", "18:20\n   -\n19:50",
            "Базы и хранилища данных (лек)", "1Н", "413", "Барабанщиков И.В."))

        subjectList.add(SubjectItem("7", "18:20\n   -\n19:50",
            "Интернет-Маркетинг (пр)", "2Н", "132Б", "Петриченко Ю.В., Новикова М.В."))

        subjectList.add(SubjectItem("8", "19:55\n   -\n21:55",
            "Тестирование программного обеспечения (пр)", "1Н", "132Б", "Булавин Р.С."))

        return subjectList
    }

    private fun myLessonsWednesday(): List<SubjectItem> {
        val subjectList = ArrayList<SubjectItem>()

        subjectList.add(SubjectItem("5", "15:00\n   -\n16:30",
            "Архитектура предприятия и моделирование бизнес-процессов (лек)", "2Н", "132Б", "Шепталин А.Г."))

        subjectList.add(SubjectItem("6", "16:40\n   -\n18:10",
            "Архитектура предприятия и моделирование бизнес-процессов (пр)", "1/2Н", "132Б", "Шепталин А.Г."))

        subjectList.add(SubjectItem("7", "18:20\n   -\n19:50",
            "Управление ИТ-проектами и жизненым\nциклом (лек)", "1/2Н", "A-15", "Владимир, Андрей"))

        subjectList.add(SubjectItem("8", "19:55\n   -\n21:55",
            "Управление ИТ-проектами и жизненым\nциклом (пр)", "1/2Н", "A-15", "Владимир, Андрей"))

        return subjectList
    }

    private fun myLessonsThursday(): List<SubjectItem> {
        val subjectList = ArrayList<SubjectItem>()

        subjectList.add(SubjectItem("6", "16:40\n   -\n18:10",
            "Анализ данных (лек)", "1Н", "A-13", "Алюков С.В."))

        subjectList.add(SubjectItem("7", "18:20\n   -\n19:50",
            "Базы и хранилища данных (пр)", "1Н", "132", "Барабанщиков И.В."))

        subjectList.add(SubjectItem("8", "19:55\n   -\n21:55",
            "Базы и хранилища данных (пр)", "1Н", "132", "Барабанщиков И.В."))

        return subjectList
    }

    private fun myLessonsFriday(): List<SubjectItem> {
        val subjectList = ArrayList<SubjectItem>()

        subjectList.add(SubjectItem("4", "13:15\n   -\n14:45",
            "Прикладная оздоровительная физическая\nкультура (лек)", "1/2Н", "-", "Ярушин С.А."))

        return subjectList
    }

    private fun myLessonsSaturday(): List<SubjectItem> {
        val subjectList = ArrayList<SubjectItem>()

        subjectList.add(SubjectItem("2-5", "10:00\n   -\n16:30",
            "Технологии прикладного\nпрограммирования (пр)", "1Н", "132", "Веригин Никита"))

        subjectList.add(SubjectItem("6", "16:40\n   -\n18:10",
            "Тестирование програмного обеспечения (лек)", "1/2Н", "-", "Булавин Р.С."))

        return subjectList
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ScheduleFragment(isWeek=false).apply {

            }
    }

}