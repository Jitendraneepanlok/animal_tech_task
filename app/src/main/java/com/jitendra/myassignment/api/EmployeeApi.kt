package com.jitendra.myassignment.api

import com.jitendra.myassignment.model.Employee
import retrofit2.Response
import retrofit2.http.GET

interface EmployeeApi {
    @GET("android-interview/employees.json")
    suspend fun getEmployees(): Response<Map<String, List<Employee>>>
}
