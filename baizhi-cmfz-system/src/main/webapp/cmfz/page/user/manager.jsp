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
            pageList:[2,4,6,8],
            pageSize:2,
            fitColumns:true,
            columns:[[
                {field:"id",title:"编号",width:140},
                {field:"name",title:"姓名",width:40},
                {field:"phone",title:"手机号",width:80},
                {field:"o",title:"操作",width:80,
                    formatter:function (value,row,index) {
                        var id=row.id;
                        return "<a class='del' onClick=\"drop('"+ id +"')\" href='javascript:;'>[删除]</a>&nbsp;&nbsp;<a class='change' href=''>[编辑]</a>";
                    }
                }
            ]],
            toolbar: [{
                iconCls: 'icon-add',
                handler: function(){
                    $('#addEmp').dialog({
                        title: 'add Emp',
                        width: 300,
                        height: 200,
                        href: '${pageContext.request.contextPath}/easyui/page/addEmp.jsp',
                        buttons:[{
                            text:'保存',
                            plain:true,
                            iconCls:'icon-save',
                            handler:function(){
                                $("#addEmpForm").form('submit',{
                                    url:'${pageContext.request.contextPath}/emp/add',
                                    success:function () {
                                        $emps.datagrid('reload');
                                        $addEmp.dialog('close',true);
                                    }
                                });
                            },
                        },{
                            text:'关闭',
                            plain:true,
                            iconCls:'icon-cancel',
                            handler:function(){
                                $addEmp.dialog('close',true);
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
</script>
<table id="manager"></table>
<div id=""></div>
