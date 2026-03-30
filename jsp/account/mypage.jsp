<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> - my page - </h1>
<div class="info-wrap">
     <div class="info-row">
       <div>ID.</div>
       <div>${sessionScope.user.id}</div>
     </div>
</div>
<div class="info-wrap">
     <div class="info-row">
       <div>PW.</div>
       <div>${sessionScope.user.pw}</div>
     </div>
</div>
<div class="info-wrap">
     <div class="info-row">
       <div>NAME.</div>
       <div>${sessionScope.user.name}</div>
     </div>
</div>
<div>
     <button class="movie-btn" onclick="location.href='user-edit'">edit</button>
     <button class="movie-btn" onclick="deleteUser()">delete</button>
    <div class="confirm" style="display: none">
         삭제 시 복구 할 수 없습니다. 계속하시겠습니까? <br>
        <form action="user-delete" method="post">
            <input type="password" name="pw">
            <button class="movie-btn conf">confirm</button>
        </form>
    </div>
</div>

<script>
    function deleteUser(){
        // let ok = confirm("really?");
        // if(ok){
        //     location.href='user-delete?edit_test='+ edit_test;
        //}
        document.querySelector('.confirm').style.display = 'block'

    }

</script>




</body>
</html>
