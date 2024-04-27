@import java.util.Map
@param Map<String, Object> params

@template.layout.page(`
    <h1>Welcome to our site!</h1>
    <p>This is a great place to get started with our application.</p>
`, model("title", "Welcome!"))
