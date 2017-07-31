package com.codegirl.model;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Şeyma Yılmaz on 30.7.2017.
 */
@Entity
@Table(name = "tbl_person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fullName")
    private String name;

    private int age;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @ElementCollection
    @JoinTable(
            name = "personAddressTable",
            joinColumns = @JoinColumn(name = "personId")
    )
    @GenericGenerator(name = "sequence-gen", strategy = "sequence")
    @CollectionId(
            columns = { @Column(name = "addressId") },
            type = @Type(type = "long"),
            generator = "sequence-gen"
    )
    private List<Address> addressList = new ArrayList<>();

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

}
