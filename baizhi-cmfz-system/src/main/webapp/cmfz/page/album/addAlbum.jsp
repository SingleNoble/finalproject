<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<script>
    $(function () {
        $('#fb11').filebox({
            buttonText: '专辑封面',
            buttonAlign: 'right',
            accept:'.jpg,.png',
        });
    });
    function saveImg() {
        $("#uploadImg").form('submit',{
            url:'${pageContext.request.contextPath}/imgUpload/upload',

            success:function(imgpath){

                $("#imgpath11").val(imgpath);

                $.messager.show({
                    title:'提示',
                    msg:'添加成功!!',
                    timeout:1000,

                });
            }
        });
    }
</script>


<form id="uploadImg" method="post" enctype="multipart/form-data">
    <div align="center" style="margin-top: 40px;">
        <input id="fb11" class="easyui-filebox" name="multipartFile" style="width:180px">
        <a id="save" href="javascript:;" onclick="saveImg();" class="easyui-linkbutton" data-options="iconCls:'icon-save'">上传</a>
    </div>
</form>

<form id="ffi" method="post" ><br/>

        <div align="center">
            名称：<input class="easyui-textbox" name="name"  style="width:200px"/>
        </div><br/>
        <div align="center">
            评分：<input class="easyui-numberbox" name="grade"  style="width:200px"/>
        </div><br/>
        <div align="center">
            作者：<input class="easyui-textbox" name="author"  style="width:200px"/>
        </div><br/>
        <div align="center">
            播音：<input class="easyui-textbox" name="teller" style="width:200px"/>
        </div><br/>
        <div align="center">
            集数：<input class="easyui-textbox" name="num"  style="width:200px" />
        </div><br/>
        <div align="center">
            简介：<textarea  name="content" required="required" style="width:200px;height:80px"/>
        </div><br/>
        <div align="center">
            <input id="imgpath11" hidden style="width:200px" name="imgpath" />
        </div><br/>

    </form>
