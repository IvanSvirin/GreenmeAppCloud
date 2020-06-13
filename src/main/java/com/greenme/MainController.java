package com.greenme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/green")
public class MainController {
    @Autowired
    private PlantRepository userRepository;

    @PostMapping(path = "/add")
    @ResponseBody
    public String addNewUser(@RequestBody Plant plant) {
        userRepository.save(plant);
        return "Saved";
    }
//    public String addNewUser(@RequestParam(value = "name", required = false, defaultValue = "name_default") String name,
//                      @RequestParam(value = "date", required = false, defaultValue = "date_default") String date,
//                      @RequestParam(value = "location", required = false, defaultValue = "location_default") String location,
//                      @RequestParam(value = "photo", required = false, defaultValue = "photo_default") String photo,
//                      @RequestParam(value = "latitude", required = false, defaultValue = "0") String latitude,
//                      @RequestParam(value = "longitude", required = false, defaultValue = "0") String longitude) {
//        Plant plant = new Plant();
//        plant.setName(name);
//        plant.setDate(date);
//        plant.setLocation(location);
//        plant.setPhoto(photo);
//        plant.setLatitude(Float.valueOf(latitude));
//        plant.setLongitude(Float.valueOf(longitude));
//        userRepository.save(plant);
//        return "Saved";
//    }

    @GetMapping(path = "/all")
    @ResponseBody
    public Iterable<Plant> getAllUsers() {
        return userRepository.findAll();
    }
}
