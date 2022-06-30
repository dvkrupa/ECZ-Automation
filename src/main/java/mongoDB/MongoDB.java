package mongoDB;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoDB {
	public static void main(String[] args) {
		try {
			MongoClient client = new MongoClient("localhost",27017);
			DB db = client.getDB("test");
			System.out.println("Connected to Database");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println(e);
		}
       System.out.println("Server is ready..");

	}

}
