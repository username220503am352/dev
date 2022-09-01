window.onload = function(){

    //내장객체

    //Object
    var o = {}; //new Object();
    o.name = '심원용';

    console.log(o.hasOwnProperty('namezzz'));

    //Number , String

    //Date

    //var d = new Date('2022/08/31 13:50:30');
    var d = new Date();

    console.log(d.getTime);
    console.log(d.getFullYear());
    console.log(d.getMonth());  //0~11
    console.log(d.getDate());
    console.log(d.getDay());
    console.log(d.getHours());
    console.log(d.getMinutes());
    console.log(d.getSeconds());
    console.log(d.getMilliseconds());
    


}//onload
