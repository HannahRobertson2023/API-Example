package lab_5.act2.model.exceptions;

@SuppressWarnings("serial")
public class SurveyItemEntityNotFoundException extends RuntimeException {

	public SurveyItemEntityNotFoundException() {
		this("Survey Not Found");
	}

	public SurveyItemEntityNotFoundException(String message) {
		super(message);
	}

	public SurveyItemEntityNotFoundException(Throwable cause) {
		super(cause);
	}

	public SurveyItemEntityNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public SurveyItemEntityNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
