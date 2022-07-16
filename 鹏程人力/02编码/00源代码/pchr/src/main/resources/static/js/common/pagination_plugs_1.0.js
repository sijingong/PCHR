/**
 * 分页查询简易插件
 * 作者:bnt
 * 说明:如果需要其它控件,自己添加
 */
(function (i) {
    $(function () {
        window.gotoPage = function (current) {
            //设置新的当前页
            $('#current').val(current);
            //提交from表单
            $('form:eq(0)').submit();
        };
        if (0 == $('.pagination').length || 0 == $('#current').length || 0 == $('#totalPage').length || 0 ==
            $('#first').length || 0 == $('#last').length) {
            console.error('缺少分页参数');
            return;
        }
        let current = parseInt($('#current').val()); //当前页号
        let totalPage = parseInt($('#totalPage').val()); //总页数
        let first = parseInt($('#first').val()); //当前版面第一页
        let last = parseInt($('#last').val()); //当前版面最后一页
        if (current <= 0 || totalPage <= 0 || first <= 0 || last <= 0) {
            console.error('分页参数错误');
            return;
        }
        if (current > totalPage || first > totalPage || last > totalPage || first > last) {
            console.error('分页参数错误');
            return;
        }

        if (1 == current) {
            $('.pagination').append('<li class="disabled"><a href="javascript:void(0)">«</a></li>');
        } else {
            $('.pagination').append(`<li><a href="javascript:void(0)" onclick="gotoPage(${current - 1})">«</a></li>`);
        }
        for (let pageNub = first; pageNub <= last; pageNub++) {
            if (current == pageNub) {
                $('.pagination').append(
                    `<li class="disabled"><a href="javascript:void(0)">${pageNub}</a></li>`);
            } else {
                $('.pagination').append(
                    `<li><a href="javascript:void(0)" onclick="gotoPage(${pageNub})">${pageNub}</a></li>`
                );
            }
        }
        if (totalPage == current) {
            $('.pagination').append('<li class="disabled"><a href="javascript:void(0)">»</a></li>');
        } else {
            $('.pagination').append(`<li ><a href="javascript:void(0)" onclick="gotoPage(${current + 1})">»</a></li>`);
        }
    });
})();
