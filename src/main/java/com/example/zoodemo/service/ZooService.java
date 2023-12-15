package com.example.zoodemo.service;

import com.example.zoodemo.dao.*;
import com.example.zoodemo.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ZooService {

    private final AnimalDao animalDao;
    private final CageDao cageDao;
    private final CategoryDao categoryDao;
    private final FoodItemDao foodItemDao;
    private final SupplierDao supplierDao;

    @Transactional
    public void insertNewAnimal(){
        Category category=categoryDao.fetchCategory("WarmBlood");
        Animal animal=new Animal("Leopard",12);
        Cage cage=new Cage("E003","East");
        animal.setCage(cage);
        cage.setAnimal(animal);
        category.addAnimal(animal);
        categoryDao.save(category);
    }

    public void removeLastAnimal(){
        Category category=categoryDao.fetchCategory("WarmBlood");
        List<Animal> animals =category.getAnimalList();
        animals.remove(animals.size() -1);
    }

    @Transactional
    public void createAnimalsWithCategory(){
        Category category=new Category();
        category.setCategoryType("WarmBlood");

        Animal animal1=new Animal("Lion",10);
        Animal animal2=new Animal("Dog",15);
        Cage cage1=new Cage("E002","East");
        Cage cage2=new Cage("W002","West");
        //mapping
        animal1.setCage(cage1);
        cage1.setAnimal(animal1);
        animal2.setCage(cage2);
        cage2.setAnimal(animal2);

        category.addAnimal(animal1);
        category.addAnimal(animal2);

        categoryDao.save(category);
        animalDao.save(animal1);
        animalDao.save(animal2);
    }


    @Transactional
    public void createDb(){
        Category category=new Category();
        category.setCategoryType("Cool Blood");
        Category category1=categoryDao.fetchCategory("WarmBlood");
        Animal animal1 = new Animal("Tiger", 20);
        Animal animal2 = new Animal("Fish",100);
        Animal animal3 = new Animal("Monkey",100);
        Animal animal4 = new Animal("Dear",50);
        category1.addAnimal(animal1);
        category1.addAnimal(animal3);
        category1.addAnimal(animal4);

        category.addAnimal(animal2);

       Cage cage1 = new Cage("E001","East");
        Cage cage2 = new Cage("W001","West");
        Cage cage3 = new Cage("N001","North");
        Cage cage4 = new Cage("S001","South");

        Supplier supplier1=new Supplier("John", "12-345-67","MDY");
        Supplier supplier2=new Supplier("Doe", "12-345-67","YGN");

        FoodItem foodItem1=new FoodItem("Apple",20);
        FoodItem foodItem2=new FoodItem("Orange",15);
        FoodItem foodItem3=new FoodItem("Milk",30);
        FoodItem foodItem4=new FoodItem("Oil",10);

        //mapping
        supplier1.addFoodItem(foodItem1);
        supplier1.addFoodItem(foodItem2);
        supplier2.addFoodItem(foodItem3);
        supplier2.addFoodItem(foodItem4);
        cage1.setAnimal(animal1);
        cage2.setAnimal(animal2);
        cage3.setAnimal(animal3);
        cage4.setAnimal(animal4);
        animal1.setCage(cage1);
        animal2.setCage(cage2);
        animal3.setCage(cage3);
        animal4.setCage(cage4);
        categoryDao.save(category);
        categoryDao.save(category);

        cageDao.save(cage1);
        cageDao.save(cage2);
        cageDao.save(cage3);
        cageDao.save(cage4);

        animalDao.save(animal1);
        animalDao.save(animal2);
        animalDao.save(animal3);
        animalDao.save(animal4);
       // supplierDao.save();
   }
}