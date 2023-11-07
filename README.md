# Nurture-Server [![Tweet](https://img.shields.io/twitter/url/http/shields.io.svg?style=social&logo=twitter)](https://twitter.com/intent/tweet?url=https%3A%2F%2Fcreativetimofficial.github.io%2Flight-bootstrap-dashboard-react&text=Light%20Bootstrap%20Dashboard%20React%20-%20Free%20Bootstrap%20Admin%20Template&original_referer=https%3A%2F%2Fdemos.creative-tim.com%2Flight-bootstrap-dashboard-react%2F&via=creativetim&hashtags=react%2Cbootstrap%2Creact-bootstrap%2Ccreativetim%2Ccreative-tim)

![version](https://img.shields.io/badge/version-2.0.1-blue.svg) ![license](https://img.shields.io/badge/license-MIT-blue.svg) [![GitHub issues open](https://img.shields.io/github/issues/creativetimofficial/light-bootstrap-dashboard-react.svg?maxAge=2592000)]() [![GitHub issues closed](https://img.shields.io/github/issues-closed-raw/creativetimofficial/light-bootstrap-dashboard-react.svg?maxAge=2592000)]() [![Chat](https://img.shields.io/badge/chat-on%20discord-7289da.svg)](https://discord.gg/E4aHAQy)

![Product Gif](https://raw.githubusercontent.com/creativetimofficial/public-assets/master/light-bootstrap-dashboard-react/light-bootstrap-dashboard-react.gif)

Server for Bala Asha App

## Steps to set up in your local

1. Install latest version of Git. Instructions
   ```
   https://git-scm.com/book/en/v2/Getting-Started-Installing-Git
   ```

2. Install java 21
   ```curl
   https://www.azul.com/downloads/?package=jdk#zulu
   ```

3. Fork the GitHub Repository. Instructions for same are [available here](https://docs.github.com/en/get-started/quickstart/fork-a-repo)

4. Clone the repository in your local (via cmd/terminal)
   ```bash
   git clone https://github.com/{user.name}/nurture-server.git
   ```
   Instructions for same can also be found at [this page](https://docs.github.com/en/repositories/creating-and-managing-repositories/cloning-a-repository)
5. Open the project in your favorite IDE. ensure that Java version is set to 21

6. run the spring boot application. `NurtureServerApplication` is the Main class

7. App will start at following URL
   ```bash
   http://localhost:8080
   ```
8. You can access the h2 database at following URL
   ```bash
   http://localhost:8080/h2-console
   ```
   Make sure jdbc url is `jdbc:h2:mem:testdb`. you do not need to provide any password. hit `connect` button and you will be logged in

9. If you want to Switch-off the Authorization check at the server, start the app with profile `AuthOff`. you can do it by passing the JVM argument as following
   ```
   -Dspring.profiles.active=AuthOff
   ```
   