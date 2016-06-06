/**
 * Created by zxy on 6/6/2016.
 */
function delusers() {
    var checkItems = document.getElementsByName("checkItem");
    var count = 0;
    var items = document.getElementsByName("item");
    var json = {};
    for (var i = 0; i < checkItems.length; i++) {
        if (checkItems[i].checked) {
            count++;
            json[count] = items[i].innerHTML;
        }
    }
    $.ajax({
        type: "POST",
        url: "/view/admin/delete",
        data: json, //组装参数
        dataType: "json"
    });
}
function restoreusers() {
    var checkItems = document.getElementsByName("checkItem");
    var count = 0;
    var items = document.getElementsByName("item");
    var values = new Array();
    for (var i = 0; i < checkItems.length; i++) {
        if (checkItems[i].checked) {
            values[count] = items[i].innerHTML;
            count++;
        }
    }
    alert(count + "      " + values[0]);
}