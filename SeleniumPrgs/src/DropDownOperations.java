import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownOperations {
	Select dropDownList;
	DropDownOperations(WebElement element){
		dropDownList = new Select(element);
	}
	int getNumberOfElement(){
		return dropDownList.getOptions().size();
	}
	void selectItem(int index){
	 dropDownList.selectByIndex(index);
 }
	void selectItem(String by,String value){
	 if(by.equals("selectByValue")){
		 dropDownList.selectByValue(value);
	 }
	 else
	 {
		 dropDownList.selectByVisibleText(value);
	 }
 }
	List<String> getAllOptions(){
		List<String> values = new ArrayList<String>();
		List<WebElement> ddValues = dropDownList.getOptions();
		
		for(WebElement element:ddValues){
			values.add(element.getText());
		}
				
		return values;
	}
	void deSelectItem(String by,String value){
		 if(by.equals("selectByValue")){
			 dropDownList.deselectByValue(value);
		 }
		 else
		 {
			 dropDownList.deselectByVisibleText(value);
		 }
	 }

}

