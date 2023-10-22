package com.pixeltrice.springbootimagegalleryapp.controller;


import com.pixeltrice.springbootimagegalleryapp.entity.Order;
import com.pixeltrice.springbootimagegalleryapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;


    @GetMapping("/orders")
    public String listOrders(Model model){

        List<Order> listOrders = orderRepository.findAll();
        model.addAttribute("listOrders",listOrders);
        return "orders";
    }


    @GetMapping("/orders/new")
    public String showOrderNewForm(Model model){

        model.addAttribute("order",new Order());
        return "order-form";

    }
    @PostMapping("/orders/save")
    public String saveOrder(Order order){
        order.setCreatedOn(LocalDateTime.now());
        orderRepository.save(order);

        return "thanks";
    }

    @RequestMapping("/orders/delete/{id}")
    public String deleteOrder(@PathVariable(name = "id") Long id) {
        orderRepository.deleteById(id);
        return "redirect:/orders";
    }


}
