<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@include file="/chiming/page/util/util.jsp"%>
<html>
<head>
    <title>持名法州后台管理系统登录</title>
    <script>
        var $lbtn,$login;
        $(function () {
            $lbtn=$("#lbtn");
            $login=$("#login");
            $lbtn.linkbutton({
                text:'登录',
                width:100,
                plain:true,
            });
        });
        /*function submit() {
            console.log(11111)
            $login.form('submit',{
                url:'${appName}/chiming/page/main/main.jsp',
            });
        }*/
    </script>
    <style>

    </style>
</head>
<body>
    <div style="text-align: center;margin-top: 50px;">
        <h1>持名法州后台管理系统登录</h1>
        <div style="margin-top: 200px;width: 300px;height: 200px;margin-left: 500px">
            <form action="${appName}/chiming/page/main/main.jsp" method="post" id="login">
                <div style="margin-bottom: 10px">
                    <span>用户名:</span>
                    <input id="username"type="text" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
                </div>
                <div>
                    <span>密码&nbsp;&nbsp;:</span>
                    <input id="password" type="password" class="easyui-passwordbox" data-options="required:true"/>
                </div>
                <div style="margin-top: 20px">
                    <%--<a  onclick="submit()" id="lbtn" class="easyui-linkbutton"></a>--%>
                    <input type="submit" value="登录" />
                </div>
            </form>
        </div>
    </div>
</body>
</html>
