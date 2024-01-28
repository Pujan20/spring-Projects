package com.example.demo;

import java.util.List;
import java.util.Optional;

public interface SdService {

    int Create(Sdetails S);

    Optional<List<Sdetails>> FindById(int id);

    List<Sdetails> ShowAll();

    int Update(Sdetails S, int id);

    default boolean isIdPresent(int id) {
        return false;
    }
}