package fileUpload;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {
    @Test
    public void testFileUpload(){
        var fileUploadPage = homePage.clickFileUpload();
        fileUploadPage.uploadFile("D:\\SW testing\\webdriver_java\\src\\main\\resources\\Ahmad Soliman CV.pdf");
        assertEquals(fileUploadPage.getUploadedFiles(), "Ahmad Soliman CV.pdf", "wrong file uploaded");
    }
}
