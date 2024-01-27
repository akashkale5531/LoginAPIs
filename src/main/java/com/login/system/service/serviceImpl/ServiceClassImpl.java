package com.login.system.service.serviceImpl;

import ch.qos.logback.core.joran.conditional.ElseAction;
import ch.qos.logback.core.net.SyslogOutputStream;
import com.login.system.DTO.EntityDTO;
import com.login.system.DTO.LoginDTO;
import com.login.system.DTO.mobNoAndEmailDTO;
import com.login.system.DTO.mobNoLoginDTO;
import com.login.system.Entity.EntityClass;
import com.login.system.PayloadResponse.LoginResponse;
import com.login.system.Repository.RepositoryInterface;
import com.login.system.service.ServiceClass;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ServiceClassImpl implements ServiceClass {

    private final RepositoryInterface repository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ServiceClassImpl(RepositoryInterface repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    //This method used to save data into database
    @Override
    public String saveEntityData(EntityDTO entityDTO) {
        // Convert DTO to Entity and save to the repository
        EntityClass entity = new EntityClass();
        entity.setName(entityDTO.getName());
        entity.setEmail(entityDTO.getEmail());
        entity.setMobNo(entityDTO.getMobNo());
        // Assuming you need to encode the password before saving
        entity.setPwd(passwordEncoder.encode(entityDTO.getPwd()));
        repository.save(entity);
        return "Data saved successfully";
    }

    //Fetch all the entries present into database
    @Override
    public Iterable<EntityClass> allEntities() {
        return repository.findAll();
    }

    //Check user email is present or not and password match with email or not
    EntityDTO entityDTO;
    @Override
    public LoginResponse loginResponse(LoginDTO loginDTO) {
        String message = "";
        EntityClass entityClass = repository.findByEmail(loginDTO.getEmail());
        if (entityClass != null) {
            String password = loginDTO.getPwd();
            String encodedPassword = entityClass.getPwd();
            Boolean pwdIsRight = passwordEncoder.matches(password, encodedPassword);
            if (pwdIsRight) {
                Optional<EntityClass> entityClassOptional = repository.findOneByEmailAndPwd(loginDTO.getEmail(), encodedPassword);
                if (entityClassOptional.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Failed", false);
                }
            } else {
                return new LoginResponse("Password not matched", false);
            }
        } else {
            return new LoginResponse("Email Not Exist", false);
        }
    }


    //By using this method user can login by mobile number
    @Override
    public LoginResponse loginResponseV2(mobNoLoginDTO mobNoLoginDTO) {
        String msg = "";
        EntityClass entityClass = repository.findByMobNo(mobNoLoginDTO.getMobNo());
        if (entityClass != null) {
            String password = mobNoLoginDTO.getPwd();
            String encodedPwd = entityClass.getPwd();
            Boolean checkPwd = passwordEncoder.matches(password, encodedPwd);
            if (checkPwd) {
                Optional<EntityClass> optionalEntityClass = repository.findOneByMobNoAndPwd(mobNoLoginDTO.getMobNo(), encodedPwd);
                if (optionalEntityClass.isPresent()) {
                    return new LoginResponse("Login with mobile no is success", true);
                } else {
                    return new LoginResponse("Failed Login by mobile", false);
                }
            } else {
                return new LoginResponse("password not matched with mobNo", false);
            }
        } else {
            return new LoginResponse("Mobile number is not exist", false);
        }
    }

    //Trying to implement login by mobile number or email is single code
    public LoginResponse loginResponseV3(mobNoAndEmailDTO mobNoAndEmailDTO1) {
        String msg = "";
        EntityClass entityClass = repository.findByMobNoOrEmail(mobNoAndEmailDTO1.getMobNo(), mobNoAndEmailDTO1.getEmail());
        if (entityClass != null) {
            String password = mobNoAndEmailDTO1.getPwd();
            String encodedPwd = entityClass.getPwd();
            Boolean checkPwd = passwordEncoder.matches(password, encodedPwd);
            if (checkPwd) {
                Optional<EntityClass> optionalEntityClass = repository.findOneByMobNoAndPwd(mobNoAndEmailDTO1.getMobNo(), encodedPwd);
                if (optionalEntityClass.isPresent()) {
                    return new LoginResponse("Login with mobile no is success", true);
                } else {
                    return new LoginResponse("Failed Login by mobile", false);
                }
            } else {
                return new LoginResponse("password not matched with mobNo", false);
            }
        } else {
            return new LoginResponse("Mobile number is not exist", false);
        }
    }
    @Transactional
    @Override
    public void updateName(Long entityId, String newName) {
            // Retrieve the entity from the database
            EntityClass entity = repository.findById(entityId).orElse(null);
            // Check if the entity exists
            if (entity != null) {
                // Update the name
                entity.setName(newName);
                // Save the updated entity back to the database
                repository.save(entity);
            } else {
                // Handle the case where the entity with the given ID is not found
                throw new EntityNotFoundException("Entity with ID " + entityId + " not found");
            }
    }


}
