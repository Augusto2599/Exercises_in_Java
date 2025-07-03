package model.entities;

import model.enums.ContactType;

import java.util.Objects;

public class Contact {

    private int id;
    private String fullName;
    private String email;
    private String phoneNumber;

    private ContactType contactType;

    public Contact() {
    }

    public Contact(int id, String fullName, String email, String phoneNumber, ContactType contactType) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.contactType = contactType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return id == contact.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "[----- Contato -----]" +
                "\n Nome: " + fullName + "." +
                "\n E-mail: " + email + "." +
                "\n Telefone: " + phoneNumber + "." +
                "\n Tipo de contato: " + contactType + "." +
                "[-------------------------]";
    }
}