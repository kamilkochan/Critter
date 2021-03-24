package com.udacity.jdnd.course3.critter.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PetService {
    @Autowired
    PetRepository petRepository;

    public Pet savePet(Pet pet){
        return petRepository.save(pet);
    }

    public Pet getPet(Long id){
        return petRepository.findById(id).get();
    }

    public List<Pet> getPets(){
        return petRepository.findAll();
    }

    public List<Pet>  getPetsByOwner(Long id){
        return petRepository.findByCustomerId(id);
    }

    public List<Pet> getPetsByIds(List<Long> ids){
        return petRepository.findAllById(ids);
    }

}
