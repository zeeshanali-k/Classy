# Classy
Text to image generation app using Compose Multiplatform with Clean Architecture.

<img src="/media/ss1.png" width="250" height="420"> <img src="/media/ss2.png" width="250" height="420">
<img src="/media/ss3.png" width="250" height="420">

# Tech Stack

<h5>As for Compose Multiplatform following libraries are used:</h5>

- Moko for ViewModels and Flows
- Voyager for navigation
- Ktor for HTTP communication
- Koin for dependency injection
- Calf for adaptive UI Elements
- Typist-CMP for text typing animation

App is following the MVVM Clean Architecture approach with buildSrc for dependencies management.


<h5>Backend</h5>

- <a href="https://github.com/zeeshanali-k/t2i_backend">Django App</a> hosted on AWS EC2 (which further uses HuggingFace's free inference api for custom trained model)
- <a href="https://huggingface.co/devscion/pakhistoricalplaces">HuggingFace Hosted Model</a>

# Setup

You can either use the above backend and deploy it and use in app by replacing base url or you can directly use HuggingFace's free inference API for generating images.
The method for parsing data returned from HuggingFace's free inference API is different so you will have to change the code related to api connection in data layer of app.

<b>Note:</b> HuggingFace's free inference API is initialised on demand so at first request you will receive invalid response and after a while, when system is initialised you need to try again to start getting the actual results.

