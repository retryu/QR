	var  spirit,startX,startY;
	var  canvas=document.getElementById("canvas");
window.onload=function(){
	
	canvas=document.getElementById("canvas");
//	canvas.addEventListener("touchstart", touchStart, false);
//	document.body.addEventListener('touchstart', touchStart, false);
//	canvas.addEventListener("touchmove", touchMove, false);
	document.body.addEventListener('touchend', end,false);
 
}
function  end(event){
	alert("touchstart  is  end");
}


function  touchStart(event){
    event.preventDefault();//?
    var touch =event.touches[0];
   	startX=touch.pageX;
   	startY=touch.pageY;
   	spirit=document.createElement("div");
   	spirit.style.backgroundColor="#ffffff";
   	spirit.style.position="absolute";
   	spirit.style.width='100px';
   	spirit.style.height='100px';
   	spirit.className="spirit";
   	spirit.style.left=startX+'px';
   	spirit.style.top=startY+'px';
   	canvas.appendChild(spirit);
//   	alert('x:'+startX+'  y:'+startY);
//   	alert('x:'+spirit.style.left+' y:'+spirit.style.right);
}
function  touchMove(event){
	event.preventDefault();
	if(!spirit||!event.touches.length)return;
	var  touch=event.touches[0],
	x=touch.pageX-startX;
	y=touch.pageY-startY;
//	alert('move x:'+x+' y:'+y);
	spirit.style.webkitTransform='translate('+x+'px,'+y+'px)';
		
}
function touchEnd(event){
	if(!spirit)return ;
	canvas.removeChild(spirit);
	spirit=null;
}



