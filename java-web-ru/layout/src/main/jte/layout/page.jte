@import java.util.Map
@param content: String
@param Map<String, Object> params

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>@params.get("title")</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
            crossorigin="anonymous">
</head>
<body>
    <header class="navbar navbar-dark bg-dark shadow-sm">
        <div class="container">
            <a href="/" class="navbar-brand d-flex align-items-center">
                <strong>Home</strong>
            </a>
            <a href="/users" class="navbar-brand d-flex align-items-center">
                <strong>Users</strong>
            </a>
        </div>
    </header>
    <main class="container mt-4">
        @content
    </main>
    <footer class="text-muted py-4 bg-light">
        <div class="container">
            <p class="float-end mb-1">
                <a href="#">Back to top</a>
            </p>
            <p class="mb-1">Example project © 2024</p>
        </div>
    </footer>
</body>
</html>
