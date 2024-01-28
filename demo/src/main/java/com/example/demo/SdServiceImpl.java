package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SdServiceImpl implements SdService {

    private final SdRepo sdRepo;

    @Autowired
    public SdServiceImpl(SdRepo sdRepo) {
        this.sdRepo = sdRepo;
    }

  
    @Override
    public int Create(Sdetails S) {
        return sdRepo.Create(S);
    }

    
    @Override
    public Optional<List<Sdetails>> FindById(int id) {
        List<Sdetails> sdList = sdRepo.FindById(id);
        return Optional.ofNullable(sdList);
    }


    @Override
    public List<Sdetails> ShowAll() {
        return sdRepo.ShowAll();
    }

    
    public int Update(Sdetails S, int id) {
        List<Sdetails> sdList = sdRepo.FindById(id);
        return !sdList.isEmpty() ? sdRepo.Update(S, id) : 0;
    }
}



