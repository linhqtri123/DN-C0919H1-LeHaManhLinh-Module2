package com.customer.customermanagement.controllers;

import com.customer.customermanagement.models.Customer;
import com.customer.customermanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ModelAndView listCustomer() {
        return new ModelAndView("list", "customers", customerService.findAll());
    }

    @GetMapping("/create-customer")
    public ModelAndView showCreateForm() {
        return new ModelAndView("customer/create", "customer", new Customer());
    }

    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);

        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            return new ModelAndView("customer/edit", "customer", customer);

        } else {
            return new ModelAndView("/error");
        }
    }

    @PostMapping("/edit-customer")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteCustomer(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            return new ModelAndView("customer/delete", "customer", customer);
        } else {
            return new ModelAndView("/error");
        }
    }

    @PostMapping("/delete-customer")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer){
        customerService.remove(customer.getId());
        return "redirect:";
    }
}
