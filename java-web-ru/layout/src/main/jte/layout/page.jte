<%--тут пишем ОБЩИЙ шаблон для страницы, эта информация будет всегда и везде.--%>
<%--В нее будет в определенном месте помещаться различный части от других шаблонов--%>
<%--это: <!doctype html> и тд и тп--%>

@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hexlet Javalin Example</title>
</head>
<body>
<p>
    <a href="/users">Users</a>
    <a href="/courses">Courses</a>
</p>
${content}
</body>
</html>