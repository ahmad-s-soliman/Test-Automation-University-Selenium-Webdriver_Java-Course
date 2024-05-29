package horizontalSlider;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HorizontalSliderTests extends BaseTests {

    @Test
    public void testHorizontalSlider(){
            var horizontalSliderPage = homePage.clickHorizontalSlider();
            horizontalSliderPage.stopAtDesiredValue("4");
        //System.out.println(horizontalSliderPage.getCurrentRangeValue());
        assertEquals(horizontalSliderPage.getCurrentRangeValue(), "4", "slider value is wrong");
        }




}
