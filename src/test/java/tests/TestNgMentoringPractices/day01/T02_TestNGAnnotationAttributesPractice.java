package tests.TestNgMentoringPractices.day01;

import org.testng.annotations.Test;

public class T02_TestNGAnnotationAttributesPractice {

    /*
    Task 2: TestNG Annotation Attributes Practice
Objective: Implement various TestNG annotation attributes
Requirements:
Create a class called AttributePracticeTest
//Create 5 test methods with different priorities (1, 3, 2, 5, 4)
//Create one test method with enabled = false
//Create a test method with timeout of 3 seconds that includes Thread.sleep(2000)
Create a test method with timeout of 1 second that includes Thread.sleep(2000)
6. Add meaningful descriptions to all test methods
Create test methods with groups: "smoke""regression"
,
"api"
,
 */

    @Test(priority = 4,description = "Tesst 01",groups = "smoke")
    void test1(){
        System.out.println("@Test 1");
    }
    @Test(priority = 1,description = "Tesst 02",groups = "regression")
    void test2(){
        System.out.println("@Test 2");

    }
    @Test(priority = 3,enabled = false,description = "Tesst 03",groups = "smoke")
    void test3(){
        System.out.println("@Test 3");

    }
    @Test(priority = 2,description = "Test 04",groups = "regression")
    void test4(){
        System.out.println("Test 04");
    }

    @Test(priority = 5,timeOut = 3000,description = "Test 05",groups = "api")
    void test5() throws InterruptedException {
        System.out.println("@Test 5");
        Thread.sleep(2000);
    }

    @Test(timeOut = 1000,description = "Test 06",groups = "api")
    void test6() throws InterruptedException {
        System.out.println("@Test 6");
        Thread.sleep(2000);
    }

}
