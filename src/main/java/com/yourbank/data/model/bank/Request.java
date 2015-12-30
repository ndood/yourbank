package com.yourbank.data.model.bank;

import com.yourbank.data.model.common.AbstractExpiringEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * @author admin.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Request extends AbstractExpiringEntity {

    @Column(unique = true)
    private String name;
    private boolean approved = false;
    private String phoneNumber;
    private String firstName;
    private String target;
    private String lastName;
    private String patronymic;
    private String email;
    private Integer period; // месяцы
    @ManyToOne(fetch = FetchType.EAGER)
    private Credit credit;

    public Request(String name, String phoneNumber, String firstName, String target,
                   String lastName, String patronymic, Credit credit, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.target = target;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.credit = credit;
        this.email = email;
    }
}
