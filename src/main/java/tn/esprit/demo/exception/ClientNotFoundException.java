package tn.esprit.demo.exception;

public class ClientNotFoundException extends RuntimeException {
	public ClientNotFoundException(String message){
		super(message);
		}
}
