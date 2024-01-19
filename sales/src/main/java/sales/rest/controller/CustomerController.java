package sales.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sales.model.Customer;
import sales.repository.CustomerRepo;

import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;


    @GetMapping("/{id}")
    public ResponseEntity getCustomerById(@PathVariable Integer id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity save(@RequestBody Customer customer) {
        customerRepo.save(customer);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomerById(@PathVariable Integer id) {
        Customer c = new Customer(id, "test");
        customerRepo.delete(c);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Customer customer) {
        return customerRepo.findById(id).map(customerFound -> {
                    customer.setId(customerFound.getId());
                    customerRepo.save(customer);
                    return ResponseEntity.noContent().build();
                }
        ).orElseGet(() -> ResponseEntity.ok().build());
    }
}
