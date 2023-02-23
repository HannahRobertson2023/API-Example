package lab_5.act2.model.exceptions;

@SuppressWarnings("serial")
public class SurveyItemInternalException extends RuntimeException {

	public SurveyItemInternalException() {
		this("There was an internal server error in the Survey Service");
	}

	public SurveyItemInternalException(String message) {
		super(message);
	}

	public SurveyItemInternalException(Throwable cause) {
		super(cause);
	}

	public SurveyItemInternalException(String message, Throwable cause) {
		super(message, cause);
	}

	public SurveyItemInternalException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
