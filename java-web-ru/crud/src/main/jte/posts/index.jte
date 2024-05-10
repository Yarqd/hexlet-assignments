<h1>Posts</h1>
<ul>
        @for(var post : page.getPosts())
                <li><a href="@NamedRoutes.postPath(post.getId())">${post.getTitle()}</a></li>
        @endfor
</ul>
<div>
        @if(page.getCurrentPage() > 1)
                <a href="@NamedRoutes.postsPath()?page=${page.getCurrentPage() - 1}">Prev</a>
        @endif
        @if(page.getCurrentPage() * 5 < page.getTotalPosts())
                <a href="@NamedRoutes.postsPath()?page=${page.getCurrentPage() + 1}">Next</a>
        @endif
</div>
