package com.tutorialsninja.automation.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

import io.cucumber.junit.Cucumber;





@RunWith(Cucumber.class)
@CucumberOptions(features={"classpath:FeatureFiles/Order.feature" },
glue={"classpath:com.tutorialsninja.automation.stepdef"},
plugin={"html:target/cucumber_html_report"},
tags = "@Order and @One")
public class TestRunner {

}
