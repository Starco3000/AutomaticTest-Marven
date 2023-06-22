package org.example.Selenium.projects.schools.onClass;

import org.example.Selenium.projects.schools.website.orangehrm.models.MyProfile.PersonalDetail;
import org.example.Selenium.projects.schools.website.orangehrm.models.XpathLink;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;
import java.util.Properties;

public class Ex_02 extends XpathLink {


    public Ex_02(WebDriver driver, String webUrl, Properties properties) {
        super( driver, webUrl, properties );
        PageFactory.initElements( driver, this );
    }

    public Ex_02(WebDriver driver, String webUrl) {
        super( driver, webUrl );
        PageFactory.initElements( driver, this );
    }

    public Ex_02 login() {
        get(webUrl)
                .sendKeys(usernameInput, "Admin", true )
                .sendKeys( passwordInput, "admin123", true )
                .click(loginSubmit, true)
        ;
        return this;
    }

    public  Ex_02 updateMyInfo (PersonalDetail personalDetail) {
        click(myInfoLocationSidebar, true).pause( 3000 )
                .clearThenSendKeys( firstNameField, personalDetail.getFirstName(), true )
                .clearThenSendKeys( middleNameField, personalDetail.getMiddleName(), true )
                .clearThenSendKeys( lastNameField, personalDetail.getLastName(), true )
                .clearThenSendKeys( nickNameField, personalDetail.getNickName(), true )
                .clearThenSendKeys( employeeIdField, personalDetail.getEmployeeId(), true )
                .clearThenSendKeys( otherIdField, personalDetail.getOtherId(), true )
                .clearThenSendKeys( driverLicenseField, personalDetail.getDriverLicenseNum(), true )
                .clearThenSendKeys( licenseExpiryDate, personalDetail.getLicenseExpiryDate(), true )
                .clearThenSendKeys( ssnNumField, personalDetail.getSsnNum(), true )
                .click( nationalityField, true ).pause( 500 )
                .click( nationalityOption, true ).pause( 500 )
                .click( materialStatusField, true ).pause( 500 )
                .click( materialStatusOptions, true).pause( 500 )
                .clearThenSendKeys( dateOfBirthField, personalDetail.getDateOfBirth(), true )
                .click( Objects.equals( personalDetail.getGender(),"Female" ) ? femaleOption : maleOption, true)
                .clearThenSendKeys( militaryServiceField, personalDetail.getMilitaryService(), true).pause( 2000 )
                .uncheck( smokerOption, smokeLabel, false)
//                .click( saveButton, true ).pause( 5000 )
                .click(userNavTopRightDropdown, true)
                .click( userNavTopRightDropdownLogout, true)
        ;
        return this;
    }
}
