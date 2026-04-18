package com.zbank.CreditCard.service;

import com.zbank.CreditCard.dto.AuthRequest;

public interface AuthService {
    String login(AuthRequest request);
}
