package com.mahmutcelik.folksdevproject.model

import jakarta.persistence.CascadeType
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.LocalDateTime

data class Account(


        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
        val id:String?,
        val balance:BigDecimal? = BigDecimal.ZERO,
        val creationDate:LocalDateTime,


        //İlgili account un sadece 1 tane customer i olmasını sağlar ManyToOne
        @ManyToOne(fetch = FetchType.LAZY , cascade = [CascadeType.ALL])
        @JoinColumn(name = "customer_id", nullable = false)
        val customer:Customer?,

        //1 accountta 1den fazla transaction olabileceği için ve bunlara erişmek istediğimizde
        //saklamak için Set kullandık ve OneToMany relationship koyduk
        @OneToMany(mappedBy = "account" , fetch = FetchType.EAGER , cascade = [CascadeType.ALL])
        val transaction:Set<Transaction>?

){
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Account

                if (id != other.id) return false
                if (balance != other.balance) return false
                if (creationDate != other.creationDate) return false
                if (customer != other.customer) return false
                if (transaction != other.transaction) return false

                return true
        }

        //1 account un 1 tane customer ı oldugu için hesaba dahil ettik
        //1 accountta 1den fazla transaction olabileceği için dahil etmedik
        override fun hashCode(): Int {
                var result = id?.hashCode() ?: 0
                result = 31 * result + (balance?.hashCode() ?: 0)
                result = 31 * result + creationDate.hashCode()
                result = 31 * result + (customer?.hashCode() ?: 0)
                return result
        }

        //VERITABANINDAKI KARSILIGI BUDUR

}
