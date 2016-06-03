/**
 * Created by zxy on 6/4/2016.
 */
function urlcheck() {
    var url = window.location.href;
    var urlend = url.substr(url.lastIndexOf('/') + 1);
    switch (urlend){
        case "main":
            document.getElementById("home").classList = "active";
            break;
        case "search":
            document.getElementById("home").classList = "active";
            break;
        case "notice":
            document.getElementById("notice").classList = "active";
            break;
        case "users":
            document.getElementById("user").classList = "active";
            break;
        case "usersAll":
            document.getElementById("user").classList = "active";
            break;
        case "usersAdd":
            document.getElementById("user").classList = "active";
            break;
        case "admin":
            document.getElementById("admin").classList = "active";
            break;
        default:
            break;
    }
}