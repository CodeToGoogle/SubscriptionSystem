package com.subscription.interview.controller;

import com.subscription.interview.model.BuySubscription;
import com.subscription.interview.model.SubscriptionMaster;
import com.subscription.interview.repository.SubscriptionMasterRepository;
import com.subscription.interview.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionMasterRepository subscriptionMasterRepository;

    @Autowired
    private SubscriptionService subscriptionService;

    //----------------- Get All Subscriptions
    @GetMapping("/list")
    public List<SubscriptionMaster> getAllSubscriptions() {
        return subscriptionMasterRepository.findAll();
    }

    // ----------- Create SubscriptionMaster (New API for adding sample data)
    @PostMapping("/create")
    public SubscriptionMaster createSubscription(@RequestBody SubscriptionMaster subscriptionMaster) {
        return subscriptionMasterRepository.save(subscriptionMaster);
    }

    // 3. Buy a subscription
    @PostMapping("/buy")
    public BuySubscription buySubscription(@RequestParam Long userId, @RequestParam Long subscriptionId) {
        return subscriptionService.buySubscription(userId, subscriptionId);
    }

    // 4. Get user subscriptions
    @GetMapping("/user/{userId}")
    public List<BuySubscription> getUserSubscriptions(@PathVariable Long userId) {
        return subscriptionService.getUserSubscriptions(userId);
    }
}
