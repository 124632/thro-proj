package com.xworkz.cm.dao;

import java.io.Serializable;

import com.xworkz.cm.entity.RegisterEntity;

public interface RegistractionDAO {

	RegisterEntity getUserByUserId(String userId);

	RegisterEntity getUserByEmail(String email);

	Serializable saveRegister(RegisterEntity registerEntity);

}