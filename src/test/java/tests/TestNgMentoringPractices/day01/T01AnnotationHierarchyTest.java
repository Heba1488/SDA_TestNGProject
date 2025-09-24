package tests.TestNgMentoringPractices.day01;

import org.testng.annotations.*;

public class T01AnnotationHierarchyTest {
    /*
    AnnotationHierarchyTest
Task 1: Basic TestNG Setup and Annotations
Objective: Create a TestNG class demonstrating annotation hierarchy
Requirements:
 1/Create a TestNG class called AnnotationHierarchyTest
2/Implement all TestNG annotations (@BeforeSuite, @BeforeTest, @BeforeClass, @BeforeMethod,
@Test, @AfterMethod, @AfterClass, @AfterTest, @AfterSuite)
 3/Add print statements in each method to observe execution order
 4/Create 2 test methods
 5/Run the test and analyze console output
     */



    @BeforeSuite
    void beforeSuite(){
        System.out.println("@BeforeSuite");
    }

    @AfterSuite
    void afterSuit(){
        System.out.println("@AfterSuite");
    }

    @BeforeTest
    void beforeTest(){
        System.out.println("@BeforeTest");
    }

    @AfterTest
    void afterTest(){
        System.out.println("@AfterTest");
    }

    @BeforeClass
    void beforeClass(){
        System.out.println("@BeforeClass");
    }

    @AfterClass
    void afterClass(){
        System.out.println("@AfterClass");
    }

    @BeforeMethod
    void beforeMethod(){
        System.out.println("@BeforeMethod");
    }

    @AfterMethod
    void afterMethod(){
        System.out.println("@AfterMethod");
    }

    @Test
    void test01(){
        System.out.println("Test01 " );
    }

    @Test
    void test02(){
        System.out.println("Test02 " );
    }

}
