package erkut.java.Beings;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import erkut.java.QuizData.QuizData;

public class Boss extends Being {
	private QuizData data;
	public Boss(String name, int damage, int health, int gold) {
		super(name, damage, health, gold);
		data = new QuizData();
	}

	public int askQuestion() {
		JSONObject question = data.getQuestion();

		System.err.println(this.getName() + ":");
		System.err.println();
		System.out.println("Looks like you kill all my creatures.");
		System.out.println("I will ask a question to you ");
		System.out.println("If you answer correctly you can go and take the treasure.");
		System.out.println("But if you can't answer correctly. You will be mine...");
		System.out.println();
		System.out.println("I " + name + ", My question is...");
		System.out.println(question.get("question"));
		JSONArray choices = (JSONArray) question.get("answers");
		for (int i = 0; i < choices.size(); i++) {
			System.out.println((i + 1) + "-) " + choices.get(i));
		}
		System.out.println();
		Long correctIndex = (Long) question.get("correctIndex");
		return correctIndex.intValue() + 1;
	}
}
