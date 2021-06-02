package com.example.demo.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Barber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;

    private String hireDate;

    private Double salary;

    private Double rating;

    private String password;

    private String rank;

    @ManyToMany
    private Set<Service> services;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getHireDate() { return hireDate; }

    public void setHireDate(String hireDate) { this.hireDate = hireDate; }

    public Double getSalary() { return salary; }

    public void setSalary(Double salary) { this.salary = salary; }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}
