
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
    var user = {};
    $('#buttonId').click(function () {
        user.username =  $('#username').val();
        user.paswword = $('#password').val();
        user.confirmPassword = $('#confirmPassword').val();
        var userObj = JSON.stringify(user);

        $.ajax({
            url : 'saveUserAjax',
            type : "POST",
            data : userObj,

            dataType : "json"
            // success : function (data) {
            //     $('#result').html(data);
            //     alert(data);
            // }
        });
    });
});
/*------------------------


 */



/*************************************************************************************************************************/





