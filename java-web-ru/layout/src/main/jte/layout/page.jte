@import gg.jte.Content
@param Content content

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Site Layout</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <header class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">Home</a>
            <a class="navbar-brand" href="/users">Users</a>
        </div>
    </header>

    <main class="container mt-4">
        ${content}
    </main>

    <footer class="footer mt-auto py-3 bg-light">
        <div class="container">
            <span class="text-muted">Visit my <a href="https://gitlab.com/yourusername">GitLab profile</a>.</span>
        </div>
    </footer>
</body>
</html>
