package com.example.demo.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BikeService {
	@Autowired
    private BikeProfile repo;
     
    public List<Bike> listAll() {
        return repo.findAll();
    }
     
    public void save(Bike bike) {
        repo.save(bike);
    }
     
    public Bike get(Long id) {
        return repo.findById(id).get();
    }
     
    public void delete(Long id) {
        repo.deleteById(id);
    }

}
