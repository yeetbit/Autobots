package dev.obit.tools.autobots.enums;

public enum NetStatus {
	
	MALFORMED_URL, TIMEOUT, CONNECTION_ERROR,
	INFORMATIONAL_RESPONSE,
	SUCCESS, OK, CREATED, ACCEPTED, NO_CONTENT,
	REDIRECT,
	CLIENT_ERROR, BAD_REQUEST, UNAUTHORIZED, FORBIDDEN, NOT_FOUND, METHOD_NOT_ALLOWED, TOO_MANY_REQUESTS, 
	SERVER_ERROR, INTERNAL_SERVER_ERROR, BAD_GATEWAY, SERVICE_UNAVAILABLE, GATEWAY_TIMEOUT, UNKNOWN_ERROR;
	
	public static NetStatus getHttpStatus(int statusCode) {
		if((statusCode >0) && (statusCode<200)) {
			return NetStatus.INFORMATIONAL_RESPONSE;
		}else if((statusCode >=200) && (statusCode<300)) {
			switch(statusCode) {
				case 200 : return NetStatus.OK;
				case 201 : return NetStatus.CREATED;
				case 202 : return NetStatus.ACCEPTED;
				case 204 : return NetStatus.NO_CONTENT;
				default : return NetStatus.SUCCESS;
			}
		}else if((statusCode >=300) && (statusCode<400)) {
			return NetStatus.REDIRECT;
		}else if((statusCode >=400) && (statusCode<500)) {
			switch(statusCode) {
				case 400 : return NetStatus.BAD_REQUEST;
				case 401 : return NetStatus.UNAUTHORIZED;
				case 403 : return NetStatus.FORBIDDEN;
				case 404 : return NetStatus.NOT_FOUND;
				case 405 : return NetStatus.METHOD_NOT_ALLOWED;
				case 429 : return NetStatus.TOO_MANY_REQUESTS;
				default : return NetStatus.CLIENT_ERROR;
			}
		}else if((statusCode >=500) && (statusCode<600)) {
			switch(statusCode) {
				case 500 : return NetStatus.INTERNAL_SERVER_ERROR;
				case 502 : return NetStatus.BAD_GATEWAY;
				case 503 : return NetStatus.SERVICE_UNAVAILABLE;
				case 504 : return NetStatus.GATEWAY_TIMEOUT;
				default : return NetStatus.SERVER_ERROR;
			}
		}else {
			return NetStatus.UNKNOWN_ERROR;
		}
		
	}

}
