package util;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import bean.DepositionInfo;

public class DepositionValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return DepositionInfo.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		DepositionInfo depositionInfo = (DepositionInfo)target;
		if(!StringUtils.hasLength(depositionInfo.getId())) { // 아이디 입력하지 않고 로그인했을 때 체크해주는 것.
			errors.rejectValue("id", "error.required");
			
		}
		if(!StringUtils.hasLength(depositionInfo.getMoney())) { // 입금액이 0원보다 작거나 같은 경우 체크
			errors.rejectValue("money", "error.required");
		}
		if(errors.hasErrors()) {
			errors.reject("error.input.depositionInfo");
		}
	}

}
