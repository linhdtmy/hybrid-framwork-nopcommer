package userPageUI;

public class NoteBookUI {
	public static final String SORT_BY_PULLDOWN = "//select[@id='products-orderby']";
	public static final String DISPLAY_PAGE_PULLDOWN = "//select[@id='products-pagesize']";
	public static final String PRODUCT_TITLE = "//h2[@class='product-title']";
	//public static final String PRODUCT_PRICE = "//span[@class='price actual-price']";
	public static final String PRODUCT_PRICE = "//div[@class ='item-box']//span[@class='price actual-price']";

	
	public static final String NEXT_ICON = "//li[@class='next-page']";
	public static final String PREVIOUS_ICON = "//li[@class='previous-page']";
	public static final String PAGE =	"//a[contains(text(),'%s')]";
	public static final String PAGE_2="//a[contains(text(),'2')]";
}
