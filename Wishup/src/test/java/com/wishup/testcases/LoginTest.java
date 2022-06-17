package com.wishup.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wishup.base.BaseClass;
import com.wishup.pages.HomePage;
import com.wishup.pages.LoginPage;
import com.wishup.utilities.XLUtils;

public class LoginTest extends BaseClass {
	private LoginPage lp;
	private HomePage hp;

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException, IOException {
		lp = new LoginPage(driver);
		lp.setUserName(user);
		lp.setPassword(pwd);
		lp.clickLogin();
		captureScreenShot(driver, "loginDDT");
		
			hp = new HomePage(driver);
			hp.moveToDropDownTest();
			hp.clickLogout();
			Assert.assertEquals(driver.getTitle(), "Wishup App");
		
	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = "./TestData/LoginTestData.xlsx";

		int rownum = XLUtils.getRowCount(path, "Credential");
		int colcount = XLUtils.getCellCount(path, "Credential", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Credential", i, j);// 1 0
			}

		}
		return logindata;
	}

}
