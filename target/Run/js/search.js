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
    else if(type == "全部")
        findAll();
}
function findRun() {
    var keyword = document.getElementById("ksearch").value;
    if(keyword!=null && ""!=(keyword))
        location.href = "search?type=rkeyword&keyword=" + keyword;
}
function findUser() {
    var keyword = document.getElementById("ksearch").value;
    if(keyword!=null && ""!=(keyword))
        location.href = "search?type=skeyword&keyword=" + keyword;
}
function findStatistics() {
    var keyword = document.getElementById("ksearch").value;
    if(keyword!=null && ""!=(keyword))
        location.href = "search?type=statistics&keyword=" + keyword;
}
function findAll(){
    var keyword = document.getElementById("ksearch").value;
    if(keyword!=null && ""!=(keyword))
        location.href = "search?type=all&keyword=" + keyword;
}