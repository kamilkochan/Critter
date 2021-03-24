package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.pet.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    PetRepository petRepository;

    public Schedule createSchedule(Schedule schedule){
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getAllSchedules(){
        return scheduleRepository.findAll();
    }

    public List<Schedule> getScheduleForPet(Long id){
        return scheduleRepository.findByPetsId(id);
    }

    public List<Schedule> getScheduleForEmployee(Long id){
        return scheduleRepository.findByEmployeesId(id);
    }

    public List<Schedule> getScheduleForCustomer(Long id){
        List<Pet> pets = petRepository.findByCustomerId(id);
        List<Long> ids = pets.stream().map(Pet::getId).collect(Collectors.toList());
        return scheduleRepository.findByPetsIdIn(ids);
    }

}
