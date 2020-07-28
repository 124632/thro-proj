package com.xworkz.cm.service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.cm.dao.RegistractionDAO;
import com.xworkz.cm.dto.RegisterDTO;
import com.xworkz.cm.entity.RegisterEntity;

@Service
public class RegisterServiceImpl<BCryptPasswordEncoder> implements RegisterService {

	@Autowired
	private RegistractionDAO dao;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
	private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
	private static final String CHARS = CHAR_LOWER + CHAR_UPPER;

	private static SecureRandom random = new SecureRandom();

	private static final Logger logger = Logger.getLogger(RegisterServiceImpl.class);

	public RegisterServiceImpl() {
		logger.info("created \t" + this.getClass().getSimpleName());
	}

	@Override
	public Map<String, Object> isValidate(RegisterDTO registerDTO) {
		logger.info("invoking \t isValidate");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isValid", true);
		if (registerDTO.getUserId() == null || registerDTO.getUserId().isEmpty()) {
			map.put("isValid", false);
			map.put("userId", "UserId should not be empty");
		} else {
			RegisterEntity entity = dao.getUserByUserId(registerDTO.getUserId());
			if (entity != null) {
				map.put("isValid", false);
				map.put("userId", "UserId is already there");
			}
		}
		if (registerDTO.getEmail() == null || registerDTO.getEmail().isEmpty()) {
			map.put("isValid", false);
			map.put("email", "Email should not be empty");
		} else {
			RegisterEntity entity = dao.getUserByEmail(registerDTO.getEmail());
			if (entity != null) {
				map.put("isValid", false);
				map.put("email", "Email is already there");

			}
		}

		if (registerDTO.getPhoneNo() == null) {
			map.put("isValid", false);
			map.put("phoneNo", "phone number should not be empty");
		} else if (registerDTO.getPhoneNo().toString().length() == 11) {
			map.put("phoneNo", "given number is not valid");
		}

		if (registerDTO.getIsAgree() == null) {
			map.put("isValid", false);
			map.put("isAgree", "isAgree should not be empty");
		} else {
			if (registerDTO.getIsAgree().equals("agree")) {

			} else {
				map.put("isValid", false);
				map.put("isAgree", "You should agree for registration");
			}
		}

		if (registerDTO.getCourseType() == null) {
			map.put("isValid", false);
			map.put("courseType", "course type should not be empty");
		}
		return map;
	}

	@Override
	public String genPassNSaveData(RegisterDTO registerDTO) {
		// TODO Auto-generated method stub
		return null;
	}


}
