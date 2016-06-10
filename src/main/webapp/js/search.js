/**
 * Created by zxy on 5/29/2016.
 */
function timeQuery() {
    var stime = document.getElementById("stime").value;
    var etime = document.getElementById("etime").value;
    var sy = stime.substr(0, 4);
    var sM = stime.substr(5, 2);
    var sd = stime.substr(8, 2);
    var ey = etime.substr(0, 4);
    var eM = etime.substr(5, 2);
    var ed = etime.substr(8, 2);
    location.href = "search?type=rtime&keyword=" + sy + sM + sd + ey + eM + ed + ed;
}
function timeChange() {
    var stime = document.getElementById("stime").value;
    var etime = document.getElementById("etime").value;
    if (stime != "" && etime != "" && (Date.parse(etime) - Date.parse(stime) ) >= 0) {
        document.getElementById("time").disabled = false;
        document.getElementById("time").classList = "btn btn-primary";
    }
}
function find() {
    var type=document.getElementById("type").value;
    if(type == "夜跑")
        findRun();
    else if(type == "统计")
        findStatistics();
    else if(type == "用户")
        findUser();
}
function findRun() {
    var keyword = document.getElementById("ksearch").value;
    location.href = "search?type=rkeyword&keyword=" + keyword;
}
function findUser() {
    var keyword = document.getElementById("ksearch").value;
    location.href = "search?type=skeyword&keyword=" + keyword;
}
function findStatistics() {
    var keyword = document.getElementById("ksearch").value;
    location.href = "search?type=statistics&keyword=" + keyword;
}
function searchtype() {
    var url = window.location.href;
    var type = url.substring(url.lastIndexOf("?") + 1,url.lastIndexOf("&"));
    if(type == "type=rkeyword" || type == "type=rtime"){
        document.getElementById("runtable").classList = "table table-striped";
    }else if(type == "type=skeyword"){
        document.getElementById("usertable").classList = "table table-striped";
    }else if(type == "type=statistics"){
        document.getElementById("totaltable").classList = "table table-striped";
    }
}