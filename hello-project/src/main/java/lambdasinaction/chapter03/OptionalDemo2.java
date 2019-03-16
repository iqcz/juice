package lambdasinaction.chapter03;

import java.util.Optional;

class Company {

    /*******Field start*******/
    private String name;
    private Optional<Office> office;

    /*******Field end*******/

    /*******Constructor start*******/
    public Company(String name, Optional<Office> office) {
        this.name = name;
        this.office = office;
    }

    /*******Constructor end*******/

    /*******Getter And Setter start*******/
    public String getName() {
        return name;
    }

    public Optional<Office> getOffice() {
        return office;
    }
    /*******Getter And Setter end*******/
}

class Office {

    private String id;
    private Optional<Address> address;

    public Office(String id, Optional<Address> address) {
        this.id = id;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public Optional<Address> getAddress() {
        return address;
    }
}

class Address {

    private Optional<String> street;
    private Optional<String> city;

    public Address(Optional<String> street, Optional<String> city) {
        this.street = street;
        this.city = city;
    }

    public Optional<String> getStreet() {
        return street;
    }

    public Optional<String> getCity() {
        return city;
    }
}

public class OptionalDemo2 {

    public static void main(String[] args) {
        Optional<Address> address1 = Optional
                .of(new Address(Optional.ofNullable(null), Optional.of("New York")));
        Optional<Office> office1 = Optional.of(new Office("OF1", address1));
        Optional<Company> company1 = Optional.of(new Company("Door Never Closed", office1));

        // What is the street address of company1?
        // In which city company1 is located?
        Optional<Office> maybeOffice = company1.flatMap(Company::getOffice);
        Optional<Address> maybeAddress = maybeOffice.flatMap(Office::getAddress);
        Optional<String> maybeStreet = maybeAddress.flatMap(Address::getStreet);

        maybeStreet.ifPresent(System.out::println);

        if (maybeStreet.isPresent()) {
            System.out.println(maybeStreet.get());
        } else {
            System.out.println("Street not found");
        }

        // if null, set default value.
        System.out.println(maybeStreet.orElse("Default Value"));

        // If a value is present, apply the provided Optional-bearing mapping function to it,
        // return that result, otherwise return an empty Optional. This method is similar to map(Function),
        // but the provided mapper is one whose result is already an Optional, and if invoked, 
        // flatMap does not wrap it with an additional Optional.

        // Map method wraps a new Optional for the returned Optional object.
        Optional<Optional<Office>> mapCompany = company1.map(Company::getOffice);
        if (mapCompany.isPresent()) {
            Optional<Office> oo = mapCompany.get();
            if (oo.isPresent()) {
                Office office = oo.get();
                System.out.println(office.getId());
                Optional<Address> addressOptional = office.getAddress();
                if (addressOptional.isPresent()) {
                    Address address = addressOptional.get();
                    System.out.println(address.getCity());
                    System.out.println(address.getStreet());
                    // TODO 
                }
            } else {
                System.out.println("Office is null");
            }
        }

        // shorter way
        String city = company1.flatMap(Company::getOffice).flatMap(Office::getAddress)
                .flatMap(Address::getCity).orElse("City not found");
        System.out.println("City: " + city);

        // only print if city is not null
        company1.flatMap(Company::getOffice).flatMap(Office::getAddress).flatMap(Address::getCity)
                .ifPresent(System.out::println);

    }
}