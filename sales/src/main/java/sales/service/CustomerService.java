package sales.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sales.model.Customer;
import sales.repository.MyRepo;

@Service
public class CustomerService {

    private MyRepo customerRepo;

    @Autowired
    public CustomerService(MyRepo repository){
        this.customerRepo = repository;
    }

    public void saveCustomer(Customer customer){
        validateCustomer(customer);
        customerRepo.save(customer);
    }

    private void validateCustomer(Customer customer) {
    }
}
