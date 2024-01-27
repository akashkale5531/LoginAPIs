package com.login.system.service;

import com.login.system.DTO.EntityDTO;
import com.login.system.DTO.LoginDTO;
import com.login.system.DTO.mobNoAndEmailDTO;
import com.login.system.DTO.mobNoLoginDTO;
import com.login.system.Entity.EntityClass;
import com.login.system.PayloadResponse.LoginResponse;


public interface ServiceClass  {

    String saveEntityData(EntityDTO entityDTO);

    Iterable<EntityClass> allEntities();

    LoginResponse loginResponse(LoginDTO loginDTO);

    LoginResponse loginResponseV2(mobNoLoginDTO mobNoLoginDTO);

    LoginResponse loginResponseV3(mobNoAndEmailDTO mobNoAndEmailDTO);

    void updateName(Long entityId, String newName);
}
