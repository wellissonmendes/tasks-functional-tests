package br.ce.wcaquino.tasks.functional;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TasksTest {

    public WebDriver acessarAplicacao() {
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://localhost:8001/tasks");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    @Test
    public void deveSalvarTarefaComSucesso() {

        WebDriver driver = acessarAplicacao();
        try {
            driver.findElement(By.id("addTodo")).click();
            driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
            driver.findElement(By.id("dueDate")).sendKeys("21/10/2030");
            driver.findElement(By.id("saveButton")).click();
            String mensagem = driver.findElement(By.id("message")).getText();

            assertEquals("Success!", mensagem);
        } finally {
            driver.quit();
        }

    }


    @Test
    public void naoDeveSalvarTarefaComDataPassada() {

        WebDriver driver = acessarAplicacao();
        try {
            driver.findElement(By.id("addTodo")).click();
            driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
            driver.findElement(By.id("dueDate")).sendKeys("21/10/2000");
            driver.findElement(By.id("saveButton")).click();
            String mensagem = driver.findElement(By.id("message")).getText();
            assertEquals("Due date must not be in past", mensagem);
        } finally {
            driver.quit();
        }

    }


    @Test
    public void naoDeveSalvarTarefaSemDescricao() {

        WebDriver driver = acessarAplicacao();
        try {
                        driver.findElement(By.id("addTodo")).click();
            driver.findElement(By.id("dueDate")).sendKeys("21/10/2000");
            driver.findElement(By.id("saveButton")).click();
            String mensagem = driver.findElement(By.id("message")).getText();
            assertEquals("Fill the task description", mensagem);
        } finally {
            driver.quit();
        }

    }


    @Test
    public void naoDeveSalvarTarefSemData() {

        WebDriver driver = acessarAplicacao();
        try {
            driver.findElement(By.id("addTodo")).click();
            driver.findElement(By.id("task")).sendKeys("Teste via Selenium");

            driver.findElement(By.id("saveButton")).click();
            String mensagem = driver.findElement(By.id("message")).getText();
            assertEquals("Fill the due date", mensagem);
        } finally {
            driver.quit();
        }

    }

}
