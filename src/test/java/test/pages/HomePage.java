package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;


public class HomePage extends Page {

  @FindBy(how = How.ID, using = "ext-gen1061")
  public WebElement leftPanelHeader;

  @FindBy(how = How.ID, using = "gridcolumn-1020")
  public WebElement rightPanelHeader;

  @FindBy(how = How.ID, using = "treeview-1017-table")
  public WebElement leftLettersTable;


  public HomePage(WebDriver webDriver) {
    super(webDriver);
  }

  public void ClickLeftList()
  {
    List<WebElement> tableRows = leftLettersTable.findElements(By.tagName("tr"));
    tableRows.get(0).findElement(By.tagName("img")).click();
  }

  public boolean IsCollapsedLeftLettersList() {
    boolean isCollapsed;

    List<WebElement> tableRows = leftLettersTable.findElements(By.tagName("tr"));

    if (tableRows.size() > 1)
    {
      isCollapsed = false;
    }
    else
    {
      isCollapsed = true;
    }

    return isCollapsed;
  }

  public void DeleteLeftLetters()
  {
    List<WebElement> tableRows = leftLettersTable.findElements(By.tagName("tr"));

    Actions action = new Actions(this.driver);

    if(!IsCollapsedLeftLettersList())
    {

      for (int i=0; i<tableRows.size(); ++i)
      {
        if (tableRows.get(i).findElement(By.className("x-tree-node-text")).getText().equals("C"))
        {
          action.contextClick(tableRows.get(i).findElement(By.className("x-tree-node-text"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).click().build().perform();
        }
      }
    }

  }
}
