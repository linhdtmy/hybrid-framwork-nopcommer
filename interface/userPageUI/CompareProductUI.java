package userPageUI;

public class CompareProductUI {
	public static final String REMOVE_BUTTON = "//button[text()='Remove']";
	// public static final String NAME_PRODUCT = "//tr[@class='product-name']//td//a['%s']";
	public static final String NAME_PRODUCT = "//tr[@class='product-name']//td//a[contains(text(),'%s')]";
	public static final String INDEX_BY_ROW = "//a[text()='%s']//parent::td//preceding-sibling::td";
	public static final String PRICE = "//tr[@class='product-price']//td[%s]";
	public static final String CLEAR_BUTTON = "//a[@class='clear-list']";
	public static final String MESSAGE_COMPARE_LIST_NO_DATA = "//div[@class='no-data']";
	public static final String TABLE_COMPARE_PRODUCT = "//table[@class='compare-products-table']";

}
