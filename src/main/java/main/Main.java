package main;

import config.JPAConfig;
import entity.CustomerEntity;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.CustomerRepository;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    static AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JPAConfig.class);
    static CustomerRepository customerRepository = applicationContext.getBean("customerRepository", CustomerRepository.class);
    public static void main (String [] args){
//        createNewCustomer();
//        customerRepository.deleteAll();
//        showList();
//        findById(11);
//        findByName("T");
//        findByPhoneOrEmail(123,"nguyenquangthien@gmail.com");
        getListMaleAge();


    }
    public static void createNewCustomer(){
        CustomerEntity customer = new CustomerEntity();
        customer.setName("Nguyen Quang Thien");
        customer.setBirthdate(LocalDate.parse("1999-06-01"));
        customer.setSex("male");
        customer.setEmail("nguyenquangthien@gmail.com");
        customer.setPhone(123);
        customer.setAddress("Quang Nam");
        CustomerEntity result = customerRepository.save(customer);
        if (result != null) {
            System.out.println("A new customer saved successfully, customer ID = " + customer.getId());
        }
        CustomerEntity customer1 = new CustomerEntity();
        customer1.setName("Nguyen Quang Trung");
        customer1.setBirthdate(LocalDate.parse("1995-04-22"));
        customer1.setSex("male");
        customer1.setEmail("nguyenquangthien@gmail.com");
        customer1.setPhone(456);
        customer1.setAddress("Quang Nam");
        CustomerEntity result1 = customerRepository.save(customer1);
        if (result != null) {
            System.out.println("A new customer saved successfully, customer ID = " + customer1.getId());
        }
    }
    public static void showList(){
        List<CustomerEntity> result = (List<CustomerEntity>) customerRepository.findAll();
        for ( int i=0; i < result.size() ;i++){
            System.out.println("----Customer--" + i);
            result.get(i).toString();
            System.out.println( result.get(i).toString());
        }
    }
    public static void findById(Integer id){
        System.out.println(customerRepository.findById(id).get().toString());
    }
    public static void findByName(String name){
        String likePattern = "%"+name+"%";
       List<CustomerEntity> result = customerRepository.findByNameLike(likePattern);
        for (CustomerEntity customerEntity:result) {
            System.out.println(customerEntity.toString());
        }
    }
    public static void findByPhoneOrEmail(int phone,String email){
        List<CustomerEntity> result = customerRepository.findByPhoneOrEmail(phone,email);
        for (CustomerEntity customerEntity:result) {
            System.out.println(customerEntity.toString());
        }
    }

    public static void getListMaleAge(){
        List<CustomerEntity> result = customerRepository.getListMaleAge();
        for (CustomerEntity customerEntity:result) {
            System.out.println(customerEntity.toString());
        }
    }




}
