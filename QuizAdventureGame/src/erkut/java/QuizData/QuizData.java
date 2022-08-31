package erkut.java.QuizData;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class QuizData {
	
	private JSONObject jsonObj;

	public QuizData() {

		Object rawObj = null;
		try {
			rawObj = JSONValue.parse(new FileReader("data.json"));
		} catch (FileNotFoundException e) {
		}
		jsonObj = (JSONObject) rawObj;
	}

	public JSONObject getQuestion() {
		JSONArray questionArray = (JSONArray) jsonObj.get("questions");
		int randomIndex = (int) (Math.random() * questionArray.size());
		JSONObject questionJson = (JSONObject) questionArray.get(randomIndex);
		return questionJson;
	}

//	public static void main(String[] args) throws FileNotFoundException {
//		QuizData q = new QuizData();
//
//		System.out.println(q.getQuestion());
//	}

}
