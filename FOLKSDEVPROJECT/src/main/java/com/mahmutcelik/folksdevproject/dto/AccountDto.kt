package com.mahmutcelik.folksdevproject.dto

import com.mahmutcelik.folksdevproject.model.Customer
import com.mahmutcelik.folksdevproject.model.Transaction
import java.math.BigDecimal
import java.time.LocalDateTime

data class AccountDto(
    val id:String?,
    val balance: BigDecimal? = BigDecimal.ZERO,
    val creationDate: LocalDateTime,
    val customer: CustomerDto?,
    val transaction:Set<TransactionDto>?

    )
