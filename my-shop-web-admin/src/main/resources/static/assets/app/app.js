/**
 * 通用的iCheck
 */

var App = function () {

    // iCheck
    var _masterCheckbox ;
    var _checkbox;

    // 用于存放 id 的数组
    var _idArray;

    /**
     * 初始化 iCheck，私有方法
     */
    var handlerChecobox = function () {
        // 激活
        //iCheck for checkbox and radio inputs
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        });

        // 获取控制端 Checkbox
        _masterCheckbox = $('input[type="checkbox"].minimal.icheck_master');
        // 获取全部 Checkbox集合
        _checkbox = $('input[type="checkbox"].minimal');
    };

    /**
     *  实现全选按钮功能
     */
    var handlerCheckboxAll = function () {


        _masterCheckbox.on("ifClicked", function (e) {
            //返回ture 表示为选中
            if (e.target.checked)   {
                _checkbox.iCheck("uncheck");
            }
            // 选中状态
            else {
                _checkbox.iCheck("check");
            }
        });

    };

    /**
     * 批量删除
     */
    var handlerDeleteMulti = function (url) {
        _idArray = new Array();
        /**
         * 选中元素 id 放入数组
         */
        _checkbox.each(function () {
            var _id = $(this).attr("id");
            if (_id != null && _id != "undefine" && $(this).is(":checked")) {
                _idArray.push(_id);
            }
        });

        // 如果没有选，则弹出框警告
        if (_idArray.length === 0)   {
            $("#modal-message-user0").html("您还没有选择任何要删除的数据，请至少选择一项");
            $("#model-message-user1").html("改操作属于用户管理的模态框操作");
        } else { // 如果选了，提示是否删除
            $("#modal-message-user0").html("您确定要删除这些数据项吗");
        }

        // 批量删除按钮弹出模态框
        $("#modal-default").modal("show");

        // 用户选择了数据项，调用删除方法
        $("#btnModalOK").bind("click",function () {
            handlerDeleteData(url);
            // delss();
        });

        // $("#btnModalOK").bind("click",function () {
        //     handlerDeleteData(url);
        // });

        /**
         * 当前私有函数的私有函数
         */
        // function delss() {
        //     $('#modal-default').modal("hide");
        //     // 没有选择数据项的处理
        //     if (_idArray.length === 0)  {
        //
        //     }
        //     // 删除操作
        //     else {
        //         setTimeout(function () {
        //             $.ajax({
        //                 "url": url,
        //                 "type": "POST",
        //                 "data": {"ids" : _idArray.toString()},
        //                 "dataType": "JSON",
        //                 "success": function (data) {
        //                     // 删除成功
        //                     if (data.status === 200)    {
        //                         window.location.reload();
        //                     }
        //                     // 删除失败
        //                     else {
        //                         $("#btnModalOK").unbind("click");
        //                         $("#btnModalOK").bind("click",function () {
        //                             $('#modal-default').modal("hide");
        //                         });
        //
        //                         $("#modal-message-user0").html(data.message);
        //                         $('#modal-default').modal("show");
        //                     }
        //                     console.log(data);
        //
        //                 }
        //             });
        //         },500);
        //     }
        // }
    };

    /**
     * ajax 异步
     * 当前私有函数的私有函数,删除数据
     */
    var handlerDeleteData = function (url) {
        $("#modal-default").modal("hide");

        if (_idArray.length > 0)    {
            // ajax 异步删除操作
            setTimeout(function () {
                $.ajax({
                   "url": url,
                   "type": "POST",
                   "data": {"ids" : _idArray.toString()},
                   "dataType": "JSON",
                   "success": function (data) {
                       // 请求成功后，需要弹出模态框提示，先解绑模态框
                       $("#btnModalOK").unbind("click");

                       //请求成功
                       if (data.status === 200) {
                           // 刷新页面
                           $("#btnModalOK").bind("click", function () {
                               window.location.href("/user/list");
                           });
                       }
                       // 请求失败
                       else {
                           // 确定按钮事件改为隐藏模态框
                           $("#btnModalOK").bind("clikc",function () {
                               $("#modal-default").modal("hide");
                           });
                       }

                       // 因为模态框的提示信息是必须的，所以这里调用模态框
                       $("#modal-message-user0").html(data.message);
                       $("#modal-default").modal("show");
                   }
                });
            },500);//延时操作 500毫秒
        }
    };


    /**
     * 把上面的方法暴露出来
     */
    return {
        /**
         * 初始化的方法
         */
        init: function()    {
            handlerChecobox();
            handlerCheckboxAll();
        },


        getCheckbox: function() {
            return _checkbox;
        },

        /**
         * 批量删除
         * @param url
         */
        deleteMulti: function (url) {
            handlerDeleteMulti(url);

        }
    }

}();

/**
 * 导入js直接生效
 */
$(document).ready(function () {
    App.init();
});