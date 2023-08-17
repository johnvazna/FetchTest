# FetchTest

### Technical test - Fetch

Write a native Android app in Kotlin or Java that retrieves data from https://fetch-hiring.s3.amazonaws.com/hiring.json .

Show this list of items to the user based on the following requirements:

- Show all items grouped by "listId"
- Sort the results first by "listId" and then by "name" when displayed.
- Filter out items where "name" is blank or null.
- The end result should be displayed to the user in an easy to read list.

Make the project buildable with the latest tools (not pre-release) and compatible with the current version mobile operating system.

### Project structure

- app: Base module for instance of hilt and navigation component
- buildSrc: Module to control configurations, versions and dependencies
- core: Module to create resources, classes and general consumables for all modules
- feature-library:network: Module to control the network layer at the configuration level and by feature module
- feature:hiring: Hiring module to display the list consumed by the hiring service

### Compilation

To successfully build the project build first add the following values ​​to local.properties:

- BASE_URL=https://fetch-hiring.s3.amazonaws.com/
- STORE_PASSWORD=Fetch12345
- KEY_ALIAS=Fetch01
- KEY_PASSWORD=Fetch123456

These data will be added to the app module and the network module for the generation of service consumption. Avoiding data in code.

### APK generation

If you want to generate an APK either for dev, debug and release. Select the sign option, select the path to the keystore folder in your project.
If necessary write the passwords that come in the local.properties

<img width="1087" alt="Screenshot 2023-08-17 at 12 00 50" src="https://github.com/johnvazna/FetchTest/assets/13882319/cc40ecea-ce29-4634-b893-ae9f0e606605">


