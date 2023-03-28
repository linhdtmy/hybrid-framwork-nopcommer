package adminNopcommerPageUI;

public class DashboardUI {

	public static final String DASHBOARD_HEADER = "//h1[contains(text(),'Dashboard')]";
	public static final String CATALOG_LEFT_MENU = "//p[contains(text(),'Catalog') and not(contains(text(),'setting'))]";
	public static final String PRODUCT_LEFT_MENU = "//p[text()=' Products']";
	public static final String PRODUCT_SEARCH_INPUT = "//input[@id='SearchProductName']";
	public static final String SEARCH_BUTTON = "//button[@id='search-products']";
	public static final String ONE_RECORD = "//div[text()='1-1 of 1 items']";
	public static final String PRODUCT_NAME = "//td[text()='%s']";
	public static final String CATEGORY_SEARCH_SELECTBOX = "//select[@name='SearchCategoryId']";
	public static final String SUB_CATEGORY_SEARCH_CHECKBOX = "//input[@name='SearchIncludeSubCategories' and @value='true']";
	public static final String NO_DATA_MESSAGE = "//td[text()='No data available in table']";
	public static final String MANUFACTURE_SELECTBOX = "//select[@name='SearchManufacturerId']";
	public static final String SKU_INPUT = "//input[@name='GoDirectlyToSku']";
	public static final String GO_BUTTON = "//button[@name='go-to-product-by-sku']";
	public static final String PRODUCT_NAME_DETAIL = "//input[@value='Lenovo IdeaCentre 600 All-in-One PC']";
	public static final String CUSTOMER_LEFT_MENU = "//i[@class='nav-icon far fa-user']//following-sibling::p[contains(text(),'Customers')]";
	public static final String SUB_CUSTOMER_LEFT_MENU = "//p[contains(text(),' Customers') and not(contains(text(),'order'))]";
	public static final String DELETE_ADDRESS_BUTTON = "//a[text()='Delete']";

}
