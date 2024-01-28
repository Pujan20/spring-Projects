package com.example.demo;

import java.util.List;

public interface SdRepo {

    int Create(Sdetails S);

    int Update(Sdetails S, int id);

    List<Sdetails> FindById(int id);

    List<Sdetails> ShowAll();

   
    default boolean isPresent(int id) {
        List<Sdetails> SdList = FindById(id);
        return !SdList.isEmpty();
    }
}