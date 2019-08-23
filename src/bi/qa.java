package bi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class qa {
public static File src=new File("C:\\Users\\Koothabiran\\eclipse-workspace\\Amazon\\excel\\automation.xlsx");
	
public static XSSFWorkbook workbook;
public static XSSFSheet sheet;
public static XSSFCell cell;
public static WebElement searchelement;
	   
//Creation of object for the class methods
static NewTest obj = new NewTest();
static WebDriver driver;
	   
	   
@Test
public void input() throws InterruptedException, IOException {

FileInputStream finput = new FileInputStream(src);

// Load the workbook.
workbook = new XSSFWorkbook(finput);

// Load the sheet in which data is stored.
sheet= workbook.getSheetAt(0);

	//Getting the row count value and storing
	int rc=sheet.getLastRowNum();

	for(int i=1; i<=rc; i++)      
	   
	   {    
	     Row row = sheet.getRow(i);
	     
	     if(row == null || row.getCell(1)==null)
	     {      
	      continue;
	     }
	         
	String testcase = row.getCell(1).toString();        
    System.out.println(testcase);
	     
 //storing the test caseid value  
  String testcaseid = row.getCell(0).toString();        
	       
switch(testcase)
{

case "launchBroswer":

System.out.println(testcaseid + ":" + testcase);

obj.launchBroswer();
Thread.sleep(5000);
updateresult("/html/body/div[2]/div/div/div/div/div[2]/div/form/a",i);
break;
	     
	     
	     
	     
case "login":

System.out.println(testcaseid + ":" + testcase);

obj.login();
Thread.sleep(5000);
updateresult("/html/body/div/div/div[1]/div[1]/div[2]/div[2]/form/div/button/svg",i);
break;



case "search":

System.out.println(testcaseid + ":" + testcase);
obj.search();
Thread.sleep(5000);
updateresult("/html/body/div/div/div[3]/div[2]/div[1]/div[1]/div/div/div/section[4]/div[2]/div[1]/div[2]/div/div/label/div[2]",i);
break;
		     
case "logout":

System.out.println(testcaseid + ":" + testcase);
obj.logout();
Thread.sleep(5000);
updateresult("html/body/div[1]/div/div[1]/main/article/div/div/div[1]/div/div/h3[2]",i);
break;
		     

	          
}	    	     
}	
	}
	 
private static File newFile(String string) {
	// TODO Auto-generated method stub
	return null;
}

@SuppressWarnings("static-access")
public static void updateresult(String componentname,int i) throws IOException, InterruptedException
     {
        
        int a =obj.driver.findElements(By.xpath(componentname)).size();
        
        // Specify the message needs to be written.          
           String message = "Pass";
           String message1 = "Fail";
           if(a==1)
        
        {    
        
        Thread.sleep(3000);  
       sheet.getRow(i).createCell(4).setCellValue(message);
      
        }
      
       else
             {
              Thread.sleep(3000);
              sheet.getRow(i).createCell(4).setCellValue(message1);                    
              
             }
           FileOutputStream foutput=new FileOutputStream(src);
        
           workbook.write(foutput);
              
           foutput.close();


     }  
	  
  }