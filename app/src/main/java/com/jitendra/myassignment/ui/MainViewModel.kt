package com.jitendra.myassignment.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jitendra.myassignment.model.Employee
import com.jitendra.myassignment.repository.EmployeeRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val repository = EmployeeRepository()

    private val _employees = MutableLiveData<List<Employee>?>()
    val employees: LiveData<List<Employee>?> get() = _employees

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    fun fetchEmployees() {
        viewModelScope.launch {
            try {
                val employeeList = repository.getEmployees()
                if (employeeList.isNullOrEmpty()) {
                    _error.postValue("No employees available.")
                }
                _employees.postValue(employeeList)
            } catch (e: Exception) {
                _error.postValue("Failed to load employees: ${e.message}")
            }
        }
    }
}

