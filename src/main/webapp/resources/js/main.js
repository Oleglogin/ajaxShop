
/*------------------
    check Password
--------------------*/

function doAjax() {
    $.ajax({
        url : 'checkStrength.html',
        data: ({password : $('#password').val()}),
        success: function (data) {
            $('#strengthValue').html(data);
        }
    });
}
/*------------------------
        saveUser
 */
$(document).ready(function () {
    $('#buttonId').click(function () {
        var username =  $('#username').val();
        var password = $('#password').val();
        var confirmPassword = $('#confirmPassword').val();
        $.ajax({
            url : 'saveUserAjax2',
            type : "POST",
            data: ({username : username,
                    password : password,
                    confirmPassword : confirmPassword}),
            dataType : "html",
            success : function (data) {
                $('#result').html(data);
            }
        });
    });
});


$(document).ready(function () {
    $('#ajaxSaveProduct').click(function () {
        var productBrand =  $('#productBrand').val();
        var productModel = $('#productModel').val();
        var description = $('#description').val();
        var price = $('#price').val();
        var productImg = $('#productImg').val();
        var category = $('#category').val();
        var subCategory = $('#subCategory').val();
        var available = $('#available').val();
        // alert(price);
        $.ajax({
            url : 'saveProduct',
            type : "POST",
            data: ({productBrand : productBrand,
                productModel : productModel,
                description : description,
                price : price,
                // productImg : productImg,
                category : category,
                subCategory : subCategory,
                available : available}),
            dataType : "html",
            success : function (data) {
                $('#errorMess').html(data);
            }
        });
    });
});

/*************************************************************************************************************************/





