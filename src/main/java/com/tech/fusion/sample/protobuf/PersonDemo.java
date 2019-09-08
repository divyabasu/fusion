package com.tech.fusion.sample.protobuf;

import com.data.model.address.AddressDetailsMessage;
import com.data.model.person.PersonDetailsMessage;
import com.google.protobuf.InvalidProtocolBufferException;

public class PersonDemo {

    public static void main(String[] args) {

        PersonDetailsMessage.Person newPersonDetails =
                populatePersonDetails();

        final byte[] binaryPerson =
                newPersonDetails.toByteArray();

        final PersonDetailsMessage.Person copiedPerson =
                instantiatePersonFromBinary(binaryPerson);

        System.out.println(
                "BEFORE Person (" + System.identityHashCode(newPersonDetails) + "): " + newPersonDetails);
        System.out.println(
                "AFTER Person (" + System.identityHashCode(copiedPerson) + "): " + copiedPerson);
    }

    private static AddressDetailsMessage.Address populateHomeAddressDetails (){
        return AddressDetailsMessage.Address.newBuilder()
                .setAddressLine1("HAL 3rd stage")
                .setAddressLine2("Old Airport Road")
                .setCity("Bangalore")
                .setCountry("India")
                .setZipCode(560017)
                .build();
    }

    private static AddressDetailsMessage.Address populateOfficeAddressDetails (){
        return AddressDetailsMessage.Address.newBuilder()
                .setAddressLine1("Prestige Tech Park")
                .setAddressLine2("Marathahalli")
                .setCity("Bangalore")
                .setCountry("India")
                .setZipCode(560103)
                .build();
    }

    private static PersonDetailsMessage.PhoneNumber populateMobileNumber(){
        return PersonDetailsMessage.PhoneNumber.newBuilder()
                .setNumber("9874561230")
                .setType(PersonDetailsMessage.PhoneType.MOBILE)
                .build();
    }

    private static PersonDetailsMessage.PhoneNumber populateHomeNumber(){
        return PersonDetailsMessage.PhoneNumber.newBuilder()
                .setNumber("8881212")
                .setType(PersonDetailsMessage.PhoneType.HOME)
                .build();
    }

    private static PersonDetailsMessage.PhoneNumber populateWorkNumber(){
        return PersonDetailsMessage.PhoneNumber.newBuilder()
                .setNumber("0802134879")
                .setType(PersonDetailsMessage.PhoneType.WORK)
                .build();
    }

    private static PersonDetailsMessage.Person populatePersonDetails(){
        return PersonDetailsMessage.Person.newBuilder()
                .setId(786)
                .setName("Davy Jones")
                .setEmail("jones@aol.com")
                .addContactNumbers(populateHomeNumber())
                .addContactNumbers(populateMobileNumber())
                .addContactNumbers(populateWorkNumber())
                .putAddressList("Office", populateOfficeAddressDetails())
                .putAddressList("Home", populateHomeAddressDetails())
                .setPanNumber("FGCAH6788A")
                .build();
    }

    private static PersonDetailsMessage.Person instantiatePersonFromBinary(final byte[] binaryPerson){
        try{
            return PersonDetailsMessage.Person.parseFrom(binaryPerson);
        } catch (InvalidProtocolBufferException ex){
            ex.printStackTrace();
            System.out.println("Failed to read from byteArray");
            return PersonDetailsMessage.Person.newBuilder().build();
        }
    }
}

