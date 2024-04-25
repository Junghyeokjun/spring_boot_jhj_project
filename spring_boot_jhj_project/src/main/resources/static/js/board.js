
let board=(function(){
    function deleteBoard(id) {
        $.ajax({
            type: "DELETE",
            contentType: 'application/json;charset=utf-8',
            url: "/board/" + id,
            success: function (result) {
                console.log(result);
            },
            error: function (e) {
                console.log(e);
            }
        });
        $(this).parent().parent().remove();
    }

    return{
        delete: deleteBoard
    }
})()