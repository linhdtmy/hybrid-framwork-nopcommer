package adminNopcommerPageUI;

public class ListCustomerUI {

	public static final String OPTION_CUSTOMER_ROLE_SELECTBOX = "//li[text()='%s']";
	public static final String CLEAR_ICON_CUSTOMER_ROLE = "//span[@title='clear' and @class='k-icon k-clear-value k-i-close']";
	public static final String DELETE_ICON_CUSTOMER_ROLE = "//span[@title='delete']";
	public static final String CUSTOMER_ROLE_SELECTBOX = "//div[@class='k-multiselect-wrap k-floatwrap']";
	public static final String SEARCH_BUTTON = "//button[@id='search-customers']";
	public static final String CELL = "//tr[%s]//td[%s]";
	public static final String PRECEDING_COLUMN_TABLE = "//th[text()='%s']//preceding-sibling::th";
	public static final String PRECEDING_ROW_TABLE = "//td[text()='%s']//parent::tr//preceding-sibling::tr";
	public static final String TEXT_CELL_LIST = "//td[text()='%s']";
	public static final String TEXT_INPUT = "//input[@name='%s']";
	public static final String EDIT_BUTTON = "//a[text()='Edit']";
	public static final String SUCCESS_MSG = "//div[contains(string(),'%s') and @class='alert alert-success alert-dismissable']";

}
