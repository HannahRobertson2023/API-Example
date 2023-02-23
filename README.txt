1. Create a survey item
	Put Mapping
	http://localhost:8080/SurveyItems
	(for when you want default 4 muliple choice answers)
	http://localhost:8080/SurveyItems/{questionNum}
	(for when you want to specify the number of answers)

2. Create a survey
	Post Mapping
	http://localhost:8080/Surveys

3. Add a survey item to a survey (note that a survey item may be on more than one survey).
	Patch Mapping 
	http://localhost:8080/Surveys/{SurveyID}/{SurveyItemID}

4. Get the set of all surveys
	Get Mapping
	http://localhost:8080/Surveys

5. Get a specific survey and the set of all survey items in that survey
	Get Mapping 
	http://localhost:8080/Surveys/{SurveyID}

6. Create a survey instance of a survey for a user
	Post mapping
	http://localhost:8080/Surveys/Instances/create/{SurveyID}

7. Accept an answer for a survey item on a specific survey instance
	PatchMapping
	http://localhost:8080/Surveys/Instances/{InstancedID}/{SurveyItemID}/{answer}

8. Retrieve the set of all survey Instances in a given state; if no state is given return all survey Instances
	GetMapping
	http://localhost:8080/Surveys/Instances/{State}
	OR
	http://localhost:8080/Surveys/Instances/

9. Retrieve a specific survey instance with all of the survey items
	http://localhost:8080/Surveys//Instances/retreive/{InstanceID}

10. Delete a specific survey
	Delete Mapping
	http://localhost:8080/Surveys/{SurveyID}

Please note that this is heavily based on the booktown AI, and I give credit to Dr. Gary for a great deal of the structure of the project. 