/**
 * 批量删除操作
 * @constructor
 */
var Model = function () {
    // 存放ID的数组
    var idArray;
    // 获取 checkbox
    var _checkbox = App.getCheckbox();

    /**
     * 关闭模态框
     */
    var handlerCloseModel = function () {
        $("#btnModalOK").bind("click",function () {
            $("#modal-default").modal("hide");
        });

    };

    /**
     * 批量删除
     */
    var handlerDeleteMulti = function () {
        idArray = new Array();

        var _checkbox = App.getCheckbox();

        /**
         * 选中元素 id 放入数组
         */
        _checkbox.each(function () {
            var _id = $(this).attr("id");
            if (_id != null && _id != "undefine" && $(this).is(":checked")) {
                idArray.push(_id);
            }

        });

        // 如果没有选，则弹出框警告
        if (idArray.length === 0)   {
            $("#modal-message-user0").html("您还没有选择任何要删除的数据，请至少选择一项");
            $("#model-message-user1").html("改操作属于用户管理的模态框操作");
        } else {
            $("#modal-message-user0").html("您确定要删除这些数据项吗");
        }

        $("#modal-default").modal("show");
    };

    /**
     * ajax 请求提交数据给后台
     */
    var handlerSendData = function () {
        $("#btnModalOK").bind("click",function () {
            del(idArray,"/user/delete");

        });



        function del(idArray,url) {

            if (idArray.length == 0)    {   // 数组没有数据则隐藏该模态框
                $("#modal-default").modal("hide");
            } else { // 提交数据到后台
                console.log("提交数据到后台");
                // TODO ajax简单做个笔记
                $.ajax({
                   "url": url,
                   "type": "POST",
                   "data": {"ids": idArray.toString()},
                   "dataType": "JSON",
                   "ok": function (data) {
                       console.log(data);

                   }
                });
            }

        }

    };
    

    return {
        init: function () {
            handlerCloseModel();
            handlerDeleteMulti();
            handlerSendData();
        }
    }

}();

/**
 * 导入js直接生效
 */
// $(document).ready(function () {
//     Model.init();
//
// })

/**
 * 若补设置为导入js就生效，需要onclick引用，例如 Model.init()
 */