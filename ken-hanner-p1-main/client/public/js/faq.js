$(function() {
    var data = [
        {
            id: 1,
            title: 'Emergency Contacts',
            asection: 'Contact Aunt Edna between 7am-3pm or Neighbor Jim between 3pm-7am.',
            bsection: 'Edna: (414)765-4321; Jim: (414)123-4567'
        },
        {
            id: 2,
            title: 'Allergies',
            asection: 'Pineapple, cherries, almonds, shellfish',
            bsection: 'Give antihistamine and call us ASAP if any problem.'
        },
        {
            id: 3,
            title: 'Screen Time',
            asection: 'Do not exceed 3 hours of screen time in a day.',
            bsection: 'Approved content: Rated-G only; Suggested content: PBS KIDS'
        },
        {
            id: 4,
            title: 'Food for You',
            asection: 'There will always be $20 on the counter for you to order delivery with.',
            bsection: 'Recommendation: Cloud Red on Oakland'
        },
        {
            id: 5,
            title: 'Dog',
            asection: 'The dog only goes out with a collar and leash. If he is barking he needs to go out for at least a walk around the block.', 
            bsection: 'Emergency Vet: (414)246-1357'
        }
    ];

    var $nav = $('#nav-container');
    var $intro = $('#intro');
    var $posts = $('#post-container');

    function initPosts() {
        for (let i = 0; i <data.length; i++) {
            //create elements
            var postId = 'post-' + data[i].id,
                $post = $('<section class="post"></section>'),
                $title = $('<h2 class="title"></h2>'),
                $asection = $('<p></p>'),
                $bsection = $('<p class="bsection"></p>'),
                $navItem = $('<li></li>');

            //add post data
            $title.text(data[i].title);
            $asection.text(data[i].asection);
            $bsection.text(data[i].bsection);

            //add nav item data
            $navItem.attr('id', data[i].id);
            $navItem.text(data[i].title);

            //combine post element
            $post.attr('id', postId);
            $post.append($title);
            $post.append($asection);
            $post.append($bsection);

            //add post and nav elements to page
            $posts.append($post);
            $nav.append($navItem);

            //wire up nav item click event handler
            $navItem.on('click', function() {
                var id = $(this).attr('id');
                $posts.children().hide();
                $posts.find('#post-' + id).fadeIn();
            });

            //hide all posts and show the intro
            $posts.children('.post').hide();
            $intro.fadeIn(1000);
        }
    }

    initPosts();
});