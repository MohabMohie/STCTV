# A sample project for STC TV using the [SHAFT_Engine](https://shafthq.github.io/) template

<img src="https://github.com/ShaftHQ/SHAFT_ENGINE/raw/main/src/main/resources/images/shaft.png" alt="SHAFT_ENGINE" style="display:block; margin-left:auto; margin-right:auto;"/> 

<a id="quick-start-guide"></a>

## I. Running some Tests 🏃

- Navigate to the module that you want to play with. For example ```GUI_Web```
- Navigate to any test class. For example ```src/test/java/TestPackage/TestClass.java```
- Press the green play button next to the class name to run the entire class, or next to a test method to run only that
  method.
- Test execution will begin, and you'll see the browser opening and the test running.
- The Test execution report will open automatically in your default web browser after the test run is completed.
- You can open the detailed allure report by running the ```generate_allure_report``` executable in your project root
  directory.

<img src="https://github.com/allure-framework/allure2/raw/master/.github/allure-report-gif.gif" alt="Allure Report" style="display:block; margin-left:auto; margin-right:auto;"/>

## II. What's next?

### Configuration and User Guide

- Change the target browser, operating system, timeouts, and other configurations using the
  ⚙️ [Configuration Manager](https://ShaftHQ.github.io/SHAFT_ENGINE/).
- Learn more about using SHAFT_Engine from the 👤 [User Guide](https://ShaftHQ.github.io/SHAFT_Engine_Docusaurus/) and
  📚 [Javadocs](https://ShaftHQ.github.io/SHAFT_ENGINE/apidocs/index.html).
- <b>Join</b>
  our ![GitHub Repo stars](https://img.shields.io/github/stars/shafthq/shaft_engine?logoColor=black&style=social) to get
  notified by email when a new release is pushed out.
- Configure `TestNG.properties` to use `setParallel=METHODS` and `setThreadCount=3` to run in parallel.
- Configure `custom.properties` to use `targetBrowserName="chrome"` or `targetBrowserName="firefox"`
  or `targetBrowserName="safari"` to change the target browser.

### CI/CD & DevOps

- This template comes preloaded with some Selenium grid 4 powered CI/CD pipelines to get you started!
- Navigate to "Actions" and then select "Desktop Browser Tests" from the side menu
- Click "Run workflow" and confirm your choice.
- You will notice that the pipeline has started building, and you can download the execution reports once the execution
  is completed.

<img src="https://github.githubassets.com/images/modules/site/actions/pr-checks-final.png" alt="GitHub Actions" style="display:block; margin-left:auto; margin-right:auto;"/>

### Stop Reinventing the wheel! Start using SHAFT!
