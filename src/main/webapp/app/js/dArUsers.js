/**
 * 删除与恢复用户
 * Created by zxy on 2016/7/8.
 */
function delusers() {
    var checkItems = document.getElementsByName("checkItem");
    var items = document.getElementsByName("item");
    var pojo = {};
    pojo["nos"] = [];
    var len = 0;
    for (var i = 0; i < checkItems.length; i++) {
        if (checkItems[i].checked) {
            pojo["nos"][len] = items[i].innerHTML;
            len++;
        }
    }
    if (pojo["nos"] != null) {
        $.ajax({
            type: "POST",
            url: "/ntr/admin/delete",
            contentType:"application/json;charset=UTF-8",
            data: JSON.stringify(pojo) //组装参数
        });
    }
}
function resuser() {
    var checkItems = document.getElementsByName("checkItem");
    var items = document.getElementsByName("item");
    var pojo = {};
    pojo["nos"] = [];
    var len = 0;
    for (var i = 0; i < checkItems.length; i++) {
        if (checkItems[i].checked) {
            pojo["nos"][len] = items[i].innerHTML;
            len++;
        }
    }
    if (pojo["nos"] != null) {
        $.ajax({
            type: "POST",
            url: "/ntr/admin/restore",
            contentType:"application/json;charset=UTF-8",
            data: JSON.stringify(pojo) //组装参数
        });
    }
}