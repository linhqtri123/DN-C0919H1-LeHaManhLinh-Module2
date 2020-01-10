package com.example.quanlyphantrang.controllers;

import com.example.quanlyphantrang.models.Customer;
import com.example.quanlyphantrang.models.Province;
import com.example.quanlyphantrang.service.CustomerService;
import com.example.quanlyphantrang.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces() {
        return provinceService.findAll();
    }

    @GetMapping("")
    public ModelAndView listCustomers(@RequestParam(value = "s",required = false) String s,@PageableDefault(size = 5) Pageable pageable) {
        Page<Customer> customers;
        ModelAndView modelAndView = new ModelAndView("list");
        if (s != null) {
            customers = customerService.findAllByFirstNameContaining(s, pageable);
            modelAndView.addObject("search", s);
        } else {
            customers = customerService.findAll(pageable);
        }
        modelAndView.addObject("customers", customers);
        return modelAndView;
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
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.remove(customer.getId());
        return "redirect:";
    }
}
