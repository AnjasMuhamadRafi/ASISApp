package com.atreus.asisapp.home.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.atreus.asisapp.adapter.TaskItemAdapter
import com.atreus.asisapp.adapter.TaskItemClickListener
import com.atreus.asisapp.component.NewTaskSheet
import com.atreus.asisapp.data.model.TaskItem
import com.atreus.asisapp.databinding.FragmentWorkBinding
import com.atreus.asisapp.viewmodel.TaskViewModel


class Work : Fragment(), TaskItemClickListener {

    private lateinit var binding: FragmentWorkBinding

    //private lateinit var taskViewModel: TaskViewModel
    private val taskViewModel: TaskViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWorkBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.newTaskButton.setOnClickListener {
            NewTaskSheet(null).show(parentFragmentManager, "newTaskTag")
        }
        setRecyclerView()
    }

    //memanggil recyclerview
    private fun setRecyclerView()
    {
        val work = this
        taskViewModel.taskItems.observe(viewLifecycleOwner){
            binding.todoListRecyclerView.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = TaskItemAdapter(it, work)
            }
        }
    }

    override fun editTaskItem(taskItem: TaskItem)
    {
        NewTaskSheet(taskItem).show(parentFragmentManager,"newTaskTag")
    }

    override fun completeTaskItem(taskItem: TaskItem)
    {
        taskViewModel.setCompleted(taskItem)
    }
}