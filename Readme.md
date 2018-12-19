# Project Assessment:(XO_GMAIL_1)
The provided repository contains an incomplete automated test for email sending functionality via Gmail.

The test is supposed to:
- Login to Gmail
- Compose an email from subject and body as mentioned in src/test/resources/test.properties
- Label email as "Social"
- Send the email to the same account which was used to login (from and to addresses would be the same)
- Wait for the email to arrive in the Inbox
- Mark email as starred
- Open the received email
- Verify email came under proper Label i.e. "Social"
- Verify the subject and body of the received email
- Generate test execution report at the end

# Notes
- Update the src/test/resources/test.properties file to replace dummy credentials and chromedriver path before you run the tests. You may remove your login details before submitting this assessment.
- Don't include downloaded packages or auto-generated folders in your submission.
- Please enable "Social" label for your Gmail account using the following steps:
    -Go to Settings of your Gmail account
    -Click on the "Labels" tab and click on "Show" for "Social" label under Categories
    -Click on "Inbox" tab and mark the checkbox for "Social" and "Primary" under Categories so that "Social" and "Primary" tabs appear on the main page of your Gmail account
- DO NOT change the project structure and use Gradle only

# Tasks:
1. Complete the automated test to include the missing functionality, refer to the section titled 'Project Assessment' for requirements.
2. There are a few bugs in the existing code that we'd like you to fix, the test case seems to be failing right now. Even though the project might not be in a great structure, please do not spend your valuable time on structure modifications unless explicitly asked to, just focus on fixing bugs.

PLEASE NOTE THAT ALL THE TASKS LISTED ABOVE ARE MANDATORY. We'll be evaluating your submission on the following parameters:

- Complete the incomplete unit test.
- Bug fixes.

# Prerequisites:
- ChromeDriver 2.44 , JDK 8+
- Any IDE

# Development Environment:
- Modify src/test/resources/test.properties to point to ChromeDriver's path on your system
- On any terminal, move to the project's root folder and execute the following command:
    - ./gradlew clean test

# How to deliver:
This is how we are going to access and evaluate your submission, so make sure you go through the following steps before submitting your answer.

1. Make sure that the tests are passing, there are no errors, and any new dependencies are specified in build.gradle.
2. Zip your project folder and name it 'cross-mail-selenium-java_<YourNameHere>.zip'.
3. Store your file in a shared location where Crossover team can access and download it for evaluation. Do not forget to paste the shared link in the answer field of this question.
