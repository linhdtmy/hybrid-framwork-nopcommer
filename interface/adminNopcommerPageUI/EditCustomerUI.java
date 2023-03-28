package adminNopcommerPageUI;

public class EditCustomerUI {

	public static final String EDIT_SUCCESS_MESSAGE = "//div[@class='alert alert-success alert-dismissable']";
	public static final String BACK_BUTTON = "//a[text()='back to customer list']";
	public static final String TEXTBOX_INPUT = "//input[@name='%s']";
	public static final String ADMIN_COMMENT = "//textarea[@name='AdminComment']";
	public static final String SAVE_BUTTON = "//button[@name='save']";
	public static final String ADDRESS_BUTTON = "//div[text()='Addresses']";
	public static final String ADD_NEW_ADDRESS_BUTTON = "//button[contains(string(),'Add new address')]";
	public static final String INFORM_ADDRESS = "//td[text()='%s']//parent::tr//td[%s]";
	public static final String COLUMN_INDEX = "//th[text()='%s']//preceding-sibling::th";
	public static final String EDIT_ADDRESS_BUTTON = "//a[contains(text(),'Edit')]";
	public static final String ADDRESS_COLUMN_INFORM = "//td//div[contains(string(),'%s') and contains(string(),'%s')and contains(string(),'%s')and contains(string(),'%s')and contains(string(),'%s')and contains(string(),'%s')]";

}
