/**
 * head.jsp 处理页面
 * Created by zxy on 2016/7/7.
 */
function urlcheck() {
    var url = window.location.href;
    var urlend = url.substr(url.lastIndexOf('/') + 1);
    urlend = urlend.substr(0, urlend.indexOf('?'));
    switch (urlend) {
        case "main":
            document.getElementById("home").classList = "active";
            document.getElementById("liDel").classList = "disabled";
            document.getElementById("liRes").classList = "disabled";
            break;
        case "excels":
            document.getElementById("home").classList = "active";
            document.getElementById("liDel").classList = "disabled";
            document.getElementById("liRes").classList = "disabled";
            break;
        case "users":
            document.getElementById("user").classList = "active";
            document.getElementById("liRes").classList = "disabled";
            document.getElementById("ahref").innerHTML = "查看活跃用户" + "<span class=\"caret\"></span>";
            break;
        case "usersAll":
            document.getElementById("user").classList = "active";
            document.getElementById("liDel").classList = "disabled";
            document.getElementById("ahref").innerHTML = "查看注销用户" + "<span class=\"caret\"></span>";
            break;
        case "userAdd":
            document.getElementById("user").classList = "active";
            document.getElementById("liDel").classList = "disabled";
            document.getElementById("liRes").classList = "disabled";
            document.getElementById("ahref").innerHTML = "单独添加用户" + "<span class=\"caret\"></span>";
            break;
        case "usersAdd":
            document.getElementById("user").classList = "active";
            document.getElementById("liDel").classList = "disabled";
            document.getElementById("liRes").classList = "disabled";
            document.getElementById("ahref").innerHTML = "批量添加用户" + "<span class=\"caret\"></span>";
            break;
        case "admin":
            document.getElementById("admin").classList = "active";
            document.getElementById("liDel").classList = "disabled";
            document.getElementById("liRes").classList = "disabled";
            break;
        default:
            document.getElementById("liDel").classList = "disabled";
            document.getElementById("liRes").classList = "disabled";
            break;
    }
}