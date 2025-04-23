package com.intelehealth.pages;

import java.io.IOException;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> 4179dc4eaab4c397c63ead2179c1294ae6a508ec

import org.openqa.selenium.WebElement;

import com.google.common.collect.ImmutableMap;
import com.intelehealth.base.BaseTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FindPatientPage extends BaseTest {
	
	// Page elements using AndroidFindBy annotation
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Find Patients']")
	private WebElement findPatients;
	
	@AndroidFindBy(accessibility = "Find Patient Screen Search Bar EditText")
	private WebElement findPatientSearchBar;
	
	@AndroidFindBy(accessibility = "Find Patient Screen Search ImageView")
	private WebElement findPatientSearchIcon;

	@AndroidFindBy(accessibility = "//android.widget.TextView[@text='Automation Rana']")
	private WebElement automationOnePatient;

	@AndroidFindBy(accessibility = "No Patient Found Placeholder Title TextView -Patient not found ")
	private WebElement patientNotFound;

	@AndroidFindBy(accessibility = "No Patient Found Placeholder Subtitle TextView-description")
	private WebElement noPatientFoundSubTitle;

	@AndroidFindBy(accessibility = "No Patient Found Placeholder 'Add New Patient' Text TextView-Add new patient")
	private WebElement addNewPatientCTAButton;

	@AndroidFindBy(id = "org.intelehealth.app:id/textlayout_find_patient")
	private WebElement findPatients;
	
	@AndroidFindBy(id = "org.intelehealth.app:id/search_txt_enter")
	private WebElement findPatientSearchBar;
	
	@AndroidFindBy(id = "org.intelehealth.app:id/icon_search")
	private WebElement findPatientSearchIcon;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='org.intelehealth.app:id/search_name'])[1]")
	private WebElement automationOnePatient;

	@AndroidFindBy(id = "org.intelehealth.app:id/search_pat_not_found_txt")
	private WebElement patientNotFound;

	@AndroidFindBy(id = "org.intelehealth.app:id/search_pat_hint_txt")
	private WebElement noPatientFoundSubTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Add New Patient']")
	private WebElement addNewPatientCTAButton;

	@AndroidFindBy(xpath = "(//android.widget.FrameLayout[@resource-id='org.intelehealth.app:id/fu_cardview_item'])[1]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]")
	private WebElement lblPatientCard;
	
//	@AndroidFindBy(accessibility = "No Patient Found Placeholder Icon ImageView")
//	private WebElement findPatient;

	// Method to click on the "Find Patient" element
	public void clickOnFindPatient() {
		click(findPatients);
	}
	public void clickOnFirstPatientCard() {
		click(lblPatientCard);
	}


// Method to enter a value in the search box and press Enter
	public void enterValueInSearchBox(String txt) throws InterruptedException {
		Thread.sleep(4000);
//	sendKeys(findPatientSearchBar,"Automation Rana");
		click(findPatientSearchBar);
		
//   Thread.sleep(2000);
//executeCommand("adb shell input keyevent 84");
		 //sendKeys(findPatientSearchBar,((PressesKey) getDriver()).pressKey(new
		// KeyEvent(AndroidKey.ENTER)));

		// click(findPatientSearchBar);
		String textToEnter = "AutomationRana";
		String adbCommand = String.format("adb shell input text %s", txt);
		executeCommand(adbCommand);
		executeCommand("adb shell input keyevent 84");
		((PressesKey) getDriver()).pressKey(new
				KeyEvent(AndroidKey.ENTER));
	}

	public static void executeCommand(String command) {
		try {
			Process process = Runtime.getRuntime().exec(command);
			process.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String verifySearchedPatient() {
			return automationOnePatient.getText();
	}
	
	public boolean isDisplayedSearchedPatient() {
		return isDisplayed(automationOnePatient, "Patient is Displayed");
			
	}
	
	public void enterInvalidPatienTName(String txt) throws InterruptedException {
		sendKeys(findPatientSearchBar, txt);

	}

	public void verifyInvalidPatientSearch() {
		isDisplayed(patientNotFound, "Patient not founf msg is displayed");
		isDisplayed(noPatientFoundSubTitle, "");
		isDisplayed(addNewPatientCTAButton, "");
	}

	public boolean verifyInvalidPatientSearch() {
		return isDisplayed(patientNotFound, "Patient not founf msg is displayed")
	&&	isDisplayed(noPatientFoundSubTitle, "")
		&& isDisplayed(addNewPatientCTAButton, "");	
	}

	public List<String> getInvalidPatientSearch() {
		return getElementsText(patientNotFound, noPatientFoundSubTitle, addNewPatientCTAButton);
	}
	
// Method to verify if the search box is visible
	public boolean verifySearchBoxIsVisible() throws InterruptedException {
	return	isDisplayed(findPatientSearchBar);
	}
}
