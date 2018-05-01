/* getFormValues()
 * ======
 * 获取所有表单元素.
 *
 * @Usage: $('#from').getFormValues()
 *
 */
(function ($) {
    var _formValues = {}, _chkName = [];
    $.fn.getFormValues = function () {
        _formValues = {}, _chkName = [];
        this.find("[name][type != 'button'][type != 'submit'][type != 'reset']").each(function () {
            var _this = this;
            switch (_this.tagName.toLowerCase()) {
                case "input":
                    processInput(_this);
                    break;
                case "textarea":
                    _formValues[_this.name] = $.trim($(_this).val());
                    break;
                case "select":
                    _formValues[_this.name] = $(_this).val();
                    break;
                default:

                    break;
            }
        });
        return _formValues;
    }

    function processInput(_input) {
        var nodetype = _input.type.toLowerCase();

        if (nodetype == "button" || nodetype == "submit" || nodetype == "reset") {
            return;
        }
        if (nodetype != "radio" && nodetype != "checkbox") {
            _formValues[_input.name] = $.trim(_input.value);
            return;
        }

        if (nodetype == "radio") {
            if (_input.checked) {
                _formValues[_input.name] = _input.value;
            }
            return;
        }

        if (nodetype == "checkbox") {
            if (("," + _chkName.join(',') + ",").indexOf(("," + _input.name + ",")) < 0) {
                _chkName.push(_input.name);
                var tempValue = [];
                $("input:checkbox[name='" + _input.name + "']").each(function (index, item) {
                    if (item.checked) {
                        tempValue.push(item.value);
                    }
                });
                _formValues[_input.name] = tempValue.join(",");
            }
            return;
        }
        console.error('<<<<未知表单--------- ');
        console.error(_input)
        console.error('>>>>未知表单--------- ');
    }

})(jQuery);


/* Date.format()
 * ======
 * 格式化日期.
 *
 * @Usage: new Date().format('yyyy-MM-dd HH:mm:ss')
 *
 */
Date.prototype.format = function (fmt) {
    var date = {
        "M+": this.getMonth() + 1,
        "d+": this.getDate(),
        "h+": this.getHours() % 12 == 0 ? 12 : this.getHours() % 12,
        "H+": this.getHours(),
        "m+": this.getMinutes(),
        "s+": this.getSeconds()
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var each in date) {
        if (new RegExp("(" + each + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (date[each]) : (("00" + date[each]).substr(("" + date[each]).length)));
        }
    }
    return fmt;
};


/* dateTimeFormatter()
 * ======
 * 格式化为yyyy-MM-dd HH:mm:ss.
 *
 * @Usage: dateTimeFormatter(毫秒值)
 *
 */
function dateTimeFormatter(value) {
    if (null == value) {
        return "";
    }
    return new Date(value).format("yyyy-MM-dd HH:mm:ss");
}


/* dateFormatter()
 * ======
 * 格式化为yyyy-MM-dd
 *
 * @Usage: dateFormatter(毫秒值)
 *
 */
function dateFormatter(value) {
    if (null == value) {
        return "";
    }
    return new Date(value).format("yyyy-MM-dd");
}


/* showMessageDialog()
 * ======
 * 操作提示
 *
 * @Usage: showMessageDialog('操作成功',1000)
 *
 */
function showMessageDialog(msg, timeout) {
    $("#message-info").text(msg);
    $("#message-dialog").modal("show");
    if (undefined !== timeout) {
        setTimeout('$("#message-dialog").modal("hide")', timeout);
    }
}

function showConfirmDialog(msg) {
    $("#confirm-dialog-body").text(msg);
    $("#confirm-dialog").modal({backdrop: 'static', keyboard: true});
}
