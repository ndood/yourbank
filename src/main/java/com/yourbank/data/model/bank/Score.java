package com.yourbank.data.model.bank;


import com.yourbank.data.model.user.User;
import com.yourbank.data.model.common.AbstractExpiringEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Currency;
import java.util.List;

/**
 * @author admin.
 */
@Entity
public class Score extends AbstractExpiringEntity {

    private double value;

    @ManyToOne
    private User user;

    @OneToOne
    private Credit credit;

    @ManyToMany
    private List<ScoreType> scoreTypes;

    public List<ScoreType> getScoreTypes() {
        return scoreTypes;
    }

    public void setScoreTypes(List<ScoreType> scoreTypes) {
        this.scoreTypes = scoreTypes;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    private Currency currency;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}