package com.mahmutcelik.folksdevproject.dto

import com.mahmutcelik.folksdevproject.model.Account

data class CustomerDto(
    val id:String?,
    val name:String?,
    val surname : String?,
    val accounts:Set<Account>

)
