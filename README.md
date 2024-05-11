### 1. 문자열 관련  
toUpperCase(): 대문자로 변환  
toLowerCase(): 소문자로 변환  
```
str = str.toUpperCase();
c = Character.toUpperCase();
```
<br/>

isUpperCase(): 대문자면 true, 소문자면 false  
isLowerCase(): 대문자면 false, 소문자면 true
```
Character.isUpperCase('A'); //true
Character.isUpperCase('a'); //false
```
<br/>

toCharArray(): String을 Char 배열 객체로 만듬
```
"str".toCharArray();
//['s', 't', 'r']
```
<br/>
