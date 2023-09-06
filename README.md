# Classy
Text to image generation Android and iOS app using Compose Multiplatform with Clean Architecture.

<img src="/media/ss1.png" width="250" height="520"> <img src="/media/ss2.png" width="250" height="520">
<img src="/media/ss3.png" width="250" height="520"> 

<h3>
  
Adaptive Bottom Sheet
</h3>
<p>
  
<img src="/media/ss4.png" width="250" height="520">
<img src="/media/ss5.png" width="250" height="520">
</p>

<h3>
  Desktop
</h3>
<img src="/media/desktop_ss.png" width="250" height="650">

# Tech Stack

<h5>As for Compose Multiplatform following libraries are used:</h5>

- <a href="https://github.com/icerockdev/moko-mvvm">Moko</a> for ViewModels and Flows
- <a href="https://github.com/adrielcafe/voyager">Voyager</a> for navigation
- <a href="https://ktor.io/docs/getting-started-ktor-client.html">Ktor</a> for HTTP communication
- <a href="https://github.com/cashapp/sqldelight">Sql Delight</a> as local database for Images History
- <a href="https://insert-koin.io/docs/setup/koin/">Koin</a> for dependency injection
- <a href="https://github.com/MohamedRejeb/Calf">Calf</a> for adaptive UI Elements
- <a href="https://github.com/zeeshanali-k/Typist-CMP">Typist-CMP</a> for text typing animation

App is following the MVVM Clean Architecture approach with buildSrc for dependencies management.


<h5>Backend</h5>

- App is currently using HuggingFace's free inference API Directly but you can also use the backend linked below. Instructions for changing to custom backend are given in data source in code. Get your token from Hugging Face and replace in data layer to start using the app. (You don't need to add "Bearer" before it, it is automatically handeld by bearerAuth function of Ktor)
- <a href="https://github.com/zeeshanali-k/t2i_backend">Django App</a> hosted on AWS EC2 (which further uses HuggingFace's free inference api for custom trained model)
- <a href="https://huggingface.co/devscion/pakhistoricalplaces">HuggingFace Hosted Model</a>

# Setup

You can either use the above backend and deploy it or you can directly use HuggingFace's free inference API for generating images (Currently Implemented Method).
<p>If you face any error mentioning <b>Sql Delight or sqlite3</b>, refer to this <a href="https://github.com/cashapp/sqldelight/issues/1442">issue</a></p>


<b>Note:</b> HuggingFace's free inference API is initialised on demand so at first request you will receive invalid response and after a while, when system is initialised you need to try again to start getting the actual results.

<a href="https://www.buymeacoffee.com/devscion"><img src="https://img.buymeacoffee.com/button-api/?text=Buy me a coffee&emoji=&slug=ZeeshanAli&button_colour=FFDD00&font_colour=000000&font_family=Cookie&outline_colour=000000&coffee_colour=ffffff"></a>




