package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTests extends BaseTests {
    @Test
    public void testSelectOption(){
        var dropdownPage = homePage.clickDropDown();
        dropdownPage.selectFromDropdown("Option 1");
        var selectedOptions = dropdownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "number of selected options is not 1");
        assertTrue(selectedOptions.contains("Option 1"), "Option 1 is not selected");

    }

    @Test
    public void testMultipleOptions(){
        var dropdownPage = homePage.clickDropDown();
        dropdownPage.setMultipleOptions();
        dropdownPage.selectFromDropdown("Option 1");
        dropdownPage.selectFromDropdown("Option 2");

        // course's way of selecting both options:

        //var optionsToSelect = List.of("Option 1", "Option 2");
        //optionsToSelect.forEach(dropDownPage::selectFromDropDown);

        var selectedOptions = dropdownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 2, "number of selected options is not 2");
    }
}
