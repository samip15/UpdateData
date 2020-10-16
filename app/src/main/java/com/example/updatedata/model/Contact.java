package com.example.updatedata.model;

import java.util.ArrayList;

public class Contact implements Comparable {
    private int id;
    private String name;
    private String phone;

    public Contact(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public Contact() {
    }

    public ArrayList<Contact> getContacts() {
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(1, "Samip", "01210201202"));
        contacts.add(new Contact(2, "Ram", "01245201202"));
        contacts.add(new Contact(3, "Shyam", "01290001202"));
        contacts.add(new Contact(4, "hari", "012102112202"));
        contacts.add(new Contact(5, "subash", "012102888202"));
        contacts.add(new Contact(7, "prem", "01210201202999"));
        contacts.add(new Contact(8, "Sarita", "0121020120290"));
        contacts.add(new Contact(9, "Suman", "0121020155"));
        contacts.add(new Contact(10, "ajay", "012102016602"));
        contacts.add(new Contact(11, "gita", "01210201207702"));
        return contacts;
    }

    public ArrayList<Contact> getUpdatedContacts()
    {
        ArrayList<Contact> contacts = getContacts();
        contacts.get(0).setName("samip gnyawali");
        contacts.get(5).setName("ram niraula");
        contacts.get(5).setPhone("00000000009999");
        contacts.get(6).setName("GO Babu");
        contacts.get(6).setPhone("12345678");
        contacts.get(8).setName("Hari Bhakta");
        contacts.get(8).setPhone("33334445555");
        return contacts;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int compareTo(Object o) {
        Contact contact = (Contact) o;
        if (contact.getName().equals(this.name) && contact.getPhone().equals(this.phone))
        return 0;
        return 1;
    }
}
