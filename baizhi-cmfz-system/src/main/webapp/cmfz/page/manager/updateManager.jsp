<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<script>

    $(function(){
        $("#managerForm").form("load","<c:url value='/manager/queryOne'/>?id=${param.id}");
    });

</script>
<div style="text-align: center;">
    <form id="managerForm" method="post">
        <div style="margin-top:5px">
            <input id="id"  hidden style="width:200px" name="id"/>
        </div>
        <div style="margin-top:5px">
            姓名:<input id="name" class="easyui-textbox" style="width:200px" name="name"/>
        </div>
        <div style="margin-top:5px">
            手机:<input id="phone" class="easyui-textbox" style="width:200px" name="phone"/>
        </div>
    </form>
</div>