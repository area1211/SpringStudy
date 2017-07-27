package util;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import logic.User;

public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(arg0);//검증대상 클래스가 User클래스임을 명시
	}

	@Override
	public void validate(Object command, Errors errors) {
		// TODO Auto-generated method stub
		User user = (User)command;
		if(!StringUtils.hasLength(user.getUserId())) { // 아이디 입력하지 않고 로그인했을 때 체크해주는 것.
			errors.rejectValue("userId", "error.required");
			
		}
		if(!StringUtils.hasLength(user.getPassword())) { // 비밀번호 입력하지 않고 로그인 했을 때 체크해주는 것.
			errors.rejectValue("password", "error.required");
		}
		if(errors.hasErrors()) {
			errors.reject("error.input.user");
		}
	}

}
