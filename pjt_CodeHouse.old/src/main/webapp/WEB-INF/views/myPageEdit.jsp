<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>codehouse</title>
    <!--bootstrap-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
    <!--summernote-->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.js"></script>


    <style>
        html {
            height: 100%;
            overflow: hidden;
        }


        body {
            margin: 0;
            padding: 0;
            perspective: 1px;
            transform-style: preserve-3d;
            height: 100%;
            overflow-x: hidden;
            overflow-y: auto;
            font-family: "Luna";
            background: #454c55;

        }

        .mypage-main {
            background: white;
            padding: 30px;
            border-radius: 5px;

        }

        .hide {
            display: none;
        }
    </style>

</head>

<body>
    <jsp:include page="/common/topnav"></jsp:include>



    <div class="container" style="margin-top: 100px;">
        <div class="row">
            <div class="col-lg">
                <div class="mypage-main">


                    <h3>내정보</h3>
                    <div class="form-group">
                        <img id="userImage" src="../../resources/imgs/noUserImage.png" class="rounded" style="width: 150px;" />
                    </div>

                    <div class="form-group">
                        <label for="inputId">아이디</label>
                        <input type="text" class="form-control" id="inputId" placeholder="아이드를 입력해 주세요">
                    </div>


                    <div class="form-group">
                        <label for="inputNickName">닉네임</label>
                        <input type="text" class="form-control" id="inputNickName" placeholder="닉네임을 입력해 주세요">
                    </div>
                    <div class="form-group">
                        <label for="inputEmail">이메일</label>
                        <input type="text" class="form-control" id="inputName" placeholder="이메일을 입력해 주세요">
                    </div>

                    <div class="form-group">
                        <label for="inputPassword">비밀번호</label>
                        <input type="password" class="form-control" id="inputPassword" placeholder="비밀번호를 입력해주세요">
                    </div>
                    <div class="form-group">
                        <label for="inputPasswordCheck">비밀번호 확인</label>
                        <input type="password" class="form-control" id="inputPasswordCheck" placeholder="비밀번호 확인을 위해 다시한번 입력 해 주세요">
                    </div>
                    <div class="text-center">
                        <button type="button" class="btn btn-primary">
                            정보 수정
                        </button>

                    </div>

                    <input style="visibility: hidden;" type="file" accept="image/*" multiple="false" class="form-control" id="inputImage">

                </div>
            </div>
        </div>


    </div>
    <script>
        //이미지 업로드 AJAX
        // 이미지 업로드가 session["mem_id"]에 종속됨 없으면 업로드 불가
        function sendFile(file) {

            var formData = new FormData();
            formData.append('file', $('#inputImage')[0].files[0]);
            $.ajax({
                type: 'post',
                url: './uploadimg.action',
                data: formData,
                success: function(status) {
                    if (status != 'error') {
                        var my_path = status;
                        $("#userImage").attr("src", my_path);
                    }
                },
                processData: false,
                contentType: false,
                // 아래 error 함수를 이용해 콘솔창으로 디버깅을 한다.
                error: function(jqXHR, textStatus, errorThrown) { 
                    console.log(jqXHR.responseText); 
                }
            });
        }

        $(document).ready(function() {
            // test라는 클래스를가진 div를 클릭할 경우 "테스트입니다요."라는 alert가 뜬다.
            $("#userImage").on("click", function() {
                document.getElementById('inputImage').click();
            });
        });
    </script>

</body>

</html>