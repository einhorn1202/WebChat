package Validator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("PasswordValidator")
public class PasswordValidator implements Validator{

    private static final String PASSWORD__PATTERN = "^(?:(?=.*[a-z])(?:(?=.*[A-Z])(?=.*[\\d\\W])|(?=.*\\W)(?=.*\\d))|(?=.*\\W)(?=.*[A-Z])(?=.*\\d)).{8,}$";

    private Pattern pattern;
    private Matcher matcher;

    public PasswordValidator(){
          pattern = Pattern.compile(PASSWORD__PATTERN);
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
    	if(value.toString().compareTo("") != 0) {
        matcher = pattern.matcher(value.toString());
        if(!matcher.matches())
            throw new ValidatorException(new FacesMessage("Kein gültiges Passwort","Password invalidate"));
    	}else 
    		throw new ValidatorException(new FacesMessage("Kein Passwort eingegeben!"));
    }
}