package userPageUI;

public class NoteBookUI {
	public static final String SORT_BY_PULLDOWN = "//select[@id='products-orderby']";
	public static final String DISPLAY_PAGE_PULLDOWN = "//select[@id='products-pagesize']";
	public static final String PRODUCT_TITLE = "//h2[@class='product-title']";
	// public static final String PRODUCT_PRICE = "//span[@class='price actual-price']";
	public static final String PRODUCT_PRICE = "//div[@class ='item-box']//span[@class='price actual-price']";

	public static final String NEXT_ICON = "//li[@class='next-page']";
	public static final String PREVIOUS_ICON = "//li[@class='previous-page']";
	public static final String PAGE = "//a[contains(text(),'%s')]";
	public static final String PAGE_2 = "//a[contains(text(),'2')]";
	public static final String PRODUCT_LINK = "//div[@class='details']//a[text()='%s']";
	public static final String PAGGING = "//div[@class='pager']";
	public static final String WISHLIST_BUTTON = "//a[text()='Asus N551JK-XO076H Laptop']//parent::h2//parent::div//following-sibling::div[@class='add-info']//div[@class='buttons']//button[text()='Add to wishlist']";
	public static final String WISHLIST_ICON = "//a[@class='ico-wishlist']";
	public static final String COMPARE_BUTTON = "//button[text()='Add to compare list']";
	public static final String ADD_TO_COMPARE_SUCCESS_MESSAGE = "//p[@class='content']";
	public static final String PRODUCT_COMPARE_LINK = "//p[@class='content']//a";
	public static final String PRODUCT_TITLE_LINK = "//div[@class='product-item']//h2//a";
	public static final String RECENT_VIEW_PRODUCT = "//a[text()='Recently viewed products']";

}
