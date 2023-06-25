package com.allena.response;

import com.allena.model.Customer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import java.time.LocalDate;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CustomerDto {

    private Long id;

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    public CustomerDto(Customer customer) {
        this.id = customer.getId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.dateOfBirth = customer.getDateOfBirth();
    }
}