
var blog_editor={
    URL:{
        add_submit: function () {
            return '/blog/submit/addtion';
        },
        update_submit:function () {
            return '/blog/submit/update';
        }
    },

    add_commit: function () {
        var content = UE.getEditor('editor').getContent();
        var title = $('#blog_title').val();
        console.log(content);

        $.ajax({
            url:blog_editor.URL.add_submit(),
            type:'post',
            data:{bContent:content,title:title},
            dataType:'json',
            success:function (data) {
                if (data.success) {
                    alert("success");
                }
            }
        });
    },

    update_commit: function () {
        var content = UE.getEditor('editor').getContent();
        var title = $('#blog_title').val();
        var blogId = $('#blog_id').val();

        $.ajax({
            url:blog_editor.URL.update_submit(),
            type:'post',
            data:{bContent:content,title:title,blogId:blogId},
            dataType:'json',
            success:function (data) {
                if (data.success) {
                    alert("success");
                }
            }
        });
    }

};


var comment_controller = {
    URL:{
        add:function (blogId) {
            return '/comment/' + blogId + '/spoken';
        },

        delete: function (commentId) {
            return '/comment/' + commentId + '/delete';
        }
    },

    add:function (blogId) {

        var speech = $('#speech').val();
        console.log(speech);
        $.ajax({
            url:comment_controller.URL.add(blogId),
            type:'post',
            data:{speech: speech},
            dataType:'json',
            success: function (data) {
                if (data.success) {
                    window.location.reload();
                }
            }
        })
    },

    delete: function (commentId) {

        $.ajax({
            url:comment_controller.URL.delete(commentId),
            type:'get',
            dataType:'json',
            success: function (data) {
                if (data.success) {
                    window.location.reload();
                }
            }
        });
    }
};

function uri_back() {
    var href = window.location.href;
    console.log(href);
}