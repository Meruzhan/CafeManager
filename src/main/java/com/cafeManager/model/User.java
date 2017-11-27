package com.cafeManager.model;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Gasparyan on 26.11.2017.
 */
@Entity
@Table(name = "member")
public  class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "firstname")
    private String firstName;


    @Column(name = "lastname")
    private String lastName;

    @ManyToOne()
    @JoinColumn(name = "roleid",referencedColumnName = "id")
    private Role role;

    public User(){
    }

    public User(long id, String firstName, String lastName, Role role) {
        this.id =id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public User( String firstName, String lastName, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
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


    public Role getRole() {
        return this.role;
    }


    public void setRole(Role role) {
        this.role = role;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", role=" + role +
//                '}';
//    }
}
