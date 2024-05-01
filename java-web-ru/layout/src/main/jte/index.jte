@import org.example.MainPage
@param MainPage mainPage

@template.layout.page(content = @`
    <h1>Welcome to My JTE Site!</h1>
    <p>Hello, ${mainPage.getWelcomeMessage()}!</p>
`)