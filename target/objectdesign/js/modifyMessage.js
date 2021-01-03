// 将单元格转化成文本框
function changeTotext(obj) {
    var tdValue = obj.innerText;
    obj.innerText = "";
    var txt = document.createElement("input");
    txt.type = "text";
    txt.value = tdValue;
    txt.id = "_text_000000000_";
    txt.setAttribute("className", "text");
    obj.appendChild(txt);
    txt.select();
}
// 取消单元格中的文本框，并将文本框中的值赋给单元格
function cancel(obj) {
    var txtValue = document.getElementById("_text_000000000_").value;
    obj.innerText = txtValue;
}
/*********************************************/
// 事件
document.ondblclick = function() {
    if(event.srcElement.tagName.toLowerCase() == "span") {
        changeTotext(event.srcElement);
    }
}
document.onmouseup = function() {
    if(document.getElementById("_text_000000000_") && event.srcElement.id != "_text_000000000_") {
        var obj = document.getElementById("_text_000000000_").parentElement;
        cancel(obj);
    }
}
