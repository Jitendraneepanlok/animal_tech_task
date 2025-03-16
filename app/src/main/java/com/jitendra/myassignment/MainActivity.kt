package com.jitendra.myassignment

import com.jitendra.myassignment.ui.EmployeeAdapter
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.jitendra.myassignment.databinding.ActivityMainBinding
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.jitendra.myassignment.ui.MainViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
      //  viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // Initialize RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Observe ViewModel Data
        viewModel.employees.observe(this) { employees ->
            binding.progressBar.visibility = View.GONE
            binding.swipeRefresh.isRefreshing = false

            if (employees != null && employees.isNotEmpty()) {
                binding.recyclerView.adapter = EmployeeAdapter(employees)
                binding.tvEmptyState.visibility = View.GONE
            } else {
                binding.tvEmptyState.visibility = View.VISIBLE
            }
        }

        // Observe error handling
        viewModel.error.observe(this) { errorMessage ->
            binding.progressBar.visibility = View.GONE
            binding.swipeRefresh.isRefreshing = false
            if (errorMessage != null) {
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            }
        }

        // Swipe-to-Refresh
        binding.swipeRefresh.setOnRefreshListener {
            fetchEmployees()
        }

        // Fetch employees on app start
        binding.progressBar.visibility = View.VISIBLE
        fetchEmployees()
    }

    private fun fetchEmployees() {
        binding.tvEmptyState.visibility = View.GONE
        viewModel.fetchEmployees()
    }
}

