package model.interrface;

import model.enums.ContactType;

public interface IContact {

    int getId();

    String getFullName();

    String getEmail();

    String getPhoneNumber();

    ContactType getContactType();
}
