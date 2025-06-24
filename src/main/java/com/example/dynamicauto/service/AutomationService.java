package com.example.dynamicauto.service;


import io.github.bonigarcia.wdm.WebDriverManager;
import jakarta.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AutomationService {

    @Value("${d365base.url}")
    private String baseUrl;
    ArrayList<String> automationScripts = new ArrayList<>();
    @PostConstruct
    public void init() {
        automationScripts.add("MeterReplacement");
        automationScripts.add("CreateSalesOrder");
        automationScripts.add("CreatePurchaseOrder");
    }
    @Tool(
        name = "dynamicAutomation",
        description = "Dynamically generates automation scripts based on user input and system context."
    )
    public String dynamicAutomation() {
        WebDriverManager.chromedriver().setup();

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the Dynamics 365 URL
            String url = "https://www.google.in"; // Replace with your D365FO URL
            driver.get(url);

            // Perform additional actions if needed
            System.out.println("Opened Dynamics 365 URL successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Automation script executed successfully.";
    }

    @Tool(
        name = "getAutomationScripts",
        description = "Retrieves a list of available automation scripts."
    )
    public ArrayList<String> getAutomationScripts() {
        return automationScripts;
    }


    @Tool(name = "meterReplacement", description = "Automates the meter replacement process in Dynamics 365.")
    public String meterReplacement() {
        // Implement the meter replacement automation logic here
        return "Meter replacement automation executed successfully.";
    }

}
