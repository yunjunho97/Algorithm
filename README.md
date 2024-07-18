### 1. 문자열 관련  
toUpperCase(): 대문자로 변환  
toLowerCase(): 소문자로 변환  
```
str = str.toUpperCase();
c = Character.toUpperCase('C');
```
<br/>

isUpperCase(): 대문자면 true, 소문자면 false  
isLowerCase(): 대문자면 false, 소문자면 true
```
Character.isUpperCase('A'); //true
Character.isUpperCase('a'); //false
```
<br/>

equalsIgnoreCase(): 대소문자에 관계없이 같은지 비교
```
"aaa".equalsIgnoreCase("aAa"); //true
```
<br/>

isAlphabetic(): 알파벳이면 true, 아니면 false
```
Character.isAlphabetic('a'); //true
Character.isAlphabetic('@'); //false
```
<br/>

isDigit(): 숫자면 true, 아니면 false
```
Character.isDigit(1); //true
Character.isDigit('a'); //false
```
<br/>

toCharArray(): String을 Char 배열 객체로 만듬
```
"str".toCharArray();
//['s', 't', 'r']
```
<br/>

String.valueOf(): String으로 변환
```
char[] ch = {'h', 'e', 'l', 'l', 'o'};
String st = String.valueOf(ch);
```
<br/>

StringBuiler: https://github.com/yunjunho97/Algorithm/blob/main/src/library_memo/StringBuilder_memo.java
<br/>
<br/>

replaceAll(): 다른 문자로 대체
```
str.replaceAll("a", "");
//문자열에서 "a"를 "(공백)"으로 대체
```
<br/>

10, 2, 8, 16진수 변환:
https://github.com/yunjunho97/Algorithm/blob/main/src/library_memo/NumberBase_memo.java
<br/>
<br/>

HashMap:  
https://github.com/yunjunho97/Algorithm/blob/main/src/library_memo/HashMap_memo.java  
getOrDefault()
```
getOrDefault(key, default);
//key의 value를 가져오되
//그런 key가 없다면 default값을 가져온다
```
<br/>

TreeSet: 주로 중복 제거를 위해 사용  
https://github.com/yunjunho97/Algorithm/blob/main/src/library_memo/TreeSet_memo.java
<br/>

IntStream:  
https://github.com/yunjunho97/Algorithm/blob/main/src/library_memo/IntStream_memo.java
<br/>

List.removeIf(람다식)
```
nodes.removeIf(node -> node.key == 1);
```
<br/>