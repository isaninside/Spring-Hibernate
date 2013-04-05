<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="content">
    <div class="blocksection">
        <h2>List All Dosen</h2>
        <table cellpadding="0" cellspacing="0" border="1" class="display" id="datatables" width="800px">
            <thead>
            <tr>
                <th>NIM</th>
                <th>Nama</th>
                <th style="width:150px;">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${data}" var="mhs">
                <tr>
                    <td>${mhs.nim}</td>
                    <td>${mhs.nama}</td>
                    <td>
                        <div class="buttonWrapper">
                            <a href="<c:url value='/mahasiswa/${mhs.id}' />" class="view">View
                            </a>
                            <a href="<c:url value='/mahasiswa/${mhs.id}/edit' />" class="edit">Edit</a>
                            <a onclick="return confirm('Apakah anda Yakin ?')"
                               href="<c:url value='/mahasiswa/${mhs.id}/delete' />"
                               class="delete">Delete</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot>
            <tr>
                <td colspan="7">
                    <div class="buttonWrapper">
                        <a href="<c:url value='/mahasiswa/new' />" class="view">Create</a>
                    </div>
                </td>
            </tr>
            </tfoot>
        </table>
    </div>
</div>
