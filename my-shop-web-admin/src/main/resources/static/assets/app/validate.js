/**
 * 封装的 表单验证（前端页面验证）
 */

/**
 * 函数对象
 * 闭包，私有属性
 * @constructor
 */
var Validate = function () {

    /**
     * 初始化 jquery validation
     * 这才是函数，上面的不是
     * 私有方法，不可以被引用
     */
    var handlerInitValidate = function () {
        /**
         * 指定哪个表单引用该验证
         */
        $("#inputForm").validate({
            errorElement: 'span',
            errorClass: 'help-block',

            errorPlacement: function (error, element) {
                element.parent().parent().attr("class", "form-group has-error");
                error.insertAfter(element);
            }
        });
    };

    /**
     * 增加自定义验证规则
     */
    var handlerInitCustomValidate = function () {
        $.validator.addMethod("mobile", function(value, element) {
            var length = value.length;
            var mobile =  /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;
            return this.optional(element) || (length == 11 && mobile.test(value));
        }, "手机号码格式错误");
    }

    /**
     * 公共的方法，可以被引用
     * 可以调用本js里的私有方法
     */
    return  {
        /**
         * 初始化
         */
        init: function()  {
                handlerInitValidate();
                handlerInitCustomValidate();

        }
    }
}();

/**
 * 方法执行完后直接引用js
 * TODO 做个笔记 在jquery里面
 */
$(document).ready(function () {
    Validate.init();
});

