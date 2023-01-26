package wordpressAdminUI;

public class ListPostAdminUI {
	public static final String ADD_NEW_BUTTON = "//div[@id='wpbody-content']//a[contains(text(),'Add New')]";
	public static final String SEARCH_TEXTBOX = "//input[@id='post-search-input']";
	public static final String SEARCH_BUTTON = "//input[@id='search-submit']";
	public static final String HEADER_TABLE = "//th[@id='%s']//preceding-sibling::th";
	public static final String CELL_TABLE = "//tbody[@id='the-list']//tr[%s]//td[%s]";
	public static final String POST_CONTENT_BY_TITLE= "//a[text()='%s']//parent::strong//parent::td//following-sibling::td[contains(@class,'author')]";
	public static final String MOVE_TO_TRASH_MESSAGE= "//p[text()='1 post moved to the Trash. ']";
	public static final String APPLY_BUTTON= "//input[@id='doaction']";
	public static final String ACTION_SELECTBOX= "//select[@name='action']";
	public static final String NO_POST_MESSAGE= "//td[text()='No posts found.']";
	public static final String POST_TITLE_BY_TITLE= "//a[text()='%s']";
	public static final String CHECKBOX_BY_TITLE= "//a[text()='%s']//parent::strong//parent::td//preceding-sibling::th//input";
	public static final String EDIT_ICON_BY_TITLE= "//strong//a[contains(text(),'%s')]//parent::strong//following-sibling::div//span//a[text()='%s']";

}
