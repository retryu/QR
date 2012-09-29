
var  s=3;
var  w_width=0;
var add_btn;
var  music_btn;
var  img_btn;
var  text;
var expanded=true;



$(document).ready(function (){
	 
	init();
	init_scroll();

//	window.addEventListener("touchstart", function(ev){
//		alert('good');
//	});
});

window.onload=function(){
//	document.body.addEventListener('touchmove', touchmove, false);
//	document.body.addEventListener('touchstart',touchstart , false);
	document.body.addEventListener('touchmove', touchend, false);
}

function  touchmove(event){
//	alert('move');
//	event.preventDefault();
}
function  touchstart(event){
//	alert('touch start');
//	 event.preventDefault();
}

function  touchend(event){
//	 event.preventDefault();
//	alert("end");
		if(expanded==false){
		 shrink_action_btn(0, 0, 0);
		 
		}
//	alert('end');
	add_btn.css('margin-bottom','10px');
		 
//		 expanded=true;
	return ;
}
function  init(){
	var browser=navigator.appName;
	var b_version=navigator.appVersion;
	var version=parseFloat(b_version);
//	alert('browser:'+browser+ "  version:"+3);
	
	
	
	var btn_finish=$('#btn_finish');
	var  info=$('#info');
	w_width=$(window).width();	
	var  div_info=$('.div_info');
	var  info_left=(w_width-div_info.width())/2;
	var  login_left=((w_width-$('.div_login_content').width())/2);
	var  login_content=$('.div_login_content');
	var  login_btn=$('#btn_login');
	var  div_login=$('.div_login');
	var  note_content=$("#note_content");
	var  banner_lable=$('#banner_lable');
	note_content.css('opacity',0);
	var  login_margin_top=(login_content.parent().height()-login_content.height())/2;
 
	 	login_content.css('margin-top',login_margin_top);
	
	
	
	
	info.css('left',info_left);
	info.css('padding-top',(400-div_info.height())/2);
	
 
	
	
	login_btn.bind('click',function(){
		div_login.animate({top:-500,opacity:0},500,function(){
		});
		note_content.css('position','absolute');
		note_content.css('display','block');
		note_content.animate({top:300,opacity:1},500,function(){
			note_content.css('position','block');
		})
	});
	
	btn_finish.bind('click',function(){
	 
		
		$('#info').animate({left:w_width,opacity:0},400,function(){
			$('#info').remove();
		});
		
		$('.div_login_content').animate({left:login_left},400);
		
	});
	
	   add_btn=$('#add_btn');
	var  action_btns=$('.action_btn');
	   music_btn=action_btns.eq(1);
	   img_btn=action_btns.eq(2);
	   text_btn=action_btns.eq(0);
	   expanded=true;
	var text_position=w_width/2-120;
	var  music_potion=text_position-200;
	var  img_position=text_position+200;
 
	add_btn.bind('click',function(){
		text_btn.css('position','absolute');
		music_btn.css('position','absolute');
		img_btn.css('position','absolute');
		
		if(expanded==true){
		 
			 $(this).rotate({animateTo:45});
			 expand_action_btn(text_position,music_potion,img_position);
	 
		return;
		}
		else{
		 shrink_action_btn(text_position, music_potion, img_position);
			return;
		}
	});
 
	text_btn.bind('click',function(){
		var  last_note=$('.div_note:last');
		$('<div id="001"  class="div_add_note">'+
		'<div  class="div_add_note_title">'+
		'<form id="form_note"  action="addNote.do" method="post">' +
		'<textarea id="noteTitle" class="textarea_add_note_title" rows="1" cols="10"></textarea>'+
		'</div>'+
		'<div  class="div_add_note_content">'+
		'<textarea name="noteContent" class="textarea_add_note"rows="10" cols="20">'+
		'</textarea>'+
		'</form>'+
		'</div>'+
		'<div  class="div_add_note_commit_btn">'+
		'<div id="note_submit" type="button"  >'+
		'<p>提交</p>'+
		'</div>'+
		'</div>'+
		'</div>').insertAfter(last_note);
		var   div_add_note=$('.div_note');
		div_add_note.animate({opacity:1},'slow');
		$('body,html').animate({scrollTop:$(document.body).height()},'slow');
		 
		add_note_dialog();
		
	});
	
	 
	
 
}


function generateNote (){
	
	var  div_add_note=$('.div_add_note');
	div_add_note.removeClass();
	div_add_note.addClass('div_note');
	var  add_note_title=$('.div_add_note_title');
	
	add_note_title.removeClass();
	add_note_title.addClass('note_title');
	var  last_div_note=$('.div_note:last');
	$('.div_add_note_content').remove();
	$('<div class="note_content">'+
			'<p>'+'在表现层（surface），你看到的是一系列的网页，有图片'+'</p>'+
		'</div>'	
	).insertAfter(last_div_note.find('.note_title'));
	last_div_note.find('.div_add_note_commit_btn').remove();
	
}


function  add_note_dialog(){
	var  add_not_submit=$('#note_submit');
	var  form_note=$('#form_note');
	add_not_submit.bind('click',function(){
		var  text=$('.textarea_add_note').val();
 
		$.post('addNote.do',
				form_note.serialize(),
				function(data,status){
			var  notes=eval("("+data+")");
			
			var  s=status;
			generateNote();
		});
	});
}
/*
 * 展开 action_btn
 */
function  expand_action_btn( text_position,music_potion,img_position  ) {
	text_btn.animate({left:music_potion},500,function(){
		text_btn.css('position','fixed');
	});
	music_btn.animate({left:text_position},400,function(){
		music_btn.css('position','fixed');
	});
	img_btn.animate({left:img_position},300,function(){
		img_btn.css('position','fixed');
	});
	expanded=false;
}

/*
 * 收缩action_btn
 */
function  shrink_action_btn(){
	 add_btn.rotate({animateTo:0});
	text_btn.animate({left:0},200,function(){
		text_btn.css('position','fixed');
	});
	music_btn.animate({left:0},300,function(){
		music_btn.css('position','fixed');
	});
	img_btn.animate({left:0},400,function(){
		img_btn.css('position','fixed');
	}); 
	expanded=true;
}
function init_scroll(){
	$(Window).bind('click',function(){
//		alert('click');
	});
	
	
	$(Window).scroll(function(){
//		alert('hah');
//		if(expanded==false){
//			shrink_action_btn();
//			expanded=true;
//			add_btn.rotate({animateTo:0});
//		}
		});
}


