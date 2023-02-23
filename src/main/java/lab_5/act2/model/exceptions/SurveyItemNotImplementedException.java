package lab_5.act2.model.exceptions;

@SuppressWarnings("serial")
public class SurveyItemNotImplementedException extends RuntimeException {

	public SurveyItemNotImplementedException() {
		this("Service not yet implemented");
	}

	public SurveyItemNotImplementedException(String message) {
		super(message);
	}

	public SurveyItemNotImplementedException(Throwable cause) {
		super(cause);
	}

	public SurveyItemNotImplementedException(String message, Throwable cause) {
		super(message, cause);
	}

	public SurveyItemNotImplementedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
