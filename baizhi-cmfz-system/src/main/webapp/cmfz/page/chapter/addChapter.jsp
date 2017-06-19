<script>
    $(function () {
        $('#fb2').filebox({
            buttonText: '选择音频',
            buttonAlign: 'right',
        });
    });
    function saveM() {
        $("#uploadM").form('submit',{
            url:'${pageContext.request.contextPath}/chapter/add',

            success:function(){
                $("#dac").dialog('close',true).html("");
                $("#cht").datagrid('reload');
                $.messager.show({
                    title:'提示',
                    msg:'添加成功~~~~',
                    timeout:2000,

                });
            }
        });
    }
</script>
<div style="text-align: center;">
    <form id="uploadM" method="post" enctype="multipart/form-data">
        <div style="margin-top: 40px;">
            <input id="fb2" class="easyui-filebox" name="ff" style="width:180px">
            <a id="save" href="javascript:;" onclick="saveM();" class="easyui-linkbutton" data-options="iconCls:'icon-save'">上传</a>
        </div>
        <div>
            <input type="text" name="album.id" hidden value="${param.albumId}"/>
        </div>
    </form>
</div>