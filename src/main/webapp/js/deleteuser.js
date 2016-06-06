/**
 * Created by zxy on 6/6/2016.
 */
function delusers(){
    var checkItems = document.getElementsByName("checkItem");
    var count = 0;
    var items = document.getElementsByName("item");
    var values = new Array();
    for (var i = 0; i < checkItems.length; i++) {
        if(checkItems[i].checked){
            values[count] = items[i].innerHTML;
            count++;
        }
    }
    alert(count + "      " + values[0]);
}
function restoreusers(){
    var checkItems = document.getElementsByName("checkItem");
    var count = 0;
    var items = document.getElementsByName("item");
    var values = new Array();
    for (var i = 0; i < checkItems.length; i++) {
        if(checkItems[i].checked){
            values[count] = items[i].innerHTML;
            count++;
        }
    }
    alert(count + "      " + values[0]);
}