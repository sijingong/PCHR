/**
 * 删除合同模板,即取消当前上传的合同模板
 */
function deleteUploadTempFile() {
    if (!window.confirm('确定删除上传的合同模板码?')) {
        return;
    }
    resetUploadForm();
}

/**
 * 重置上传form表单信息
 */
function resetUploadForm() {
    $('#tempFiles').val('');
    $('#uploadControlDiv').html('');
    $('#tempFilePath').val('');
    $('#uploadBut').attr("disabled", false)
}

/**
 * 创建合同模板
 */
function createTemp() {
    let tempName = $(':input[name="tempName" ]').val();
    if ('' == tempName) {
        alert('请输入合同模板名称');
        return;
    }
    if (tempName.match(/\s/g) != null) {
        alert('合同模板名称不能含有空格、回车、换行等空白字符!');
        return;
    }
    let tempFilePath = $('#tempFilePath').val();
    if ('' == tempFilePath) {
        alert('未上传合同模板文件');
        return;
    }
    if (!window.confirm('确定要添加合同模板吗?')) {
        return;
    }
    let formData = $('#createTempForm').serialize();
    $.ajax({
        url: '/contract/template/create',
        type: 'post',
        data: formData,
        contextType: 'application/x-www-form-urlencoded',// 在发送前对所有字符进行编码
        dataType: 'json',
        success: function (jsonData) {
            if (0 != jsonData.status) {
                alert(`添加合同模板失败【${jsonData.message}】`);
                return;
            }
            let rows = jsonData.data;
            if (1 == rows) {
                alert('添加合同模板成功!!');
                //隐藏模态框
                $("#tempModal").hide();
                window.location.reload();//刷新页面
            } else {
                alert('添加合同模板,服务器返回未知操作状态!');
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert(`添加合同模板失败【${errorThrown || textStatus}】`);
        }
    });
}

/**
 * 修改合同模板
 */
function modifyTemp() {
    let tempName = $(':input[name="tempName" ]').val();
    if ('' == tempName) {
        alert('请输入合同模板名称');
        return;
    }
    if (tempName.match(/\s/g) != null) {
        alert('合同模板名称不能含有空格、回车、换行等空白字符!');
        return;
    }
    let tempFilePath = $('#tempFilePath').val();
    if ('' == tempFilePath) {
        alert('未上传合同模板文件');
        return;
    }
    if (!window.confirm('确定要修改合同模板吗?')) {
        return;
    }
    let formData = $('#modifyTempForm').serialize();
    $.ajax({
        url: '/contract/template/modify',
        type: 'post',
        data: formData,
        contextType: 'application/x-www-form-urlencoded',// 在发送前对所有字符进行编码
        dataType: 'json',
        success: function (jsonData) {
            if (0 != jsonData.status) {
                alert(`修改合同模板失败【${jsonData.message}】`);
                return;
            }
            let rows = jsonData.data;
            if (1 == rows) {
                alert('修改合同模板成功!!');
                //隐藏模态框
                $("#tempModal").hide();
                window.location.reload();//刷新页面
            } else {
                alert('修改合同模板,服务器返回未知操作状态!');
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert(`修改合同模板失败【${errorThrown || textStatus}】`);
        }
    });
}

/**
 * 加载合同模板信息
 * @param tempId
 */
function loadTempData(tempId) {
    $.ajax({
        url: '/contract/template/load',
        type: 'get',
        data: {temp_id: tempId},
        dataType: 'json',
        success: function (jsonData) {
            let status = jsonData.status;
            if (0 != status) {
                alert(`加载合同模板数据失败,原因:${jsonData.message}`);
                return;
            }
            //保存原始数据,即挂在到window对象下
            temp = jsonData.data;
            //初始化合同模板表单数据
            $(':text[name="tempName"]').val(temp.tempName);
            $('#modifyTempForm select[name="tempType"]').val(temp.tempType);
            $('#modifyTempForm select[name="tempState"]').val(temp.tempState);
            $(':hidden[name="tempFilePath"]').val(temp.tempFilePath);
            //设置合同模板文件信息
            $('#tempFiles').val('');//清空上传文件
            $('#uploadControlDiv').append(`<span class="temp-name-span"  data-id="${temp.tempId}" onclick="viewTemp(this)"><img src="/static/img/pdf_icon.png" title="预览">${temp.tempName}.pdf</span>`);
            $('#uploadControlDiv').append(`<span class="glyphicon glyphicon-remove temp-remove" style="color: red;" title="删除模板文件" onclick="deleteUploadTempFile()"></span>`);
            $('#uploadBut').attr("disabled", true);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert(`加载合同模板数据失败,原因:${textStatus || errorThrown}`);
        }
    });
}

/**
 * 上传合同模板文件
 * @returns {boolean}
 */
function uploadTempFile() {
    let tempName = $(':input[name="tempName" ]').val();
    if ('' == tempName) {
        alert('请输入合同模板名称');
        return;
    }
    if (tempName.match(/\s/g) != null) {
        alert('合同模板名称不能含有空格、回车、换行等空白字符!');
        return;
    }
    let files = $('#tempFiles')[0].files;
    let len = files.length;
    if (0 == len) {
        alert("未选择任何合同模板文件");
        return false;
    }
    if (len > 1) {
        alert("目前仅支持上传单个合同模板文件");
        return false;
    }
    let file = files[0];
    let fileName = file.name;
    if (!fileName.toLowerCase().endsWith('.pdf')) {
        alert("合同模板格式或文件类型不对【" + fileName + "】");
        $('#tempFiles').val("");//清空上传文件
        return false;
    }
    //利用jQuery AJAX异常上传合同模板文件
    let formData = new FormData();
    formData.append('temp_files', file);
    formData.append('temp_name', tempName);
    $.ajax({
        url: '/contract/template/upload',
        type: "POST",
        data: formData,
        dataType: 'json',
        processData: false,
        async: false,
        contentType: false,
        success: function (jsonData) {
            let status = jsonData.status;
            if (0 != jsonData.status) {
                alert(`上传合同模板失败【${jsonData.message}】`);
                return;
            }
            alert('上传合同模板成功!!!')
            let temp = jsonData.data;
            console.info(temp);
            $('#tempFiles').val('');//清空上传文件
            $('#uploadControlDiv').append(`<span class="temp-name-span" onclick="onlinePreview('${temp.tempURL}')"><img src="/static/img/pdf_icon.png" title="预览">${temp.tempName}.pdf</span>`);
            $('#uploadControlDiv').append(`<span class="glyphicon glyphicon-remove temp-remove" style="color: red;" title="删除合同模板文件" onclick="deleteUploadTempFile()"></span>`);
            $('#tempFilePath').val(temp.tempFilePath);
            //禁用上传按钮
            $('#uploadBut').attr("disabled", true)
        }, error: function () {
            alert('上传合同模板失败');
        }
    });
}