<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    var $dg, $df,$dfa;
    $(function () {
        $dg=$("#dgUser");
        $df=$("#dfUser");
        $dfa=$("#dfaUser");
        $dg.datagrid({
            fit:true,
            toolbar:'#tbUser',

            url:"<c:url value='/user/queryByPage'/>",
            columns:[[
                {field:'id',title:'ID',width:40,align:'center'},
                {field:'realname',title:'姓名',width:40,align:'center'},
                {field:'nickname',title:'法号',width:40,align:'center'},
                {field:'sex',title:'性别',with:20,align:'center'},
                {field:'description',title:'签名',width:140,align:'center'},
                {field:'phone',title:'电话',width:100,align:'center'},
                {field:'master',title:'师傅',width:100,align:'center',formatter:function(value,row,index){
                    return row.master.nickname;
                }},
                {field:'address',title:'住址',width:140,align:'center',formatter:function(value,row,index){
                    return row.province.name+row.city.name;
                }},

                {field:'options',title:'操作',width:200,align:'center',formatter:function(value,row,index){
                    return "<a class='del' onClick=\"del('"+row.id+"')\" href='javascript:;'>删除</a>";
                }},

            ]],
            pagination:true,
            pageNumber:1,
            pageSize:2,
            pageList:[2,4,6,8,10],

            onLoadSuccess:function(data) {
                $(".del").linkbutton({
                    plain: true,
                    iconCls: 'icon-remove',
                });
            }
        });

    });
    function del(id) {
        $.messager.confirm("提示","您确定要删除吗?",function(r){
            if(r){
                $.post("<c:url value='/user/delete'/>",{"id":id},function(result){
                    $dg.datagrid('reload');
                    $.messager.show({
                        title:'提示',
                        msg:result.message,
                        timeout:2000,
                    });
                });
            }
        });

    }

</script>

<table id="dgUser"></table>
<div id="tbUser">
    <a href="${pageContext.request.contextPath}/poiExcel/download" class="easyui-linkbutton" data-options="iconCls:'icon-print',plain:true">导出Excel</a>


</div>




