<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>codeshare</title>
    <!--bootstrap-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
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

                    
                    <h3 style="">내정보</h3> 
                    <div class="form-group">
                        <img id="userImage" src="../../resources/imgs/noUserImage.png" class="rounded" style="width: 150px;" />
                        
                    </div>
                    <div class="btn btn-primary">
                        정보 수정
                    </div>

                    <div class="form-group">
                        <label for="inputId">아이디</label>
                        <input type="text" class="form-control" readonly />
                    </div>


                    <div class="form-group">
                        <label for="inputNickName">닉네임</label>
                        <input type="text" class="form-control" readonly />
                    </div>
                    <div class="form-group">
                        <label for="inputEmail">이메일</label>
                        <input type="text" class="form-control" readonly />
                    </div>







                    <input style="visibility: hidden;" type="file" accept="image/*" multiple="false" class="form-control" id="inputImage">

                </div>
            </div>
        </div>

        <div class="row">

            <div class="col-lg">
                <div id="viewController" class="btn-group" role="group" style="width: 100%; background: white;">
                    <button type="button" id="showPage1Btn" data-launch-view="page1" class="btn btn-outline-dark active" style="width: 100%;">내가 쓴글</button>
                    <button type="button" id="showPage2Btn" data-launch-view="page2" class="btn btn-outline-dark" style="width: 100%;">내 댓글</button>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="view" id="page1">
                    <table class="table table-hover bg-light align-middle table-bordered">
                        <thead>
                            <tr>
                                <th class="bg-primary" scope="col">#</th>
                                <th class="bg-primary" scope="col">First</th>
                                <th class="bg-primary" scope="col">Last</th>
                                <th class="bg-primary" scope="col">Handle</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                            <tr>
                                <th scope="row">3</th>
                                <td colspan="2">Larry the Bird</td>
                                <td>@twitter</td>
                            </tr>
                            <tr>
                                <th scope="row">4</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                            <tr>
                                <th scope="row">5</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                            <tr>
                                <th scope="row">6</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                            <tr>
                                <th scope="row">7</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                            <tr>
                                <th scope="row">8</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                            <tr>
                                <th scope="row">9</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                            <tr>
                                <th scope="row">10</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="row">
                        <div class="col">
                            <div class="container d-flex justify-content-center">
                                <nav aria-label="Page navigation example">
                                    <ul class="pagination">
                                        <li class="page-item">
                                            <a class="page-link" href="#" aria-label="Previous">
                                                <span aria-hidden="true">&laquo;</span>
                                            </a>
                                        </li>
                                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                                        <li class="page-item">
                                            <a class="page-link" href="#" aria-label="Next">
                                                <span aria-hidden="true">&raquo;</span>
                                            </a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="view hide" id="page2">
                    <table class="table table-hover bg-light align-middle table-bordered">
                        <thead>
                            <tr>
                                <th class="bg-primary" scope="col">#</th>
                                <th class="bg-primary" scope="col">First</th>
                                <th class="bg-primary" scope="col">Last</th>
                                <th class="bg-primary" scope="col">Handle</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                            <tr>
                                <th scope="row">3</th>
                                <td colspan="2">Larry the Bird</td>
                                <td>@twitter</td>
                            </tr>
                            <tr>
                                <th scope="row">4</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                            <tr>
                                <th scope="row">5</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                            <tr>
                                <th scope="row">6</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                            <tr>
                                <th scope="row">7</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                            <tr>
                                <th scope="row">8</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                            <tr>
                                <th scope="row">9</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                            <tr>
                                <th scope="row">10</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="row">
                        <div class="col">
                            <div class="container d-flex justify-content-center">
                                <nav aria-label="Page navigation example">
                                    <ul class="pagination">
                                        <li class="page-item">
                                            <a class="page-link" href="#" aria-label="Previous">
                                                <span aria-hidden="true">&laquo;</span>
                                            </a>
                                        </li>
                                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                                        <li class="page-item">
                                            <a class="page-link" href="#" aria-label="Next">
                                                <span aria-hidden="true">&raquo;</span>
                                            </a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
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
                url: 'memImageUploader.ashx',
                data: formData,
                success: function(status) {
                    if (status != 'error') {
                        var my_path = status;
                        $("#userImage").attr("src", my_path);
                    }
                },
                processData: false,
                contentType: false,
                error: function() {
                    alert("Whoops something went wrong!");
                }
            });
        }

        $(document).ready(function() {
            // test라는 클래스를가진 div를 클릭할 경우 "테스트입니다요."라는 alert가 뜬다.
            $("#userImage").on("click", function() {
                document.getElementById('inputImage').click();
            });
        });

        $(document).ready(function(e) {

            function showView(viewName) {
                $('.view').hide();
                $('#' + viewName).show();
            }

            $('[data-launch-view]').click(function(e) {
                e.preventDefault();
                var viewName = $(this).attr('data-launch-view');
                changeCategoryClass(this);

                showView(viewName);
            });

        });

        function changeCategoryClass(el) {
            var category = document.getElementById('viewController'),
                children = category.children,
                i;

            for (i = 0; i < children.length; i++) {
                children[i].className = 'btn btn-outline-dark';
            }

            if (el) {
                el.className = 'btn btn-outline-dark active';
            }
        }
    </script>

</body>

</html>