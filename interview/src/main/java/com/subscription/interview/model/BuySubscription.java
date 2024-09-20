package com.subscription.interview.model;


import com.subscription.interview.model.SubscriptionMaster;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "buy_subscription")
public class BuySubscription {

    // Getters and Setters
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscription_id")
    private SubscriptionMaster subscription;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    // Constructors
    public BuySubscription() {}

    public BuySubscription(Long userId, SubscriptionMaster subscription, LocalDate startDate, LocalDate endDate) {
        this.userId = userId;
        this.subscription = subscription;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}
