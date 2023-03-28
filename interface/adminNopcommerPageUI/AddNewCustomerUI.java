package adminNopcommerPageUI;

public class AddNewCustomerUI {
	public static final String ADD_NEW_BUTTON = "//h1[contains(text(),'Customers')]//following-sibling::div//a";
	public static final String TEXTBOX_INPUT = "//input[@name='%s']";
	public static final String NEW_LETTER_SELECTBOX = "//select[@name='SelectedNewsletterSubscriptionStoreIds']";
	public static final String FEMALE_GENDER_RADIO = "//input[@id='Gender_Female']";
	public static final String ADMIN_COMMENT = "//textarea[@name='AdminComment']";
	public static final String SAVE_CONTINUE_BUTTON = "//button[@name='save-continue']";
	public static final String EDIT_SUCCESS_MESSAGE = "//div[@class='alert alert-success alert-dismissable']";
	public static final String CHILDREN_NEW_LETTER_SELECTBOX = "//ul[@id='SelectedNewsletterSubscriptionStoreIds_listbox']//li";
	public static final String PARENT_NEW_LETTER_SELECTBOX = "//ul[@id='SelectedNewsletterSubscriptionStoreIds_listbox']";
	public static final String OPTION_CUSTOMER_ROLE_SELECTBOX = "//li[text()='%s']";
	public static final String DELETE_ICON_CUSTOMER_ROLE = "//span[@title='delete']";
	public static final String CUSTOMER_ROLE_SELECTBOX = "//div[@class='k-multiselect-wrap k-floatwrap']";
	public static final String PARENT_CUSTOMER_ROLE_SELECTBOX = "//ul[@id='SelectedNewsletterSubscriptionStoreIds_taglist']//following-sibling::input";
	public static final String CHILDREN_CUSTOMER_ROLE_SELECTBOX = "//ul[@id='SelectedCustomerRoleIds_listbox']//li";
}
