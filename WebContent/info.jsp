<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<p> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/info.css" />
<link rel="stylesheet" type="text/css" href="css/note.css" />
<script type="text/javascript"  src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript"  src="js/jquery_rotate.js"></script>
<script type="text/javascript"  src="js/info.js"></script>
</head>
<body>

 
 	<div  class="banner">
  
 	<div class="div_center"> 
    
    	<div class="div_tip">
    	<div class="div_msg_out">
    		<div class="div_msg">
    		<img src="msg_icon.png"> 
    		</div>
    	</div>
    	<div class="div_banner_lable">
    	<label class="banner_lable">获得你的标签吧 </p></label>
    	 </div>
    </div>
 
	</div>
	</div>  
	
	
		<div class="div_login">
			<div  class="div_login_content">
			<div  class="login_input">
			<table> 
			<tr>
			<td class="p_login">用户名</td>
			<td   ><input class="p_input" type="text"></td>
			</tr>
			<tr>
			<td class="p_login">密码</td>
			<td   ><input class="p_input" type="text"></td>
			</tr>
			<td>
			<tr>
			</tr>
			</td>
			</table>
			<input  type="button" id="btn_login" value="登入">
			<input id="btn_register" value="注册" type="button">
			 
			</div>
			
		
		</div>
		
		<div  id="info"  class="div_login_center">
		<div   class="div_info"> 
			<p class="p_info">hey~,我就是你刚才扫描的二维码 </p>
			<p class="p_info">我是你的私密便签，记事本，私密照册</p>
			<p class="p_info">一切都储存在这张纸条里。</p>
			<div  class="p_start"> 
			 觉得有点意思的？现在开始吧
			<img  id="btn_finish" class="btn_finish"  src="btn_finish.png" ></img>
			</div>
		</div>
		</div>	
		</div>
		
		<div   id="note_content" class="div_note">
				<div   class="note_title">
				<p>互联网产品经理入门</p>
				</div>
				
				<div class="note_content">
					<p>  刺猬型的人非常敏感，随时都保持警惕，只要一感觉受到威胁，便会用豪猪般的刺扎向对手，让人避之不及。他们通常自我封闭，坚守自己的地盘，处处表现出来自己是对的，虽然其实他自己也并没有底气。他不会让别人看到自己的脆弱。</p>
				</div>
		</div>
			 
			 
		<c:forEach   items="${notes}"  var="note">
			<div   id="note_content" class="div_note">
				<div   class="note_title">
				<p>互联网产品经理入门</p>
				</div>
				
				<div class="note_content">
					<p>${note.content} </p>
				</div>
		</div>
		
		</c:forEach>
		
		
		
      <!--    	<div id="001"  class="div_add_note">
		<div  class="div_add_note_title">
		<p>添加便签</p>
		</div>
		<div  class="div_add_note_content">
		<form id="form_note"  action="addNote.do" method="post"> 
		<textarea name="note_content" class="textarea_add_note"rows="10" cols="20">
		</textarea>
		</form>
		</div>
		
		<div  class="div_add_note_commit_btn">
			<div id="note_submit" type="button"  >
			<p>提交</p>
			</div>
		</div>
		</div>
		 -->
		
		 
		
		
		
		
		
 
		<div class="action_btn"  > 
		<img   src="./img/text_icon.png">
		</div>
		<div class="action_btn"  > 
		<img   src="./img/music_icon.png">
		</div>
		<div class="action_btn"  > 
		<img   src="./img/img_icon.png">
		<input id='file_upload' type="file"  >
		</div>
		<div id="add_btn"  > 
		<img  src="./img/add_btn.png">
		 
		</div>
	 
	 
	 <div  class="footer"></div>
	 