import com.nopcommerce.data.DataMapper;
import com.nopcommerce.data.UserDataMapper;
import com.nopcommerce.data.User_Data;

public class Data_Test {

	public static void main(String[] args) {
		String firstname= User_Data.Register.FIRST_NAME;
		System.out.println(firstname);
		
		
		UserDataMapper userMapper= new UserDataMapper();
		userMapper= UserDataMapper.getUserData();
		String lastName= userMapper.getLastName();
		System.out.println(lastName);
		
		
		DataMapper dataMapper= new DataMapper();
		dataMapper= DataMapper.getUserData();
		System.out.println(dataMapper.getAddress());
		System.out.println(dataMapper.getUsename()+ dataMapper.getPassword());
	}

}
