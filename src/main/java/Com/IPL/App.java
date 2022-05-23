package Com.IPL;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class App {
	public static void main(String[] args) throws ParseException, IOException {

		JSONParser parser = new JSONParser();

		Object obj = parser.parse(new FileReader("./src/main/java/Com/IPL/TeamRCB.json"));

		JSONObject jsonObject = (JSONObject) obj;

		String name = (String) jsonObject.get("name");
		String course = (String) jsonObject.get("location");

		JSONArray player = (JSONArray) jsonObject.get("player");

		System.out.println("Name: " + name);
		System.out.println("Course: " + course);
		System.out.println("Player:");

		List<String> roles = new ArrayList<String>();
		List<String> Countries = new ArrayList<String>();

		for (int i = 0; i < player.size(); i++)

		{
			JSONObject innerobj = (JSONObject) player.get(i);

			String r = (String) innerobj.get("role");
			roles.add(r);

			String c = (String) innerobj.get("country");
			Countries.add(c);
		}

		if (roles.contains("Wicket-keeper")) {
			System.out.println(name + " - has at least one Wicket Keeper");
		} else {
			System.out.println(name + " - Doesnot have one Wicket Keeper");
		}

		int counter = 0;
		for (String a : Countries) {
			if (!a.contains("India")) {
				counter++;
			}
		}
		if (counter == 4) {
			System.out.println("Team has only 4 forgain players");
		} else {
			System.out.println("Team dont have 4 forgain players");
		}

	}

}
