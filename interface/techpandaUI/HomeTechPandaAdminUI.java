package techpandaUI;

public class HomeTechPandaAdminUI {
	public static final String POPUP = "//div[@id='message-popup-window']";
	public static final String CLOSE_ICON = "//span[text()='close']";
	public static final String EMAIL_SEARCH_INPUT = "//input[@id='customerGrid_filter_email']";
	public static final String SEARCH_BUTTON = "//span[text()='Search']//parent::span//parent::span//parent::button";
	public static final String HEADER_TITLE = "//span[text()='%s']/parent::a/parent::span/parent::th/preceding-sibling::th";
	public static final String ROW_BY_INDEX = "//table[@id='customerGrid_table']//tbody//tr//td[%s]";
	public static final String CHECKBOX = "//input[@name='customer']";
	public static final String ACTION_SELECTBOX = "//label[text()='Actions']/following-sibling::select";
	public static final String SUBMIT_BUTTON = "//span[text()='Submit']/parent::span/parent::span/parent::button";
	public static final String NO_RECORD_MESSAGE ="//td[text()='No records found.']";
}
