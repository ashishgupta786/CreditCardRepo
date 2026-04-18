//package com.zbank.CreditCard.security;
//
//import com.zbank.CreditCard.entity.Customer;
//import com.zbank.CreditCard.repository.CustomerRepository;
//import com.zbank.CreditCard.utility.JwtUtil;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//@Component
//@RequiredArgsConstructor
//public class JwtFilter extends OncePerRequestFilter {
//
//    private  JwtUtil jwtUtil;
//    private  CustomerRepository customerRepository;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        final String authHeader = request.getHeader("Authorization");
//        String email = null;
//        String token = null;
//
//        if (authHeader != null && authHeader.startsWith("Bearer ")) {
//            token = authHeader.substring(7);
//            email = jwtUtil.extractEmail(token);
//        }
//        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            Customer customer = customerRepository.findByEmail(email).orElse(null);
//            if (customer != null && jwtUtil.validateToken(token)) {
//                UsernamePasswordAuthenticationToken authToken =
//                        new UsernamePasswordAuthenticationToken(
//                                customer.getEmail(),
//                                null,
//                                new ArrayList<>()
//                        );
//
//                SecurityContextHolder.getContext().setAuthentication(authToken);
//            }
//        }
//
//        filterChain.doFilter(request, response);
//    }
//}