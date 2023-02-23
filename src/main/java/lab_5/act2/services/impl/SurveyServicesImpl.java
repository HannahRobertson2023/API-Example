package lab_5.act2.services.impl;

import java.util.ArrayList;
import java.util.List;

import lab_5.act2.model.Survey;
import lab_5.act2.model.SurveyInstance;
import lab_5.act2.model.SurveyItem;
import lab_5.act2.model.exceptions.SurveyItemInternalException;
import lab_5.act2.model.exceptions.SurveyItemEntityNotFoundException;
import lab_5.act2.services.SurveyService;

public class SurveyServicesImpl implements SurveyService {
	private static ArrayList<Survey> Surveys = new ArrayList<Survey>();
	private static ArrayList<SurveyItem> SurveyItems = new ArrayList<SurveyItem>();
	private static ArrayList<SurveyInstance> SurveyInstances = new ArrayList<SurveyInstance>();
	private int idNum;
	private int sidNum;
	private int instId;

	public SurveyServicesImpl() {
		idNum = 1;
		sidNum = 0;
		instId = 0;
	}
	
	public Survey createSurvey() {
		List<SurveyItem> survey1 = new ArrayList<SurveyItem>();
		Survey newS = new Survey(idNum, survey1);

		Surveys.add(newS);
		idNum++;
		return newS;
	}

	@Override
	public List<Survey> getSurveys() {
		return Surveys;
	}

	@Override
	public Survey getSurvey(int id) throws SurveyItemEntityNotFoundException {
		for (Survey a : Surveys) {
			System.out.println(a.getSurveyID() + " " + id);
			if (a.getSurveyID() == (id)) {
				return a;
			}
		}
		throw new SurveyItemEntityNotFoundException();
	}

	@Override
	public Survey modifySurvey(int id, String sid) throws SurveyItemEntityNotFoundException {
		try {
			for (int i = 0; i < Surveys.size(); i++) {
				if (Surveys.get(i).getSurveyID()==(id)) {
					Surveys.get(i).addSurveyItem(this.getSurveyItem(sid));
					return Surveys.get(i);
				}
			}
			throw new SurveyItemEntityNotFoundException();
		} catch (Throwable t) {
			throw new SurveyItemInternalException();
		}
	}

	@Override
	public Survey deleteSurvey(int id) throws SurveyItemEntityNotFoundException {
		//try {
			for (int i = 0; i < Surveys.size(); i++) {
				if (Surveys.get(i).getSurveyID()==(id)) {
					Surveys.get(i).setState("Deleted");
					return Surveys.get(i);
				}
			}
			throw new SurveyItemEntityNotFoundException();
		//} catch (Throwable t) {
		//	throw new SurveyItemInternalException();
		//}
	}

	public List<SurveyItem> getSurveyItems() {
		return SurveyItems;
	}

	public SurveyItem getSurveyItem(String id) throws SurveyItemEntityNotFoundException {
		idNum = Integer.parseInt(id.replace("SI", ""));
		if (idNum < SurveyItems.size()) {
			return SurveyItems.get(idNum);
		}
		throw new SurveyItemEntityNotFoundException("No SurveyItem found with ID " + id);
	}
	
	public SurveyItem createSurveyItem(int questions) {
		SurveyItem newSI = new SurveyItem(questions, "SI" + sidNum);
		SurveyItems.add(newSI);

		sidNum++;
		return newSI;
	}
	
	
	public List<SurveyInstance> getSurveyInstances() {
		return SurveyInstances;
	}
	
	public List<SurveyInstance> getSurveyInstances(String state) {
		List<SurveyInstance> temp = new ArrayList<SurveyInstance>();
		for (SurveyInstance a : SurveyInstances) {
			if (a.getState().equals(state)) {
				temp.add(a);
			}
		}
		return temp;
	}
	
	public SurveyInstance getSurveyInstance(String id) {
		for (SurveyInstance a : SurveyInstances) {
			if (a.getId().equals(id)) {
				return a;
			}
		}
		throw new SurveyItemEntityNotFoundException();
	}
	
	public SurveyInstance createSurveyInstance(int sid) {
		Survey surv = getSurvey(sid);
		SurveyInstance newsim = new SurveyInstance(surv, "S" + surv.getSurveyID() + "IMP" + instId);
		instId++;

		SurveyInstances.add(newsim);
		return newsim;
	}
	
	public SurveyInstance answerSurveyItem(String instid, String sid, int ans) {
		SurveyItem si = getSurveyItem(sid);
		SurveyInstance inst = getSurveyInstance(instid);
		inst.inputAnswer(si,  ans);
		return inst;
	}
}
