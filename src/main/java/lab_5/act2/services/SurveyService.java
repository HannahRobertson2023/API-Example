package lab_5.act2.services;

import java.util.List;

import lab_5.act2.model.Survey;
import lab_5.act2.model.SurveyInstance;
import lab_5.act2.model.SurveyItem;
import lab_5.act2.model.exceptions.SurveyItemEntityNotFoundException;
import lab_5.act2.services.impl.SurveyServicesImpl;

public interface SurveyService {
	public static final int CREATE_Survey_ERROR = -1;
	
	public static SurveyService getInstance() {
		return new SurveyServicesImpl();
	}
	
	public List<Survey> getSurveys();
	public Survey createSurvey();
	public Survey getSurvey(int id) throws SurveyItemEntityNotFoundException;
	public Survey modifySurvey(int id, String sid) throws SurveyItemEntityNotFoundException;
	public Survey deleteSurvey(int id) throws SurveyItemEntityNotFoundException;
	
	public SurveyItem createSurveyItem(int questions);
	public List<SurveyItem> getSurveyItems();
	public SurveyItem getSurveyItem(String id) throws SurveyItemEntityNotFoundException;
	
	public SurveyInstance createSurveyInstance(int sid);
	public SurveyInstance answerSurveyItem(String implid, String sid, int ans);
	public SurveyInstance getSurveyInstance(String id);
	public List<SurveyInstance> getSurveyInstances();
	public List<SurveyInstance> getSurveyInstances(String state);
}
