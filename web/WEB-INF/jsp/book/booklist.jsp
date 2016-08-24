<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/15
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>图书列表</title>
</head>
<style type="text/css">
    th {
        background: #00bfff;
    }
    tr {
        text-align: center;
    }
    .text1 {
        width: 30px;
    }
</style>
<script type="text/javascript">
    function logout() {
        if(confirm("是否退出系统?")) {
            window.location.href = '/bookSys/logout';
        }
    }

    function tiao() {
        var pos = document.getElementById("pos");
        if(pos.value <= 0 || pos.value > ${page.totalPageCount}) {
            alert("请输入正确的页码！");
            return;
        }
        window.location.href = "list?<c:if test="${not empty bookType}">bookType=<c:out value="${bookType}&"/></c:if><c:if test="${not empty bookName}">bookName=<c:out value="${bookName}&"/></c:if><c:if test="${not empty isBorrow}">isBorrow=<c:out value="${isBorrow}&"/></c:if>pageNow=" + pos.value;
    }
</script>
<body>
    <h1 align="center">图书借阅系统</h1>
    <table align="center">

        <form method="post" action="list">
            <tr>
            <td colspan="2" align="left">
            图书分类：
            <select name="bookType">
                <option value="" selected="selected">——请选择——</option>
                <c:forEach items="${bookTypes}" var="type">
                    <option value="${type.id}">${type.typeName}</option>
                </c:forEach>
            </select>
            </td>
            <td colspan="2">
            图书名称：
            <input type="text" name="bookName">
            </td>
            <td colspan="1">
            是否借阅：
            <select name="isBorrow">
                <option value="" selected="selected">--请选择--</option>
                <option value="0">未借阅</option>
                <option value="1">已借阅</option>
            </select>
            </td>
                <td colspan="1" align="right">
                    <input type="submit" value="查询">
                </td>
            </tr>
        </form>
        <tr>
            <td colspan="6">
                <div align="right">当前用户：${sessionScope.user.userCode}   <a href="javascript:logout()">退出</a></div>
            </td>
        </tr>


        <tr>
            <th width="120px" >图书编号</th>
            <th width="100px" >图书分类</th>
            <th width="160px">图书名称</th>
            <th width="130px">作者</th>
            <th width="200px">出版社</th>
            <th width="80px">操作</th>
        </tr>
        
        <c:forEach items="${books}" var="book" varStatus="status">
            <tr <c:if test="${status.count%2==0}">bgcolor="#7fffd4" </c:if>>
                <td><c:out value="${book.bookCode}"/></td>
                <td><c:out value="${book.type.typeName}"/></td>
                <td><c:out value="${book.bookName}"/></td>
                <td><c:out value="${book.bookAuthor}"/></td>
                <td><c:out value="${book.publishPress}"/></td>
                <td>
                    <c:if test="${book.isBorrow==0}">
                        <a href="borrow?bookId=${book.bookId}">申请借阅</a>
                    </c:if>
                    <c:if test="${book.isBorrow==1}">
                        <div style="color:red">已借阅</div>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <c:choose>
                <c:when test="${page.totalCount!=0}">
                    <td colspan="6" align="right">
                        <c:choose>
                            <c:when test="${page.hasPre}">
                                <a href="list?<c:if test="${not empty bookType}">bookType=<c:out value="${bookType}&"/></c:if><c:if test="${not empty bookName}">bookName=<c:out value="${bookName}&"/></c:if><c:if test="${not empty isBorrow}">isBorrow=<c:out value="${isBorrow}&"/></c:if>pageNow=${page.pageNow-1}">上一页</a>
                            </c:when>
                            <c:otherwise>
                                <font color="#a9a9a9">上一页 </font>
                            </c:otherwise>
                        </c:choose>

                        <c:choose>
                            <c:when test="${page.hasFirst}">
                                <a href="list?<c:if test="${not empty bookType}">bookType=<c:out value="${bookType}&"/></c:if><c:if test="${not empty bookName}">bookName=<c:out value="${bookName}&"/></c:if><c:if test="${not empty isBorrow}">isBorrow=<c:out value="${isBorrow}&"/></c:if>pageNow=1" >◀</a>
                            </c:when>
                            <c:otherwise>
                                <font color="#a9a9a9">◀</font>
                            </c:otherwise>
                        </c:choose>

                        <c:forEach var="i" begin="${(page.pageNow-1)<=0?1:((page.pageNow+1)>page.totalPageCount?((page.pageNow-2)<=0?1:page.pageNow-2):page.pageNow-1)}" end="${(page.pageNow-1)<=0?((page.pageNow+2)>page.totalPageCount?page.totalPageCount:page.pageNow+2):((page.pageNow+1)>page.totalPageCount?page.totalPageCount:page.pageNow+1)}" step="1">
                            <c:choose>
                                <c:when test="${page.pageNow==i}">
                                    <font color="#a9a9a9">${i}</font>
                                </c:when>
                                <c:otherwise>
                                    <a href="list?<c:if test="${not empty bookType}">bookType=<c:out value="${bookType}&"/></c:if><c:if test="${not empty bookName}">bookName=<c:out value="${bookName}&"/></c:if><c:if test="${not empty isBorrow}">isBorrow=<c:out value="${isBorrow}&"/></c:if>pageNow=${i}">${i}</a>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>

                        <c:choose>
                            <c:when test="${page.hasLast}">
                                <a href="list?<c:if test="${not empty bookType}">bookType=<c:out value="${bookType}&"/></c:if><c:if test="${not empty bookName}">bookName=<c:out value="${bookName}&"/></c:if><c:if test="${not empty isBorrow}">isBorrow=<c:out value="${isBorrow}&"/></c:if>pageNow=${page.totalPageCount}">▶</a>
                            </c:when>
                            <c:otherwise>
                                <font color="#a9a9a9">▶</font>
                            </c:otherwise>
                        </c:choose>

                        <c:choose>
                            <c:when test="${page.hasNext}">
                                <a href="list?<c:if test="${not empty bookType}">bookType=<c:out value="${bookType}&"/></c:if><c:if test="${not empty bookName}">bookName=<c:out value="${bookName}&"/></c:if><c:if test="${not empty isBorrow}">isBorrow=<c:out value="${isBorrow}&"/></c:if>pageNow=${page.pageNow+1}">下一页</a>
                            </c:when>
                            <c:otherwise>
                                <font color="#a9a9a9">下一页</font>
                            </c:otherwise>
                        </c:choose>

                        共<c:out value="${page.totalPageCount}"/>页 到第<input type="text" class="text1" id="pos"/>页 <input type="button" value="确定" onclick="tiao()"/>
                    </td>
                </c:when>
                <c:otherwise>
                    <td align="center" colspan="6" height="30px">
                        <font color="#a9a9a9">对不起，没有符合查询条件的结果！</font>
                    </td>
                </c:otherwise>
            </c:choose>

        </tr>
    </table>
</body>
</html>
