<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<script>
    var $manager;
    $(function () {
        $manager=$("#manager");
        $manager.datagrid({
            url:"<c:url value="/manager/queryByPage"/>",
            method:"post",
            fit:true,
            pagination:true,
            pageNumber:1,
            pageList:[2,4,6,8,10],
            pageSize:2,
            fitColumns:true,
            columns:[[
                {field:"id",title:"编号",width:140},
                {field:"name",title:"姓名",width:40},
                {field:"phone",title:"手机号",width:80},
                {field:"o",title:"操作",width:80,
                    formatter:function (value,row,index) {
                        var id=row.id;
                        return "<a class='del' onClick=\"delManager('"+ id +"')\" href='javascript:void(0);'>[删除]</a>&nbsp;&nbsp;" +
                                "<a class='change' onClick=\"editManager('"+ id +"')\" href='javascript:void(0);'>[编辑]</a>";
                    }
                }
            ]],

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

    function delManager(id) {
        $.messager.confirm("提示","您确定要删除吗?",function(r){
            if(r){
                $.post("<c:url value='/manager/delete'/>",{"id":id},function(result){
                    $manager.datagrid('reload');
                    $.messager.show({
                        title:'提示',
                        msg:result.message,
                        timeout:2000,
                    });
                });
            }
        });
    }


    function editManager(id) {
        $manager.dialog({
            title:'修改信息',
            iconCls:'icon-edit',
            width:400,
            height:300,

            href:"${pageContext.request.contextPath}/cmfz/page/manager/updateManager.jsp?id="+id,

            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:function (){
                    $("#managerForm").form('submit',{
                        url:"<c:url value='/manager/update'/>",

                        success:function(result){
                            $manager.dialog('close',true).html("");
                            $manager.datagrid('reload');
                        }
                    });
                },
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function (){
                    $manager.dialog('close',true).html("");
                },
            }]
        });
    }

</script>
<table id="manager"></table>
<div id=""></div>
