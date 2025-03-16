package com.jitendra.myassignment.repository

import com.jitendra.myassignment.api.ApiClient
import com.jitendra.myassignment.model.Employee

class EmployeeRepository {
    suspend fun getEmployees(): List<Employee>? {
        val response = ApiClient.api.getEmployees()
        return if (response.isSuccessful) response.body()?.get("employees") else null
    }
}
