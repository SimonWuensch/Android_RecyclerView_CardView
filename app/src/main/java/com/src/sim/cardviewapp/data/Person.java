package com.src.sim.cardviewapp.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 16.04.2015.
 */
public class Person {

    public String id;
    public String firstName;
    public String lastName;

    public List<Person> dataList;

    public boolean defaultData = false;

    public Person(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public static List<Person> createDefaultPersons(){
        return new ArrayList<Person>(){
            {
             add(new Person("1111", "Simon", "Wünsch"));
             add(new Person("2222", "Andreas", "Peter"));
             add(new Person("3333", "Max1", "Muster"));
             add(new Person("4444", "Max2", "Muster"));
             add(new Person("5555", "Max3", "Muster"));
             add(new Person("6666", "Max4", "Muster"));
             add(new Person("7777", "Max5", "Muster"));
             add(new Person("8888", "Max6", "Muster"));
             add(new Person("9999", "Max7", "Muster"));
            }
        };
    }
}
