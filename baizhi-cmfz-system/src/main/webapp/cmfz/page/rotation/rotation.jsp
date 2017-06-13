<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<script>
    var $rtt,$addRtt,$editRtt;
    $(function () {
        $rtt=$("#rtt");
        $addRtt=$("#addRtt");
        $editRtt=$("#editRtt");
        $rtt.datagrid({
            url:"${pageContext.request.contextPath}/rotation/queryByPage",
            method:"post",
            pagination:true,
            pageNumber:1,
            pageList:[2,4,6,8],
            pageSize:2,
            fitColumns:true,
            columns:[[
                {field:"id",title:"编号",width:140},
                {field:"description",title:"描述",width:80},
                {field:"filePath",title:"路径",width:80},
                {field:"o",title:"操作",width:80,
                    formatter:function (value,row,index) {
                        var id=row.id;
                        return "<a class='del' onClick=\"drop('"+ id +"')\" href='javascript:;'>[删除]</a>";
                    }
                }
            ]],
            toolbar: [{
                iconCls: 'icon-add',
                handler: function(){
                    $addRtt.dialog({
                        title: '添加图片',
                        width: 300,
                        height: 200,
                        href: '${pageContext.request.contextPath}/cmfz/page/rotation/add.jsp',
                        buttons:[{
                            text:'保存',
                            plain:true,
                            iconCls:'icon-save',
                            handler:function(){
                                $("#addRttForm").form('submit',{
                                    url:'${pageContext.request.contextPath}/rotation/add',
                                    success:function () {
                                        $rtt.datagrid('reload');
                                        $addRtt.dialog('close',true);
                                    }
                                });
                            }
                        },{
                            text:'关闭',
                            plain:true,
                            iconCls:'icon-cancel',
                            handler:function(){
                                $addRtt.dialog('close',true);
                            }
                        }]
                    });
                }
            }],
            onLoadSuccess:function (data) {
                $(".del").linkbutton({
                    plain:true,
                    iconCls:'icon-remove',
                });
                $(".change").linkbutton({
                    plain:true,
                    iconCls:'icon-edit',
                });
            }
        });
    });
    //删除
    function drop(id){
        $.messager.confirm("提示","您确定要删除吗?",function(r){
            if(r){
                //发送异步请求删除数据
                $.get('${pageContext.request.contextPath}/rotation/drop?id='+id,function (result) {

                },'json');
                $.messager.alert({
                    title:"删除提示",
                    msg:"删除成功"
                });
                $rtt.datagrid('reload');
            }
        });
    }
</script>
<table id="rtt"></table>
<%--添加图片--%>
<div id="addRtt"></div>
<%--修改图片--%>
<div id="editRtt"></div>
