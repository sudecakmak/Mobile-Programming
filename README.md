# Mobile-Programming
Projects I made in mobile programming. I use android studio for my projects.

## Apps
- [Calculator App](#calculator-app)
- [Radiobutton App](#radiobutton-app)
- [Checkbox App](#checkbox-app)
- [Login App](#login-app)
- [Spinner App](#spinner-app)
- [Seekbar App](#seekbar-app)
- [Shared Preferences](#shared-preferences)
- [Listview App](#listview-app)
- [User Settings App](#user-settings-app)
- [Sms Sending App](#sms-sending-app)
- [Switch Activities App](#switch-activities-app)
- [Listview with Class App](#listview-with-class-app)
- [Sign up Login App](#sign-up-login-app)
- [Sqlite App](#sqlite-app)
- [JSON Current Weather App](#json-current-weather-app)
- [JSON Current Currency App](#json-current-currency-app)

# Calculator App
It displays the result of addition, subtraction, multiplication and division of two numbers written by the user in the textbox.

![Screenshot 2022-11-10 015215](https://user-images.githubusercontent.com/102357822/200959412-cd4aa670-fca4-4a36-a6dd-52d88b359ff9.png)



# Radiobutton App
The picture of the selected animal is displayed in the imagebox. The animal image comes from the link address of the photo with the internet connection setup using the gidle library.

![Screenshot 2022-11-10 014840](https://user-images.githubusercontent.com/102357822/200958951-91a75ecf-5800-4000-8b13-72a515e55625.png)



# Checkbox App
Selected days are shown in textbox, if the day is deselected the day written in textbox will be removed.

<p align="middle">
  <img src="https://user-images.githubusercontent.com/102357822/211897726-1299c090-0958-4a3e-ae48-f13c327d03b4.png"/>
  <img src="https://user-images.githubusercontent.com/102357822/211897741-e49cec54-875d-4b75-8cb7-5491bc43c3ab.png"/>
</p>


# Login App
The user name and password are entered. If entered incorrectly 3 times, the background color will turn red. If written correctly, the background color will turn green. 

<p align="middle">
  <img src="https://user-images.githubusercontent.com/102357822/212309916-b1ec21f1-a9c9-4eb1-8fb6-5ccd4c774909.png"/>
  <img src="https://user-images.githubusercontent.com/102357822/212309921-8adbd0c8-e7e0-4efd-970f-df9c75456065.png"/>
  <img src="https://user-images.githubusercontent.com/102357822/212309930-dc1be861-ecb4-4eba-910d-c21f219b3369.png"/>
</p>

# Spinner App
When user select one of the names in the spinner selected names image displayed in the imagebox.

<p align="middle">
  <img src="https://user-images.githubusercontent.com/102357822/212422516-55d8e1c4-5b6f-4c8d-9683-fab0f075793d.png"/>
  <img src="https://user-images.githubusercontent.com/102357822/212422525-9396829d-a8d1-4350-8e90-e67889a1f728.png"/>
</p>


# Seekbar App
The seekbar on the screen determines the range of red, blue and green colors and allows the background color to change according to the seekbar movement.

![Screenshot 2023-01-10 205935](https://user-images.githubusercontent.com/102357822/212470202-6d4d260b-4e57-495f-86e5-92cd4a6a1ee9.png)

# Shared Preferences
Adding a shared preference to the seekbar application. The red, green, blue values are saved and when the app is opened again, thanks to the last saved color values the background color are displayed.

![Screenshot 2022-11-11 140058](https://user-images.githubusercontent.com/102357822/201327040-961be504-9e43-4b1b-a4e1-fbfbe19e81e1.png)



# Listview App
The provinces of the region selected from the spinner are shown in the listview.

![Screenshot 2022-11-07 233749](https://user-images.githubusercontent.com/102357822/200410486-7b03b3a5-04aa-485b-b364-40f1775fdf80.png)



# User Settings App
User settings are saved with the add to shared preference button, the saved data is displayed with the read button, and the texts in the edittext are deleted with delete button.

![Screenshot 2022-12-16 155743](https://user-images.githubusercontent.com/102357822/208103491-4a03787a-b8f9-444d-824b-5625e0db6af5.png)


# Sms Sending App
Sms to be sent is written in the edittext and saved to the sharedpreferences with the save button, and the person to be sent is selected from the listview. After the person to be sent is selected, the sms saved in the edittext is sent with the send button. The texts in the dollar sign written in the edittext are found from the listview and replaced with string replace.

<p align="middle">
  <img src="https://user-images.githubusercontent.com/102357822/200911505-ba2d75d2-a058-48be-abd2-45e04d3cafb8.png"/>
  <img src="https://user-images.githubusercontent.com/102357822/200911526-b89e346e-3b30-4315-96e8-7d9f2eba059a.png"/>
</p>


# Switch Activities App
In the first activity, you can switch to the other activity by pressing the color settings button. Color adjustments are made in the activity to which the transition is made, and it is seen that the color adjustment is made in the first activity by returning with the back button. Since the settings are saved in the shared preferences, when the application is opened again, it is seen that the settings are the same.

<p align="middle">
  <img src="https://user-images.githubusercontent.com/102357822/205444651-bc2c25fe-a559-4f0d-90fa-398b5e91c1c4.png"/>
  <img src="https://user-images.githubusercontent.com/102357822/205444654-fe1d0d57-03cd-4d31-80d4-34a4e0e70b11.png"/>
</p>

# Listview with Class App
New java classes are created. These classes are used to create a contact list. A contact list is created by entering name, age and gender information. There are add, delete and edit buttons. 

![Screenshot 2022-12-03 204419](https://user-images.githubusercontent.com/102357822/205455024-344c3568-a67f-4bfc-9baa-72d91d707990.png)

# Sign up Login App
When the user signs up, the username and password are registered to the shared preference. If the user name and password entered when the user logs in meets the ones registered in the shared preference, they log in and switch to the next page. On this page, the user name and password entered are displayed.

<p align="middle">
  <img src="https://user-images.githubusercontent.com/102357822/206709348-99b8c23b-4dcc-469b-8b9a-66973b66fc43.png"/>
  <img src="https://user-images.githubusercontent.com/102357822/206709359-6b7c55b9-5230-4a80-b71c-92e15984c6fa.png"/>
</p>

# Sqlite App
Enter the person's name, age, hair color. Pictures are assigned according to gender and age. Adding, deleting, editing and listing operations are performed. All data is recorded in the database. Transactions also occur in the database.

![Screenshot 2022-12-15 183155](https://user-images.githubusercontent.com/102357822/207904117-f74c7086-71ba-4435-8f1d-09243c2c194c.png)


# JSON Current Weather App
The weather api is taken as a json string. Current weather information is retrieved from json. It is added to the database. The city is written and searched. The city's weather, temperature, weather picture and query date are added to the listview.

![Screenshot 2022-12-22 000420](https://user-images.githubusercontent.com/102357822/209002512-c226eb89-d0ec-4a9f-8f4b-258a6bd2b924.png)


# JSON Current Currency App
The currency api is taken as a json string. Current currency information is retrieved from json. It is added to the database. It lists forrex selling, forex buying, Currency name and date.

![Screenshot 2022-12-22 002830](https://user-images.githubusercontent.com/102357822/209005801-0c11bdf1-fa2a-4be5-b2e1-5848028ac89f.png)
