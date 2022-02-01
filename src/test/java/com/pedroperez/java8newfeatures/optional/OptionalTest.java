package com.pedroperez.java8newfeatures.optional;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OptionalTest {
    @Test
    public void testOptionalCreation() {
        //An instance of the Optional class can be created with the help of its static methods:

        final Optional<String> optional = Optional.empty();
        // Returns an empty Optional.
        assertThat(optional.isEmpty()).isEqualTo(true);
        assertThat(optional.isPresent()).isEqualTo(false);

        final String str = "value";
        final Optional<String> optional1 = Optional.of(str);
        //Returns an Optional which contains a non - null value.
        assertThat(optional1.isEmpty()).isEqualTo(false);
        assertThat(optional1.isPresent()).isEqualTo(true);


        final String text = null;
        final Optional<String> optional2 = Optional.ofNullable(text);
        // Will return an Optional with a specific value or an empty Optional if the parameter is null.
        assertThat(optional2.isEmpty()).isEqualTo(true);
        assertThat(optional2.isPresent()).isEqualTo(false);
    }

    @Test
    public void testOptionalNullList() {
        //before java8: when you expect to get a List and if is null you want a new instance of an ArrayList:

        final List<String> list = getNullList();
        final List<String> listOpt = list != null ? list : new ArrayList<>();
        assertThat(listOpt).isNotNull();
        //In Java 8:
        final List<String> listOptJava8 = getNullListOpt().orElseGet(() -> new ArrayList<>());
        assertThat(listOptJava8).isNotNull();

    }

    @Test
    public void testOptionalNullAttribute() {
        //before java8
        final User user = getUser();
        String streetName = null;
        if (user != null) {
            final Address address = user.getAddress();
            if (address != null) {
                final Street street = address.getStreet();
                if (street != null) {
                    streetName = street.getName();
                }
            }
        }
        assertThat(streetName).isNull();
        //With java8
        final Optional<User> userOpt = Optional.ofNullable(getUser());
        final String streetName2 = userOpt
                .map(User::getAddress)
                .map(Address::getStreet)
                .map(Street::getName)
                .orElse("No Street");
        assertThat(streetName2).isEqualTo("No Street");

        final Optional<String> streetNameOpt = userOpt
                .map(User::getAddress)
                .map(Address::getStreet)
                .map(Street::getName);
        assertThat(streetNameOpt.isEmpty()).isEqualTo(true);

        //If our getters return Optional<T> we use the flatMap() method instead:

        final Optional<OptionalUser> optionalUser = Optional.ofNullable(getOptionalUser());
        final String result = optionalUser
                .flatMap(OptionalUser::getAddress)
                .flatMap(OptionalAddress::getStreet)
                .flatMap(OptionalStreet::getName)
                .orElse("not specified");
        assertThat(result).isEqualTo("not specified");
    }

    @Test
    public void testChangeNullException() throws CustomException {
        final String value = null;
        String result = "";
        try {
            result = value.toUpperCase();
        } catch (final NullPointerException exception) {
            throw new CustomException();
        }
        //And what if we use Optional<String>? The answer is more readable and simpler:

        final String value2 = null;
        final Optional<String> valueOpt = Optional.ofNullable(value);
        final String result2 = valueOpt.orElseThrow(CustomException::new).toUpperCase();
    }

    private OptionalUser getOptionalUser() {
        return OptionalUser.builder().address(Optional.of(OptionalAddress.builder().street(Optional.
                of(OptionalStreet.builder().name(Optional.ofNullable(null)).build())).build())).build();
    }

    private User getUser() {
        return User.builder().build();
    }

    private List<String> getNullList() {
        return null;
    }

    private Optional<List<String>> getNullListOpt() {
        return Optional.empty();
    }
}
