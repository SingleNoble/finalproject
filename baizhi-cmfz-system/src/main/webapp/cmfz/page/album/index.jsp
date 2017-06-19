<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<script>
    var $int,$dai;
    $(function(){
        $int = $("#int");
        $dai = $("#dai");
        $(".btn").linkbutton();
        $int.datagrid({
            striped:true,
            url:'${pageContext.request.contextPath}/album/queryAllByPage',
            fit:true,
            fitColumns:true,
            pagination:true,
            toolbar:'#tt4',
            pageNumber:1,
            pageSize:10,
            pageList:[10,20,50],
            columns:[[
                {field:'id',title:'ID',width:240,align:'center'},
                {field:'name',title:'名称',width:150,align:'center'},
                {field:'author',title:'作者',width:150,align:'center'},
                {field:'teller',title:'播音员',width:150,align:'center'},
                {field:'num',title:'集数',width:150,align:'center'},
                {field:'content',title:'简介',width:150,align:'center'},
                {field:'createdate',title:'创建日期',width:100,align:'center'},
                {field:'grade',title:'评分',width:50,align:'center'},
                {field:'imgpath',title:'封面',width:150,align:'center'},
                {title:'操作',field:'options',width:200,
                    formatter:function (value,row,index) {
                        return"<a class='chapter' onClick=\"chapter('"+row.id+"')\">专辑列表</a>" +
                                "<a class='del' onClick=\"deli('"+row.id+"')\">删除</a>";
                    }
                },
            ]],
            onLoadSuccess:function () {
                $(".del").linkbutton({
                    plain:true,
                    iconCls:'icon-remove',
                });
                $(".look").linkbutton({
                    plain:true,
                    iconCls:'icon-layout_content',
                });
                $(".chapter").linkbutton({
                    plain:true,
                    iconCls:'icon-text_columns',
                });
            }
        });
    })
    function addi() {
        $dai.dialog({
            iconCls:'icon-add',
            title:"添加信息",
            resizable:true,
            width:380,
            height:530,
            href:'${pageContext.request.contextPath}/cmfz/page/album/addAlbum.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:insertInt,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDai,
            }
            ]
        })
    };

    function chapter(id) {
        $dai.dialog({
            title:"章节列表",
            iconCls:'icon-text_columns',
            resizable:true,
            width:1200,
            height:500,
            href:'${pageContext.request.contextPath}/cmfz/page/chapter/index.jsp?albumId='+id,
            buttons:[{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDai,
            }
            ]
        });
    };
    function deli(id) {
        $.messager.confirm('确认','您确认想要删除记录吗？',function(r){
            if (r){
                $.post('${pageContext.request.contextPath}/album/drop',{'id':id},function(){
                    $int.datagrid('reload');
                });
                $.messager.show({
                    title:'我的消息',
                    msg:'删除成功！',
                    timeout:1000,
                    showType:'slide'
                });
            }
        });
    };
    function insertInt() {
        $("#ffi").form('submit',{
            url:'${pageContext.request.contextPath}/album/add',
            success:function () {
                $dai.dialog('close',true).html("");
                $int.datagrid('reload');
                $.messager.show({
                    title:'我的消息',
                    msg:'添加成功！',
                    timeout:1500,
                    showType:'slide'
                });
            }
        })
    };
    function closeDai() {
        $dai.dialog('close',true).html("");
        $int.datagrid('reload');
    }
</script>
    <table id="int"></table>
    <div id="tt4">
        <a href="#" onclick="addi()" class="btn" data-options="iconCls:'icon-add'">添加</a>
    </div>
    <div id="dai"></div>