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

        // 判断用户是否选择了数据项
        if (_idArray.length === 0) {
            $("#modal-message-user0").html("您还没有选择任何要删除的数据，请至少选择一项");
            $("#model-message-user1").html("改操作属于用户管理的模态框操作");
        } else { // 如果选了，提示是否删除
            $("#modal-message-user0").html("您确定要删除这些数据项吗");
        }

        // 批量删除按钮弹出模态框
        $("#modal-default").modal("show");

        // 用户选择了数据项，则调用删除方法
        $("#btnModalOK").bind("click", function () {
            handlerDeleteData(url);
        });
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
                       // 请求成功后，无论成功失败需要弹出模态框提示，所以这里需要先解绑模态框
                       $("#btnModalOK").unbind("click");

                       // 请求成功,刷新页面
                       if (data.status === 200) {
                           // 刷新页面
                           $("#btnModalOK").bind("click", function () {
                               window.location.replace("/user/list");
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
     * jQuery 插件 DataTable的封装
     * @param url
     * @param columns
     */
    var handlerInitDataTables = function (url,columns) {

        var _dataTable = $("#dataTable123").DataTable({
            // TODO 这个 jquery 插件的用法，结合这里做一个笔记
            "paging": true, // 左上角选择展示的数据条数
            "stateSave": true, // 开启当前页面处于对应分页的保存状态
            "info": true, // 左下角的信息
            "ordering": false, // 不允许开启排序
            "processing": true, // 若页面加载时间过长的温馨提示
            "searching": false, // 右上角的本地搜索关闭
            "serverSide": true, // 分页给后台做
            // "ajax": "/user/page", // 分页给后台做，后台分页的地址，拿数据的
            "deferRender": true, // 延迟渲染，提高速度
            // 传参数给后台
            "ajax": {
                "url": url,
            },
            // 后台传送的数据用户表格展示
            "columns": columns,
            // 把语言变成中文,可以根据内容自定义
            "language": {
                "sProcessing": "载入中...请耐心等待",
                "sLengthMenu": "当前页面要显示的数据项数 _MENU_ ",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...请耐心等待",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上一页",
                    "sNext": "下一页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            // 表格渲染后回调函数，此处用来激活全选的框样式
            "drawCallback": function( settings ) {
                // 初始化和实现 全选效果
                handlerChecobox();
                handlerCheckboxAll();
            },
        });

        return _dataTable;

    };

    /**
     * 查看用户详情
     * @param url
     */
    var handlerShowDetail = function (url) {
        // 通过 Ajax 请求 html 的方式，将页面装载进模态框中
        $.ajax({
            url: url,
            type: "get",
            dataType: "html",
            success: function (data) {
                $("#modal-detail-user0").html(data);
                $("#modal-detail").modal("show");
            }
        });
        $("#btnModalDetailOk").bind("clikc",function () {
            console.log("hello");
            $("#modal-detail").modal("hide");
        });
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


        // getCheckbox: function() {
        //     return _checkbox;
        // },

        /**
         * 批量删除
         * @param url
         */
        deleteMulti: function (url) {
            handlerDeleteMulti(url);

        },

        /**
         * jquery Datatables插件的参数封装
         * @param url
         * @param columns
         */
        initDataTables: function (url,columns) {
            return handlerInitDataTables(url,columns);
        },

        /**
         * 显示用户信息详情
         * @param url
         */
        showDetail: function (url) {
            handlerShowDetail(url);

        }
    }

}();

/**
 * 导入js直接生效
 */
$(document).ready(function () {
    App.init();
});