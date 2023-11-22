package br.ce.wcaquino.tasks.functional;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TasksTest {

    public WebDriver acessarAplicacao() throws MalformedURLException {
  //      WebDriver driver = new FirefoxDriver();
        DesiredCapabilities cap = DesiredCapabilities.firefox();
        WebDriver driver = new RemoteWebDriver(new URL("http://172.27.16.1:4444"), cap);
        driver.navigate().to("http://localhost:8001/tasks");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    @Test
    public void deveSalvarTarefaComSucesso() throws MalformedURLException {

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
    public void naoDeveSalvarTarefaComDataPassada() throws MalformedURLException {

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
    public void naoDeveSalvarTarefaSemDescricao() throws MalformedURLException {



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
    public void naoDeveSalvarTarefSemData() throws MalformedURLException {

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

    @Test
    public void naoDeveSalvarTarefSemNada() throws MalformedURLException {

        WebDriver driver = acessarAplicacao();
        try {
            driver.findElement(By.id("addTodo")).click();
            driver.findElement(By.id("saveButton")).click();
            String mensagem = driver.findElement(By.id("message")).getText();
            assertEquals("Fill the task description", mensagem);
        } finally {
            driver.quit();
        }

    }


    @Test
    public void naoDeveSalvarTarefSemNada1() throws MalformedURLException {

        WebDriver driver = acessarAplicacao();
        try {
            driver.findElement(By.id("addTodo")).click();
            driver.findElement(By.id("saveButton")).click();
            String mensagem = driver.findElement(By.id("message")).getText();
            assertEquals("Fill the task description", mensagem);
        } finally {
            driver.quit();
        }

    }

    @Test
    public void naoDeveSalvarTarefSemNada2() throws MalformedURLException {

        WebDriver driver = acessarAplicacao();
        try {
            driver.findElement(By.id("addTodo")).click();
            driver.findElement(By.id("saveButton")).click();
            String mensagem = driver.findElement(By.id("message")).getText();
            assertEquals("Fill the task description", mensagem);
        } finally {
            driver.quit();
        }

    }

    @Test
    public void naoDeveSalvarTarefSemNada3() throws MalformedURLException {

        WebDriver driver = acessarAplicacao();
        try {
            driver.findElement(By.id("addTodo")).click();
            driver.findElement(By.id("saveButton")).click();
            String mensagem = driver.findElement(By.id("message")).getText();
            assertEquals("Fill the task description", mensagem);
        } finally {
            driver.quit();
        }

    }

}
