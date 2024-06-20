<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${page.post.getTitle()}</title>
</head>
<body>
<h1>${page.post.getTitle()}</h1>
<p>${page.post.getContent()}</p>
<a href="${@NamedRoutes::postsPath()}">Back to posts</a>
</body>
</html>
