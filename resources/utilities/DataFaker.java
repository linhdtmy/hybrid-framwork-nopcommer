package utilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class DataFaker {
	private Locale local = new Locale("vi");
	private Faker faker= new Faker(local);
	public static DataFaker getDataFaker() {
		return new DataFaker();
	}
	public String getFirstName() {
		return faker.address().firstName();
	}
	public String getLastName() {
		return faker.address().lastName();
	}
	public String getAddressName() {
		return faker.address().fullAddress();
	}

}
