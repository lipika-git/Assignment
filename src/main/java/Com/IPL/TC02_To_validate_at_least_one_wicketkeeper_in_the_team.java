package Com.IPL;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TC02_To_validate_at_least_one_wicketkeeper_in_the_team {
	public static void main(String[] args) throws ParseException, IOException {
		
		JSONParser parser = new JSONParser();

		Object obj = parser.parse(new FileReader("./src/main/java/Com/IPL/TeamRCB.json"));

		JSONObject jsonObject = (JSONObject) obj;

		String name = (String) jsonObject.get("name");
		String course = (String) jsonObject.get("location");

		JSONArray player = (JSONArray) jsonObject.get("player");

		List<String> roles = new ArrayList<String>();
		
		//capturing all contries and roles of cricketers
		for (int i = 0; i < player.size(); i++)

		{
			JSONObject innerobj = (JSONObject) player.get(i);

			String r = (String) innerobj.get("role");
			roles.add(r);

		
		}

		if (roles.contains("Wicket-keeper")) {
			System.out.println(name + " - has at least one Wicket Keeper");
		} else {
			System.out.println(name + " - Doesnot have one Wicket Keeper");
		}

		

	}

}
