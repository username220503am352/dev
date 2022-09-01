window.onload = function(){

    //객체 선언

    //var pokemon = new Object();
    var pokemon = {
        name : 'pikachu' , 
        level : 10 ,
        atk : 70 ,
        foods : ['medicine' , 'olang' , 'mageCandy' , 'seeds'] ,
        "body attack" : function(){console.log('몸통박치기 ~~~');}
    };

    // console.log(pokemon);
    // console.log(pokemon.name);
    // console.log(pokemon.level);
    // console.log(pokemon.atk);
    // console.log(pokemon.foods);
    // console.log(pokemon["body attack"]);
    // pokemon["body attack"]();


    for(var k in pokemon){
        console.log(pokemon[k]);
    }

    console.log("-----------------");

    //속성 추가 (key : value)
    pokemon.def = 99;
    pokemon.skill = function(){
        console.log("백만볼트~~~!");
    }

    //속성삭제
    delete(pokemon.skill);
    //pokemon.skill = null;


    //확인
    console.log(pokemon);
    //pokemon.skill();



    //--------------
    //객체배열

    //var s1 = {name : "심원용", age : 20};

    var studentArr = [
        {name : '조하나' , age : 20 , height : 180},
        {name : '주환' , age : 21 , height : 170},
        {name : '이도경' , age : 22 , height : 160}
    ];

    var s = {name : '안연주' , age : 23 , height : 190}
    studentArr.push(s);
    
    console.log(studentArr);



    //---------------
    //생성자 함수
    function Student(name, age, height){
        this.name = name;
        this.age = age;
        this.height = height;
    }

    Student.prototype.skill = 'study';
    
    console.log(Student.prototype);

    s1 = new Student('심원용', 20, 180);
    console.log(s1);
    console.log(s1.skill);

    s2 = new Student('심투용', 20, 180);
    console.log(s2);
    console.log(s2.skill);


    console.log(s1 instanceof Student);
    console.log(s2 instanceof Student);







    
    





}//onload


