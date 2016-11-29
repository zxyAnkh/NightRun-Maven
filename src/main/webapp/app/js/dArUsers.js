/**
 * 删除与恢复用户
 * Created by zxy on 2016/7/8.
 */
function delusers() {
    var checkItems = document.getElementsByName("checkItem");
    var items = document.getElementsByName("item");
    var str = "";
    for (var i = 0; i < checkItems.length; i++) {
        if (checkItems[i].checked) {
            str += items[i].innerHTML;
        }
    }
    if (str != "") {
        $.ajax({
            type: "DELETE",
            url: "/ntr/admin/delete",
            data: str //组装参数
        });
    }
}
function resuser() {
    var checkItems = document.getElementsByName("checkItem");
    var items = document.getElementsByName("item");
    var str = "";
    for (var i = 0; i < checkItems.length; i++) {
        if (checkItems[i].checked) {
            str += items[i].innerHTML;
        }
    }
    if (str != "") {
        $.ajax({
            type: "PUT",
            url: "/ntr/admin/restore",
            data: str //组装参数
        });
    }
}