package techpandaUI;

public class ShoppingCartTechPandaUI {
	public static final String COUPON_CODE = "//input[@id='coupon_code']";
	public static final String APPLY_BUTTON = "//button[@value='Apply']";
	public static final String ADD_CART_SUCCESS_MESSAGE = "//li[@class='success-msg']//span";
	public static final String DISCOUNT = "//td[contains(string(),'Discount (Guru50)')]//following-sibling::td//span";
	public static final String GRAND_TOTAL = "//strong[text()='Grand Total']//parent::td//following-sibling::td//span";

}
