package techpandaUI;

public class ShoppingCartTechPandaUI {
	public static final String COUPON_CODE = "//input[@id='coupon_code']";
	public static final String APPLY_BUTTON = "//button[@value='Apply']";
	public static final String ADD_CART_SUCCESS_MESSAGE = "//li[@class='success-msg']//span";
	public static final String DISCOUNT = "//td[contains(string(),'Discount (Guru50)')]//following-sibling::td//span";
	public static final String GRAND_TOTAL = "//strong[text()='Grand Total']//parent::td//following-sibling::td//span";
	public static final String QTY = "//input[@title='Qty']";
	public static final String UPDATE_BUTTON = "//button[@title='Update']";
	public static final String ERROR_QTY_MSG = "//li[@class='error-msg']//span";
	public static final String ERROR_MAXLENGTH_MSG = "//p[@class='item-msg error']";
	public static final String COUNTRY = "//select[@id='country']";
	public static final String ZIP_CODE = "//input[@id='postcode']";
	public static final String ESTIMATE_BUTTON = "//button[@title='Estimate']";

}
