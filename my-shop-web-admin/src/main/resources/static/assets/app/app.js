/**
 * 通用的iCheck
 */
var App = function () {

    /**
     * 初始化 iCheck，私有方法
     */
    var handlerChecobox = function () {
        //iCheck for checkbox and radio inputs
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        })
    };

    /**
     * 把上面的方法暴露出来
     */
    return {
        init: function()    {
            handlerChecobox();
        }

    }

}();

/**
 * 导入js直接生效
 */
$(document).ready(function () {
    App.init();
});