package com.example.zoodemo.service;

import com.example.zoodemo.dao.AnimalDao;
import com.example.zoodemo.dao.CageDao;
import com.example.zoodemo.entity.Animal;
import com.example.zoodemo.entity.Cage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ZooService {

    private final AnimalDao animalDao;
    private final CageDao cageDao;
    @Transactional //transction is alive and so are persistence and
    public void createDb(){
        Animal animal1 = new Animal("Tiger", 20);
        Animal animal2 = new Animal("Fish",100);
        Animal animal3 = new Animal("Monkey",100);
        Animal animal4 = new Animal("Dear",50);

        Cage cage1 = new Cage("E001","East");
        Cage cage2 = new Cage("W001","West");
        Cage cage3 = new Cage("N001","North");
        Cage cage4 = new Cage("S001","South");

        //mapping
//        cage1.setAnimal(animal1);
//        cage2.setAnimal(animal2);
//        cage3.setAnimal(animal3);
//        cage4.setAnimal(animal4);

        animal1.setCage(cage1);
        animal2.setCage(cage2);
        animal3.setCage(cage3);
        animal4.setCage(cage4);

        cageDao.save(cage1);
        cageDao.save(cage2);
        cageDao.save(cage3);
        cageDao.save(cage4);

        animalDao.save(animal1);
        animalDao.save(animal2);
        animalDao.save(animal3);
        animalDao.save(animal4);

    }
}