@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create New Article</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1>Create New Article</h1>
    <form action="/articles" method="POST">
        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" class="form-control ${page.errors != null && page.errors.containsKey('title') ? 'is-invalid' : ''}" id="title" name="title" value="${page.title ? page.title : ''}" required>
            <div class="invalid-feedback">
                @if(page.errors != null && page.errors.containsKey('title'))
                    @for(var error : page.errors.get('title'))
                        <div>${error.message}</div>
                    @endfor
                @endif
            </div>
        </div>
        <div class="form-group">
            <label for="content">Content</label>
            <textarea class="form-control ${page.errors != null && page.errors.containsKey('content') ? 'is-invalid' : ''}" id="content" name="content" rows="5" required>${page.content ? page.content : ''}</textarea>
            <div class="invalid-feedback">
                @if(page.errors != null && page.errors.containsKey('content'))
                    @for(var error : page.errors.get('content'))
                        <div>${error.message}</div>
                    @endfor
                @endif
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
