/**
 * Created by zxy on 12/4/2016.
 */

function page() {
    var p = document.getElementById("pageinput").value;
    if (p != null && "" != (p)) {
        var url = window.location.href;
        var urlend = url.substr(url.lastIndexOf('/') + 1);
        var u = urlend.substr(0,urlend.lastIndexOf('&'));
        urlend = urlend.substr(0, urlend.indexOf('?'));
        switch (urlend) {
            case "main":
                location.href = "ntr/admin/main?page=" + p;
                break;
            case "excels":
                location.href = "ntr/admin/excels?page=" + p;
                break;
            case "users":
                location.href = "ntr/admin/users?page=" + p;
                break;
            case "usersAll":
                location.href = "ntr/admin/usersAll?page=" + p;
                break;
            case "search":
                location.href = "ntr/admin/" + u + "&page=" + p;
                break;
            default:
                break;
        }
    }
}