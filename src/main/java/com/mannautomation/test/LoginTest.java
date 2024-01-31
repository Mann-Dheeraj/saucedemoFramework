package com.mannautomation.test;

import java.io.IOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mannautomation.base.BaseTest;
import com.mannautomation.uicomponents.LoginPageFunctionality;
import com.mannautomation.utility.FetchDataFromExcelFile;

public class LoginTest extends BaseTest {

	LoginPageFunctionality lpf;

	@BeforeMethod
	public void setUpReferences() {
		lpf = new LoginPageFunctionality(this.driver);

	}

	@Test(dataProvider = "getCredentialsFromExcelFile")
	public void loginWithEmailAndPassword(String uname, String pass, String url) throws IOException {
		
		lpf.navigateToLoginPage();
		lpf.loginWithEmailAndPassword( uname, pass);
		if(uname.equalsIgnoreCase("locked_out_user")) {
			System.out.println(uname+" struck on login page due to invalid credentials  "+ url);
			lpf.AssertLoginPageUrl(url);
		}else {
			System.out.println(uname+" has successfully logged in to homepage:  "+ url);
			lpf.AssertLoginPageUrl(url);
		}
		
	}

	@DataProvider
	public String[][] getCredentialsFromExcelFile() throws IOException {
		FetchDataFromExcelFile fetchCredentials = new FetchDataFromExcelFile();

		String credentialsFilePath = "E:\\myFrameWork\\saucedemoFramework\\TestData\\TestData.xlsx";
		String[][] credentials = fetchCredentials.getCredentialsFromExcelFile(credentialsFilePath, 1);
		return credentials;
	}

//	@DataProvider
//	public String[][] testDataGenerator() {
//		String [][] emailPasswordCombination = {{"standard_user", "secret_sauce"},
//												{"locked_out_user", "secret_sauce"},
//												{"problem_user", "secret_sauce"},
//												{"performance_glitch_user", "secret_sauce"},
//												{"error_user", "secret_sauce"},
//												{"visual_user", "secret_sauce"}
//												};
//		return emailPasswordCombination;
//	}

}
