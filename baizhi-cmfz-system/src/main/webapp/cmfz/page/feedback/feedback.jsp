<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<script>
    var $fb;
    $(function () {
        $fb=$("#feedback");

        $fb.datagrid({
            url:"<c:url value='/feedback/queryByPage'/>",
            method:"post",
            pagination:true,
            pageNumber:1,
            pageList:[2,4,6,8],
            pageSize:2,
            fitColumns:true,
            columns:[[
                {field:"id",title:"编号",width:80,align:"center"},
                {field:"content",title:"反馈内容",width:80,align:"center"},
                {field:"user.name",title:"用户",width:80,align:"center",
                    formatter:function (value,row,index) {
                        var name=row.user.nickname;
                        return name;
                    }
                }
            ]],
        })
    });
</script>
<table id="feedback"></table>

