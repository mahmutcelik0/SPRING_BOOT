package com.mahmutcelik.folksdevproject.dto;

import com.mahmutcelik.folksdevproject.model.Account;
import com.mahmutcelik.folksdevproject.model.Customer;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AccountDtoConverter {

    private final CustomerDtoConverter customerDtoConverter;
    private final TransactionDtoConverter transactionDtoConverter;

    public AccountDtoConverter(CustomerDtoConverter customerDtoConverter,
                               TransactionDtoConverter transactionDtoConverter) {
        this.customerDtoConverter = customerDtoConverter;
        this.transactionDtoConverter = transactionDtoConverter;
    }

    public AccountDto convert(Account from) {
        return new AccountDto(
                from.getId(),
                from.getBalance(),
                from.getCreationDate(),
                customerDtoConverter.convertToCustomerDto(Objects.requireNonNull(from.getCustomer())),
                Objects.requireNonNull(from.getTransaction())
                        .stream()
                        .map(transactionDtoConverter::convert)
                        .collect(Collectors.toSet()));
    }
}
