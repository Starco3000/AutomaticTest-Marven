package org.example.Selenium.projects;

import org.example.Selenium.TestAction;
import org.example.Selenium.projects.schools.onClass.Ex_02;
import org.example.Selenium.projects.schools.website.orangehrm.models.MyProfile.PersonalDetail;
import org.example.Selenium.setup.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RunFile extends TestAction {
    static Driver driver = new Driver();

    public static void main(String[] args) {
        doEx_02();
    }

    private static void doEx_02() {
        PersonalDetail material02 = new PersonalDetail()
                .setFirstName( "Automation" )
                .setMiddleName( "Nhóm 11" )
                .setLastName( "Ca 4" )
                .setNickName( "Testing" )
                .setEmployeeId( "11" )
                .setOtherId( "110" )
                .setDriverLicenseNum( "11111" )
                .setLicenseExpiryDate( "2023-06-21" )
                .setSsnNum( "300" )
                .setNationality( "tự chọn" )
                .setMaterialStatus( "Single" )
                .setDateOfBirth( "2023-06-22" )
                .setGender("Female")
                .setMilitaryService( "1" )
                .setSmoker( "no" )
        ;

        Ex_02 exercise02 = new Ex_02(driver.useChrome(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        exercise02.login().updateMyInfo(material02).pause(5000).quit();
    }

}
