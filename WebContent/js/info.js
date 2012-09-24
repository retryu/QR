$(document).ready(function (){
	

	init();
	
})
function  init(){
	
	var btn_finish=$('#btn_finish');
	var  info=$('#info');
	var  w_width=$(window).width();	
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
		note_content.css('display','block');
		note_content.animate({top:300,opacity:1},500,function(){
		})
	});
	
	btn_finish.bind('click',function(){
	 
		
		$('#info').animate({left:w_width,opacity:0},400,function(){
			$('#info').remove();
		});
		
		$('.div_login_content').animate({left:login_left},400);
		
	});
	
	var  add_btn=$('#add_btn');
	var  action_btns=$('.action_btn');
	var  music_btn=action_btns.eq(2);
	var  img_btn=action_btns.eq(1);
	var  text_btn=action_btns.eq(0);
	var  swi=true;
	music_btn.css('posiiton','absolute');
	add_btn.bind('click',function(){

		if(swi==true){
			swi=false;
		 
		text_btn.animate({left:700},300,function(){
		});
//		img_btn.animate({left:900},300,function(){
//		});
//		music_btn.animate({left:500},300,function(){
//		});
		return;
		}
		else{
			text_btn.animate({left:0},300,function(){
			});
//			img_btn.animate({left:0},300,function(){
//			});
//			music_btn.animate({left:0},300,function(){
//			});
			swi=true;
			return;
		}
	})
 

	
	
	
 
}