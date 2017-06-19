<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<script>
    var $cht,$dac;
    $(function(){
        $cht = $("#cht");
        $dac = $("#dac");
        $(".btn").linkbutton();
        $cht.datagrid({
            striped:true,
            url:'${pageContext.request.contextPath}/chapter/queryByPage?albumId=${param.albumId}',
            fit:true,
            fitColumns:true,
            pagination:true,
            toolbar:'#tt5',
            pageNumber:1,
            pageSize:10,
            pageList:[10,20,50],
            columns:[[
                {title:'id',field:'id',align:'center',width:300},
                {title:'名字',field:'oldname',align:'center',width:100},
                {title:'下载地址',field:'filepath',align:'center',width:300},
                {title:'大小',field:'filesize',align:'center',width:100},
                {title:'操作',field:'options',align:'center',width:100,
                    formatter:function (value,row,index) {
                        return "<a class='del' onClick=\"delc('"+row.id+"')\">删除</a>";
                    }
                },
            ]],
            onLoadSuccess:function () {
                $(".del").linkbutton({
                    plain:true,
                    iconCls:'icon-remove',
                });
            }
        });
    });
    function delc(id) {
        $.messager.confirm('确认','您确认想要删除记录吗？',function(r){
            if (r){
                $.post('${pageContext.request.contextPath}/chapter/drop',{id:id},function(){
                    $cht.datagrid('reload');
                    $int.datagrid('reload');
                });
                $.messager.show({
                    title:'提示信息',
                    msg:'删除成功！',
                    timeout:1500,
                    showType:'slide'
                });
            }
        });
    };
    function addc() {
        $dac.dialog({
            iconCls:'icon-add',
            title:"添加信息",
            resizable:true,
            width:380,
            height:330,
            href:'${pageContext.request.contextPath}/cmfz/page/chapter/addChapter.jsp?albumId=${param.albumId}',
            buttons:[{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDac,
            }
            ]
        })
    };

    function closeDac() {
        $dac.dialog('close',true);
        $int.datagrid('reload');
    };
</script>
<table id="cht"></table>
<div id="tt5">
    <a href="#" onclick="addc()" class="btn" data-options="iconCls:'icon-add'">添加</a>
</div>
<div id="dac"></div>