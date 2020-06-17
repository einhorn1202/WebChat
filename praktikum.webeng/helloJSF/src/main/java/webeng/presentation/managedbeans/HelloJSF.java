package webeng.presentation.managedbeans;


import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named() // optional: @Named(value="<SOMENAME>")
@SessionScoped
public class HelloJSF implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HelloJSF() {
	      System.out.println("Hello JSF started!");   
	   }
	private String message = "Hello JSF!";
	
	public String update()
	{
		System.out.println("HelloJSF: update called");
		message = "Hello JSF! " + new Date().toString();

		return null;
	}
	public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
        
    }
}