package wordpressUserUI;

public class HomePageUserUI {
	public static final String SEARCH_ICON = "//input[@id='adminbar-search']";
	public static final String POST_TITLE = "//h2[@class='wp-block-post-title']//a";
	public static final String POST_TITLE_BY_TITLE = "//h2//a[text()='%s']";
	public static final String POST_CONTENT_BY_TITLE = "//a[text()='%s']//parent::h2//following-sibling::div//p";
	public static final String POST_CONTENT = "//p[@class='wp-block-post-excerpt__excerpt']";
	public static final String POST_DATE = "//div[@class='wp-block-post-date']//time";

}
