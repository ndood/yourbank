package com.yourbank.data.model.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yourbank.data.model.bank.Accrual;
import com.yourbank.data.model.bank.Credit;
import com.yourbank.data.model.common.AbstractExpiringEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 09.01.2016.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class UserCredit extends AbstractExpiringEntity {

    private String description;

    @Enumerated(EnumType.STRING)
    private Credit.CurrencyCode currency;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    private UserProfile userProfile;

    private String name;

    private double percent;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Accrual> accruals = new ArrayList<>();
    private int term; // окончание
    private double sum;
    private boolean paid;
}
