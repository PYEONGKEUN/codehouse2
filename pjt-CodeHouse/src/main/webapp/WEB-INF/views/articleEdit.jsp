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

        .content {

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
                <div class="content">
                    <form method="post" action="./articleedit.insert">
                        <div class="row">
                            <div class="col">
                                <input name="title" class="form-control form-control-lg" type="text" placeholder="제목">
                            </div>
                        </div>
                        <hr />
                        <div class="row">
                            <div class="col">
                                <textarea id="summernote" name="editordata"></textarea>
                            </div>
                        </div>
                        <hr/>                        
                        <div class="row">
                            <div class="col text-center">
                                <input type="submit" class="btn btn-primary"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>

	<script>
		/* TextArea Summernote */

		$(document).ready(function() {
			$('#summernote').summernote({
				placeholder : '내용을 입력하세요.',
				tabsize : 2,
				height : 450,
				callbacks : {
					onImageUpload : function(files, editor, welEditable) {
						for (var i = files.length - 1; i >= 0; i--) {
							sendFileInSummernote(files[i], this);
						}
					}
				}
			});
		});

		function sendFileInSummernote(file, el) {
			var form_data = new FormData();
			form_data.append('file', file);
			$
					.ajax({
						data : form_data,
						type : "post",
						url: './uploadimg.action',
						enctype : 'multipart/form-data',
						success : function(status) {
							if (status != 'error') {
								var url = status;
								$(el).summernote('editor.insertImage', url);
								$('#imageBoard > ul').append('<li><img src="' + url + '" width="480" height="auto"/></li>');
							}
						},
						processData : false,
						contentType : false,
						 // 아래 error 함수를 이용해 콘솔창으로 디버깅을 한다.
			            error: function(jqXHR, textStatus, errorThrown) { 
			                console.log(jqXHR.responseText); 
			            }
					});

		}
	</script>

</body>

</html>