package model;

public class TokenResponse {
	
private String acces_token;  // propiedad que corresponde al toke en forma de json que nos va a devorver el keycloak.

public TokenResponse(String acces_token) {
	super();
	this.acces_token = acces_token;
}

public String getAcces_token() {
	return acces_token;
}

public void setAcces_token(String acces_token) {
	this.acces_token = acces_token;
}

public TokenResponse() {
	super();
}

	
}
