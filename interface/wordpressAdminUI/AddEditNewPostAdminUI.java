package wordpressAdminUI;

public class AddEditNewPostAdminUI {
	public static final String TITLE_INPUT = "//h1[contains(@class,'editor-post-title__input')]";
	public static final String CONTENT_INPUT = "//p[contains(@class,'block-editor-default-block-appender__content')]";
	public static final String CONTENT_INPUT_AFFTER = "//p[contains(@class,'block-editor-rich-text__editable')]";
	public static final String PUBLISH_BUTTON = "//button[contains(@class,'post-publish-button')]";
	public static final String PUBLISH_BUTTON_2 = "//div[@class='editor-post-publish-panel']//button[contains(@class,'post-publish-button')]";
	public static final String PUBLISHED_MESSAGE = "//div[@class='components-snackbar__content']";
	public static final String CLOSE_DIALOG_ICON = "//div[@class='components-modal__header']//button[@class='components-button has-icon']";
	public static final String POST_HEADER_ICON = "//div[@class='edit-post-header']//a";
	public static final String UPDATE_BUTTON= "//button[text()='Update']";
	public static final String UPDATE_SUCCESS_MESSAGE= "//div[text()='Post updated.']";

}
