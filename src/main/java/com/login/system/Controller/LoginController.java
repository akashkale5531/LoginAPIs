package com.login.system.Controller;

import com.login.system.DTO.EntityDTO;
import com.login.system.DTO.LoginDTO;
import com.login.system.DTO.mobNoAndEmailDTO;
import com.login.system.DTO.mobNoLoginDTO;
import com.login.system.Entity.EntityClass;
import com.login.system.PayloadResponse.LoginResponse;
import com.login.system.service.ServiceClass;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class LoginController {


    @Autowired
    private ServiceClass serviceClass;

    //save the entities into data
    @PostMapping("/save")
    public String saveData(@RequestBody EntityDTO entityDTO){
        String id= serviceClass.saveEntityData(entityDTO);
        return id;
    }

    //Fetch all entities from database
    @GetMapping("/all")
    Iterable<EntityClass> all(){
        return serviceClass.allEntities();
    }
    //By using this method user can login by email
    @PostMapping("/login")
    public ResponseEntity<?> loginCheck(@RequestBody LoginDTO loginDTO){
        LoginResponse loginMassage=serviceClass.loginResponse(loginDTO);
        return ResponseEntity.ok(loginMassage);
    }
    //By using this method user can login by email
    @PostMapping("/v2/login")
    public ResponseEntity<?> loginCheckV2(@RequestBody mobNoLoginDTO mobNoLoginDTO){
        LoginResponse loginMassage=serviceClass.loginResponseV2(mobNoLoginDTO);
        return ResponseEntity.ok(loginMassage);
    }
    //By using this method user can login via email or mobile number
    @PostMapping("/v3/login")
    public ResponseEntity<?> loginCheckV3(@RequestBody mobNoAndEmailDTO mobNoAndEmailDTO){
        LoginResponse loginMassage=serviceClass.loginResponseV3(mobNoAndEmailDTO);
        return ResponseEntity.ok(loginMassage);
    }

    @PutMapping("/{entityId}/updateName")
    public ResponseEntity<String> updateEntityName(@PathVariable Long entityId, @RequestParam String newName) {
        try {
            serviceClass.updateName(entityId, newName);
            return new ResponseEntity<>("Name updated successfully", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("Entity not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
