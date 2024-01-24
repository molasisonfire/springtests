package sales.rest.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sales.model.Customer;
import sales.repository.CustomerRepo;

import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;


    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Integer id) {
        return customerRepo
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND,"Not found"));

    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(@RequestBody @Valid Customer customer) {
        return customerRepo.save(customer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomerById(@PathVariable Integer id) {
        customerRepo
                .findById(id)
                .map( found -> {
                    customerRepo.delete(found);
                    return null;
                })
                .orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND,"Not found"));
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable Integer id, @RequestBody Customer customer) {
        return customerRepo.findById(id).map(customerFound -> {
                    customer.setId(customerFound.getId());
                    customerRepo.save(customer);
                    return customerFound;
                }
        ).orElseThrow(() -> new ResponseStatusException( HttpStatus.NOT_FOUND,"Not found"));
    }
}
