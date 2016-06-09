package miller2016uat.pageObject;
/** 
 * Абстрактный класс PageObject
 * @author a.fatov
 */
public abstract class Page {
	public Page() {
	}
	public String baseUrl = "http://miller-uat.efessky.net";
	public String pageUrl = "";
	public abstract String getPage() throws Exception;
	public abstract void openPage() throws Exception;
}
