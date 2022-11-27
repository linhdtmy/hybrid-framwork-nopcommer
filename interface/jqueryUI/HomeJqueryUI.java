package jqueryUI;

public class HomeJqueryUI {
	public static final String PAGING_NUMBER = "//li[@class='qgrd-pagination-page']//a[text()='%s']";
	public static final String ACTIVE_PAGE = "//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String INPUT_SEACH_BY_LABEL ="//div[text()='%s']/parent::div//following-sibling::input";
	public static final String TEXT_BY_LABEL ="//td[@data-key='%s' and text()='%s']";
	public static final String LIST_PAGE="//a[contains(@class,'qgrd-pagination-page-link')]";
	public static final String ROW_ONE_PAGE="//tbody//tr";
	public static final String INDEX_COLUMN_BY_HEADER_LABEL="//tr/td[text()='%s']/preceding-sibling::td";
	public static final String INPUT_BY_ROW="//tr[%s]//td[%s]/input";
	public static final String SELECT_BY_ROW="//tr[1]//td[5]//select";
}
