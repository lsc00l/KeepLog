# [안드로이드] Android SharedPreferences 예제 - 저장, 조회, 삭제

  
SharedPreferences에 데이터를 저장하면 어플리케이션을 삭제하기 전까지 데이터가 보존된다.
그래서 자동 로그인이나 간단한 값 저장을 위해 SharedPreferences를 많이 사용한다.
SharedPreferences에 데이터를 저장, 조회, 삭제 하는 방법을 알아보자


## 1. SharedPreferences 데이터 저장하기
``` java
//SharedPreference 저장하기
SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
SharedPreferences.Editor editor = pref.edit();

editor.putBoolean("keeplog",true);
editor.commit();
``` 
- Sharedpreferences는 key-value형태로 값을 저장한다.
- 데이터타입에 맞게 putXxxx("key", value); 형태로 작성한다.



## 2. SharedPreferences에 데이터 조회하기
``` java
//SharedPreference 값읽어오기
SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
boolean keeplog = pref.getBoolean("keeplog", false); //자동로그인 체크 여부
String userID = pref.getString("userID", "fail");  //사용자id
SharedPreferences에서 "keeplog"와 "userID" 에 해당하는 값을 읽어오는 코드다.
``` 
- 데이터를 저장하지 않았다면 kepplog와 userID는 각각 false와 "fail"을 리턴한다.



## 3. SharedPreferences 데이터 삭제하기

``` java
//SharedPreference 삭제하기
SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
pref.edit().remove("keeplog").commit();
```

- 삭제할 key 값을 적어준다.


  
https://blog.naver.com/lsc00l22/221726345016
