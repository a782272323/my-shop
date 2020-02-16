/**
 * jQuery Datatables
 */
var Datatables_test1 = function () {

    var handlerdatatables_test1 = function () {
        $(function () {
            $('#example1').DataTable()
            $('#example2').DataTable({
                'paging'      : true,
                'lengthChange': false,
                'searching'   : false,
                'ordering'    : true,
                'info'        : true,
                'autoWidth'   : false
            })
        })

    };

    return {

        init: function () {
            handlerdatatables_test1();

        }
    }
}();

$(document).ready(function () {
    Datatables_test1.init();
});