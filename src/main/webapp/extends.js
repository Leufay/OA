function Person() {

}
Person.prototype.a = 5;
function SuperPerson() {

}
SuperPerson.prototype = Person.prototype;// 让superPerson的属性指向Person的prototype
var sp = new SuperPerson();
alert(sp.a);

function createClass(json) {
	function F() {

	}
	for ( var i in json) {
		F.prototype[i] = json[i];
	}
	return F;
}
var Person = createClass({
	a : 5,
	b : 6
});
var p = new Person();
alert(p.a + "-" + p.b);



//声明一个自定义事件
$("button").unbind("我的事件");
$("button").bind("我的事件",function(){
	alert("我的事件");
});

$("button").unbind("click");
$("button").bind("click",function(){
	$(this).trigger("我的事件");
});