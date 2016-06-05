/**
 * Created by zxy on 6/4/2016.
 */
function urlcheck() {
    var url = window.location.href;
    var urlend = url.substr(url.lastIndexOf('/') + 1);
    switch (urlend){
        case "main":
            document.getElementById("home").classList = "active";
            document.getElementById("userdiv").classList = "btn-toolbar hidden";
            break;
        case "search":
            document.getElementById("home").classList = "active";
            document.getElementById("userdiv").classList = "btn-toolbar hidden";
            break;
        case "notice":
            document.getElementById("notice").classList = "active";
            document.getElementById("userdiv").classList = "btn-toolbar hidden";
            break;
        case "users":
            document.getElementById("user").classList = "active";
            document.getElementById("userdiv").classList = "btn-toolbar";
            break;
        case "usersAll":
            document.getElementById("user").classList = "active";
            document.getElementById("userdiv").classList = "btn-toolbar";
            break;
        case "userAdd":
            document.getElementById("user").classList = "active";
            document.getElementById("userdiv").classList = "btn-toolbar";
            break;
        case "usersAdd":
            document.getElementById("user").classList = "active";
            document.getElementById("userdiv").classList = "btn-toolbar";
            break;
        case "admin":
            document.getElementById("admin").classList = "active";
            document.getElementById("userdiv").classList = "btn-toolbar hidden";
            break;
        default:
            break;
    }
}